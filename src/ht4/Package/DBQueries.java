package ht4.Package;

import java.sql.*;

public class DBQueries {
    public void creatingUser(String userN, String pwd, Connection conn) {
        try {
            Statement s = conn.createStatement();
            s.executeUpdate("INSERT INTO Table_Login (username, password) VALUES ('" + userN + "','" + pwd + "')");
        } catch (SQLException ex) {
            //ex.printStackTrace();
        }
    }
    public boolean updatingUserInfo(Connection conn, String name, String phone, String email, String age, String heightFT, String heightIN, String cWeight, String bmi, String gWeight) {
        try {
            Statement s = conn.createStatement();
            s.executeUpdate("UPDATE Table_Login SET name = '" + name + "', phone = '" + phone + "', email = '" + email + "', age = '" + age + "', [height ft] = '" + heightFT + "', [height in] = '" + heightIN + "', [Current weight] = '" + cWeight + "', bmi = '" + bmi + "', [Goal weight] = '" + gWeight + "' WHERE id = '11'");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean selectingUserLogin(String userN, String pwd, Connection conn) {
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM Table_Login WHERE (username = '" + userN + "' AND password = '" + pwd + "')");

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    //deletes the query row from database given the user ID.
    public boolean deleteQuery(int userID, Connection conn) {
        try {
            PreparedStatement st = conn.prepareStatement("DELETE FROM Table_Login WHERE (id = '" + userID + "')");
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
