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

    public String[] selectingUserInfo(Connection conn) {
        String[] info = new String[9];
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM Table_Login WHERE (name = '" + info[0] + "', phone = '" + info[1] + "', email = '" + info[2] + "', age = '" + info[3] + "', [height ft] = '" + info[4] + "', [height in] = '" + info[5] + "', [Current weight] = '" + info[6] + "', bmi = '" + info[7] + "', [Goal weight] = '" + info[8] + "' WHERE id = '11')");

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return info;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
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
