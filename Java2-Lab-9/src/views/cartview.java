package views;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import models.*;
import java.util.Scanner;

public class cartview {
    private static final String connURL = "jdbc:mysql://localhost:3306/ebookstore";
    private static final String connUser = "root";
    private static final String connPass = "";
    private static ResultSet rset;
    private static ResultSetMetaData rsMD;
    String username;
    Scanner input = new Scanner(System.in);

    public List<cart> addtocart(user user){
        List<cart> items = new ArrayList<>();
        cart c1 = new cart();
        System.out.printf("Enter bookID: ");
        int bookID = input.nextInt();
        c1.setBookID(bookID);
        System.out.printf("Amount: ");
        int amount = input.nextInt();
        c1.setAmount(amount);
        return items;
    }
}
