package com.dev.modelviewcontroller.Entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
public int ProductId;
@Column
public String productName;
@Column
public String productType;
@Column 
public int productAmount;
@Column
public int productQuantity;
@Lob
@Column(columnDefinition = "LONGBLOB")
private byte[] image;


    public Product(int ProductId, String productName, String productType, int productAmount, int productQuantity, byte[] image) {
        this.ProductId = ProductId;
        this.productName = productName;
        this.productType = productType;
        this.productAmount = productAmount;
        this.productQuantity = productQuantity;
        this.image = image;
    }

    public byte[] getImage() {
        return this.image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Product image(byte[] image) {
        setImage(image);
        return this;
    }

    public Product() {
    }

    public Product(int ProductId, String productName, String productType, int productAmount, int productQuantity) {
        this.ProductId = ProductId;
        this.productName = productName;
        this.productType = productType;
        this.productAmount = productAmount;
        this.productQuantity = productQuantity;
    }

    public int getProductId() {
        return this.ProductId;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return this.productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getProductAmount() {
        return this.productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public int getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Product ProductId(int ProductId) {
        setProductId(ProductId);
        return this;
    }

    public Product productName(String productName) {
        setProductName(productName);
        return this;
    }

    public Product productType(String productType) {
        setProductType(productType);
        return this;
    }

    public Product productAmount(int productAmount) {
        setProductAmount(productAmount);
        return this;
    }

    public Product productQuantity(int productQuantity) {
        setProductQuantity(productQuantity);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return ProductId == product.ProductId && Objects.equals(productName, product.productName) && Objects.equals(productType, product.productType) && productAmount == product.productAmount && productQuantity == product.productQuantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ProductId, productName, productType, productAmount, productQuantity);
    }

    @Override
    public String toString() {
        return "{" +
            " ProductId='" + getProductId() + "'" +
            ", productName='" + getProductName() + "'" +
            ", productType='" + getProductType() + "'" +
            ", productAmount='" + getProductAmount() + "'" +
            ", productQuantity='" + getProductQuantity() + "'" +
            "}";
    }


}
