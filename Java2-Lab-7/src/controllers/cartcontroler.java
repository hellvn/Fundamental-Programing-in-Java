package controllers;

import java.sql.*;

import models.*;


public class cartcontroler {
    private static final String connURL = "jdbc:mysql://localhost:3306/ebookstore";
    private static final String connUser = "root";
    private static final String connPass = "";
    private static ResultSet rset;

    public cart loadcart(books books){
        cart obj = new cart();
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
                ){
            String select = "Select * from books where bookID = "+books.getBookID();
            ResultSet rset = stmt.executeQuery(select);
            System.out.printf("%-30s%-30s%-30s%-30s%-30s","bookID","title","price","qty","discount");
            System.out.println();
            int row = 0;
            int id = 0;
            String title = null;
            double price = 0;
            while (rset.next()) {
                id = rset.getInt("bookID");
                title = rset.getString("title");
                price = rset.getDouble("price");
                row++;
            }
            if(row==0){
                System.out.println("No book with entered ID");
                return null;
            }else
                obj = new cart(id, books.getQty());
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return obj;
    }
}
