package com.redfoxanna.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * @author redfoxanna
 *
 * The type LogIn which is responsible for getting the
 * cognito properties from the servlet context and
 * creating the url to redirect to when logged in successfully
 */
@WebServlet(urlPatterns = {"/logIn"})
public class LogIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieves Cognito properties from the servlet context
        Properties cognitoProperties = (Properties) getServletContext().getAttribute("cognitoProperties");
        String clientId = cognitoProperties.getProperty("client.id");
        String loginUrl = cognitoProperties.getProperty("loginURL");
        String redirectUrl = cognitoProperties.getProperty("redirectURL");

        // Constructs the login URL
        String url = loginUrl + "?response_type=code&client_id=" + clientId + "&redirect_uri=" + redirectUrl;
        resp.sendRedirect(url);
    }
}
