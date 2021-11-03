package ht4.Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    //Container frame = getContentPane();
    JLabel userLabel = new JLabel("USERNAME:");
    JLabel passwordLabel = new JLabel("PASSWORD:");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton registerButton = new JButton("Register");
    JCheckBox showPassword = new JCheckBox("Show Password");

    // inside your class constructor/method
    JPanel panel = new JPanel();
    ImageIcon img = new ImageIcon(new String("./Resources/healtech1-removebg-preview.png"));
    JLabel jlPic = new JLabel(img);

    LoginFrame() {

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

    public void setLayoutManager() {
        frame.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 325, 100, 30);
        passwordLabel.setBounds(50, 370, 100, 30);
        userTextField.setBounds(150, 325, 150, 30);
        passwordField.setBounds(150, 370, 150, 30);
        showPassword.setBounds(150, 400, 150, 30);
        loginButton.setBounds(150, 450, 100, 30);
        registerButton.setBounds(150, 500, 100, 30);
        jlPic.setBounds(20, 25, 325, 300);

    }

    public void addLoginComponentsToContainer() {
        frame.add(userLabel);
        frame.add(passwordLabel);
        frame.add(userTextField);
        frame.add(passwordField);
        frame.add(showPassword);
        frame.add(loginButton);
        frame.add(registerButton);
        frame.add(jlPic);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    public void changePanel(FrameHome panel) {
        getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().doLayout();
        update(getGraphics());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("joey") && pwdText.equalsIgnoreCase("12345")) {
                //Main mainFrame = new Main();
                frame.dispose();
                FrameHome homeFrame = new FrameHome();
                homeFrame.setTitle("SmartAss");
                homeFrame.setVisible(true);
                homeFrame.setBounds(10, 10, 370, 600);
                homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                homeFrame.setResizable(false);

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }

        // Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword)

        {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }

        }
    }
}

//class Login {
//    public static void main(String[] a) {
//        LoginFrame frame = new LoginFrame();
//        frame.setTitle("SmartAss");
//        frame.setVisible(true);
//        frame.setBounds(10, 10, 370, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);
//
//    }
//
//}

