import java.sql.*;
import java.util.Scanner;

public class Exercises_1 {
    public static void main(String[] args) {
        try(
                Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
                Statement stmt = conn.createStatement();
        ){
            //delete  records  with id > 8000
            String sqlDelete = "delete from books where id>8000";
            System.out.println("the SQL statement is: " +sqlDelete + "\n");
            int countDelete = stmt.executeUpdate(sqlDelete);
            System.out.println(countDelete + "records deleted.\n");

            //insert  2 record
            String sqlInsert = "insert into books values "
                    + "(8001, 'Java Core', 'Dang Kim Thi', 15.55, 55),"
                    + "(8002, 'Java Advanced', 'James Gosling', 25.55, 55)";
            System.out.println("the SQL statement is: " + sqlInsert + "\n");
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + "records insert.\n");

            //insert a records with null col
            sqlInsert = "insert into books(id,title,author) values(2001,'Java JDBC MySQL','ThiDK')";
            System.out.println("the SQL statement is: " + sqlInsert + "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + "record inserted. \n");

            //delete a records
            System.out.println("Enter bookID you want to delete: ");
            Scanner input = new Scanner(System.in);
            int id = input.nextInt();
            sqlDelete = "delete from books where id ="+id;
            System.out.println("The SQL statement is " + sqlDelete);
            countDelete = stmt.executeUpdate(sqlDelete);
            System.out.println(countDelete + " row(s) effected");

            //add a book
            System.out.printf("Book Id: ");
            id = input.nextInt();
            System.out.printf("Title: ");
            input.nextLine();
            String title = input.nextLine();
            System.out.printf("Author: ");
            String author = input.nextLine();
            System.out.printf("Price: ");
            double price = input.nextDouble();
            System.out.printf("Qty: ");
            int qty = input.nextInt();
            sqlInsert = "Insert into books values"+
                    "("+id+",'"+title+"'"+",'"+author+"'"+","+price+","+qty+")";
            System.out.println("The SQL statemnet is "+sqlInsert);
            countInserted= stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted+" book added");

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
