package com.redfoxanna.controller;

import com.redfoxanna.aws.S3;
import com.redfoxanna.aws.Textract;
import com.redfoxanna.entity.Genre;
import com.redfoxanna.entity.Poem;
import com.redfoxanna.entity.PoemGenre;
import com.redfoxanna.persistence.GenericDao;
import org.apache.commons.io.IOUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Servlet that handles adding a new poem to the database
 *
 * @author redfoxanna
 */
@WebServlet(name = "addPoem",
        urlPatterns = {"/poem-add"}
)
public class PoemAddAction extends HttpServlet {
    private S3 s3;
    private Textract textract;
    private String bucketName;
    private GenericDao<Genre> genreDao;

    @Override
    public void init() throws ServletException {
        super.init();
        s3 = new S3();
        textract = new Textract();
        genreDao = new GenericDao<>(Genre.class);
        // TODO: get bucket-name from a properties file
        bucketName = "diamond-poems";
    }

    /**
     *
     * @param request the request object
     * @param response the response object
     * @throws ServletException if a servlet error
     * @throws IOException if an error reading the file
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Part filePart = request.getPart("poemImage");
        InputStream fileContent = filePart.getInputStream();
        String userName = request.getAttribute("userName").toString();
        // TODO process genres?
        String[] genres = request.getParameterValues("genres");

        // Extract poem content using Textract
        ArrayList<String> textractedValues = textract.getS3Text(textract.getClient(), bucketName, filePart.getSubmittedFileName());
        String poemContent = String.join("\n", textractedValues);

        // Save the poem to the database
        int poemId = addPoem(fileContent, userName, poemContent, filePart.getSubmittedFileName(), genres);

        // TODO: Add success message to the session

        // TODO: redirect to poem edit page
        //String url = "/poem-add-display.jsp";
        //response.sendRedirect(request.getContextPath() + url);
    }

    /**
     * Adds the poem to the database via the DAO
     * @param fileStream the file steam
     * @param userName the author of the poem
     * @param poemContent the content of the uploaded poem
     * @param poemImageFileName the name of the image file
     * @param genres the genres associated with the uploaded poem
     * @return the inserted Poem entity
     * @throws IOException if an error reading the file
     */
    private int addPoem(InputStream fileStream, String userName, String poemContent, String poemImageFileName, String[] genres) throws IOException {
        String key = s3.makeKey(userName);
        File saveFile = writeTmpFile(fileStream, key);

        s3.putS3Object(s3.getClient(), bucketName, key, saveFile.getPath());

        // Extract genres from the array
        Set<PoemGenre> poemGenres = new HashSet<>();
        for (String genreName : genres) {
            PoemGenre poemGenre = new PoemGenre();

            // Retrieve the Genre object corresponding to the genre name from the database
            Genre genre = genreDao.getByPropertyEqual("genreName", genreName).get(0);

            poemGenre.setGenre(genre);

            // Add the PoemGenre object to the set
            poemGenres.add(poemGenre);
        }

        // Create Poem object with content, image URL, current timestamp, and genres
        Poem poem = new Poem(poemContent, key, poemGenres.toString());

        // Save the Poem object to the database and return the ID
        GenericDao<Poem> poemDao = new GenericDao<>(Poem.class);
        return poemDao.insertEntity(poem);
    }

    /**
     * Creates a temporary file on the server
     * @param initialStream the initial file stream
     * @param filePath the path to the file
     * @return the file
     * @throws IOException if an error reading the file
     */
    private File writeTmpFile(InputStream initialStream, String filePath) throws IOException {
        File targetFile = new File(String.format("tmp/%s", filePath));
        OutputStream outStream = new FileOutputStream(targetFile);

        byte[] buffer = new byte[8 * 1024];
        int bytesRead;
        while ((bytesRead = initialStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        IOUtils.closeQuietly(initialStream);
        IOUtils.closeQuietly(outStream);

        return targetFile;
    }
}
