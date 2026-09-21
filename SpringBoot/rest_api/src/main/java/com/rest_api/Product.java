package com.rest_api;

public class Product {
    private int productId;
    private String productName;
    private String category;
    private int price;
    private int stockQuantity;

    public Product( int productId, String productName, String category, int price, int stockQuantity){
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public int getProductId(){
        return productId;
    }
    public String getProductName(){
        return productName;
    }
    public String getCategory(){
        return category;
    }
    public int getPrice(){
        return price;
    }
    public int getStockQuantity(){
        return stockQuantity;
    }
}
