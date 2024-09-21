package com.example.service;

import com.example.model.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService extends BaseService {
    public static List<Customer> customers = new ArrayList<Customer>();
    static{
        Customer customer1 = new Customer("Min Min","min@gmail.com","Dawei");
        Customer customer2 = new Customer("Ni Ni","ni@gmail.com","Dawei");
        Customer customer3 = new Customer("Lin Lin","lin@gmail.com","Dawei");
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
    }
    public CustomerService() {

    }
    public Customer getCustomerData() throws IOException {
        Customer customer=null;
        do{
            System.out.println("Enter Your Registered Email!!");
            String email=br.readLine();
            customer=findCustomerByEmail(email);
            if(customer==null){System.out.println("User does not exist int the System!!");}
        }while(customer==null);

        return customer;
    }
    public Customer findCustomerByEmail(String email) {
        for (Customer customer: customers) {
           if(customer.getEmail().equals(email)){
               return customer;
           }
        }
        return null;
    }
}
