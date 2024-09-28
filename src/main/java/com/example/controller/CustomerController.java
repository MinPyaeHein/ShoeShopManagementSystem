package com.example.controller;

import com.example.dao.CustomerDao;
import com.example.model.Customer;
import com.example.service.CustomerService;

import java.io.IOException;
import java.util.List;

public class CustomerController extends BaseController {
    private CustomerService customerService;
    private CustomerDao customerDao;
    public CustomerController() throws IOException {
        this.customerService=new CustomerService();
        this.customerDao=new CustomerDao();
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
                	updateCustomer();
                    break;
                case 3:
                	deleteCustomer();
                    break;
                case 4:
                	displayAllCustomers();
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
    
    public void updateCustomer() throws IOException{
    	System.out.print("Enter customer email to Update: ");
    	String email = br.readLine();
    	
    	Customer existingCustomer = customerDao.findCustomerByEmail(email);
    	if(existingCustomer == null) {
    		System.out.println("Customer with this email does not exist.");
    		return;
    	}
    	
    	System.out.println("Current detial: ");
    	System.out.println("Name: " + existingCustomer.getName());
        System.out.println("Address: " + existingCustomer.getAddress());
        
        System.out.println("Enter new Name :");
        String newName = br.readLine();
        existingCustomer.setName(newName);
        
        System.out.println("Enter new Address");
        String newAddress = br.readLine();
        existingCustomer.setAddress(newAddress);
        
        System.out.println("Enter new email: ");
        String newEmail = br.readLine();
        existingCustomer.setEmail(newEmail);
    }
    
    public void deleteCustomer() throws IOException{
    	System.out.print("Enter customer email to detete: ");
    	String email = br.readLine();
    	
    	Customer existingCustomer = customerDao.findCustomerByEmail(email);
    	if(existingCustomer == null) {
    		System.out.println("Customer with this email does not exist.");
    	}
        existingCustomer.setName(" ");
        existingCustomer.setAddress(" ");
        existingCustomer.setEmail(" ");
        System.out.println("Delete customer information sucess ");
    }
    
    public void displayAllCustomers() {
    	List<Customer> customers = customerDao.getAllCustomers();
    	 for (Customer customer : customers) {
    	        System.out.println("Email: " + customer.getEmail() +" Name: "+ customer.getName() + " Address: "+ customer.getAddress());
    }
    }
    

}
