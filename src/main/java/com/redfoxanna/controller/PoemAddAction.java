package com.redfoxanna.controller;

import com.redfoxanna.aws.S3;
import com.redfoxanna.aws.Textract;
import com.redfoxanna.entity.Poem;
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

/**
 * Servlet that handles adding a new poem to the database
 *
 * @author redfoxanna
 */
@WebServlet(name = "addPoem",
        urlPatterns = {"/poem-add"}
)
public class PoemAddAction extends HttpServlet {
    S3 s3;
    Textract textract;
    String bucketName;

    @Override
    public void init() throws ServletException {
        super.init();
        s3 = new S3();
        textract = new Textract();
        // TODO: get bucket-name from a properties file
        bucketName = "diamond-poems";
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Part filePart = request.getPart("poemImage");
        InputStream fileContent = filePart.getInputStream();
        String userName = request.getAttribute("userName").toString();
        int poemId = addPoem(fileContent, userName);

        // TODO add the success add message to the session

        // TODO: redirect to poem edit page
        //String url = "/poem-add-display.jsp";
        //response.sendRedirect(request.getContextPath() + url);
    }

    private int addPoem(InputStream fileStream, String userName) throws IOException {
        String key = s3.makeKey(userName);
        File saveFile = writeTmpFile(fileStream, key);

        s3.putS3Object(s3.getClient(), bucketName, key, saveFile.getPath());
        ArrayList<String> textractedValues = textract.getS3Text(textract.getClient(), bucketName, key);
        String poemContent = String.join("/n", textractedValues);

        Poem poem = new Poem(poemContent, key, userName);
        GenericDao<Poem> poemDao = new GenericDao<>();

        return poemDao.insert(poem);
    }
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
