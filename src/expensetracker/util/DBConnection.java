package expensetracker.util;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/expensetracker";
        String user = "root";
        String password = "raj@123"; // change this
        return DriverManager.getConnection(url, user, password);
    }
}
