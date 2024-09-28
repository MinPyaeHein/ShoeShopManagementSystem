package com.example.service.impl;

import com.example.dao.ShoeDao;
import com.example.model.Shoe;
import com.example.service.ShoeService;

import java.io.IOException;

public class ShoeServiceImpl extends BaseServiceImpl implements ShoeService {


    public ShoeDao shoeServiceDao;
    public ShoeServiceImpl() {
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
	
	
}
