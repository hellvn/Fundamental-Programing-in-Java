package Exercises1;

import java.sql.*;
import java.util.Scanner;

public class SelectFromBooks {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop",
                        "root", "");
                Statement stmt = conn.createStatement()
        ) {
            String strSelect = "SELECT *FROM books";
            System.out.println("\nThe SQL statement is: " + strSelect);

            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The result are: ");
            int rowCount = 0;
            while (rset.next()) {
                String title = rset.getString("title");
                double price = rset.getDouble("price");
                int qty = rset.getInt("qty");
                System.out.println(title + ", " + price + ", " + qty);
                ++rowCount;
            }
            System.out.println("Total number of record = " + rowCount);

            strSelect = "SELECT title, price FROM books";
            System.out.println("\nThe SQL statement is: " + strSelect);

            rset = stmt.executeQuery(strSelect);

            System.out.println("The result are: ");
            rowCount = 0;
            while (rset.next()) {
                String title = rset.getString("title");
                double price = rset.getDouble("price");
                System.out.println(title + ", " + price);
                ++rowCount;
            }
            System.out.println("Total number of record = " + rowCount);

            String srch;
            Scanner input = new Scanner(System.in);
            System.out.printf("Type author name to search: ");
            srch = input.nextLine();
            strSelect = "SELECT title, author, price FROM books where author like" + "\'%" + srch + "%\'";
            System.out.println("\nThe SQL statement is: " + strSelect);

            rset = stmt.executeQuery(strSelect);

            System.out.println("The result are: ");
            rowCount = 0;
            while (rset.next()) {
                String title = rset.getString("title");
                String author = rset.getString("author");
                double price = rset.getDouble("price");
                System.out.println(title + ", " + author + ", " + price);
                ++rowCount;
            }
            System.out.println("Total number of record = " + rowCount);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

