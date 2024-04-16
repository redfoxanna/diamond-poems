package com.redfoxanna.controller;

import com.redfoxanna.entity.Poem;
import com.redfoxanna.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


/**
 * Servlet that gets search parameters, performs a poem search
 * and then forwards the results to the JSP.
 * @author redfoxanna
 */
@WebServlet(
        name = "poemSearchResults",
        urlPatterns = { "/poem-search-results" }
)
public class PoemSearchResultsServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Gets the search term and search type and forwards the request
     * and response to the poem-search-results JSP
     * @param request the request object
     * @param response the response object
     * @throws ServletException if a servlet error
     * @throws IOException if an io error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GenericDao<Poem> poemDao = new GenericDao<>(Poem.class);
        request.setAttribute("poems", poemDao.getAll());
        logger.debug("The poems: " + poemDao);

        String url = "/poem-search-results.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}