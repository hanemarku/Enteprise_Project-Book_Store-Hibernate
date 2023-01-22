package com.bookstore.dao;

import com.bookstore.entity.Book;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.List;


public class BookDAO extends JpaDAO<Book> implements GenericDAO<Book>{
    public BookDAO() {
    }

    @Override
    public Book create(Book book) {
        book.setLastUpdateTime(new java.util.Date());
        return super.create(book);
    }

    @Override
    public void delete(Object bookId) {
        super.delete(Book.class, bookId);
    }

    @Override
    public Book update(Book book) {
        book.setLastUpdateTime(new java.util.Date());
        return super.update(book);
    }

    @Override
    public Book get(Object bookId) {
        return super.find(Book.class, bookId);
    }


    public Book findByTitle(String title){
        List<Book> result = super.findWithNamedQuery("Book.findByTitle", "title", title);
        if(!result.isEmpty()){
            return result.get(0);
        }
        return null;
    }

    public List<Book> listByCategory(int categoryId){
        return super.findWithNamedQuery("Book.findByCategory", "catId", categoryId);
    }

    public List<Book> listNewBooks(){
        return super.findWithNamedQuery("Book.listNew", 0, 4);
    }

    public List<Book> search(String keyword){
        return super.findWithNamedQuery("Book.search", "keyword", keyword);
    }

    @Override
    public List<Book> listAll() {
        return super.findWithNamedQuery("Book.findAll");
    }

    @Override
    public long count(){
        return super.countWithNamedQuery("Book.countAll");
    }

}
