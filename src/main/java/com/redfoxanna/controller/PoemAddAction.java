package com.redfoxanna.controller;

import com.redfoxanna.aws.S3;
import com.redfoxanna.aws.Textract;
import com.redfoxanna.entity.Genre;
import com.redfoxanna.entity.Poem;
import com.redfoxanna.entity.PoemGenre;
import com.redfoxanna.entity.User;
import com.redfoxanna.persistence.GenericDao;
import com.redfoxanna.util.PropertiesLoader;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Servlet implementation class PoemAddAction.
 * This servlet handles the addition of a new poem, including processing images with Textract.
 * @author redfoxanna
 */
@WebServlet(name = "addPoem",
        urlPatterns = {"/poem-add"})
@MultipartConfig
public class PoemAddAction extends HttpServlet implements PropertiesLoader {
    private S3 s3;
    private Textract textract;
    private String bucketName;
    private GenericDao<User> userDao;
    private GenericDao<Genre> genreDao;
    private GenericDao<PoemGenre> poemGenreDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void init() throws ServletException {
        super.init();
        s3 = new S3();
        textract = new Textract();
        // TODO: get bucket-name from the properties file
        bucketName = "diamond-poems";
        userDao = new GenericDao<>(User.class);
        genreDao = new GenericDao<>(Genre.class);
    }

    /**
     * Handles HTTP POST requests for adding a new poem, including image processing with Textract.
     *
     * @param request  the HTTP request
     * @param response the HTTP response
     * @throws ServletException if an error occurs while processing the request
     * @throws IOException      if an I/O error occurs while sending or receiving the response
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        logger.info("The username from the session: " + userName);

        // Get the user from the database using the username
        User user = userDao.getByPropertyEqual("userName", userName).get(0);

        // TODO create a separate method for this stuff
        // Images processing starts here
        Part filePart = request.getPart("poemImage");
        InputStream fileContent = filePart.getInputStream();

        // Makes the s3 key with the username
        String key = s3.makeKey(userName);
        File saveFile = writeTmpFile(fileContent, key);

        s3.putS3Object(s3.getClient(), bucketName, key, saveFile.getPath());

        // Gets textracted values and assigns it to the poem content
        ArrayList<String> textractedValues = textract.getS3Text(textract.getClient(), bucketName, key);
        String poemContent = String.join("\n", textractedValues);
        logger.info("The poem content: " + poemContent);

        // Create a new Poem object with the associated user
        Poem newPoem = new Poem(poemContent, key, user);
        logger.info("The new poem: " + newPoem);

        // Insert the new poem into the database
        GenericDao<Poem> poemDao = new GenericDao<>(Poem.class);
        poemDao.insertEntity(newPoem);
        // Get the id of the new poem
        int poemId = newPoem.getId();
        logger.info("The new poem id: " + poemId);
        // Set poemId as request attribute
        request.setAttribute("poemId", poemId);

        // Gets the user selected genres from the form submission THIS IS WORKING
        String[] selectedGenreIds = request.getParameterValues("selectedGenres");
        logger.info("The selected genres: " + Arrays.toString(selectedGenreIds));

        // TODO genre functionality needs to be implemented
        // Associate selected genres with the new poem
        if (selectedGenreIds != null) {
            for (String genreId : selectedGenreIds) {
                if (genreId != null && !genreId.isEmpty()) { // Check if genreId is not null or empty
                    try {
                        // Get the Genre object from the genreId
                        int id = Integer.parseInt(genreId);
                        Genre genre = genreDao.getById(id);

                        // Create a new PoemGenre object with the new poem and genre
                        PoemGenre poemGenre = new PoemGenre(newPoem, genre);

                        // Save the PoemGenre object to associate genre with the poem
                        poemGenreDao.insertEntity(poemGenre);
                    } catch (NumberFormatException e) {
                        // Handle invalid genreId (non-numeric)
                        // Log or handle the exception as needed
                        logger.error("Invalid genre ID: " + genreId, e);
                    }
                }
            }
        }
        request.setAttribute("poem", newPoem);
        String url = "/poem-edit.jsp";

        // Forward the request instead of redirecting
        request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Writes the Textracted results to a temporary file to save memory.
     *
     * @param initialStream the input stream containing Textracted results
     * @param filePath      the file path for the temporary file
     * @return the temporary file
     * @throws IOException if an I/O error occurs while writing the file
     */
    private File writeTmpFile(InputStream initialStream, String filePath) throws IOException {
        File targetFile = File.createTempFile(filePath, null);
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
