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

            // Update the Poem object in the database
            poemDao.update(poem);

            // Log success message
            logger.info("Poem updated successfully: " + poem);
            request.setAttribute("newPoemEdit", poem);

            // TODO do I want this or to go somewhere else?
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
