package com.bookstore.service;

import com.bookstore.dao.ReviewDAO;

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

    public void listAllReview() throws ServletException, IOException {
        listAllReview(null);
    }
    public void listAllReview(String message) throws ServletException, IOException {
        List<Review> listReviews = reviewDAO.listAll();
        request.setAttribute("listReviews", listReviews);

        String listPage = "review_list.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);

        if (message != null) {
            request.setAttribute("message", message);
        }
        dispatcher.forward(request, response);
    }

    public void deleteReview() throws ServletException, IOException {
        Integer reviewId = Integer.parseInt(request.getParameter("id"));
        reviewDAO.delete(reviewId);

        String message = "Review has been deleted successfully.";

        listAllReview(message);
    }

    public void showReviewForm() throws ServletException, IOException {
        String targetPage = "frontend/review_form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(targetPage);
        dispatcher.forward(request, response);
    }

}
