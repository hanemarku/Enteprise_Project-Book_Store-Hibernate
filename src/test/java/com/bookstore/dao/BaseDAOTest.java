package com.bookstore.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BaseDAOTest {
    protected static EntityManagerFactory entityManagerFactory;
    protected static EntityManager entityManager;

    public void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();
    }

    void tearDown() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
