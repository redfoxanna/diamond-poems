package com.redfoxanna.controller;

import com.redfoxanna.entity.Poem;
import com.redfoxanna.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Handles the editing of a poem
 * @author redfoxanna
 */
@WebServlet(name = "editPoem",
        urlPatterns = {"/poem-edit"})
public class PoemEditAction extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<Poem> poemDao;

    @Override
    public void init() throws ServletException {
        super.init();
        poemDao = new GenericDao<>(Poem.class);
    }

    /**
     * Handles HTTP POST requests for editing a poem.
     *
     * @param request  the HTTP request
     * @param response the HTTP response
     * @throws ServletException if an error occurs while processing the request
     * @throws IOException      if an I/O error occurs while sending or receiving the response
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve the ID of the poem being edited from request parameters
        int poemId = Integer.parseInt(request.getParameter("poemId"));

        // Retrieve the updated content of the poem from request parameters
        String updatedContent = request.getParameter("poemContent");

        // Retrieve the Poem object from the database using the ID
        Poem poem = poemDao.getById(poemId);

        if (poem != null) {
            // Update the content of the Poem object with the new content
            poem.setContent(updatedContent);

            // Update the Poem in the database
            poemDao.update(poem);

            logger.info("Poem updated successfully: " + poem);
             request.setAttribute("poem", poem);

            // Redirect to the search results page to show all poems
            String url = "/poem-edit-results.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        } else {
            // Log error message
            logger.error("Poem with ID " + poemId + " not found.");

            // Redirect to an error page
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
