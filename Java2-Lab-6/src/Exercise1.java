import java.sql.*;
import java.util.Scanner;

public class Exercise1 {

    public static void increasePrice(){
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop",
                "root","");
             Statement stmt = conn.createStatement()
        ){
            String strUpdate = "update books set price = price+price/2 where title = 'A cup of Java'";
            System.out.println("The sql statement is: " + strUpdate +"\n");
            int countUpdated = stmt.executeUpdate(strUpdate);
            System.out.println(countUpdated + " records effected.");

            String strSelect = "Select * from books where title = 'A cup of Java'";
            System.out.println("The sql statement is: " + strSelect);
            ResultSet rSet = stmt.executeQuery(strSelect);
            while (rSet.next()){
                System.out.println(rSet.getInt("id")+", "
                        + rSet.getString("author")+", "
                        +rSet.getString("title")+", "
                        +rSet.getDouble("price")+", "
                        +rSet.getInt("qty"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void setqty(){
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop",
                "root","");
             Statement stmt = conn.createStatement()
        ){
            String strUpdate = "update books set qty = 0 where title = 'A teaspoon of Java'";
            System.out.println("The sql statement is: " + strUpdate +"\n");
            int countUpdated = stmt.executeUpdate(strUpdate);
            System.out.println(countUpdated + " records effected.");

            String strSelect = "Select * from books where title = 'A teaspoon of Java'";
            System.out.println("The sql statement is: " + strSelect);
            ResultSet rSet = stmt.executeQuery(strSelect);
            while (rSet.next()){
                System.out.println(rSet.getInt("id")+", "
                        + rSet.getString("author")+", "
                        +rSet.getString("title")+", "
                        +rSet.getDouble("price")+", "
                        +rSet.getInt("qty"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte choose = 0;
        boolean exit = false;
        System.out.println("1- Tang price len 50% cho \"A Cup of Java\"\n" +
                "2- Set qty = 0 cho \"A Teaspoon of Java\"\n" +
                "3- Exit");
        while (!exit){
            System.out.printf("Your choose: ");
            choose = input.nextByte();
            switch (choose){
                case 1:
                    increasePrice();
                    break;
                case 2:
                    setqty();
                    break;
                case 3:
                    exit = true;
                    break;
            }
        }
    }
}
