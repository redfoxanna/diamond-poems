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

/**
 * The type Poem add action.
 */
@WebServlet(name = "addPoem",
        urlPatterns = {"/poem-add"})
@MultipartConfig
public class PoemAddAction extends HttpServlet implements PropertiesLoader {
    private S3 s3;
    private Textract textract;
    private String bucketName;
    private GenericDao<User> userDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void init() throws ServletException {
        super.init();
        s3 = new S3();
        textract = new Textract();
        // TODO: get bucket-name from the properties file
        bucketName = "diamond-poems";
        userDao = new GenericDao<>(User.class);
    }

    /**
     * Adds a new poem to the database after processing with Textract
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        logger.info("The username from the session: " + userName);

        // Get the user from the database using the username
        User user = userDao.getByPropertyEqual("userName", userName).get(0);

        Part filePart = request.getPart("poemImage");
        InputStream fileContent = filePart.getInputStream();

        String key = s3.makeKey(userName);
        File saveFile = writeTmpFile(fileContent, key);

        s3.putS3Object(s3.getClient(), bucketName, key, saveFile.getPath());

        ArrayList<String> textractedValues = textract.getS3Text(textract.getClient(), bucketName, key);
        String poemContent = String.join("\n", textractedValues);
        logger.info("The poem content: " + poemContent);

        // Create a new Poem object with the associated user
        Poem newPoem = new Poem(poemContent, key, user);
        logger.info("The new poem: " + newPoem);

        // Insert the new poem into the database
        GenericDao<Poem> poemDao = new GenericDao<>(Poem.class);
        poemDao.insertEntity(newPoem);

        request.setAttribute("newPoem", newPoem);
        String url = "/poem-edit.jsp";

        // Forward the request instead of redirecting
        request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Writes the textracted results to a temp file to save memory
     * @param initialStream
     * @param filePath
     * @return
     * @throws IOException
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
