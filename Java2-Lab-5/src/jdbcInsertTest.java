import java.sql.*;

public class jdbcInsertTest {
    public static void main(String[] args) {
        try(
                Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
                Statement stmt = conn.createStatement();
        ){
            //delete  records  with id >= 3000 and id < 4000
            String sqlDelete = "delete from books where id>=3000 and id < 4000";
            System.out.println("the SQL statement is: " +sqlDelete + "\n");
            int countDelete = stmt.executeUpdate(sqlDelete);
            System.out.println(countDelete + "records deleted.\n");

            //insert  a record
            String sqlInsert = "insert into books value (3001, 'Gone Fishing', 'Kumar', 11.11, 11)";
            System.out.println("the SQL statement is: " + sqlInsert + "\n");
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + "records insert.\n");

            //insert multiple records
            sqlInsert = "insert into books values "
                    + "(3002, 'Gone Fishing 2', 'Kumar', 22.22, 22),"
                    + "(3003, 'Gone Fishing 3', 'Kumar', 33.33, 33)";
            System.out.println("the SQL statement is: " + sqlInsert + "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + "record inserted. \n");

            //insert partial records
            sqlInsert = "insert into books (id, title, author) values (3004, 'Fishing 101', 'Kumar')";
            System.out.println("the SQL statement is: " + sqlInsert + "\n");
            countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + "record inserted. \n");

            //issue a select to check the changes
            String strSelect = "select * from books";
            System.out.println("the SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()){
                System.out.println(rset.getInt("id") + ","
                        + rset.getString("author") + ","
                        + rset.getInt("qty") + ","
                        + rset.getString("title") + ","
                        + rset.getDouble("price") + ",");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
