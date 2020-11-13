package controllers;

import models.customer;
import models.user;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class usercontroler {
    private static final String connURL = "jdbc:mysql://localhost:3306/ebookstore";
    private static final String connUser = "root";
    private static final String connPass = "";
    private static ResultSet rset;
    private static ResultSetMetaData rsMD;
    String username;
    Scanner input = new Scanner(System.in);
    List<user> userList = new ArrayList<>();

    public List<user> Loader(){
        try (Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
             Statement stmt = conn.createStatement();){

            String sqlSelect = "SELECT * FROM user";
            ResultSet rset = stmt.executeQuery(sqlSelect);
            while (rset.next()){
                user obj = new user();
                obj.setUsername(rset.getString("username"));
                obj.setPassword(rset.getString("password"));
                obj.setRole(rset.getInt("role"));
                obj.setCreated(rset.getString("created"));
                obj.setUpdated(rset.getString("updated"));
                userList.add(obj);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return userList;

    }

    public void regist() {
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            System.out.println("\n=====REGISTER=====\n");
            char tryagain = 'y';
            do {
                System.out.printf("User Name: ");
                username = input.nextLine();
                System.out.printf("Password: ");
                String password = input.nextLine();
                System.out.printf("Retype Password: ");
                String password2 = input.nextLine();
                String sqlSelect = "SELECT username FROM user WHERE username = '"+username+"'";
                rset = stmt.executeQuery(sqlSelect);
                if (rset.next()) {
                    System.out.println("Username already taken!");
                    System.out.printf("Try again? (Y/N):");
                    String Char = input.nextLine();
                    tryagain = Char.charAt(0);
                } else {
                    if (password.equals(password2)) {
                        user sqlregist = new user(username, password);
                        stmt.executeUpdate(String.valueOf(sqlregist));
                        System.out.println("\nSign Up Success!\n");
                        fillinfo();
                        tryagain = 'n';
                    } else
                        System.out.println("Password not match!");
                }

            } while (tryagain == 'y');

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public void login() {
        System.out.println("\n=====LOGIN=====\n");
        System.out.printf("Username: ");
        String username = input.nextLine();
        System.out.printf("Password: ");
        String password = input.nextLine();
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "SELECT username, password FROM user WHERE username=? AND password=?";
            PreparedStatement stm = conn.prepareStatement(sqlSelect);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rSet = stm.executeQuery();
            if (rSet.next()) {
                System.out.println("\nLogin Success!\n");
                sqlSelect = "SELECT role from user where username ='" + username + "'";
                rset = stmt.executeQuery(sqlSelect);
                rset.next();
                int role = rset.getByte("role");
                switch (role) {
                    case 1:
                        System.out.println("Welcome " + username + "! you are normal model.user\n");
                        ;
                        break;
                    case 2:
                        System.out.println("Welcome " + username + "! you are normal model.user\n");
                        vipmenu();
                        break;
                    case 3:
                        System.out.println("You are an administrator!");
                        adminmenu();
                        break;
                    case 4:
                        System.out.println("You are Supper administrator!");
                        superadminmenu();
                        break;
                }
            } else {
                System.out.println("\nLogin Failed!\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void fillinfo(){
        System.out.printf("Enter your name: ");
        String customerName = input.nextLine();
        System.out.printf("Enter address: ");
        String customerAddress = input.nextLine();
        System.out.printf("Enter Email: ");
        String customerEmail = input.nextLine();
        System.out.printf("Enter phone number: ");
        String customerPhone = input.nextLine();
        customer c1 = new customer(username, customerName, customerAddress, customerEmail, customerPhone);
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            customer sqlInsert = c1;
            stmt.executeUpdate(String.valueOf(sqlInsert));
            System.out.println("Done! now you can use our service.\n\t\t\tLet's enjoy it!\n");
            login();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void setrole(){
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter username to set roll: ");
        String username = input.nextLine();
        System.out.println("1- Normal model.user\n" +
                "2- Vip model.user\n" +
                "3- Administrator\n" +
                "4- Supper Administrator\n");
        System.out.printf("Your choice: ");
        int choice = input.nextInt();
        if (choice > 0 && choice < 3) {
            try (
                    Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                    Statement stmt = conn.createStatement();
            ) {
                String sqlUpdate = "UPDATE `user` SET `role` = '" + choice + "' WHERE `user`.`username` = '" + username + "'";
                stmt.executeUpdate(sqlUpdate);
                System.out.println("Role updated");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else if (choice == 4 || choice ==3){
            System.out.println("You do not have permission.");
        }
        else {
            System.out.println("Invalid choice");
        }
    }
    public void setrolesupper(){
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter username to set roll: ");
        String username = input.nextLine();
        System.out.println("1- Normal model.user\n" +
                "2- Vip model.user\n" +
                "3- Administrator\n" +
                "4- Supper Administrator\n");
        System.out.printf("Your choice: ");
        int choice = input.nextInt();
        if (choice > 0 && choice <= 4) {
            try (
                    Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                    Statement stmt = conn.createStatement();
            ) {
                String sqlUpdate = "UPDATE `user` SET `role` = '" + choice + "' WHERE `user`.`username` = '" + username + "'";
                stmt.executeUpdate(sqlUpdate);
                System.out.println("Role updated");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else {
            System.out.println("Invalid choice");
        }
    }
    public void deletemember(){
        Scanner input = new Scanner(System.in);
        char choice = 'n';
        System.out.printf("Enter username to delete: ");
        String username = input.nextLine();

    }
}
