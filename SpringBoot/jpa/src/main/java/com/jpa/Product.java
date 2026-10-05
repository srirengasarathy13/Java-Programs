package com.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product{
    @Id
    private String productId;
    private String productName;
    private String category;
    private int price;
    private int quantity;

    public Product(){

    }

    public Product(String productId, String productName, String category, int price, int quantity){
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductId(){
        return productId;
    } 
    public void setProductId(String productId){
        this.productId = productId;
    }

    public String getProductName(){
        return productName;
    } 
    public void setProductName(String productName){
        this.productName = productName;
    }

    public String getCategory(){
        return category;
    } 
    public void setCategory(String category){
        this.category = category;
    }

    public int getPrice(){
        return price;
    } 
    public void setPrice(int price){
        this.price = price;
    }

    public int getQuantity(){
        return quantity;
    } 
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
