package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String email;
    private String address;
    private List<Purchase> purchases;
    public Customer() {
    }
    public Customer(String name, String email, String address) {
        this.purchases=new ArrayList<Purchase>();
        this.name = name;
        this.email = email;
        this.address = address;
    }



    public void addPurchase(Purchase purchase){
        this.purchases.add(purchase);
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


}
