package dao;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class UserDAOTest {

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
}
