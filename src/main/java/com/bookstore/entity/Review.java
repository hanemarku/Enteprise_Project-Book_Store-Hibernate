package com.bookstore.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity

@NamedQueries({
        @NamedQuery(name = "Review.listAll", query = "SELECT r FROM Review r ORDER BY r.reviewTime DESC"),
        @NamedQuery(name = "Review.countAll", query = "SELECT COUNT(r) FROM Review r"),
        @NamedQuery(name = "Review.findByCustomerAndBook",
                query = "SELECT r FROM Review r WHERE r.customer.customerId =:customerId"
                        + " AND r.book.bookId =:bookId"),
        @NamedQuery(name = "Review.mostFavoredBooks",
                query = "SELECT r.book, COUNT(r.book.bookId) AS ReviewCount, AVG(r.rating) as AvgRating FROM Review r "
                        + "GROUP BY r.book.bookId HAVING AVG(r.rating) >= 4.0 "
                        + "ORDER BY ReviewCount DESC, AvgRating DESC")
})
public class Review {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "review_id")
    private int reviewId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
    @Basic
    @Column(name = "rating")
    private int rating;
    @Basic
    @Column(name = "headline")
    private String headline;
    @Basic
    @Column(name = "comment")
    private String comment;
    @Basic
    @Column(name = "review_time")
    private Date reviewTime;

    public Review(int reviewId, Customer customer, Book book, int rating, String headline, String comment, Date reviewTime) {
        this.reviewId = reviewId;
        this.customer = customer;
        this.book = book;
        this.rating = rating;
        this.headline = headline;
        this.comment = comment;
        this.reviewTime = reviewTime;
    }

    public Review() {
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public void setReviewTime(Timestamp reviewTime) {
        this.reviewTime = reviewTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (reviewId != review.reviewId) return false;
        if (rating != review.rating) return false;
        if (headline != null ? !headline.equals(review.headline) : review.headline != null) return false;
        if (comment != null ? !comment.equals(review.comment) : review.comment != null) return false;
        if (reviewTime != null ? !reviewTime.equals(review.reviewTime) : review.reviewTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reviewId;
        result = 31 * result + rating;
        result = 31 * result + (headline != null ? headline.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (reviewTime != null ? reviewTime.hashCode() : 0);
        return result;
    }


    @Transient
    public String getStars() {
        String result = "";

        int numberOfStarsOn = (int) rating;

        for (int i = 1; i <= numberOfStarsOn; i++) {
            result += "on,";
        }

        for (int j = numberOfStarsOn + 1; j <= 5; j++) {
            result += "off,";
        }

        return result.substring(0, result.length() - 1);
    }
}
