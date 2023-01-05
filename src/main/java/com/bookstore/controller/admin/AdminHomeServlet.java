package com.bookstore.controller.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet("/admin/")
public class AdminHomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AdminHomeServlet() {
        super();
    }

    protected void doGet(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        String homePage = "index.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(homePage);
        dispatcher.forward(request,  response);
    }
}
