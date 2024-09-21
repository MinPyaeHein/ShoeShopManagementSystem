package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Shoe {
    private int id;
    private String name;
    private String color;
    private double size;
    private String type;
    private double price;
    private int stockQty;
    private int purchaseCount;
    private List<Purchase> purchases;
    public Shoe(int id,String name, String color, double size,int stockQty,double price){
        this.purchases = new ArrayList<Purchase>();
        this.name = name;
        this.color = color;
        this.size = size;
        this.id = id;
        this.stockQty = stockQty;
        this.price = price;
    }

    public  int getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(int qty) {
        this.purchaseCount+=qty;
    }

    public void addPurchase(Purchase purchase){
        this.purchases.add(purchase);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Shoe{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", size=" + size +
                ", type='" + type + '\'' +
                ", stockQty=" + stockQty +
                '}';
    }



}

