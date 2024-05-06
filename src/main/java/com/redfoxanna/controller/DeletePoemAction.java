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
 * The type Delete poem action.
 * @author redfoxanna
 */
@WebServlet(name = "DeletePoemAction",
        urlPatterns = {"/delete-poem"})
public class DeletePoemAction extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<Poem> poemDao;

    @Override
    public void init() throws ServletException {
        super.init();
        poemDao = new GenericDao<>(Poem.class);
    }

    /**
     * Handles the deletion of a poem
     * @param request the HTTP request
     * @param response the HTTP response
     * @throws ServletException if an error while processing request
     * @throws IOException if an i/o exception
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the ID of the poem to be deleted from the request parameters
        int poemId = Integer.parseInt(request.getParameter("id"));

        // Retrieve the Poem object from the database using the ID
        Poem poem = poemDao.getById(poemId);

        if (poem != null) {
            // Delete the poem from the database
            poemDao.delete(poem);

            // Log success message
            logger.info("Poem deleted successfully: " + poem);

            // Redirect the user back to the user-poems.jsp page
            response.sendRedirect(request.getContextPath() + "/user-poems");
        } else {
            // Log error message if poem not found
            logger.error("Poem with ID " + poemId + " not found.");
            // Redirect to an error page or handle appropriately
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
