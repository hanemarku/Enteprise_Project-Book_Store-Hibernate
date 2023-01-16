package com.bookstore.dao;

import com.bookstore.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDAOTest extends BaseDAOTest{
    private static CategoryDAO categoryDAO;

    @BeforeEach
    public void setUp() {
        super.setUp();
        categoryDAO = new CategoryDAO(entityManager);
    }

    @AfterEach
    void tearDown() {
        super.tearDown();
    }

    @Test
    void create() {
        Category newCat = new Category("Python");
        Category category = categoryDAO.create(newCat);
        assertTrue(category != null && category.getCategoryId() > 0);
    }

    @Test
    void update() {
        Category cat = new Category("Java Core");
        cat.setCategoryId(1);
        Category category = categoryDAO.update(cat);
        assertEquals(cat.getName(), category.getName());
    }

    @Test
    void get() {
        Integer catId = 2;
        Category cat = categoryDAO.get(catId);
        assertNotNull(cat);
    }

    @Test
    void delete() {
        Integer catId = 3;
        categoryDAO.delete(catId);
        Category category = categoryDAO.get(catId);
        assertNull(category);
    }

    @Test
    public void listAll(){
        List<Category> categories = categoryDAO.listAll();
        assertTrue(categories.size() > 0);
    }

    @Test
    public void testCount(){
        long totalCategories = categoryDAO.count();
        assertEquals(2, totalCategories);
    }

}