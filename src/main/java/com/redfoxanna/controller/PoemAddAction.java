package com.redfoxanna.controller;

import com.redfoxanna.aws.S3;
import com.redfoxanna.aws.Textract;
import com.redfoxanna.entity.Genre;
import com.redfoxanna.entity.Poem;
import com.redfoxanna.entity.PoemGenre;
import com.redfoxanna.entity.User;
import com.redfoxanna.persistence.GenericDao;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.*;
import java.util.*;

/**
 * Servlet that handles adding a new poem to the database
 *
 * @author redfoxanna
 */
@WebServlet(name = "addPoem",
        urlPatterns = {"/poem-add"}
)
@MultipartConfig
public class PoemAddAction extends HttpServlet {
    private S3 s3;
    private Textract textract;
    private String bucketName;
    // TODO decide how to deal with the genres here
    private GenericDao<Genre> genreDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

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

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        logger.info("The username from the session: " + userName);

        Part filePart = request.getPart("poemImage");
        InputStream fileContent = filePart.getInputStream();

        String key = s3.makeKey(userName);
        File saveFile = writeTmpFile(fileContent, key);

        s3.putS3Object(s3.getClient(), bucketName, key, saveFile.getPath());


        ArrayList<String> textractedValues = textract.getS3Text(textract.getClient(), bucketName, key);
        String poemContent = String.join("\n", textractedValues);
        logger.info("The poem content: " + poemContent);

        // TODO add the poem to the database
        User uploadedBy = (User) session.getAttribute("userName");
        Poem newPoem = new Poem(poemContent, key, uploadedBy);
        logger.info("The new poem: " + newPoem);
        GenericDao<Poem> poemDao = new GenericDao<>(Poem.class);
        poemDao.insertEntity(newPoem);


        String url = "/poem-edit.jsp";
        response.sendRedirect(request.getContextPath() + url);
    }


    /**
     * Creates a temporary file on the server
     * @param initialStream the initial file stream
     * @param filePath the path to the file
     * @return the file
     * @throws IOException if an error reading the file
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
