package com.example.controller;

import com.example.model.Customer;
import com.example.service.CustomerService;

import java.io.IOException;

public class CustomerController extends BaseController {
    private CustomerService customerService;
    public CustomerController() throws IOException {
        this.customerService=new CustomerService();
        System.out.println("Welcome to Customer Master Dashboard!!");
        System.out.println("Enter menu number that you want to perform::\n " +
                "1. Customer Registration\n " +
                "2. Update Customer Data\n " +
                "3. Delete Customer\n " +
                "4. Display All Customers");
        int menu=Integer.parseInt(br.readLine());
        switch (menu) {
                case 1:
                    registerCustomer();
                    break;
                case 2:
                    //TODO: update customer data
                    break;
                case 3:
                    //TODO: delete customer
                    break;
                case 4:
                    //TODO: display all customers
                    break;
                default:
                    System.out.println("Invalid Option!!");
                    break;

        }

    }
    public void registerCustomer() throws IOException {
        Customer customer=new Customer();
        System.out.println("Enter Your Email!!");
        customer.setEmail(br.readLine());
        System.out.println("Enter Your Name!!");
        customer.setName(br.readLine());
        System.out.println("Enter Your Address!!");
        customer.setAddress(br.readLine());
        if(this.customerService.saveCustomerData(customer)){
            System.out.println("Customer Registered Successfully!!");
        }else{
            System.out.println("Failed to Register Customer!!");
        }
    }

}
