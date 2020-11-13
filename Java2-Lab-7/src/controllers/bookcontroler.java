package controllers;

import models.books;
import models.customer;
import models.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class bookcontroler {
    private static final String connURL = "jdbc:mysql://localhost:3306/ebookstore";
    private static final String connUser = "root";
    private static final String connPass = "";
    private static ResultSet rset;
    List<books> booksList = new ArrayList<>();

    public List<books> loader(){
        try(
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement()){
            String sqlSelect = "SELECT * FROM books";
            rset = stmt.executeQuery(sqlSelect);
            while (rset.next()){
                int bookID = rset.getInt("bookID");
                String title = rset.getString("title");
                String author = rset.getString("author");
                int published = rset.getInt("published");
                int qty = rset.getInt("qty");
                float price = rset.getFloat("price");
                int status = rset.getInt("status");
                String created = rset.getString("created");
                String updated = rset.getString("updated");
                books obj = new books(bookID, title, author, published, qty, price, status, created, updated);
                booksList.add(obj);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return booksList;
    }
    public void displayBook() {
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String stt = "Select * from books";
            ResultSet rset = stmt.executeQuery(stt);
            ResultSetMetaData rsetMD = rset.getMetaData();
            int numColums = rsetMD.getColumnCount();
            for (int i = 1; i <= numColums; i++) {
                System.out.printf("%-30s", rsetMD.getColumnName(i));
            }
            loader();
            System.out.println();
            while (rset.next()) {
                for (int i = 1; i <= numColums; i++) {
                    System.out.printf("%-30s", rset.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public boolean insertBook(books books) {
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlInsert = "INSERT INTO books(bookId,title,author,qty,price) VALUES (" + books.getBookID() + ",'" + books.getTitle() + "','" + books.getAuthor() + "'," + books.getQty() + "," + books.getPrice() + ")";
            stmt.executeUpdate(sqlInsert);
            loader();
            System.out.println("Done!");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public int updateBook(books book) {
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String update = "update books set qty=" + book.getQty() + ",price=" + book.getPrice() + " where bookID =" + book.getBookID();
            int count = stmt.executeUpdate(update);
            loader();
            if (count == 0) {
                return 0;
            } else {
                return 1;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
    }
    public boolean deleteBook(books book) {
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String select = "select * from orderdetail where bookID =" + book.getBookID();
            ResultSet rset = stmt.executeQuery(select);
            if (!rset.next()) {
                String delete = "delete from books where bookID =" + book.getBookID();
                stmt.executeUpdate(delete);
                loader();
                System.out.println("Deleted");
                return true;
            } else
                System.out.println("Book not found");
            return false;
        } catch (SQLException ex) {
            System.out.println("Something went wrong can't delete this book!");
            ex.printStackTrace();
            return false;
        }
    }
}