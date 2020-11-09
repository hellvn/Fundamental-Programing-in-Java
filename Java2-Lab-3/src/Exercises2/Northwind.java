package Exercises2;

import java.sql.*;
import java.util.Scanner;

public class Northwind {
    private static final String connURL = "jdbc:mysql://localhost:3306/northwind";
    private static final String connUser = "root";
    private static final String connPass = "";

    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
                ){
            int choice = 0;
            int rowCount = 0;
            boolean quit = false;
            ResultSet rset = null;
            Scanner input = new Scanner(System.in);



            System.out.println("Please choose:\n" +
                    "1 - Show Customer list.\n" +
                    "2 - Search customer by name.\n" +
                    "3 - Show list of product.\n" +
                    "4 - Search product by price.\n" +
                    "5 - Show a order detail.\n" +
                    "6 - Show menu.\n" +
                    "7 - Exit.");

            while (!quit){
                System.out.printf("Your choice:");
                choice = input.nextInt();
                switch (choice){
                    case 1:
                        String CustomerList = "SELECT CustomerID, ContactName FROM customers";
                        rset = stmt.executeQuery(CustomerList);
                        rowCount = 0;
                        System.out.println("\t ID\t\t\tName");
                        while (rset.next()){
                            String CustomerID = rset.getString("CustomerID");
                            String ContactName = rset.getString("ContactName");
                            System.out.println("\t" + CustomerID + "\t" + ContactName);
                            ++rowCount;
                        }
                        System.out.printf("There are total " + rowCount + " customers.\n");
                        break;
                    case 2:
                        String srch;
                        System.out.printf("Type customer name to search: ");
                        input = new Scanner(System.in);
                        srch = input.nextLine();
                        String SearchCustomer = "SELECT CustomerID, ContactName FROM customers WHERE ContactName LIKE" + "\'%" + srch + "%\'";
                        rset = stmt.executeQuery(SearchCustomer);
                        rowCount = 0;
                        System.out.println("\n ID\t\t\tName");
                        while (rset.next()){
                            String CustomerID = rset.getString("CustomerID");
                            String ContactName = rset.getString("ContactName");

                            System.out.println("\t" + CustomerID + "\t" + ContactName);
                            ++rowCount;
                        }
                        System.out.printf("There are total " + rowCount + " customers.\n");
                        break;
                    case 3:
                        String ProductList = "SELECT ProductID, ProductName, UnitsInStock, UnitPrice FROM products";
                        rset = stmt.executeQuery(ProductList);
                        rowCount = 0;
                        System.out.println("\tID\t\t\tName\t\t\tIn Stock");
                        while (rset.next()){
                            String ProductID = rset.getString("ProductID");
                            String ProductName = rset.getString("ProductName");
                            int UnitsInStock = rset.getInt("UnitsInStock");
                            float UnitPrice = rset.getFloat("UnitPrice");
                            System.out.println("\t" + ProductID + "\t" + ProductName + "\t" + UnitsInStock + "\t" + UnitPrice);
                            ++rowCount;
                        }
                        System.out.printf("There are total " + rowCount + " Products.\n");
                        break;
                    case 4:
                        int highestprc;
                        int lowestprc;
                        System.out.printf("Type lowest price to search: ");
                        input = new Scanner(System.in);
                        lowestprc = input.nextInt();
                        System.out.printf("Type Highest price to search: ");
                        highestprc = input.nextInt();
                        String SearchProduct = "SELECT ProductID, ProductName, UnitsInStock, UnitPrice FROM products WHERE UnitPrice BETWEEN " +lowestprc + " AND " + highestprc;
                        rset = stmt.executeQuery(SearchProduct);
                        rowCount = 0;
                        System.out.println("\nID\t\tIn Stock\t\tPrice\t\t\tName");
                        while (rset.next()){
                            String ProductID = rset.getString("ProductID");
                            String ProductName = rset.getString("ProductName");
                            int UnitsInStock = rset.getInt("UnitsInStock");
                            float UnitPrice = rset.getFloat("UnitPrice");
                            System.out.println(ProductID + "\t\t\t" + UnitsInStock + "\t\t\t" + UnitPrice + "\t\t" + ProductName );
                            ++rowCount;
                        }
                        System.out.printf("There are total " + rowCount + " Products.\n");
                        break;
                    case 5:
                        System.out.printf("Type Order ID to View Detail: ");
                        input = new Scanner(System.in);
                        int OrderIDSrt = input.nextInt();
                        String OrderDetail = "SELECT*FROM `order details` where OrderID = "+OrderIDSrt;
                        rset = stmt.executeQuery(OrderDetail);
                        rowCount = 0;
                        while (rset.next()){
                            int OrderID = rset.getInt("OrderID");
                            int ProductID = rset.getInt("ProductID");
                            int Quantity = rset.getInt("Quantity");
                            float UnitPrice = rset.getFloat("UnitPrice");
                            double Discount = rset.getDouble("Discount");
                            System.out.println(OrderID + "\t" + ProductID + "\t" + Quantity + "\t" + UnitPrice + "\t" + Discount);
                            ++rowCount;
                        }
                        break;
                    case 6:
                        System.out.println("Please choose:\n" +
                                "1 - Show Customer list.\n" +
                                "2 - Search customer by name.\n" +
                                "3 - Show list of product.\n" +
                                "4 - Search product by price.\n" +
                                "5 - Show a order detail.\n" +
                                "6 - Show menu.\n" +
                                "7 - Exit.");
                        break;
                    case 7:
                        rset.close();
                        stmt.close();
                        System.out.println("Disconnecting.....");
                        conn.close();
                        quit =  true;
                        break;
                }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
