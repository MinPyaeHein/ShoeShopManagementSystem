package com.example.service;

import com.example.dao.ShoeDao;
import com.example.model.Shoe;

import java.io.IOException;

public class ShoeService extends BaseService{


    public ShoeDao shoeServiceDao;
    public ShoeService() {
        this.shoeServiceDao=new ShoeDao();
    }
    public Shoe getShoeData() throws IOException {
        Shoe shoe=null;
        do{
            System.out.println("Enter Your Ordered Shoe ID::");
            int id=Integer.parseInt(br.readLine());
            shoe=this.shoeServiceDao.findShoeById(id);
            if(shoe==null){System.out.println("Enter Correct Shore ID!!");}
        }while(shoe==null);

        return shoe;
    }

    
    public Shoe stockIncreasement() throws IOException{
    	Shoe shoe=null;
    	String flag=null;
    	
    	do{ 
    		System.out.println("Enter Shoe ID to update InStock: ");
    	    int id=Integer.parseInt(br.readLine());
    	    shoe=findShoeById(id);
    	if(shoe != null) {
    		System.out.println("Enter Update Shoe Instock Qty: ");
    		int qty=Integer.parseInt(br.readLine());
    	    shoe.setStockQty(shoe.getStockQty()+qty);
    	    System.out.println(" Shoe Name: "+ shoe.getName() + " UPdated stock qty: "+ shoe.getStockQty());
    	    System.out.println("Do you want to add more yes or no");
    	    flag = br.readLine();
    	}else {
    		System.out.println("Enter correct Shoe ID! ");
    	}
    	}while(shoe == null || flag.equals("yes"));
		return shoe;
    }
    
    
 
    
    public Shoe findShoeById(int id) {
        for(Shoe shoe : shoeServiceDao.getAllShoes()){
            if(shoe.getId()==id){
                return shoe;
            }
        }
        return null;
    }



}
