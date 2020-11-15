package views;

import models.books;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bookview {
    private static final String connURL = "jdbc:mysql://localhost:3306/ebookstore";
    private static final String connUser = "root";
    private static final String connPass = "";
    private static ResultSet rset;
    private static ResultSetMetaData rsMD;
    String username;
    Scanner input = new Scanner(System.in);

    public void top100selled() {
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "select books.bookID,books.title,author,published,books.status,qty,books.price,sum(orderdetail.amount)" +
                    " as soldamount from books inner join orderdetail " +
                    "on books.bookID = orderdetail.bookID inner join bookorder " +
                    "on bookorder.orderID = orderdetail.orderID where bookorder.status != 0 " +
                    "group by books.bookID,books.title,author,published,books.status,qty,books.price order " +
                    "by soldamount DESC limit 100";
            rset = stmt.executeQuery(sqlSelect);
            System.out.println("=====Top 100 sold Book=====");
            while (rset.next()) {
                int id = rset.getInt("bookID");
                String title = rset.getString("title");
                String author = rset.getString("author");
                String year = rset.getString("published");
                int status = rset.getInt("status");
                int qty = rset.getInt("qty");
                double price = rset.getDouble("price");
                int soldamount = rset.getInt("soldamount");
                System.out.printf("%-8d\t\t%-20s\t\t%-20s\t\t%-10s\t\t%-6d\t\t%-6d\t%-6.1f\t\t%-6d\n", id, title, author, year, status, qty, price, soldamount);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void top10newbook() {
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "SELECT * FROM books order by published limit 10";
            rset = stmt.executeQuery(sqlSelect);
            rsMD = rset.getMetaData();
            int numColumn = rsMD.getColumnCount();
            System.out.println("****Top 10 Newest Book****");
            for (int i = 1; i <= numColumn; i++) {
                System.out.printf("%-25s", rsMD.getColumnName(i));
            }
            System.out.println();
            while (rset.next()) {
                for (int i = 1; i <= numColumn; ++i) {
                    System.out.printf("%-25s", rset.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void addbook(){
        Scanner input = new Scanner(System.in);
        System.out.println("\n=====Add New Book=====\n");
        System.out.printf("Enter book ID: ");
        int bookID = input.nextInt();
        input.nextLine();
        System.out.printf("Enter book Title: ");
        String title = input.nextLine();
        System.out.printf("Enter book Author: ");
        String author = input.nextLine();
        System.out.printf("Enter Published year: ");
        int published = input.nextInt();
        System.out.printf("Enter Qty: ");
        int qty = input.nextInt();
        System.out.printf("Enter book price: ");
        float price = input.nextFloat();
        System.out.printf("Enter Status (1-5): ");
        int status = input.nextByte();
        books b1 = new books(bookID, title, author, published, qty, price);
        try(
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement()
        ){
            books sqlInsert = b1;
            System.out.println(sqlInsert);
            int countInserted = stmt.executeUpdate(String.valueOf(sqlInsert));
            System.out.println(countInserted + " Book inserted.\n");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void orderbook() {
//        try (
//                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
//                Statement stmt = conn.createStatement();
//        ) {
//            String checkBookID = "SELECT bookID FROM model.books WHERE bookID=?";
//
//            Scanner input = new Scanner(System.in);
//
//            System.out.println("****Order a book****");
//            System.out.printf("Enter book ID: ");
//            int bookID = input.nextInt();
//            PreparedStatement stm = conn.prepareStatement(checkBookID);
//            stm.setInt(1, bookID);
//            rset = stm.executeQuery();
//            if (rset.next()) {
//                System.out.printf("Enter order ID: ");
//                int orderID = input.nextInt();
//                System.out.printf("Enter amount: ");
//                int amount = input.nextInt();
//                System.out.printf("Enter discount: ");
//                int discount = input.nextInt();
//                String checkAmount = "SELECT title, status, qty, price FROM model.books WHERE bookID=" + bookID;
//                ResultSet rset2 = stmt.executeQuery(checkAmount);
//                rset2.next();
//                String title = rset2.getString("title");
//                int status = rset2.getInt("status");
//                int qty = rset2.getInt("qty");
//                float price = rset2.getFloat("price");
//                int total = (int) (price * amount);
//                float caldiscount = (total * discount) / 100;
//                if (amount <= qty) {
//                    String newOrder = "INSERT INTO `orders` (`orderID`, `customerID`, `discount`, `total`, `orderdate`, `status`, `createddate`, `updateddate`) VALUES (" + orderID + ", " + inputID + "," + discount + ", " + caldiscount + ", CURRENT_DATE(), " + status + ", CURRENT_DATE(), CURRENT_DATE());";
//
//                    String newOrderdetail = "INSERT INTO `orderdetail` (`orderID`, `bookID`, `title`, `amount`, `price`, `createddate`, `updateddate`) VALUES (" + orderID + ", " + bookID + ", \"" + title + "\", " + amount + ", " + price + ", CURRENT_DATE(), CURRENT_DATE());";
//
//                    String newUpdatebooks = "UPDATE `model.books` SET `qty` = " + (qty - amount) + ", `updateddate` = CURDATE() WHERE `model.books`.`bookID` = " + bookID + " AND `model.books`.`title` = \"" + title + "\";";
//
//                    System.out.println(newOrder);
//                    System.out.println(newOrderdetail);
//                    System.out.println(newUpdatebooks);
//                    stmt.executeUpdate(newOrder);
//                    stmt.executeUpdate(newOrderdetail);
//                    stmt.executeUpdate(newUpdatebooks);
//                    System.out.println("order book successfully! Thank you!");
//                } else {
//                    System.out.printf("The amount of model.books in stock is not enough!");
//                }
//            } else {
//                System.out.println("Book ID not found!");
//            }
//
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
    }
}
