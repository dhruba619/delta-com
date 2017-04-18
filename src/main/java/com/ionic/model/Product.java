package com.ionic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {
    @NotNull
    @Size(min = 1)
    private String productName;
    @NotNull
    @Size(min = 1)
    @Id
    private String productId;
    @NotNull
    @Size(min = 1)
    private String categoryId;
    private String image;
    @NotNull
    @Size(min = 1)
    private String units;
    @NotNull
    @Size(min = 1)
    private double quantity;
    @NotNull
    @Size(min = 1)
    private double price;
    private int discount;
    private String productDescription;
    private String brand;
    @NotNull
    @Size(min = 1)
    private boolean isAvail;
    @NotNull
    @Size(min = 1)
    private String marketAvail;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isAvail() {
        return isAvail;
    }

    public void setAvail(boolean isAvail) {
        this.isAvail = isAvail;
    }

    public String getMarketAvail() {
        return marketAvail;
    }

    public void setMarketAvail(String marketAvail) {
        this.marketAvail = marketAvail;
    }

}
