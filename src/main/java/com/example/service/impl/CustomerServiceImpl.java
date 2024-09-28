package com.example.service.impl;

import com.example.dao.CustomerDao;
import com.example.model.Customer;
import com.example.service.CustomerService;

import java.io.IOException;

public class CustomerServiceImpl extends BaseServiceImpl implements CustomerService {
    public CustomerDao customerDao;
    
    public CustomerServiceImpl(){
        this.customerDao=new CustomerDao();
    }
    @Override
    public Customer getCustomerDataByEmail() throws IOException {
        Customer customer=null;
        do{
            System.out.println("Enter Your Registered Email!!");
            String email=br.readLine();
            customer=this.customerDao.findCustomerByEmail(email);
            if(customer==null){System.out.println("User does not exist int the System!!");}
        }while(customer==null);

        return customer;
    }

    @Override
    public Boolean saveCustomer(Customer customer) throws IOException {
        Customer cus=this.customerDao.findCustomerByEmail(customer.getEmail());
        if(cus!=null){
          return false;
        }else{
            this.customerDao.saveCustomer(customer);
        }
        return true;
    }

    @Override
   public void updateCustomer(Customer currentCustomer,Customer updatedcustomer) throws IOException{
        currentCustomer.setEmail(updatedcustomer.getEmail());
        currentCustomer.setName(updatedcustomer.getName());
        currentCustomer.setAddress(updatedcustomer.getAddress());
        System.out.println("Customer updated!!");
   }

    @Override
   public void deleteCustomer(Customer customer){
        this.customerDao.deleteCustomerByEmail(customer.getEmail());
        System.out.println("Customer "+customer.getEmail()+"is Deleted!!");
   }
    @Override
   public void displayAllCustomers(){
        for(Customer customer :CustomerDao.getAllCustomers()){
            System.out.println(customer);
        }
   }


}
