package com.bookstore.controller.fronted;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.BookServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/view_category")
public class ViewBooksByCategoryServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookServices bookServices = new BookServices(entityManager, request, response);
        bookServices.listBooksByCategory();
    }
}
