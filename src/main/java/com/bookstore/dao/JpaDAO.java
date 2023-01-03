package com.bookstore.dao;

import jakarta.persistence.EntityManager;

import java.util.List;

public class JpaDAO<T> {
    protected EntityManager entityManager;

    public JpaDAO(EntityManager entityManager) {
        super();
        this.entityManager = entityManager;
    }

//    @Override
    public T create(T t) {
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.flush();
        entityManager.refresh(t);
        entityManager.getTransaction().commit();
        return t;
    }

//    @Override
    public T update(T t) {
        return null;
    }

//    @Override
    public T get(Object id) {
        return null;
    }

//    @Override
    public void delete(Object id) {

    }

//    @Override
    public List<T> listAll() {
        return null;
    }

//    @Override
    public long count() {
        return 0;
    }
}
