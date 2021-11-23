/* This is where we will connect to a Database */
package ht4.Package;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class DBConnection {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static Connection DBC() {

        String connectionUrl =
                "jdbc:sqlserver://smartassdb.cbwxuz3gtope.us-east-2.rds.amazonaws.com:1433;"
                        + "database=Smartass;"
                        + "user=admin;"
                        + "password=Smart123Ass#;";

        try {
            Connection connection = DriverManager.getConnection(connectionUrl);
            System.out.println("Connected to DB");
            return connection;
        } catch (SQLException e) {
            System.out.println("Could not connect to DB");
            e.printStackTrace();
        }
        return null;
    }

}

