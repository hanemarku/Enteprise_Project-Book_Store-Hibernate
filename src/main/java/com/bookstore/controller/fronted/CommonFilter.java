package com.bookstore.controller.fronted;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;



@WebFilter("/*")
public class CommonFilter implements Filter {

    private final CategoryDAO categoryDAO;

    public CommonFilter() {
        categoryDAO = new CategoryDAO();
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        if (!path.startsWith("/admin/")) {
            List<Category> listCategory = categoryDAO.listAll();
            request.setAttribute("listCategory", listCategory);
        }

        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }


}
