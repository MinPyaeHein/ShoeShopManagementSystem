package com.example.service;

import com.example.model.Shoe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShoeService extends BaseService{
    public static List<Shoe> shoes=new ArrayList<Shoe>();
    static{
       Shoe shoe1= new Shoe(12,"NikeRunning","Black",43,12,1700);
       Shoe shoe2= new Shoe(13,"NikeWalking","Black",43,12,2000);
       Shoe shoe3= new Shoe(14,"NikeStyle","Black",43,12,3900);
       shoes.add(shoe1);
       shoes.add(shoe2);
       shoes.add(shoe3);
    }
    public ShoeService() {}
    public Shoe getShoeData() throws IOException {
        Shoe shoe=null;
        do{
            System.out.println("Enter Your Ordered Shoe ID::");
            int id=Integer.parseInt(br.readLine());
            shoe=findShoeById(id);
            if(shoe==null){System.out.println("Enter Correct Shore ID!!");}
        }while(shoe==null);

        return shoe;
    }
    public Shoe findShoeById(int id) {
        for(Shoe shoe : shoes){
            if(shoe.getId()==id){
                return shoe;
            }
        }
        return null;
    }
}
