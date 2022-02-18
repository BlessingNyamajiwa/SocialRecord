package socialrecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Munyaradzi Nyamajiwa
 */
public class DBConnection 
{
    private static Connection conn;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/parish_register";
//    private  final String DB_USER = "root";
//    private  final String DB_PASS = "";
//    Above two can not be referenced from a static context
    
    public static Connection getConnection()
    {
        try
        {
            conn = DriverManager.getConnection(DB_URL, "root", "");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return conn;
    }
}
