import java.sql.*;

public class AtomicTransaction {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookstore", "root", "");
                Statement stmt = conn.createStatement();
                ){
            conn.setAutoCommit(false);
            String strQuery = "SELECT id, qty FROM books WHERE id IN(1001, 1002)";
            System.out.println();
            ResultSet rset = 
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
