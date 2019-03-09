package com.example.farhadhossain.tongdemo2;

/**
 * Created by Farhad Hossain on 12-Feb-19.
 */

public class Product {
    public String id;
    public String productName;
    public String category;
    public int quantity;
    public double purchasePrice;
    public double sellPrice;

    public Product(String id, String productName, String category, int quantity, double purchasePrice, double sellPrice) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
    }
    public Product(String id, String productName, String category, int quantity) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

//    public Product(String id, String productName, String category, int quantity, double purchasePrice, double sellPrice) {
//        this.id = id;
//        this.productName = productName;
//        this.email = email;
//        this.password = password;
//    }

}
