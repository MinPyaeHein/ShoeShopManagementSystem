package com.example.service.impl;

import com.example.model.Customer;
import com.example.model.Purchase;
import com.example.model.Shoe;

import java.io.IOException;

public class PurchaseServiceImpl extends BaseServiceImpl {

    private CustomerServiceImpl customerServiceImpl;
    private ShoeServiceImpl shoeServiceImpl;
    public PurchaseServiceImpl() throws IOException {
    	customerServiceImpl=new CustomerServiceImpl();
    	shoeServiceImpl=new ShoeServiceImpl();
        String flag=null;
        do{
            doPurchase();
            System.out.println("Do you want to purchase more Yes or No??");
            flag=br.readLine();
        }while(flag.equals("yes"));

    }
    public Purchase doPurchase() throws IOException {
        Customer customer=customerServiceImpl.getCustomerDataByEmail();
        Shoe shoe=shoeServiceImpl.getShoeData();
        System.out.println("Enter Qty of purchase::");
        int qty=Integer.parseInt(br.readLine());
        Purchase purchase=new Purchase(shoe,customer,qty);
        return purchase;
    }
}


