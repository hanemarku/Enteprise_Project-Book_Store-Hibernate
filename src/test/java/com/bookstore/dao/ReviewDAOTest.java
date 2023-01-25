package com.bookstore.dao;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReviewDAOTest {
    private static ReviewDAO reviewDao;

    @BeforeEach
    public void setUp() {
        reviewDao = new ReviewDAO();
    }
    @AfterEach
    void tearDown() {
    }

    @Test
    public void testCreateReview() {
        Review review = new Review();
        Book book = new Book();
        book.setBookId(42);

        Customer customer = new Customer();
        customer.setCustomerId(12);

        review.setBook(book);
        review.setCustomer(customer);

        review.setHeadline("Excellent book!");
        review.setRating(5);
        review.setComment("A comprehensive book about Spring framework.");

        Review savedReview = reviewDao.create(review);

        assertTrue(savedReview.getReviewId() > 0);
    }

    @Test
    public void testGet() {
        Integer reviewId = 1;
        Review review = reviewDao.get(reviewId);

        assertNotNull(review);
    }

    @Test
    public void testUpdateReview() {
        Integer reviewId = 17;
        Review review = reviewDao.get(reviewId);
        review.setHeadline("Excellent book");

        Review updatedReview = reviewDao.update(review);

        assertEquals(review.getHeadline(), updatedReview.getHeadline());

    }

    @Test
    public void testDeleteReview() {
        int reviewId = 18;
        reviewDao.delete(reviewId);

        Review review = reviewDao.get(reviewId);

        assertNull(review);

    }

    @Test
    public void testListAll() {
        List<Review> listReview = reviewDao.listAll();

        for (Review review : listReview) {
            System.out.println(review.getReviewId() + " - " + review.getBook().getTitle()
                    + " - " + review.getCustomer().getFullname()
                    + " - " + review.getHeadline() + " - " + review.getRating());
        }

        assertTrue(listReview.size() > 0);
    }

    @Test
    public void testCount() {
        long totalReviews = reviewDao.count();
        System.out.println("Total Reviews: " + totalReviews);
        assertTrue(totalReviews > 0 );
    }


    @Test
    public void testFindByCustomerAndBookFound() {
        Integer customerId = 12;
        Integer bookId = 42;

        Review result = reviewDao.findByCustomerAndBook(customerId, bookId);

        assertNotNull(result);
    }

    @Test
    public void testListMostRecent() {
        List<Review> recentReviews = reviewDao.listMostRecent();

        assertEquals(3, recentReviews.size());
    }


}
