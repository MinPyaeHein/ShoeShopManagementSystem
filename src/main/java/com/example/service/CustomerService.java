package com.example.service;

import com.example.model.Customer;

import java.io.IOException;

public interface CustomerService {
    public Customer getCustomerDataByEmail() throws IOException;
    public Boolean saveCustomer(Customer customer)throws IOException ;
    public void updateCustomer(Customer currentCustomer,Customer updatedcustomer)throws IOException ;
    public void deleteCustomer(Customer customer) ;
    public void displayAllCustomers();
}
