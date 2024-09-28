package org.example;

import com.example.controller.CustomerController;
import com.example.service.impl.PurchaseServiceImpl;
import com.example.service.impl.SaleReportServiceImpl;

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
                    "\n3.Custer Dashboard: " +
                    "\n4.Exit");
            menu=br.readLine();
            switch (menu) {
                case "1":
                    PurchaseServiceImpl purchaseService = new PurchaseServiceImpl();
                    break;
                case "2":
                    SaleReportServiceImpl salesReportService = new SaleReportServiceImpl();
                    break;
                case "3":
                    CustomerController customerController = new CustomerController();
                    break;
            }
        }while(!menu.equals("4"));
    }
}