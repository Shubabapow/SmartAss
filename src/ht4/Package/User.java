//user class to store current user in order to update info or delete account
package ht4.Package;

import java.sql.*;

public class User {
    Connection connection = DBConnection.DBC();
    ResultSet rs = null;

    //user object is created from searching the row in database that matches the desired name.
    public User(int userID) {
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM Table_Login WHERE (id = '" + userID + "')");
            rs = st.executeQuery();
            rs.next(); //move pointer to the resultSet (database query/entry with user info)
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
