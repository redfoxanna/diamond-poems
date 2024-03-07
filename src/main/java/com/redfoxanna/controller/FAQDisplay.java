package com.redfoxanna.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "questions",
        urlPatterns = {"/questions"}
)

public class FaqDisplay extends HttpServlet {

    /**
     * doGet that forwards the request/response to the
     * FAQ jsp
     * @param request the request object
     * @param response the response object
     * @throws ServletException if a servlet error
     * @throws IOException if an io error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/faq.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}