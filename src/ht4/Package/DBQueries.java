package ht4.Package;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBQueries {
    public void inserting(String email, String pwd, Connection conn) {
        try {
            Statement s = conn.createStatement();
            s.executeUpdate("INSERT INTO Table_Login (username, password) VALUES ('" + email + "','" + pwd + "')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public boolean selecting(String email, String pwd, Connection conn) {
        try {
            Statement s = conn.createStatement();
            s.executeUpdate("SELECT * FROM Table_Login WHERE (username = '" + email + "' AND password = '" + pwd + "')");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
