package com.bookstore.controller.frontend;



import com.bookstore.controller.BaseServlet;
import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("")
public class HomeServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;
    public HomeServlet(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO();
        BookDAO bookDAO = new BookDAO();

        List<Category> categoryList = categoryDAO.listAll();
        List<Book> listNewBooks = bookDAO.listNewBooks();

        request.setAttribute("listCategory", categoryList);
        request.setAttribute("listNewBooks", listNewBooks);

        String homePage = "frontend/index.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(homePage);
        dispatcher.forward(request,  response);
    }

//    protected void doPost(HttpServlet request, HttpServlet response)  throws ServletException, IOException{
//        doGet(request, response);
//    }



}
