package com.bookstore.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "book_order", schema = "bookstoredb", catalog = "")
public class BookOrder {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id")
    private int orderId;
    @Basic
    @Column(name = "customer_id")
    private int customerId;
    @Basic
    @Column(name = "order_date")
    private Timestamp orderDate;
    @Basic
    @Column(name = "shipping_address")
    private String shippingAddress;
    @Basic
    @Column(name = "recipient_name")
    private String recipientName;
    @Basic
    @Column(name = "recipient_phone")
    private String recipientPhone;
    @Basic
    @Column(name = "payment_method")
    private String paymentMethod;
    @Basic
    @Column(name = "total")
    private double total;
    @Basic
    @Column(name = "status")
    private String status;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookOrder bookOrder = (BookOrder) o;

        if (orderId != bookOrder.orderId) return false;
        if (customerId != bookOrder.customerId) return false;
        if (Double.compare(bookOrder.total, total) != 0) return false;
        if (orderDate != null ? !orderDate.equals(bookOrder.orderDate) : bookOrder.orderDate != null) return false;
        if (shippingAddress != null ? !shippingAddress.equals(bookOrder.shippingAddress) : bookOrder.shippingAddress != null)
            return false;
        if (recipientName != null ? !recipientName.equals(bookOrder.recipientName) : bookOrder.recipientName != null)
            return false;
        if (recipientPhone != null ? !recipientPhone.equals(bookOrder.recipientPhone) : bookOrder.recipientPhone != null)
            return false;
        if (paymentMethod != null ? !paymentMethod.equals(bookOrder.paymentMethod) : bookOrder.paymentMethod != null)
            return false;
        if (status != null ? !status.equals(bookOrder.status) : bookOrder.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = orderId;
        result = 31 * result + customerId;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (shippingAddress != null ? shippingAddress.hashCode() : 0);
        result = 31 * result + (recipientName != null ? recipientName.hashCode() : 0);
        result = 31 * result + (recipientPhone != null ? recipientPhone.hashCode() : 0);
        result = 31 * result + (paymentMethod != null ? paymentMethod.hashCode() : 0);
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
