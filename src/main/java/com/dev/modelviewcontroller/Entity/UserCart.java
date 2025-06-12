package com.dev.modelviewcontroller.Entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_cart")
public class UserCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Integer cartid; // changed from int to Integer

    @Column(name = "product_name")
    private String CPName;

    @Column(name = "user_address")
    private String UserAdd;

    @Column(name = "product_amount")
    private Integer CPA;

    @Column(name = "quantity")
    private Integer Quantity;

    public UserCart() {
    }

    public UserCart(Integer cartid, String CPName, String UserAdd, Integer CPA, Integer Quantity) {
        this.cartid = cartid;
        this.CPName = CPName;
        this.UserAdd = UserAdd;
        this.CPA = CPA;
        this.Quantity = Quantity;
    }

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
        return UserAdd;
    }

    public void setUserAdd(String UserAdd) {
        this.UserAdd = UserAdd;
    }

    public Integer getCPA() {
        return CPA;
    }

    public void setCPA(Integer CPA) {
        this.CPA = CPA;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    public UserCart cartid(Integer cartid) {
        this.cartid = cartid;
        return this;
    }

    public UserCart CPName(String CPName) {
        this.CPName = CPName;
        return this;
    }

    public UserCart UserAdd(String UserAdd) {
        this.UserAdd = UserAdd;
        return this;
    }

    public UserCart CPA(Integer CPA) {
        this.CPA = CPA;
        return this;
    }

    public UserCart Quantity(Integer Quantity) {
        this.Quantity = Quantity;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCart userCart)) return false;
        return Objects.equals(cartid, userCart.cartid) &&
                Objects.equals(CPName, userCart.CPName) &&
                Objects.equals(UserAdd, userCart.UserAdd) &&
                Objects.equals(CPA, userCart.CPA) &&
                Objects.equals(Quantity, userCart.Quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartid, CPName, UserAdd, CPA, Quantity);
    }

    @Override
    public String toString() {
        return "UserCart{" +
                "cartid=" + cartid +
                ", CPName='" + CPName + '\'' +
                ", UserAdd='" + UserAdd + '\'' +
                ", CPA=" + CPA +
                ", Quantity=" + Quantity +
                '}';
    }
}
