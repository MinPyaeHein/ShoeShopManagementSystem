package com.example.service;

import com.example.dao.CustomerDao;
import com.example.dao.ShoeDao;
import com.example.model.Customer;
import com.example.model.Purchase;
import com.example.model.Shoe;

import java.io.IOException;

public class SaleReportService extends BaseService{
    private CustomerDao customerServiceDao;
    private ShoeDao shoeServiceDao;
    private CustomerService customerService;
    private ShoeService shoeService;
    public SaleReportService() throws IOException {
        customerService=new CustomerService();
        shoeService=new ShoeService();
        customerServiceDao=new CustomerDao();
        shoeServiceDao=new ShoeDao();
        int menu=0;
        do{ System.out.println("!!!Welcome from sale report Menu!!!");
            System.out.println(
                    "  1. Over All Sale Reports" +
                    "\n2. Sale Report By All Cusromer" +
                    "\n3. Sale Report By Individual Customer" +
                    "\n4. Sale Report By Individual Shoe"+
                    "\n5. Exist"
            );
            System.out.println("Enter Your Choice::");
            menu=Integer.parseInt(br.readLine());
            switch (menu) {
                case 1:
                    overAllSaleReports();
                    break;
                case 2:
                    SaleReportByAllCusromer();
                    break;
                case 3:
                    SaleReportByIndividualCustomer();
                    break;
                case 4:
                    saleReportByIndividualShoe();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Option!!!");
            }

        }while(5!=menu);
    }

    public void overAllSaleReports(){
        for(Shoe shoe: ShoeDao.getAllShoes()){
            System.out.println("Name Of Shoe="+shoe.getName()+"| TotalPurchaseCount=="+shoe.getPurchaseCount()+"|TotalPrice=="+shoe.getPurchaseCount()*shoe.getPrice());
        }
    }
    public void SaleReportByAllCusromer(){
        for(Customer customer: CustomerDao.getAllCustomers()){
            System.out.println("Name Of Customer="+customer.getName());
            for(Purchase purchase:customer.getPurchases()){
                System.out.println("Name Of Shoe="+purchase.getShoe().getName()+"| TotalPurchaseCount=="+purchase.getQty()+"|TotalPrice=="+purchase.getTotalPrice());
            }

        }

    }
    public void SaleReportByIndividualCustomer() throws IOException {
       System.out.println("Enter Customer Email to get Sale Report::");
       String email=br.readLine();
       Customer customer=customerServiceDao.findCustomerByEmail(email);
       System.out.println("Name Of Customer="+customer.getName());
       for(Purchase purchase:customer.getPurchases()){
           System.out.println("Name Of Shoe="+purchase.getShoe().getName()+"| TotalPurchaseCount=="+purchase.getQty()+"|TotalPrice=="+purchase.getTotalPrice());
       }

    }
    public void saleReportByIndividualShoe() throws IOException {
        System.out.println("Enter Shoe Id to get Sale Report::");
        int id = Integer.parseInt(br.readLine());
        Shoe shoe = this.shoeServiceDao.findShoeById(id);
        System.out.println("Name Of Shoe="+shoe.getName());
        for(Purchase purchase:shoe.getPurchases()){
            System.out.println("Name Of Customer="+purchase.getCustomer().getName()+"| TotalPurchaseCount=="+purchase.getQty()+"|TotalPrice=="+purchase.getTotalPrice());
        }
    }


}
