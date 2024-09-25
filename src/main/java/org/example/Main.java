package org.example;

import com.example.controller.CustomerController;
import com.example.model.Customer;
import com.example.model.Purchase;
import com.example.model.Shoe;
import com.example.service.PurchaseService;
import com.example.service.SaleReportService;
import com.example.service.ShoeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        String menu=null;
        do{
            System.out.println("!!!!Welcome From Lily Shoe Shop!!!");
            System.out.println("1.Purchase Shoe:" +
                    "\n2.Sale Reports: " +
            		"\n3.Update Shoe Stock qty "+
                    "\n3.Custer Dashboard: " +

                    "\n4.Exit");
            menu=br.readLine();
            switch (menu) {
                case "1":
                    PurchaseService purchaseService = new PurchaseService();
                    break;
                case "2":
                    SaleReportService salesReportService = new SaleReportService();
                    break;
                case"3":
                	ShoeService shoe=new ShoeService();
                	shoe.stockIncreasement();
                	
                case "3":
                    CustomerController customerController = new CustomerController();
                    break;
            }
        }while(!menu.equals("4"));
    }
}