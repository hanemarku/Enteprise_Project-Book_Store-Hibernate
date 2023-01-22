package com.bookstore.dao;

import com.bookstore.entity.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerDAOTest {
    private static CustomerDAO customerDAO;
    @BeforeEach
    public void setUp() {
        customerDAO = new CustomerDAO();
    }
    @AfterEach
    void tearDown() {
    }
    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setEmail("customer11@gmail.com");
        customer.setFullname("test test");
        customer.setCity("New York");
        customer.setCountry("United States");
        customer.setAddress("100 North Avenue");
        customer.setPassword("test");
        customer.setPhone("18001900");
        customer.setZipcode("100000");

        Customer savedCustomer = customerDAO.create(customer);

        assertTrue(savedCustomer.getCustomerId() > 0);
    }

    @Test
    public void testGet() {
        Integer customerId = 11;
        Customer customer = customerDAO.get(customerId);

        assertNotNull(customer);
    }

    @Test
    public void testUpdateCustomer() {
        Customer customer = customerDAO.get(11);
        String firstname = "hanatest";
        customer.setFullname(firstname);
        customer.setPassword("123456");
        Customer updatedCustomer = customerDAO.update(customer);
        assertTrue(updatedCustomer.getFullname().equals(firstname));
    }

    @Test
    public void testDeleteCustomer() {
        Integer customerId = 16;
        customerDAO.delete(customerId);
        Customer customer = customerDAO.get(customerId);

        assertNull(customer);

    }

    @Test
    public void testListAll() {
        List<Customer> listCustomers = customerDAO.listAll();

        for (Customer customer : listCustomers) {
            System.out.println(customer.getFullname());
        }

        assertFalse(listCustomers.isEmpty());
    }

    @Test
    public void testCount() {
        long totalCustomers = customerDAO.count();

        assertEquals(1, totalCustomers);

    }

    @Test
    public void testFindByEmail() {
        String email = "customer11@gmail.com";
        Customer customer = customerDAO.findByEmail(email);

        assertNotNull(customer);

    }

    @Test
    public void testCheckLoginSuccess() {
        String email = "hana.marku22@gmail.com";
        String password = "Hana123.";

        Customer customer = customerDAO.checkLogin(email, password);

        assertNotNull(customer);

    }
//
//    @Test
//    public void testCheckLoginFail() {
//        String email = "abc@gmail.com";
//        String password = "secret";
//
//        Customer customer = customerDao.checkLogin(email, password);
//
//        assertNull(customer);
//
//    }
}