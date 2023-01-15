package dao;


import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;
import jakarta.persistence.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class UserDAOTest {
//    private static EntityManagerFactory entityManagerFactory;
//    private static EntityManager entityManager;
//    private static UserDAO userDAO;
//
//    @BeforeClass
//    private static void setUpClass(){
//        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
//        entityManager = entityManagerFactory.createEntityManager();
//        userDAO = new UserDAO(entityManager);
//    }


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
    public void testUpdateUsers(){
        Users user1 = new Users();
        user1.setUserId(1);
        user1.setEmail("testttttttt@gmail.com");
        user1.setFullName("user testtttttttt");
        user1.setPassword("passwordtestttt");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        UserDAO userDAO = new UserDAO(entityManager);
        user1 = userDAO.update(user1);
        String expected = "passwordtestttt";
        String actual = user1.getPassword();

        entityManager.close();
        entityManagerFactory.close();

        assertEquals(expected, actual);
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


    @Test
    public void testListAll(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDAO userDAO = new UserDAO(entityManager);
        List<Users> usersList = userDAO.listAll();

        for (Users user : usersList){
            System.out.println(user.getEmail());
        }

        entityManager.close();
        entityManagerFactory.close();

        assertTrue(usersList.size() > 0);
    }

    @Test
    public void testCount(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDAO userDAO = new UserDAO(entityManager);
        long totalUsers = userDAO.count();


        entityManager.close();
        entityManagerFactory.close();

        assertEquals(13, totalUsers);
//        assertTrue(totalUsers == 7);
    }

    @Test
    public void testFindByEmail(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDAO userDAO = new UserDAO(entityManager);
        String email = "hana.marku22@gmail.com";
        userDAO.findByEmail(email);


        entityManager.close();
        entityManagerFactory.close();

        assertNotNull(userDAO);
    }

    @Test
    public void testDeleteUser(){
        Integer userId = 1;
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


//    @AfterClass
//    public static void tearDownClass(){
//        entityManager.close();
//        entityManagerFactory.close();
//    }
}
