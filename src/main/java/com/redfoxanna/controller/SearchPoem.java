package com.redfoxanna.controller;

import com.redfoxanna.persistence.PoemDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A servlet for handling the user search
 * // TODO Add search logic for userName, anything else?
 * @author redfoxanna
 */

@WebServlet(
        urlPatterns = {"/searchPoem"}
)

public class SearchPoem extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // TODO update for a generic dao
        PoemDao poemDao = new PoemDao();

        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("poems", poemDao.getByPropertyLike("content", req.getParameter("searchTerm")));
        } else {
            req.setAttribute("poems", poemDao.getAll());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/poem-search-results.jsp");
        dispatcher.forward(req, resp);
    }
}