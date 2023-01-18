package com.bookstore.dao;

import com.bookstore.entity.Book;
import com.bookstore.entity.Book;
import com.bookstore.entity.Category;
import jakarta.persistence.EntityManager;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.List;


public class BookDAO extends JpaDAO<Book> implements GenericDAO<Book>{
    public BookDAO(EntityManager entityManager) {
        super(entityManager);
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

    @Override
    public List<Book> listAll() {
        return super.findWithNamedQuery("Book.findAll");
    }

    @Override
    public long count(){
        return super.countWithNamedQuery("Book.countAll");
    }

}
