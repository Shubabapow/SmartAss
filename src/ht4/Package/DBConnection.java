package ht4.Package;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {

        String connectionUrl =
                "jdbc:sqlserver://DESKTOP-IIPD0JO\\SQLEXPRESS.database.windows.net:1433;"
                        + "database=SmartAssDB;"
                        + "user=Admin;"
                        + "password=12345;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        try {
            Connection connection = DriverManager.getConnection(connectionUrl);
            System.out.println("Connected to DB");
        } catch (SQLException e) {
            System.out.println("Could not connect to DB");
            e.printStackTrace();
        }
    }
    }

