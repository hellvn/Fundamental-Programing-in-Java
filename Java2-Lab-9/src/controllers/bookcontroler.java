package controllers;

import models.BookModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookControler {
    private static final String connURL = "jdbc:mysql://localhost:3306/ebookstore";
    private static final String connUser = "root";
    private static final String connPass = "";
    private ResultSet rset;
    private ResultSetMetaData rsMd;
    public int qty;
    public int bookID;
    List<BookModel> booksList = new ArrayList<>();

    public List<BookModel> LoadBook() {
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement()
        ) {
            String sqlSelect = "SELECT * FROM books";
            rset = stmt.executeQuery(sqlSelect);
            while (rset.next()) {
                bookID = rset.getInt("bookID");
                String title = rset.getString("title");
                String author = rset.getString("author");
                int published = rset.getInt("published");
                qty = rset.getInt("qty");
                float price = rset.getFloat("price");
                int status = rset.getInt("status");
                String created = rset.getString("created");
                String updated = rset.getString("updated");
                BookModel obj = new BookModel(bookID, title, author, published, qty, price, status, created, updated);
                booksList.add(obj);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return booksList;
    }

    public void ViewBook() {
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement()
        ) {
            rset = stmt.executeQuery("SELECT bookID, title, author, published, price FROM books");
            rsMd = rset.getMetaData();

            int col = rsMd.getColumnCount();

            for (int i = 1; i <= col; i++) {
                System.out.printf("%-30s", rsMd.getColumnName(i));
            }
            System.out.println();
            while (rset.next()) {
                for (int i = 1; i <= col; ++i) {
                    System.out.printf("%-30s", rset.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
}