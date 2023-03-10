package com.bookstore.controller.admin.user;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.UserServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/admin/create_user")
public class CreateUserServlet extends HttpServlet{
    public CreateUserServlet() {
        super();
    }
    @Override
    protected void doPost(HttpServletRequest request ,HttpServletResponse response) throws ServletException, IOException {
        UserServices userServices = new UserServices(request, response);
        userServices.createUser();
    }
}
