package com.example.dao;

import com.example.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private static List<Customer> customers = new ArrayList<Customer>();
    static{
        Customer customer1 = new Customer("Min Min","min@gmail.com","Dawei");
        Customer customer2 = new Customer("Ni Ni","ni@gmail.com","Dawei");
        Customer customer3 = new Customer("Lin Lin","lin@gmail.com","Dawei");
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
    }
    public Customer findCustomerByEmail(String email) {
        for (Customer customer: customers) {
            if(customer.getEmail().equals(email)){
                return customer;
            }
        }
        return null;
    }
    public static List<Customer> getAllCustomers( ){
        return customers;
    }
    public void saveCustomer(Customer customer) {
         customers.add(customer);
     }
     public void deleteCustomerByEmail(String email) {
                customers.remove(findCustomerByEmail(email));
        }
     }


