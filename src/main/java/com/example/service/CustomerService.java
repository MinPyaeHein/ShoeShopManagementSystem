package com.example.service;

import com.example.dao.CustomerDao;
import com.example.model.Customer;

import java.io.IOException;

public class CustomerService extends BaseService {
    public CustomerDao customerServiceDao;
    public CustomerService(){
        this.customerServiceDao=new CustomerDao();
    }
    public Customer getCustomerData() throws IOException {
        Customer customer=null;
        do{
            System.out.println("Enter Your Registered Email!!");
            String email=br.readLine();
            customer=this.customerServiceDao.findCustomerByEmail(email);
            if(customer==null){System.out.println("User does not exist int the System!!");}
        }while(customer==null);

        return customer;
    }
    public Boolean saveCustomerData(Customer customer) throws IOException {
        Customer cus=this.customerServiceDao.findCustomerByEmail(customer.getEmail());
        if(cus!=null){
          return false;
        }else{
            this.customerServiceDao.saveCustomer(customer);
        }
        return true;
    }



}
