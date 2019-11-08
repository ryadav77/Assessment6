package com.main;
import java.util.*;

import com.dao.ProductsDao;
import com.model.Products;

public class MainClass {

	
	 static Scanner sc = new Scanner(System.in);
	 static ProductsDao product = new ProductsDao();
	 static List<Products> products= new ArrayList<>();
	 
	 public static void main(String[] args) {
		 
		 
		 System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		 System.out.printf("%70s\n","Welcome to the Inventory");
		 System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		 int option=-1;
		 do {
	    	  System.out.println("\n\nSelect from the following options.....\n");
	    	  System.out.println("------------------------------------------------------------------------------------------------------------------------------");
			  System.out.println("Press 1 to Add Product");
		      System.out.println("Press 2 to View Existing Product");
		      System.out.println("Press 3 to Update Existing Product");
		      System.out.println("Press 4 to Delete Existing Product");
			  System.out.println("Press 5 to Exit");
			  
			  option= sc.nextInt();
			  
			  switch(option) {
			  
			  case 1:
				    System.out.println("Enter Product Name:");
				    String name=sc.next();
				    System.out.println("Enter Description: ");
					String desc=sc.next();
					System.out.println("Enter Price: ");
					double price=sc.nextDouble();
					System.out.println("Enter Quantity: ");
					int quantity=sc.nextInt();
					Products p= new Products(name,quantity,price,desc);
					product.create(p);
					break;
				  
			  case 2:
				     List<Products> products =product.findAll();
				     
				     System.out.println("------------------------------------------------------------------------------------------------------------------------------");
				      System.out.println("ID   Name       Price         Description                   Quantity \n");
				      for(Products itr:products) {
				    	  System.out.printf("%1s %9s  %12s %18s %25s  \n",itr.getId(),itr.getName(),itr.getPrice(),itr.getDesc(),itr.getQuantity());
				    	  
				      }
				      break;
			  case 3:
				  
				  System.out.println("Enter id");
					int id=sc.nextInt();
					System.out.println("Enter updated name");
					String uname=sc.next();
					System.out.println("Enter updated Price");
					double uprice=sc.nextDouble();
					System.out.println("Enter updated quantity");
					int uquantity=sc.nextInt();
					System.out.println("Enter updated Description");
					String udesc=sc.next();
					Products ps=product.update(id,uname, uprice, uquantity,udesc); 
					break;
				  
			  case 4:
				  System.out.println("Enter the Id of the elemenent you want to delete ");
					int did=sc.nextInt();
					product.delete(did);
					break;
				    
			  case 5:
				  option=-1;
				  System.out.println("------------------------------------------------------------------------------------------------------------------------------");
				  System.out.printf("%70s\n","Exiting the Inventory Manager");
				  System.out.println("------------------------------------------------------------------------------------------------------------------------------");
				  break;
				  
			 
				  
			  default:
				  System.out.println("Enter a Valid Choice");
			  }
			  
	      }while(option!=-1);
	 }
	  
		 
}


