package ht4.Package;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class DBQueries {
    public void inserting(String userN, String pwd, Connection conn) {
        try {
            Statement s = conn.createStatement();
            s.executeUpdate("INSERT INTO Table_Login (username, password) VALUES ('" + userN + "','" + pwd + "')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public boolean selecting(String userN, String pwd, Connection conn) {
        try {
            PreparedStatement st = (PreparedStatement) conn.prepareStatement("SELECT username, password FROM Table_Login WHERE (username = '" + userN + "' AND password = '" + pwd + "')");
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
