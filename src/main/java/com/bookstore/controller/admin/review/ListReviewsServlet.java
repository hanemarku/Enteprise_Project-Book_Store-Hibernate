package com.bookstore.controller.admin.review;

import com.bookstore.service.ReviewServices;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/admin/list_review")
public class ListReviewsServlet extends HttpServlet {

    ListReviewsServlet(){

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReviewServices reviewServices = new ReviewServices(request, response);
        reviewServices.listAllReview();
    }

}
