import java.sql.*;

public class JdbcUpdateTest {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop",
                "root","");
             Statement stmt = conn.createStatement()
        ){
            String strUpdate = "update books set price = price*0.7, qty = qty + 1 where id = 1001";
            System.out.println("The sql statement is: " + strUpdate +"\n");
            int countUpdated = stmt.executeUpdate(strUpdate);
            System.out.println(countUpdated + " records effected.");

            String strSelect = "Select * from books where id = 1001";
            System.out.println("The sql statement is: " + strSelect);
            ResultSet rSet = stmt.executeQuery(strSelect);
            while (rSet.next()){
                System.out.println(rSet.getInt("id")
                        + rSet.getString(" author")+", "
                        +rSet.getString(" title")+", "
                        +rSet.getDouble(" price")+", "
                        +rSet.getInt(" qty"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}