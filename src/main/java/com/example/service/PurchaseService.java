package com.example.service;

import com.example.model.Customer;
import com.example.model.Purchase;
import com.example.model.Shoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PurchaseService extends BaseService{

    private CustomerService customerService;
    private ShoeService shoeService;
  
    public PurchaseService() throws IOException {
        customerService=new CustomerService();
        shoeService=new ShoeService();
        String flag=null;
        do{
            doPurchase();
            System.out.println("Do you want to purchase more Yes or No??");
            flag=br.readLine();
        }while(flag.equals("yes"));

    }
    public Purchase doPurchase() throws IOException {
        Customer customer=customerService.getCustomerData();
        Shoe shoe=shoeService.getShoeData();
        
        System.out.println("Enter Qty of purchase::");
        int qty=Integer.parseInt(br.readLine());
        
        if(!stockValidate(shoe,qty)) {
        	System.out.println("Purchase Failed");
        	return null;
        }
       
        Purchase purchase=new Purchase(shoe,customer,qty);
        
        return purchase;
    }
    

    
    public boolean stockValidate(Shoe shoeName,int qty) throws IOException {
    		if(qty > shoeName.getStockQty()) {
        		System.out.println("Doesn't have a Enough in Stock for shoe: " + shoeName.getName());
        		System.out.println("Avaiable In stock is :  "+ shoeName.getStockQty());
        		return false;
    	}
		return true;
    	
    }
    
}


