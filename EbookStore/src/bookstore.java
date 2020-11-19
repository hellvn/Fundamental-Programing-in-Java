import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class bookstore {
    private static final String connURL = "jdbc:mysql://localhost:3306/ebookstore2";
    private static final String connUser = "root";
    private static final String connPass = "";
    private static ResultSet rset;
    private static ResultSetMetaData rsMD;

    public void top10newbook() {
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "SELECT * FROM books order by years limit 10";
            rset = stmt.executeQuery(sqlSelect);
            rsMD = rset.getMetaData();
            int numColumn = rsMD.getColumnCount();
            System.out.println("****Top 10 Newest Book****");
            for (int i =1; i<= numColumn; i++){
                System.out.printf("%-25s", rsMD.getColumnName(i));
            }
            System.out.println();
            while (rset.next()){
                for (int i=1; i<=numColumn; ++i){
                    System.out.printf("%-25s", rset.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void top100selled(){
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "select books.bookID,books.title,author,years,books.status,qty,books.price,sum(orderdetail.amount)" +
                    " as soldamount from books inner join orderdetail " +
                    "on books.bookID = orderdetail.bookID inner join orders " +
                    "on orders.orderID = orderdetail.orderID where orders.status != 0 " +
                    "group by books.bookID,books.title,author,years,books.status,qty,books.price order " +
                    "by soldamount DESC limit 100";
            rset = stmt.executeQuery(sqlSelect);
            System.out.println("****Top 100 solded Book****");
            while(rset.next()){
                int id = rset.getInt("bookID");
                String title = rset.getString("title");
                String author = rset.getString("author");
                String year = rset.getString("years");
                int status = rset.getInt("status");
                int qty = rset.getInt("qty");
                double price = rset.getDouble("price");
                int soldamount = rset.getInt("soldamount");
                System.out.printf("%-8d\t\t%-20s\t\t%-20s\t\t%-10s\t\t%-6d\t\t%-6d\t%-6.1f\t\t%-6d\n",id,title,author,year,status,qty,price,soldamount);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void searchbycategory(){
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter category code to search: ");
        int categorycode = input.nextByte();
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "SELECT * FROM books where category="+categorycode;
            rset = stmt.executeQuery(sqlSelect);
            if (rset.next()){
                rsMD = rset.getMetaData();
                int numColumn = rsMD.getColumnCount();
                for (int i =1; i<= numColumn; i++){
                    System.out.printf("%-25s", rsMD.getColumnName(i));
                }
                System.out.println();
                for (int i=1; i<=numColumn; ++i){
                    System.out.printf("%-25s", rset.getString(i));
                }
                System.out.println();

            }
            else {
                System.out.println("Invalid category!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void searchbyauthor(){
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter author name to search: ");
        String categorycode = input.nextLine();
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "SELECT * FROM books where author='"+categorycode+"'";
            rset = stmt.executeQuery(sqlSelect);
            if (rset.next()){
                rsMD = rset.getMetaData();
                int numColumn = rsMD.getColumnCount();
                for (int i =1; i<= numColumn; i++){
                    System.out.printf("%-25s", rsMD.getColumnName(i));
                }
                System.out.println();
                for (int i=1; i<=numColumn; ++i){
                    System.out.printf("%-25s", rset.getString(i));
                }
                System.out.println();

            }
            else {
                System.out.println("Invalid author name!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void searchbyid(){
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter bookID to search: ");
        int bookID = input.nextInt();
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "SELECT * FROM books where bookID="+bookID;
            rset = stmt.executeQuery(sqlSelect);
            if (rset.next()){
                rsMD = rset.getMetaData();
                int numColumn = rsMD.getColumnCount();
                for (int i =1; i<= numColumn; i++){
                    System.out.printf("%-25s", rsMD.getColumnName(i));
                }
                System.out.println();
                for (int i=1; i<=numColumn; ++i){
                    System.out.printf("%-25s", rset.getString(i));
                }
                System.out.println();

            }
            else {
                System.out.println("Invalid bookID!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void viewneworder(){
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "SELECT * FROM orders where status = 1 order by orderdate limit 30";
            rset = stmt.executeQuery(sqlSelect);
            rsMD = rset.getMetaData();
            int numColumn = rsMD.getColumnCount();
            System.out.println("=====30 new order=====");
            for (int i =1; i<= numColumn; i++){
                System.out.printf("%-25s", rsMD.getColumnName(i));
            }
            System.out.println();
            while (rset.next()){
                for (int i=1; i<=numColumn; ++i){
                    System.out.printf("%-25s", rset.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void vieworderbycustomer(){
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter customerID: ");
        int customer = input.nextInt();
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "SELECT * FROM orders where customerID="+customer;
            rset = stmt.executeQuery(sqlSelect);
            if (rset.next()){
                rsMD = rset.getMetaData();
                int numColumn = rsMD.getColumnCount();
                for (int i =1; i<= numColumn; i++){
                    System.out.printf("%-25s", rsMD.getColumnName(i));
                }
                System.out.println();
                for (int i=1; i<=numColumn; ++i){
                    System.out.printf("%-25s", rset.getString(i));
                }
                System.out.println();

            }
            else {
                System.out.println("Invalid customerID!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void vieworderbyid(){
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter orderID: ");
        int orderID = input.nextInt();
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "SELECT * FROM orders where orderID="+orderID;
            rset = stmt.executeQuery(sqlSelect);
            if (rset.next()){
                rsMD = rset.getMetaData();
                int numColumn = rsMD.getColumnCount();
                for (int i =1; i<= numColumn; i++){
                    System.out.printf("%-25s", rsMD.getColumnName(i));
                }
                System.out.println();
                for (int i=1; i<=numColumn; ++i){
                    System.out.printf("%-25s", rset.getString(i));
                }
                System.out.println();

            }
            else {
                System.out.println("Invalid orderID!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void vieworderbystatus(){
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter status code: ");
        int status = input.nextInt();
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "SELECT * FROM orders where status="+status;
            rset = stmt.executeQuery(sqlSelect);
            if (rset.next()){
                rsMD = rset.getMetaData();
                int numColumn = rsMD.getColumnCount();
                for (int i =1; i<= numColumn; i++){
                    System.out.printf("%-25s", rsMD.getColumnName(i));
                }
                System.out.println();
                for (int i=1; i<=numColumn; ++i){
                    System.out.printf("%-25s", rset.getString(i));
                }
                System.out.println();

            }
            else {
                System.out.println("Invalid status code!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void viewwaitingorder(){
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "SELECT * FROM orders where status=2";
            rset = stmt.executeQuery(sqlSelect);
            if (rset.next()){
                rsMD = rset.getMetaData();
                int numColumn = rsMD.getColumnCount();
                for (int i =1; i<= numColumn; i++){
                    System.out.printf("%-25s", rsMD.getColumnName(i));
                }
                System.out.println();
                for (int i=1; i<=numColumn; ++i){
                    System.out.printf("%-25s", rset.getString(i));
                }
                System.out.println();

            }
            else {
                System.out.println("No order to view!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void viewpackedorder(){
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "SELECT * FROM orders where status=3";
            rset = stmt.executeQuery(sqlSelect);
            if (rset.next()){
                rsMD = rset.getMetaData();
                int numColumn = rsMD.getColumnCount();
                for (int i =1; i<= numColumn; i++){
                    System.out.printf("%-25s", rsMD.getColumnName(i));
                }
                System.out.println();
                for (int i=1; i<=numColumn; ++i){
                    System.out.printf("%-25s", rset.getString(i));
                }
                System.out.println();

            }
            else {
                System.out.println("No order to view!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void viewdeliveryorder(){
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "SELECT * FROM orders where status=4";
            rset = stmt.executeQuery(sqlSelect);
            if (rset.next()){
                rsMD = rset.getMetaData();
                int numColumn = rsMD.getColumnCount();
                for (int i =1; i<= numColumn; i++){
                    System.out.printf("%-25s", rsMD.getColumnName(i));
                }
                System.out.println();
                for (int i=1; i<=numColumn; ++i){
                    System.out.printf("%-25s", rset.getString(i));
                }
                System.out.println();

            }
            else {
                System.out.println("No order to view!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void viewdeliveredorder(){
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "SELECT * FROM orders where status=5";
            rset = stmt.executeQuery(sqlSelect);
            if (rset.next()){
                rsMD = rset.getMetaData();
                int numColumn = rsMD.getColumnCount();
                for (int i =1; i<= numColumn; i++){
                    System.out.printf("%-25s", rsMD.getColumnName(i));
                }
                System.out.println();
                for (int i=1; i<=numColumn; ++i){
                    System.out.printf("%-25s", rset.getString(i));
                }
                System.out.println();

            }
            else {
                System.out.println("No order to view!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void viewcanceledorder(){
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            String sqlSelect = "SELECT * FROM orders where status=0";
            rset = stmt.executeQuery(sqlSelect);
            if (rset.next()){
                rsMD = rset.getMetaData();
                int numColumn = rsMD.getColumnCount();
                for (int i =1; i<= numColumn; i++){
                    System.out.printf("%-25s", rsMD.getColumnName(i));
                }
                System.out.println();
                for (int i=1; i<=numColumn; ++i){
                    System.out.printf("%-25s", rset.getString(i));
                }
                System.out.println();

            }
            else {
                System.out.println("No order to view!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args){
        bookstore b1 = new bookstore();
            int choice;
            boolean quit = false;
            Scanner input = new Scanner(System.in);
            while (!quit){
                System.out.println("1- Top 10 newest book\n" +
                        "2- Top 100 selled book\n" +
                        "3- Search book by category\n" +
                        "4- Search book by author name\n" +
                        "5- Search book by ID\n" +
                        "6- View 30 new order\n" +
                        "7- View order by customer\n" +
                        "8- View order by orderID\n" +
                        "9- View order by status code\n" +
                        "10-View waiting order\n" +
                        "11-View packed order\n" +
                        "12-View delivery order\n" +
                        "13-View delivered order\n" +
                        "14-View canceled order\n" +
                        "15-Exit");
                System.out.printf("Your choice: ");
                choice = input.nextInt();
                switch (choice){
                    case 1:
                        b1.top10newbook();
                        break;
                    case 2:
                        b1.top100selled();
                        break;
                    case 3:
                        b1.searchbycategory();
                        break;
                    case 4:
                        b1.searchbyauthor();
                        break;
                    case 5:
                        b1.searchbyid();
                        break;
                    case 6:
                        b1.viewneworder();
                        break;
                    case 7:
                        b1.vieworderbycustomer();
                        break;
                    case 8:
                        b1.vieworderbyid();
                        break;
                    case 9:
                        b1.vieworderbystatus();
                        break;
                    case 10:
                        b1.viewwaitingorder();
                        break;
                    case 11:
                        b1.viewpackedorder();
                        break;
                    case 12:
                        b1.viewdeliveryorder();
                        break;
                    case 13:
                        b1.viewdeliveredorder();
                        break;
                    case 14:
                        b1.viewcanceledorder();
                        break;
                    case 15:
                        quit = true;
                        break;
                }
            }

    }
}
