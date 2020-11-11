import java.sql.*;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte choose = 0;
        boolean exit = false;
        System.out.println("=====MENU=====\n" +
                "1- Chance Category name\n" +
                "2- Chance Customer's Address\n" +
                "3- Chance Product Price\n" +
                "4- Chance Order's Shipvia\n" +
                "5- Exit");
        while (!exit){
            System.out.printf("Your choose: ");
            choose = input.nextByte();
            switch (choose){
                case 1:
                    chanceCategory();
                    break;
                case 2:
                    chanceAddress();
                    break;
                case 3:
                    chancePrice();
                    break;
                case 4:
                    chanceOrder();
                    break;
                case 5:
                    exit = true;
                    break;
            }
        }
    }
    public static void chanceCategory(){
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind",
                "root","");
             Statement stmt = conn.createStatement()
        ){
            String strUpdate = "UPDATE `categories` SET `CategoryName` = 'SeaFood VN' WHERE `categories`.`CategoryName` = 'Seafood';";
            int countUpdated = stmt.executeUpdate(strUpdate);
            System.out.println(countUpdated + " records effected.");

            String strSelect = "SELECT * FROM `categories` WHERE `categories`.`CategoryName` = 'SeaFood VN';";
            System.out.println("The sql statement is: " + strSelect);
            ResultSet rSet = stmt.executeQuery(strSelect);
            while (rSet.next()){
                System.out.println(rSet.getInt("CategoryID")+", "
                        + rSet.getString("CategoryName")+", "
                        +rSet.getString("Description")+", "
                        +rSet.getBinaryStream("Picture"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void chanceAddress(){
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind",
                "root","");
             Statement stmt = conn.createStatement()
        ){
            String strUpdate = "UPDATE `customers` SET `Address` = '1A Yet Kieu - Ha Noi' WHERE `customers`.`CustomerID` = 'FRANK'";
            int countUpdated = stmt.executeUpdate(strUpdate);
            System.out.println(countUpdated + " records effected.");

            String strSelect = "SELECT * FROM `customers` WHERE `customers`.`CustomerID` = 'FRANK'";
            System.out.println("The sql statement is: " + strSelect);
            ResultSet rSet = stmt.executeQuery(strSelect);
            while (rSet.next()){
                System.out.println(rSet.getString("CustomerID")+", "
                        + rSet.getString("CompanyName")+", "
                        +rSet.getString("ContactName")+", "
                        +rSet.getString("ContactTitle")+", "
                        +rSet.getString("Address")+", "
                        +rSet.getString("City")+", "
                        +rSet.getString("Region")+", "
                        +rSet.getString("PostalCode")+", "
                        +rSet.getString("Country")+", "
                        +rSet.getString("Phone")+", "
                        +rSet.getString("Fax"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void chancePrice(){
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root","");
            Statement stmt = conn.createStatement()) {
            String sqlUpdate = "Update products set UnitPrice = UnitPrice+UnitPrice/100*10 where CategoryId = 5";
            stmt.executeUpdate(sqlUpdate);
            sqlUpdate = "Update products set UnitPrice = UnitPrice+UnitPrice/100*10 where CategoryId = 7";
            stmt.executeUpdate(sqlUpdate);
            sqlUpdate = "Update products set UnitPrice = UnitPrice+UnitPrice/100*10 where CategoryId = 8";
            stmt.executeUpdate(sqlUpdate);
            System.out.println("Updated");
            ResultSet rSet = stmt.executeQuery("SELECT * FROM products where CategoryId = 5");
            while (rSet.next()){
                System.out.println(rSet.getInt("ProductID") + ", "
                        + rSet.getString("ProductName")+ ", "
                        + rSet.getInt("CategoryID") + ", "
                        + rSet.getString("QuantityPerUnit") + ", "
                        + rSet.getDouble("UnitPrice"));
            }
            rSet = stmt.executeQuery("SELECT * FROM products where CategoryId = 7");
            while (rSet.next()){
                System.out.println(rSet.getInt("ProductID") + ", "
                        + rSet.getString("ProductName")+ ", "
                        + rSet.getInt("CategoryID") + ", "
                        + rSet.getString("QuantityPerUnit") + ", "
                        + rSet.getDouble("UnitPrice"));
            }
            rSet = stmt.executeQuery("SELECT * FROM products where CategoryId = 8");
            while (rSet.next()){
                System.out.println(rSet.getInt("ProductID") + ", "
                        + rSet.getString("ProductName")+ ", "
                        + rSet.getInt("CategoryID") + ", "
                        + rSet.getString("QuantityPerUnit") + ", "
                        + rSet.getDouble("UnitPrice"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void chanceOrder(){
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root","");
            Statement stmt = conn.createStatement()) {
            String update = "UPDATE orders set ShipVia = 2 where OrderID = 10313";
            System.out.println("The sql statement is: " + update + "\n");
            stmt.executeUpdate(update);
            System.out.println("Updated");
            ResultSet rSet = stmt.executeQuery("SELECT * from orders where OrderID = 10313");
            while (rSet.next()){
                System.out.println(rSet.getString("OrderID") + ", "
                        + rSet.getString("CustomerID")+ ", "
                        + rSet.getString("ShipVIa"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
