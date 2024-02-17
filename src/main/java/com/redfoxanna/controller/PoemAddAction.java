package com.redfoxanna.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Serlvet that handles adding a new poem to the database
 *
 * @author redfoxanna
 */
@WebServlet(name = "addPoem",
        urlPatterns = {"/add-poem"}
)
public class PoemAddAction extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // TODO get the data from the new poem form

        // TODO call the add poem method

        // TODO add the success add message to the session

        // TODO send redirect? to the add-poem jsp
        String url = "/poem-add.jsp";
        response.sendRedirect(request.getContextPath() + url);
    }
}
