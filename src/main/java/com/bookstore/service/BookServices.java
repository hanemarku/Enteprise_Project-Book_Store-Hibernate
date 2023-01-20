package com.bookstore.service;

import com.bookstore.dao.BookDAO;
import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BookServices {
    private EntityManager entityManager;
    private BookDAO bookDAO;
    private CategoryDAO categoryDAO;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public BookServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
        this.entityManager = entityManager;
        this.request = request;
        this.response = response;
        bookDAO = new BookDAO(entityManager);
        categoryDAO = new CategoryDAO(entityManager);
    }

    public void listBooks() throws ServletException, IOException {
        listBooks(null);
    }

    public void listBooks(String message) throws ServletException, IOException {
        List<Book> books = bookDAO.listAll();
        request.setAttribute("listBooks", books);
        String listPage = "book_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
        if(message != null){
            request.setAttribute("message", message);

        }
        requestDispatcher.forward(request, response);
    }

    public void showBookNewForm() throws ServletException, IOException {
        List<Category> listCategory = categoryDAO.listAll();
        request.setAttribute("listCategory", listCategory);
        String newPage = "book_form.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(newPage);
        requestDispatcher.forward(request, response);

    }

    public void createBook() throws ServletException, IOException {
        String title = request.getParameter("title");


        Book existBook = bookDAO.findByTitle(title);
        if(existBook != null){
            String message = "Could not create new book because the title " + title + " already exists.";
            listBooks(message);
            return;
        }

        Book  newBook = new Book();
        readBookFields(newBook);
        Book createdBook = bookDAO.create(newBook);
        if(createdBook.getBookId() > 0){
            String message = "A new book has been creaated succesfully";
            request.setAttribute("message", message);
            listBooks(message);
        }

    }

    public void editBook() throws ServletException, IOException {
        Integer bookId = Integer.parseInt(request.getParameter("id"));
        Book book = bookDAO.get(bookId);
        List<Category> listCategory = categoryDAO.listAll();

        request.setAttribute("book", book);
        request.setAttribute("listCategory", listCategory);

        String editPage = "book_form.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
        requestDispatcher.forward(request, response);
    }

    public void readBookFields(Book book) throws ServletException, IOException {
        String author = request.getParameter("author");
        String description = request.getParameter("description");
        String isbn = request.getParameter("isbn");
        Float price = Float.valueOf(request.getParameter("price"));
        String title = request.getParameter("title");
        Integer categoryId = Integer.parseInt(request.getParameter("category"));



        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date publishDate = null;
        try{
            publishDate = dateFormat.parse(request.getParameter("publishDate"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        book.setTitle(title);
        book.setAuthor(author);
        book.setDescription(description);
        book.setIsbn(isbn);
        book.setPrice(price);
        book.setPublishDate(publishDate);

        Category category = categoryDAO.get(categoryId);
        book.setCategoryId(category.getCategoryId());

        Part part = request.getPart("bookImage");
        if(part != null && part.getSize() > 0){
            long size = part.getSize();
            byte[] imageBytes = new byte[(int) size];
            InputStream inputStream = part.getInputStream();
            inputStream.read(imageBytes);
            inputStream.close();

            book.setImage(imageBytes);
        }

    }

    public void updateBook() throws ServletException, IOException {
        Integer bookId = Integer.parseInt(request.getParameter("bookId"));
        String title = request.getParameter("title");

        Book existBook = bookDAO.get(bookId);
        Book bookByTitle = bookDAO.findByTitle(title);
        if(!existBook.equals(bookByTitle)){
            String message = "Could not update book because there is another book having the same title";
            listBooks(message);
            return;
        }
        readBookFields(existBook);
        bookDAO.update(existBook);
        String message = "The book has been updated successfully";
        listBooks(message);
    }

    public void deleteBook() throws ServletException, IOException {
        Integer bookId = Integer.valueOf(request.getParameter("id"));
        bookDAO.delete(bookId);
        String message = "The book has been deleted successfully";
        listBooks(message);
    }

    public void listBooksByCategory() throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("id"));
        List<Book> listBooks = bookDAO.listByCategory(categoryId);
        request.setAttribute("listBooks", listBooks);

        String listPage = "frontend/books_list_by_category.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
        requestDispatcher.forward(request, response);
    }
}