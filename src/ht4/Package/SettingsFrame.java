package ht4.Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsFrame extends JFrame implements ActionListener{
    JFrame settingsFrame = new JFrame();
    JLabel settingsLabel = new JLabel("Settings");
    JButton backButton = new JButton("Back");
    JButton profileButton = new JButton(new ImageIcon("/icons/profilePic.png"));
    JLabel editProfileLabel = new JLabel("Edit Profile");
    JButton darkThemeButton = new JButton("Dark Theme");
    JButton changeLanguageButton = new JButton("Change Language");
    JButton dietTrackerSettingsButton = new JButton("Diet Tracker Settings");
    JButton toggleNotificationsButton = new JButton("Toggle Notifications");
    JButton logoutButton = new JButton("Log out");

    boolean darkThemeClicked = false; //ActionListener flag for sequential button clicking.
    boolean toggleNotificationsClicked = false;

    SettingsFrame() {
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

    public void setLayoutManager() {
        settingsFrame.setLayout(null);
    }

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
    }

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
    }

    public void addActionEvent() {
        profileButton.addActionListener(this);
        backButton.addActionListener(this);
        darkThemeButton.addActionListener(this);
        logoutButton.addActionListener(this);
        toggleNotificationsButton.addActionListener(this);
    }

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
            new LoginFrame();
        }
        else if (e.getSource() == darkThemeButton && !darkThemeClicked) {
            settingsFrame.getContentPane().setBackground(Color.DARK_GRAY);
            settingsLabel.setForeground(Color.WHITE);
            editProfileLabel.setForeground(Color.WHITE);
            darkThemeClicked = true;
        }
        else if (e.getSource() == darkThemeButton && darkThemeClicked){
            settingsFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
            settingsLabel.setForeground(Color.BLACK);
            editProfileLabel.setForeground(Color.BLACK);
            darkThemeClicked = false;
        }
        else if (e.getSource() == toggleNotificationsButton && !toggleNotificationsClicked) {
            JOptionPane.showMessageDialog(settingsFrame,"Notifications turned off");
            toggleNotificationsClicked = true;
        }
        else if (e.getSource() == toggleNotificationsButton && toggleNotificationsClicked) {
            JOptionPane.showMessageDialog(settingsFrame,"Notifications turned on");
            toggleNotificationsClicked = false;
        }
    }
}

//class Settings {
//    public static void main(String[] args) {
//        new SettingsFrame();
//    }
//}
