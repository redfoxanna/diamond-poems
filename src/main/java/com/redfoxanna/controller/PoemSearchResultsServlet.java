package com.redfoxanna.controller;

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

    /**
     * Gets the EmployeeDirectory instance from the ServletContext,
     * the search term and search type and forwards the request and
     * response to the employee-search-results JSP
     * @param request the request object
     * @param response the response object
     * @throws ServletException if a servlet error
     * @throws IOException if an io error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create a local variable that references the ServletContext
        ServletContext servletContext = getServletContext();

        // Get the EmployeeDirectory instance from the ServletContext TODO update for diamond-poems
        //EmployeeDirectory employeeDirectory = (EmployeeDirectory) servletContext.getAttribute("project4EmployeeDirectory");

        // Get the search type and the search term from the HTML form
        String searchType = request.getParameter("searchType");
        String searchTerm = request.getParameter("searchTerm");

        // Search for employees TODO update for diamond-poems
        //Search search = employeeDirectory.searchEmployeeDatabase(searchType, searchTerm);

        // Place the Search object into the session
        HttpSession session = request.getSession();
        //session.setAttribute("searchResults", search);

        // Forward the request and response to the Employee Search Results JSP page
        String url = "/poem-search-results.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);



    }
}


