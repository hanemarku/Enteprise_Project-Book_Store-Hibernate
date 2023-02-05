package com.bookstore.controller.admin;

import com.bookstore.dao.*;
import com.bookstore.entity.BookOrder;
import com.bookstore.entity.Review;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/")
public class AdminHomeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDAO userDao = new UserDAO();
        OrderDAO orderDao = new OrderDAO();
        ReviewDAO reviewDao = new ReviewDAO();
        BookDAO bookDao = new BookDAO();
        CustomerDAO customerDao = new CustomerDAO();

        List<BookOrder> listMostRecentSales = orderDao.listMostRecentSales();
        List<Review> listMostRecentReviews = reviewDao.listMostRecent();

        long totalUsers = userDao.count();
        long totalBooks = bookDao.count();
        long totalCustomers = customerDao.count();
        long totalReviews = reviewDao.count();
        long totalOrders = orderDao.count();

        request.setAttribute("listMostRecentSales", listMostRecentSales);
        request.setAttribute("listMostRecentReviews", listMostRecentReviews);

        request.setAttribute("totalUsers", totalUsers);
        request.setAttribute("totalBooks", totalBooks);
        request.setAttribute("totalCustomers", totalCustomers);
        request.setAttribute("totalReviews", totalReviews);
        request.setAttribute("totalOrders", totalOrders);

        String homepage = "index.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
        dispatcher.forward(request, response);
    }

}
