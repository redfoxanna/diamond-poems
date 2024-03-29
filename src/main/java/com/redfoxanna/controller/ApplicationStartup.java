package com.redfoxanna.controller;

import com.redfoxanna.util.PropertiesLoader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.Properties;

/**
 * Servlet to load properties on start-up
 *
 * @author redfoxanna
 */
@WebServlet(name = "applicatonStartup",
        urlPatterns = "/diamondpoem-startup",
        loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {

    public void init() throws ServletException {
    Properties properties = loadProperties("/cognito.properties");
    ServletContext context = getServletContext();
    context.setAttribute("cognitoProperties", properties);
    }

}
