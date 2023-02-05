package com.bookstore.controller.admin.review;

import com.bookstore.service.CustomerServices;
import com.bookstore.service.ReviewServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/edit_review")
public class EditReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditReviewServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReviewServices reviewServices = new ReviewServices(request, response);
		reviewServices.editReview();
	}

}
