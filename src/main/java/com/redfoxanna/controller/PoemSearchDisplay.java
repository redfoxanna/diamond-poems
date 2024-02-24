package com.redfoxanna.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

/**
 * Servlet that forwards to the Poem Search JSP
 * @author redfoxanna
 */

@WebServlet(
        name = "poemSearch",
        urlPatterns = {"/poem-search"}
)
public class PoemSearchDisplay extends HttpServlet {

    /**
     * doGet that forwards the request/response to the
     * poem-search jsp
     * @param request the request object
     * @param response the response object
     * @throws ServletException if a servlet error
     * @throws IOException if an io error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/poem-search.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}