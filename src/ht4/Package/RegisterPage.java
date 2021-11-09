/*  */
package ht4.Package;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterPage extends JFrame implements ActionListener {
    //instantiating all of our elements
    JFrame frame = new JFrame();
    JLabel emailLabel = new JLabel("EMAIL:");
    JLabel passwordLabel = new JLabel("PASSWORD:");
    JLabel cPasswordLabel = new JLabel("CONFIRM PASSWORD:");
    JTextField emailTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField cPasswordField = new JPasswordField();
    JButton createAccountButton = new JButton("Create Account");

    //Grabbing image from folder and making it into a JLabel
    ImageIcon img = new ImageIcon(("./Resources/healtech1-removebg-preview.png"));
    JLabel jlPic = new JLabel(img);

    //Creating the constructor and setting the size of the JFrame along with calling our helper methods
    RegisterPage() {

        frame.setTitle("SmartAss");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        setLayoutManager();
        setLocationAndSize();
        addLoginComponentsToContainer();
        addActionEvent();
    }
    //Setting layout to null, which ends up just using the default layout
    public void setLayoutManager() {
        frame.setLayout(null);
    }
    //Declares the size for the elements
    public void setLocationAndSize() {
        emailLabel.setBounds(50, 325, 100, 30);
        passwordLabel.setBounds(50, 370, 100, 30);
        cPasswordLabel.setBounds(50, 415, 100, 30);
        emailTextField.setBounds(150, 325, 150, 30);
        passwordField.setBounds(150, 370, 150, 30);
        cPasswordField.setBounds(150, 415, 150, 30);

        createAccountButton.setBounds(150, 500, 200, 30);
        jlPic.setBounds(20, 25, 325, 300);

    }
    //Adds all the elements to the JFrame
    public void addLoginComponentsToContainer() {
        frame.add(emailLabel);
        frame.add(passwordLabel);
        frame.add(cPasswordLabel);
        frame.add(emailTextField);
        frame.add(passwordField);
        frame.add(cPasswordField);

        frame.add(createAccountButton);
        frame.add(jlPic);
    }
    //Adds an action listener to the buttons
    public void addActionEvent() {
        createAccountButton.addActionListener(this);
    }
    //This is to clear the JPanel
//    public void changePanel(FrameHome panel) {
//        getContentPane().removeAll();
//        getContentPane().add(panel, BorderLayout.CENTER);
//        getContentPane().doLayout();
//        update(getGraphics());
//    }

    // This is the action of clicking on the login button.
    // If the username and password are correct then it will take you to the home screen.
    //If the login is not correct it will tell you it's an invalid login
    @Override
    public void actionPerformed(ActionEvent e) {
        // Coding Part of LOGIN button
        if (e.getSource() == createAccountButton) {
            String emailText;
            String pwdText;
            String cpwdText;
            emailText = emailTextField.getText();
            pwdText = passwordField.getText();
            cpwdText = cPasswordField.getText();

            //for(int i = 0; i <= pwdText.length(); i++) {

                if (1==1/*pwdText.charAt(i) == cpwdText.charAt(i)*/) {
                    String connectionUrl =
                            "jdbc:sqlserver://smartassdb.cbwxuz3gtope.us-east-2.rds.amazonaws.com:1433;"
                                    + "database=Smartass;"
                                    + "user=admin;"
                                    + "password=Smart123Ass#;";
                    Connection connection = null;
                    try {
                        connection = DriverManager.getConnection(connectionUrl);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    Statement s = null;
                    try {
                        s = connection.createStatement();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        s.executeUpdate("INSERT INTO Table_Login (username, password) VALUES ('" + emailText + "','" + pwdText + "')");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Passwords don't match");
                }
            //}
        }
    }
    public static void main(String[] a) {
        new RegisterPage();

    }
}


