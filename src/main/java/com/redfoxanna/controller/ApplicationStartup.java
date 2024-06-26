package com.redfoxanna.controller;

import com.redfoxanna.entity.Genre;
import com.redfoxanna.persistence.GenericDao;
import com.redfoxanna.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;
import java.util.Properties;

/**
 * Servlet to load properties on start-up
 *
 * @author redfoxanna
 */
@WebServlet(name = "applicationStartup",
        urlPatterns = "/diamondpoem-startup",
        loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());

    // TODO if properties weren't loaded properly, route to an error page
    public void init() throws ServletException {

        logger.info("Loading the application properties...");
        Properties cognitoProperties = loadProperties("/cognito.properties");
        Properties databaseProperties = loadProperties("/database.properties");
        Properties log4jProperties = loadProperties("/log4j2.properties");
        Properties awsProperties = loadProperties("/aws.properties");

        ServletContext context = getServletContext();

        context.setAttribute("cognitoProperties", cognitoProperties);
        context.setAttribute("databaseProperties", databaseProperties);
        context.setAttribute("log4jProperties", log4jProperties);
        context.setAttribute("awsProperties", awsProperties);
    }
}
