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

@WebServlet("/user-poem-edit")
public class UserPoemEdit extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<Poem> poemDao;

    @Override
    public void init() throws ServletException {
        super.init();
        poemDao = new GenericDao<>(Poem.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve poem ID from request parameters
        int poemId = Integer.parseInt(request.getParameter("id"));

        // Retrieve the poem object based on the ID
        Poem poem = poemDao.getById(poemId);

        if (poem != null) {
            // Set poem object as an attribute in the request
            request.setAttribute("poem", poem);

            // Forward the request to the JSP page for editing
            request.getRequestDispatcher("/poem-edit.jsp").forward(request, response);
        } else {
            // Log error message
            logger.error("Poem with ID " + poemId + " not found.");

            // Redirect to an error page or display an error message
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
