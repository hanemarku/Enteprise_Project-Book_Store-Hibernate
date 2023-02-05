package com.bookstore.controller.frontend.customer;

import com.bookstore.service.CustomerServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/update_profile")
public class UpdateCustomerProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerServices customerServices = new CustomerServices(request, response);
        customerServices.updateCustomerProfile();
    }
}
