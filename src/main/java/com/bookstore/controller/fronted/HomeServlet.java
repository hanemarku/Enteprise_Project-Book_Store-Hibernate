package com.bookstore.controller.fronted;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public HomeServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        String homePage = "frontend/index.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(homePage);
        dispatcher.forward(request,  response);
    }

//    protected void doPost(HttpServlet request, HttpServlet response)  throws ServletException, IOException{
//        doGet(request, response);
//    }



}