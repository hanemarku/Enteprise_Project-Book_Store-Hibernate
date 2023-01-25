package com.bookstore.entity;

import com.bookstore.dao.ReviewDAO;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRatingTest {

    @Test
    public void testAverageRating(){
        Book book = new Book();
        Set<Review> reviews = new HashSet<>();
        Review review1 = new Review();
        review1.setRating(5);
        reviews.add(review1);
        book.setReviews(reviews);

        float averageRating = book.getAverageRating();
        assertEquals(5.0, averageRating, 0.0);
    }

    @Test
    public void testRatingString(){
        float averageRating = 0.0f;
        Book book = new Book();
        String actual = book.getRatingString(averageRating);
        String expected = "off,off,off,off,off";
        assertEquals(expected, actual);
    }

    @Test
    public void testRatingString3(){
        float averageRating = 3.0f;
        Book book = new Book();
        String actual = book.getRatingString(averageRating);
        String expected = "on,on,on,off,off";
        assertEquals(expected, actual);
    }

}










