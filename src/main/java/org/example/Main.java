package org.example;

import com.example.model.Purchase;
import com.example.service.PurchaseService;
import com.example.service.SaleReportService;

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
                    "\n3.Exit");
            menu=br.readLine();
            switch (menu) {
                case "1":
                    PurchaseService purchaseService = new PurchaseService();
                    break;
                case "2":
                    SaleReportService salesReportService = new SaleReportService();
                    break;
            }
        }while(!menu.equals("3"));
    }
}