import java.sql.*;
import java.util.Scanner;

public class bookstore {
    private static final String connURL = "jdbc:mysql://localhost:3306/ebookstore";
    private static final String connUser = "root";
    private static final String connPass = "";
    private static ResultSet rset;
    private static int inputID;
    private static String inputEmail;
    private static ResultSetMetaData rsMD;
    public static void addbook(){
        try(
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement()
        ){
            int bookID;
            String title;
            String author;
            int years;
            byte status;
            int qty;
            float price;
            Scanner input = new Scanner(System.in);
            System.out.println("****Add New Book****");
            System.out.printf("Enter book ID: ");
            bookID = input.nextInt();
            input.nextLine();
            System.out.printf("Enter book Title: ");
            title = input.nextLine();
            System.out.printf("Enter book Author: ");
            author = input.nextLine();
            System.out.printf("Enter Published year: ");
            years = input.nextInt();
            System.out.printf("Enter Status (1-5): ");
            status = input.nextByte();
            System.out.printf("Enter Qty: ");
            qty = input.nextInt();
            System.out.printf("Enter book price: ");
            price = input.nextFloat();

            String sqlInsert = "INSERT INTO books(bookid, title, author, years, status, qty, price) VALUES ("+bookID+", \""+title+"\", \""+author+"\", "+years+", "+status+", "+qty+", "+price+")";
            System.out.println(sqlInsert);
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " Book inserted.\n");
            menu();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void orderbook(){
        try(
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ){
            String checkBookID = "SELECT bookID FROM books WHERE bookID=?";

            Scanner input = new Scanner(System.in);

            System.out.println("****Order a book****");
            System.out.printf("Enter book ID: ");
            int bookID = input.nextInt();
            PreparedStatement stm = conn.prepareStatement(checkBookID);
            stm.setInt(1,bookID);
            rset = stm.executeQuery();
            if (rset.next()){
                System.out.printf("Enter order ID: ");
                int orderID = input.nextInt();
                System.out.printf("Enter amount: ");
                int amount = input.nextInt();
                System.out.printf("Enter discount: ");
                int discount = input.nextInt();
                String checkAmount = "SELECT title, status, qty, price FROM books WHERE bookID="+bookID;
                ResultSet rset2 = stmt.executeQuery(checkAmount);
                rset2.next();
                String title = rset2.getString("title");
                int status = rset2.getInt("status");
                int qty = rset2.getInt("qty");
                float price = rset2.getFloat("price");
                int total = (int) (price*amount);
                float caldiscount = (total*discount)/100;
                if (amount <= qty){
                    String newOrder = "INSERT INTO `orders` (`orderID`, `customerID`, `discount`, `total`, `orderdate`, `status`, `createddate`, `updateddate`) " +
                            "VALUES ("+orderID+", "+inputID+","+discount+ ", " +caldiscount+ ", CURRENT_DATE(), "+status+ ", CURRENT_DATE(), CURRENT_DATE());" +
                            "INSERT INTO `orderdetail` (`orderID`, `bookID`, `title`, `amount`, `price`, `createddate`, `updateddate`) " +
                            "VALUES ("+orderID+ ", "+bookID+ ", \""+title+ "\", "+amount+ ", "+price+", CURRENT_DATE(), CURRENT_DATE());" +
                            "UPDATE `books` SET `qty` = "+(qty-amount)+ ", `updateddate` = CURDATE() WHERE `books`.`bookID` = "+bookID+" AND `books`.`title` = \""+title+"\";";
                    System.out.println(newOrder);
                    stmt.executeUpdate(newOrder);
                    System.out.println("order book successfully! Thank you!");
                }
                else {
                    System.out.printf("The amount of books in stock is not enough!");
                }
            }
            else{
                System.out.println("Book ID not found!");
            }

        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }


    }
    public static void memberRegist(){
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
                ) {
            int customerID;
            String customerName;
            String customerAddress;
            String customerEmail;
            String customerPhone;
            Scanner input = new Scanner(System.in);
            System.out.println("****Add New Member****");
            System.out.printf("Enter ID: ");
            customerID = input.nextInt();
            input.nextLine();
            System.out.printf("Enter name: ");
            customerName = input.nextLine();
            System.out.printf("Enter address: ");
            customerAddress = input.nextLine();
            System.out.printf("Enter Email: ");
            customerEmail = input.nextLine();
            System.out.printf("Enter phone number: ");
            customerPhone = input.nextLine();

            String sqlInsert = "INSERT INTO customers(customerID, name, address, email, phone) VALUES ("+customerID+", \""+customerName+"\", \""+customerAddress+"\", \""+customerEmail+"\", \""+customerPhone+"\")";
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " Member registered.\n");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void login(){


        Scanner input = new Scanner(System.in);
        System.out.printf("Enter your ID: ");
        inputID = input.nextInt();
        input.nextLine();
        System.out.printf("Enter your Email: ");
        inputEmail = input.nextLine();
        try(
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ){
            String sqlSelect = "SELECT customerID, email FROM customers WHERE customerID=? AND email=?";
            PreparedStatement stm = conn.prepareStatement(sqlSelect);
            stm.setInt(1, inputID);
            stm.setString(2, inputEmail);
            ResultSet rSet = stm.executeQuery();
            if(rSet.next()){
                System.out.println("\nLogin Success!\n");
                menu();
            }
            else {
                System.out.println("\nLogin Failed!\n");
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public static void top10newbook() {
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
    public static void top100selled(){
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
    public static void menu(){
        int choice;
        boolean quit = false;
        Scanner input = new Scanner(System.in);
        while (!quit){
            System.out.println("1- Top 10 newest book\n" +
                    "2- Top 100 selled book\n" +
                    "3- Add book\n" +
                    "4- Order book\n" +
                    "5- Logout");
            System.out.printf("Your choice: ");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    top10newbook();
                    break;
                case 2:
                    top100selled();
                    break;
                case 3:
                    addbook();
                    break;
                case 4:
                    orderbook();
                    break;
                case 5:
                    quit =  true;
                    break;
            }
        }
    }

        public static void main(String[] args) {
        int choice;
        boolean quit = false;
        Scanner input = new Scanner(System.in);
            while (!quit){
                System.out.println("1- login\n" +
                        "2- Register\n" +
                        "3- Quit");
                System.out.printf("Your choice: ");
                choice = input.nextInt();
                switch (choice){
                    case 1:
                        login();
                        break;
                    case 2:
                        memberRegist();
                        break;
                    case 3:
                        quit =  true;
                        break;
                }
            }
    }
}
