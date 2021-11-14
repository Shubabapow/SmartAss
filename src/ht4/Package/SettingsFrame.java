/* This is the settings page.
this is where the user can change the settings for their application */
package ht4.Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class SettingsFrame extends JFrame implements ActionListener{
    //instantiating all of our elements
    JFrame settingsFrame = new JFrame();
    JLabel settingsLabel = new JLabel("Settings");
    JButton backButton = new JButton("Back");
    JButton profileButton = new JButton(new ImageIcon("./src/ht4.Package/icons/profile-icon.png"));
    JLabel editProfileLabel = new JLabel("Edit Profile");
    JButton darkThemeButton = new JButton("Dark Theme");
    JButton changeLanguageButton = new JButton("Change Language");
    JButton dietTrackerSettingsButton = new JButton("Diet Tracker Settings");
    JButton toggleNotificationsButton = new JButton("Toggle Notifications");
    JButton logoutButton = new JButton("Log out");
    JButton deleteAccountButton = new JButton("Delete Account");

    static boolean darkThemeClicked = false; //ActionListener flag for sequential button clicking.
    static boolean toggleNotificationsClicked = false;
    static Color defaultBackground = UIManager.getColor("Panel.background");

    //Creating the constructor and setting the size of the JFrame along with calling our helper methods
    SettingsFrame() {
        if (darkThemeClicked) {
            settingsFrame.getContentPane().setBackground(Color.DARK_GRAY);
            settingsLabel.setForeground(Color.WHITE);
            editProfileLabel.setForeground(Color.WHITE);
        }
        settingsFrame.setTitle("Settings");
        settingsFrame.setVisible(true);
        settingsFrame.setBounds(10, 10, 370, 600);
        settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settingsFrame.setResizable(false);
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    //Setting layout to null, which ends up just using the default layout
    public void setLayoutManager() {
        settingsFrame.setLayout(null);
    }

    //Declares the size for the elements
    public void setLocationAndSize() {
        settingsLabel.setBounds(10,10,100,50);
        backButton.setBounds(280,25,70,20);
        profileButton.setBounds(140,100,70,70);
        editProfileLabel.setBounds(143,160,100,50);
        logoutButton.setBounds(85, 400, 180, 30);
        dietTrackerSettingsButton.setBounds(85, 360, 180, 30);
        changeLanguageButton.setBounds(85, 320, 180, 30);
        toggleNotificationsButton.setBounds(85, 280, 180, 30);
        darkThemeButton.setBounds(85, 240, 180, 30);
        deleteAccountButton.setBounds(220,500,130,20);
    }

    //Adds all the elements to the JFrame
    public void addComponentsToContainer() {
        settingsFrame.add(settingsLabel);
        settingsFrame.add(backButton);
        settingsFrame.add(profileButton);
        settingsFrame.add(editProfileLabel);
        settingsFrame.add(darkThemeButton);
        settingsFrame.add(changeLanguageButton);
        settingsFrame.add(toggleNotificationsButton);
        settingsFrame.add(dietTrackerSettingsButton);
        settingsFrame.add(logoutButton);
        settingsFrame.add(deleteAccountButton);
    }

    //Adds an action listener to the buttons
    public void addActionEvent() {
        profileButton.addActionListener(this);
        backButton.addActionListener(this);
        darkThemeButton.addActionListener(this);
        logoutButton.addActionListener(this);
        toggleNotificationsButton.addActionListener(this);
        deleteAccountButton.addActionListener(this);
        changeLanguageButton.addActionListener(this);
    }

    //Setting the action in which each button will do.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            settingsFrame.dispose();
            new FrameHome();
        }
        else if (e.getSource() == profileButton) {
            settingsFrame.dispose();
            new ProfilePage();
        }
        else if (e.getSource() == logoutButton) {
            settingsFrame.dispose();
            darkThemeClicked = false;
            new LoginFrame();
        }
        else if (e.getSource() == darkThemeButton) {
            darkTheme(settingsFrame);
        }
        else if (e.getSource() == toggleNotificationsButton && !toggleNotificationsClicked) {
            JOptionPane.showMessageDialog(this,"Notifications turned off");
            toggleNotificationsClicked = true;
        }
        else if (e.getSource() == toggleNotificationsButton && toggleNotificationsClicked) {
            JOptionPane.showMessageDialog(this,"Notifications turned on");
            toggleNotificationsClicked = false;
        }
        else if (e.getSource() == changeLanguageButton) {

        }
        else if (e.getSource() == deleteAccountButton) {
            int result = JOptionPane.showConfirmDialog(this,"Are you sure?","Delete Account Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                Connection connection = DBConnection.DBC();
                DBQueries queries = new DBQueries();
                int userID = User.id;
                if (queries.deleteQuery(userID, connection)) {
                    JOptionPane.showMessageDialog(this, "Account Deleted. You will be redirected to the Login menu.");
                    settingsFrame.dispose();
                    new LoginFrame();
                }
            }
        }
    }

    public void darkTheme(JFrame frame) {
        if (!darkThemeClicked) {
            frame.getContentPane().setBackground(Color.DARK_GRAY);
            settingsLabel.setForeground(Color.WHITE);
            editProfileLabel.setForeground(Color.WHITE);
            darkThemeClicked = true;
        }
        else {
            frame.getContentPane().setBackground(defaultBackground);
            settingsLabel.setForeground(Color.BLACK);
            editProfileLabel.setForeground(Color.BLACK);
            darkThemeClicked = false;
        }
    }
}
//For testing the single page
//class Settings {
//    public static void main(String[] args) {
//        new SettingsFrame();
//    }
//}
