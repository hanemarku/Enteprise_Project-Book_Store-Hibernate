package com.bookstore.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Book.findAll", query = "select b from Book b"),
        @NamedQuery(name = "Book.findByTitle", query = "select b from Book b where b.title = :title"),
        @NamedQuery(name = "Book.countAll", query = "select count(b) from Book b"),
        @NamedQuery(name = "Book.findByCategory", query = "select b from Book b join Category c on b.category.categoryId = c.categoryId and c.categoryId = :catId"),
        @NamedQuery(name = "Book.listNew", query = "select b from Book b order by b.publishDate desc "),
        @NamedQuery(name = "Book.search", query = "select b from Book b where b.title LIKE CONCAT('%',:keyword,'%') OR b.author LIKE CONCAT('%',:keyword,'%')")

})
public class Book  implements java.io.Serializable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "book_id")
    private int bookId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "author")
    private String author;
    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "isbn")
    private String isbn;


    private transient String base64Image;
    @Basic
    @Column(name = "image")
    private byte[] image;
    @Basic
    @Column(name = "price")
    private double price;
    @Basic
    @Column(name = "publish_date")
    private Date publishDate;
    @Basic
    @Column(name = "last_update_time")
    private Date lastUpdateTime;
//    @Basic
//    @Column(name = "category_id")

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
    private Set<Review> reviews = new HashSet<Review>(0);

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }


    //    public Set<Review> getReviews() {
//        TreeSet<Review> sortedReviews = new TreeSet<>(new Comparator<Review>() {
//
//            @Override
//            public int compare(Review review1, Review review2) {
//                return review2.getReviewTime().compareTo(review1.getReviewTime());
//            }
//
//        });
//
//        sortedReviews.addAll(reviews);
//        return sortedReviews;
//    }
//
//    public void setReviews(Set<Review> reviews) {
//        this.reviews = reviews;
//    }

//    @OneToMany
//    private Set<Review> reviews = new HashSet<Review>(0);
//    @OneToMany
//    private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }


    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Transient
    public String getBase64Image(){
        this.base64Image = Base64.getEncoder().encodeToString(this.image);
        return this.base64Image;
    }

    @Transient
    public void setBase64Image(String base64Image){
        this.base64Image = base64Image;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return bookId == book.bookId;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Book book = (Book) o;
//
//        if (bookId != book.bookId) return false;
//        if (Double.compare(book.price, price) != 0) return false;
//        if (categoryId != book.categoryId) return false;
//        if (title != null ? !title.equals(book.title) : book.title != null) return false;
//        if (author != null ? !author.equals(book.author) : book.author != null) return false;
//        if (description != null ? !description.equals(book.description) : book.description != null) return false;
//        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
//        if (!Arrays.equals(image, book.image)) return false;
//        if (publishDate != null ? !publishDate.equals(book.publishDate) : book.publishDate != null) return false;
//        if (lastUpdateTime != null ? !lastUpdateTime.equals(book.lastUpdateTime) : book.lastUpdateTime != null)
//            return false;
//
//        return true;
//    }


    @Override
    public int hashCode() {
        int result;
        long temp;
        result = bookId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (lastUpdateTime != null ? lastUpdateTime.hashCode() : 0);

        return result;
    }
}
