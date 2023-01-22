package com.bookstore.controller.admin.user;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.UserServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/admin/edit_user")
public class EditUserServlet extends HttpServlet {
    public EditUserServlet(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServices userServices = new UserServices(request, response);
        userServices.editUser();
    }

}
