package com.bookstore.controller.admin;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.UserServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/admin/login")
public class AdminLoginServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        response.getWriter().println(email + " , " + password);

        UserServices userServices = new UserServices(entityManager, request, response);
        userServices.login();
    }
}