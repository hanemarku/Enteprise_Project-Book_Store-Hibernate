package com.bookstore.dao;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
//import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;


public class BookDAOTest{
    private static BookDAO bookDAO;
    @BeforeEach
    public void setUp() {
        bookDAO = new BookDAO();
    }
    @AfterEach
    void tearDown() {

    }

    @Test
    public void testCreateBook() throws ParseException, ParseException {
        Book newBook = new Book();
        Category category = new Category();
        category.setCategoryId(9);
        newBook.setCategory(category);
        newBook.setTitle("c++");
        newBook.setAuthor("Joshua Bloch");
        newBook.setDescription("New coverage of generics");
        newBook.setPrice(387);
        newBook.setIsbn("0239828139");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date publishDate = dateFormat.parse("01/04/2022");
        newBook.setPublishDate(publishDate);
        newBook.setImage("test".getBytes());
        Book book = bookDAO.create(newBook);
        assertTrue(book.getBookId() > 0);

    }

    @Test
    public void testUpdateBook() throws ParseException, ParseException {
        Book existBook = new Book();
        existBook.setBookId(32);

        Category category = new Category("Advanced Java");
        category.setCategoryId(2);
        existBook.setCategory(category);
        existBook.setTitle("testtest");
        existBook.setAuthor("Joshua Bloch");
        existBook.setDescription("New coverage of generics");
        existBook.setPrice(387);
        existBook.setIsbn("0239828139");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date publishDate = dateFormat.parse("01/04/2022");
        existBook.setPublishDate(publishDate);
        existBook.setImage("test".getBytes());
        Book updatedBook = bookDAO.update(existBook);
        assertEquals(updatedBook.getTitle(), "testtest");
    }

    @Test
    void deleteFail() {
        Integer bookId = 34;
        bookDAO.delete(bookId);
        assertTrue(true);
    }

    @Test
    public void testListALl(){
        List<Book> bookList = bookDAO.listAll();
        assertFalse(bookList.isEmpty());
    }

    @Test
    public void testFindByName(){
        String title = "testtest";
        Book book = bookDAO.findByTitle(title);
        assertNotNull(book);
    }

    @Test
    public void  testGetBookSuccess(){
        Integer bookId = 36;
        Book book = bookDAO.get(bookId);
        assertNotNull(book);
    }

    @Test
    public void countBooks(){
        long toalBooks = bookDAO.count();
        assertEquals(6, toalBooks);
    }

    @Test
    public void testListByCategory(){
        int catId = 2;
        List<Book> bookList = bookDAO.listByCategory(catId);
        assertTrue(bookList.size() > 0);
    }

    @Test
    public void testListNewBook(){
        List<Book> newBookList = bookDAO.listNewBooks();
        assertEquals(newBookList.size(), 4);
    }

    @Test
    public void testSearchBookTitle(){
        String keyword = "Java";
        List<Book> search = bookDAO.search(keyword);
        for (Book book : search){
            System.out.println(book.getTitle());
        }
        assertEquals(4, search.size());
    }

}
