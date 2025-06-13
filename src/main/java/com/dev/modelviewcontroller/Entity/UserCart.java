package com.dev.modelviewcontroller.Entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_cart")
public class UserCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Integer cartid;

    @Column(name = "product_name")
    private String CPName;

    @Column(name = "user_address")
    private String userAdd;

    @Column(name = "product_amount")
    private Integer CPA;

    @Column(name = "quantity")
    private Integer quantity;

    // ✅ ManyToOne relation with UserTable
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserTable user;

    // ✅ Default Constructor
    public UserCart() {}

    // ✅ Constructor for testing (without UserTable)
    public UserCart(Integer cartid, String CPName, String userAdd, Integer CPA, Integer quantity) {
        this.cartid = cartid;
        this.CPName = CPName;
        this.userAdd = userAdd;
        this.CPA = CPA;
        this.quantity = quantity;
    }

    // ✅ Constructor with User (for app logic)
    public UserCart(Integer cartid, String CPName, String userAdd, Integer CPA, Integer quantity, UserTable user) {
        this.cartid = cartid;
        this.CPName = CPName;
        this.userAdd = userAdd;
        this.CPA = CPA;
        this.quantity = quantity;
        this.user = user;
    }

    // ✅ Getters and Setters
    public Integer getCartid() {
        return cartid;
    }

    public void setCartid(Integer cartid) {
        this.cartid = cartid;
    }

    public String getCPName() {
        return CPName;
    }

    public void setCPName(String CPName) {
        this.CPName = CPName;
    }

    public String getUserAdd() {
        return userAdd;
    }

    public void setUserAdd(String userAdd) {
        this.userAdd = userAdd;
    }

    public Integer getCPA() {
        return CPA;
    }

    public void setCPA(Integer CPA) {
        this.CPA = CPA;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public UserTable getUser() {
        return user;
    }

    public void setUser(UserTable user) {
        this.user = user;
    }

    // ✅ equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCart)) return false;
        UserCart that = (UserCart) o;
        return Objects.equals(cartid, that.cartid) &&
                Objects.equals(CPName, that.CPName) &&
                Objects.equals(userAdd, that.userAdd) &&
                Objects.equals(CPA, that.CPA) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartid, CPName, userAdd, CPA, quantity, user);
    }

    // ✅ toString
    @Override
    public String toString() {
        return "UserCart{" +
                "cartid=" + cartid +
                ", CPName='" + CPName + '\'' +
                ", userAdd='" + userAdd + '\'' +
                ", CPA=" + CPA +
                ", quantity=" + quantity +
                ", user=" + (user != null ? user.getId() : null) +
                '}';
    }
}
