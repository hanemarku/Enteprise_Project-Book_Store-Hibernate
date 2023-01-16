package com.bookstore.controller.admin.category;

import com.bookstore.controller.BaseServlet;
import com.bookstore.service.CategoryServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/admin/list_category")
public class ListCategoryServlet extends BaseServlet {

    public ListCategoryServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("list category");
        CategoryServices categoryServices = new CategoryServices(entityManager,request, response);
        categoryServices.listCategories();
    }

}
