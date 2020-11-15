import java.sql.*;

public class JdbcPreparedStatementTest {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop","root","");
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO books VALUES (?, ?, ?, ?, ?)");
                PreparedStatement pstmtSelect = conn.prepareStatement("SELECT * FROM books");
                ) {
            pstmt.setInt(1, 7001);
            pstmt.setString(2,"Mahjong 101");
            pstmt.setString(3,"Kumar");
            pstmt.setDouble(4,88.88);
            pstmt.setInt(5,88);
            int rowInserted = pstmt.executeUpdate();
            System.out.println(rowInserted + " rows affected.");

            pstmt.setInt(1, 7002);
            pstmt.setString(2, "mahjong 102");
            rowInserted = pstmt.executeUpdate();
            System.out.println(rowInserted + " rows affected.");

            ResultSet rset = pstmtSelect.executeQuery();
            while (rset.next()){
                System.out.println(rset.getInt("id") + ", "
                + rset.getString("author") + ", "
                + rset.getString("title") + ", "
                + rset.getDouble("price") + ", "
                + rset.getInt("qty"));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
