import java.sql.*;

public class demometadata {
    private static final String connURL = "jdbc:mysql://localhost:3306/northwind";
    private static final String connUser = "root";
    private static final String connPass = "";

    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(connURL, connUser, connPass);
                Statement stmt = conn.createStatement();
        ) {
            ResultSet rset = stmt.executeQuery("SELECT * FROM customers");
            ResultSetMetaData rsMD = rset.getMetaData();

            int numColumn = rsMD.getColumnCount();

            for (int i =1; i<= numColumn; i++){
                System.out.printf("%-40s", rsMD.getColumnName(i));
            }
            System.out.println();

            for (int i =1; i <= numColumn; i++){
                System.out.printf("%-40s","(" + rsMD.getColumnClassName(i) + ")");
            }
            System.out.println();

            while (rset.next()){
                for (int i=1; i<=numColumn; ++i){
                    System.out.printf("%-40s", rset.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
