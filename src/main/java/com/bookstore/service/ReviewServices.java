package com.bookstore.service;

import com.bookstore.dao.ReviewDAO;
import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Review;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ReviewServices {
    private ReviewDAO reviewDAO;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public ReviewServices(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        reviewDAO = new ReviewDAO();
    }

    public void listAllReview() {
    }

    public void listAllReview(String message) throws ServletException, IOException {

        request.setAttribute("test", "test");
//        List<Review> listReviews = reviewDAO.listAll();
//
//        request.setAttribute("listReviews", listReviews);
//
//        if (message != null) {
//            request.setAttribute("message", message);
//        }
//
        String listPage = "review_list.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
        dispatcher.forward(request, response);

    }
}
