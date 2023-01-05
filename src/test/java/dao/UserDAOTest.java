package dao;


import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;
import jakarta.persistence.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class UserDAOTest {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static UserDAO userDAO;

    @BeforeClass
    private static void setUpClass(){
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();
        userDAO = new UserDAO(entityManager);
    }


    @Test
    public void testCreateUsers(){
        Users user1 = new Users();
        user1.setEmail("test@gmail.com");
        user1.setFullName("user test");
        user1.setPassword("password");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        UserDAO userDAO = new UserDAO(entityManager);
        user1 = userDAO.create(user1);

        entityManager.close();
        entityManagerFactory.close();

        assertTrue(user1.getUserId() > 0);
    }

    @Test
    public void testGetUsersFound(){
        Integer userId = 1;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDAO userDAO = new UserDAO(entityManager);

        Users user = userDAO.get(userId);
        entityManager.close();
        entityManagerFactory.close();

        assertNotNull(user);
    }

    @Test( )
    public void testDeleteUser(){
        Integer userId = 13;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDAO userDAO = new UserDAO(entityManager);

        userDAO.delete(userId);
        Users user1 = userDAO.get(userId);
        entityManager.close();
        entityManagerFactory.close();

        assertNull(user1);
    }

//    @Test(expected = PersistenceException.class)
//    public void testCreateUsersFieldsNotSet(){
//        Users user1 = new Users();
//        user1 = userDAO.create(user1);
//    }


    @AfterClass
    public static void tearDownClass(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
