package com.bookstore.entity;

import jakarta.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u ORDER BY u.fullName"),
//        @NamedQuery(name = "Users.countAll", query = "SELECT Count(u) from Users u"),
        @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
        @NamedQuery(name = "Users.checkLogin", query = "SELECT u FROM Users u WHERE u.email = :email AND u.password = :password"),

})
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "full_name")
    private String fullName;

    public Users(String email, String password, String fullName) {
        super();
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public Users(int userId, String email, String password, String fullName) {
        this(email, password, fullName);
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Users() {
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != users.userId) return false;
        if (email != null ? !email.equals(users.email) : users.email != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (fullName != null ? !fullName.equals(users.fullName) : users.fullName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        return result;
    }
}
