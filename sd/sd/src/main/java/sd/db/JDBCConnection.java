package sd.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JDBCConnection {
    private static Connection conn = null;

    static
    {
        String url = "jdbc:mysql://localhost:3306/sahana";
        String user = "root";
        String pass = "Sahana@123";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return conn;
    }
}