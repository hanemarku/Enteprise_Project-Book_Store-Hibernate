package com.bookstore.controller.admin.customer;

import com.bookstore.service.CategoryServices;
import com.bookstore.service.CustomerServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/admin/delete_customer")
public class DeleteCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerServices customerServices = new CustomerServices(request, response);
        customerServices.deleteCustomer();
    }
}
