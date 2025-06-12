package com.dev.modelviewcontroller.Entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment_history")
public class PaymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentId;
    private String orderId;
    private String productName;
    private Integer amount;
    private String currency;
    private String userAddress;
    private LocalDateTime paymentTime;

    // Default constructor
    public PaymentHistory() {
    }

    // ✅ Constructor without ID (used when creating new record)
    public PaymentHistory(String paymentId, String orderId, String productName, Integer amount,
                          String currency, String userAddress, LocalDateTime paymentTime) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.productName = productName;
        this.amount = amount;
        this.currency = currency;
        this.userAddress = userAddress;
        this.paymentTime = paymentTime;
    }

    // Constructor with ID (optional)
    public PaymentHistory(Long id, String paymentId, String orderId, String productName, Integer amount,
                          String currency, String userAddress, LocalDateTime paymentTime) {
        this.id = id;
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.productName = productName;
        this.amount = amount;
        this.currency = currency;
        this.userAddress = userAddress;
        this.paymentTime = paymentTime;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    // Builder methods (optional)
    public PaymentHistory id(Long id) {
        setId(id);
        return this;
    }

    public PaymentHistory paymentId(String paymentId) {
        setPaymentId(paymentId);
        return this;
    }

    public PaymentHistory orderId(String orderId) {
        setOrderId(orderId);
        return this;
    }

    public PaymentHistory productName(String productName) {
        setProductName(productName);
        return this;
    }

    public PaymentHistory amount(Integer amount) {
        setAmount(amount);
        return this;
    }

    public PaymentHistory currency(String currency) {
        setCurrency(currency);
        return this;
    }

    public PaymentHistory userAddress(String userAddress) {
        setUserAddress(userAddress);
        return this;
    }

    public PaymentHistory paymentTime(LocalDateTime paymentTime) {
        setPaymentTime(paymentTime);
        return this;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentHistory that)) return false;
        return Objects.equals(id, that.id) &&
                Objects.equals(paymentId, that.paymentId) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(userAddress, that.userAddress) &&
                Objects.equals(paymentTime, that.paymentTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentId, orderId, productName, amount, currency, userAddress, paymentTime);
    }

    // toString()
    @Override
    public String toString() {
        return "PaymentHistory{" +
                "id=" + id +
                ", paymentId='" + paymentId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", productName='" + productName + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", paymentTime=" + paymentTime +
                '}';
    }
} 
