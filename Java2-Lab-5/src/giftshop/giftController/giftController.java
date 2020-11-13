package giftshop.giftController;

import giftshop.giftmodel.Gift;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class giftController {
    private static final String connURL = "jdbc:mysql://localhost:3306/giftshop";
    private static final String connUser = "root";
    private static final String connPass = "";
    List<Gift> gifts = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void selectgift() {
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            System.out.println("\n\t\t\t\t\t=====VIEW GIFT=====\n");
            String sqlSelect = "SELECT * FROM gift";
            ResultSet rset = stmt.executeQuery(sqlSelect);
            ResultSetMetaData rsMd = rset.getMetaData();

            int col = rsMd.getColumnCount();

            for (int i = 1; i <= col; i++) {
                System.out.printf("%-20s", rsMd.getColumnName(i));
            }
            System.out.println();
            while (rset.next()) {
                for (int i = 1; i <= col; ++i) {
                    System.out.printf("%-20s", rset.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public void insertgift() {
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            System.out.println("\n\t\t\t\t\t=====ADD GIFT=====\n");
            System.out.printf("Gift ID: ");
            int id = input.nextInt();
            input.nextLine();
            System.out.printf("Gift name: ");
            String name = input.nextLine();
            System.out.printf("Price: ");
            float price = input.nextFloat();
            System.out.printf("Number: ");
            int qty = input.nextInt();

            Gift g1 = new Gift(id, name, price, qty);
            Gift sqlinsert = g1;
            stmt.executeUpdate(String.valueOf(sqlinsert));
            System.out.println("");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public void deletegift() {
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ){
            System.out.println("\n=====DELETE GIFT=====\n");
            System.out.printf("Gift ID: ");
            int id = input.nextInt();
            String sqlDelete = "DELETE FROM `gift` WHERE `gift`.`giftID` ="+id;
            stmt.executeUpdate(sqlDelete);
            System.out.println("Gift deleted.");
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
