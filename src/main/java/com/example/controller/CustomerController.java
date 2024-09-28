package com.example.controller;

import com.example.model.Customer;
import com.example.service.CustomerService;
import com.example.service.impl.CustomerServiceImpl;

import java.io.IOException;

public class CustomerController extends BaseController {
    private CustomerService customerService;
    public CustomerController() throws IOException {
        this.customerService=new CustomerServiceImpl();
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
                    this.updateCustomer();
                    break;
                case 3:
                    this.deleteCustomer();
                    break;
                case 4:
                    this.displayAllCustomer();
                    break;
                default:
                    System.out.println("Invalid Option!!");
                    break;

        }

    }
    public void registerCustomer() throws IOException {
        Customer customer=getCustomerInformation();
        if(this.customerService.saveCustomer(customer)){
            System.out.println("Customer Registered Successfully!!");
        }else{
            System.out.println("Failed to Register Customer!!");
        }
    }
    public void updateCustomer() throws IOException {
        Customer customer=customerService.getCustomerDataByEmail();
        if(customer!=null){
            System.out.println("!!Current Customer Data!!\n"+customer);
            Customer customerUpdated=this.getCustomerInformation();
            customerService.updateCustomer(customer, customerUpdated);
        }

    }
    public void deleteCustomer() throws IOException {
        Customer customer=this.customerService.getCustomerDataByEmail();
        this.customerService.deleteCustomer(customer);
    }

    public Customer getCustomerInformation() throws IOException {
        Customer customer=new Customer();
        System.out.println("Enter Your Email!!");
        customer.setEmail(br.readLine());
        System.out.println("Enter Your Name!!");
        customer.setName(br.readLine());
        System.out.println("Enter Your Address!!");
        customer.setAddress(br.readLine());
        return customer;
    }
    public void displayAllCustomer(){
        this.customerService.displayAllCustomers();

    }

}
