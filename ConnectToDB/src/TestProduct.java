import java.sql.*;
import java.util.Scanner;

public class TestProduct {
    public static void main(String[] args) {
        String srch = "";
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/test",
                        "root", "");
                Statement stmt = conn.createStatement()
        ) {
            String strSelect = "SELECT *FROM products";
            System.out.println("The SQL statement is: " + strSelect + "\n");

            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The result are: ");
            int rowCount = 0;
            while (rset.next()) {
                int id = rset.getInt("id");
                String name = rset.getString("name");
                float price = rset.getInt("price");
                System.out.println(id + ", " + name + ", " + price);
                ++rowCount;
            }
            System.out.println("Total in stock product = " + rowCount + " product");

            System.out.printf("Type something to search: ");
            Scanner input = new Scanner(System.in);
            srch = input.nextLine();
            strSelect = "SELECT * FROM products WHERE name like " + "\'%" + srch + "%\'";
            System.out.println("The SQL statement is: " + strSelect + "\n");

            rset = stmt.executeQuery(strSelect);
            System.out.println("The result are: ");
            rowCount = 0;
            while (rset.next()) {
                int id = rset.getInt("id");
                String name = rset.getString("name");
                float price = rset.getInt("price");
                System.out.println(id + ", " + name + ", " + price);
                ++rowCount;
            }
            System.out.println("Product Found: " + rowCount + " product");
            if(rowCount == 0){
                System.out.println(srch + " not found!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
