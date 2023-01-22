package com.bookstore.controller.admin.customer;

import com.bookstore.service.CustomerServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/admin/create_customer")
public class CreateCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerServices customerServices = new CustomerServices(request, response);
        customerServices.createCustomer();
    }
}
