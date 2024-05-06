package com.redfoxanna.controller;

import com.redfoxanna.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Logs a user out by removing them from the session
 * @author redfoxanna
 */
@WebServlet(
        urlPatterns = {"/logOut"}
)

public class LogOut extends HttpServlet implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Remove User object from session, redirect to the home page
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException if an error occues while processing the request
     * @throws IOException if an i/o exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        logger.info("User logged out: " + session.getAttribute("userName"));
        session.removeAttribute("userName");
        String url = "index.jsp";
        resp.sendRedirect(url);
    }
}