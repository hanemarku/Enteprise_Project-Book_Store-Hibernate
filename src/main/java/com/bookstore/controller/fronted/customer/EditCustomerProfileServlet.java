package com.bookstore.controller.fronted.customer;

import com.bookstore.service.CustomerServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/edit_profile")
public class EditCustomerProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerServices customerServices = new CustomerServices(request, response);
        customerServices.showCustomerProfileEditForm();
    }
}
