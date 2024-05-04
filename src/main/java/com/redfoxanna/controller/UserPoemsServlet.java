package com.redfoxanna.controller;

import com.redfoxanna.entity.Poem;
import com.redfoxanna.entity.User;
import com.redfoxanna.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet that handles getting all the poems
 * for a user that is signed in to the application
 */
@WebServlet(name = "UserPoems", urlPatterns = {"/user-poems"})
public class UserPoemsServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<Poem> poemDao;

    @Override
    public void init() throws ServletException {
        super.init();
        poemDao = new GenericDao<>(Poem.class);
    }

    /**
     * Uses the DAO to get the current user and finds all their
     * poems and saves them as a request attribute before forwarding to jsp
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve currently logged-in user from session
        User currentUser = (User) request.getSession().getAttribute("user");

        if (currentUser != null) {
            // Retrieve all poems associated with the current user from the database
            List<Poem> userPoems = poemDao.getByPropertyEqual("user", currentUser);

            // Set user poems as an attribute in the request
            request.setAttribute("userPoems", userPoems);

            // Forward the request to the JSP page to display user poems
            request.getRequestDispatcher("/user-poems.jsp").forward(request, response);
        } else {
            // User not logged in, redirect to home page
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}