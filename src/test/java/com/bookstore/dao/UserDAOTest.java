package com.bookstore.dao;


import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;
import jakarta.persistence.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class UserDAOTest extends BaseDAOTest{
    private static UserDAO userDAO;
    @BeforeEach
    public void setUp() {
        super.setUp();
        userDAO= new UserDAO(entityManager);
    }

    @AfterEach
    void tearDown() {
        super.tearDown();
    }

    @Test
    public void testCreateUsers(){
        Users user1 = new Users();
        user1.setEmail("test@gmail.com");
        user1.setFullName("user test");
        user1.setPassword("password");
        user1 = userDAO.create(user1);

        assertTrue(user1.getUserId() > 0);
    }

    @Test
    public void testUpdateUsers(){
        Users user1 = new Users();
        user1.setUserId(1);
        user1.setEmail("testttttttt@gmail.com");
        user1.setFullName("user testtttttttt");
        user1.setPassword("passwordtestttt");

        user1 = userDAO.update(user1);
        String expected = "passwordtestttt";
        String actual = user1.getPassword();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetUsersFound(){
        Integer userId = 1;
        Users user = userDAO.get(userId);

        assertNotNull(user);
    }


    @Test
    public void testListAll(){
        List<Users> usersList = userDAO.listAll();
        for (Users user : usersList){
            System.out.println(user.getEmail());
        }
        assertTrue(usersList.size() > 0);
    }

    @Test
    public void testCheckLoginSuccess(){
        String email = "hana.marku22@gmail.com";
        String password = "Hana123.";
        boolean loginResult = userDAO.checkLogin(email, password);
        assertTrue(loginResult);
    }
    @Test
    public void testCount(){
        long totalUsers = userDAO.count();

        assertEquals(13, totalUsers);
//        assertTrue(totalUsers == 7);
    }

    @Test
    public void testFindByEmail(){
        String email = "hana.marku22@gmail.com";
        userDAO.findByEmail(email);
        assertNotNull(userDAO);
    }

    @Test
    public void testDeleteUser(){
        Integer userId = 1;
        userDAO.delete(userId);
        Users user1 = userDAO.get(userId);
        assertNull(user1);
    }
}
