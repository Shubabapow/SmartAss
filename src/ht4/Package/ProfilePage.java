/* This is the user profile page.
This is where the user can see and edit their user information. */
package ht4.Package;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfilePage extends JFrame implements ActionListener {
    //instantiating all of our elements
    JFrame profileFrame = new JFrame();
    JLabel titleName = new JLabel("Name:");
    JLabel titlePhone = new JLabel("Phone:");
    JLabel titleEmail= new JLabel("Email:");
    JLabel titleAge = new JLabel("Age:");
    JLabel titleHeight = new JLabel("Height:");
    JLabel titleCWeight = new JLabel("Current Weight:");
    JLabel titleBMI = new JLabel("BMI:");
    JLabel titleGWeight = new JLabel("Goal Weight:");

    JTextField nameText = new JTextField("Jane Doe");
    JTextField phoneText = new JTextField("123-456-7899");
    JTextField emailText = new JTextField("demo@test.com");
    JTextField ageText = new JTextField("32");
    JTextField heightText = new JTextField("5 ft 1 in");
    JTextField cWeightText = new JTextField("145 lb");
    JTextField bmiText = new JTextField("22");
    JTextField gWeightText = new JTextField("115 lb");

    private JButton exitButton = new JButton("Exit");

    //Creating the constructor and setting the size of the JFrame along with calling our helper methods
    ProfilePage() {
        profileFrame.setTitle("SmartAss");
        profileFrame.setBounds(10, 10, 370, 600);
        profileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        profileFrame.setVisible(true);
        profileFrame.setResizable(false);

        setLayoutManager();
        setLocationAndSize();
        addHomeComponentsToContainer();
        addActionEvent();
    }

    //Setting layout to null, which ends up just using the default layout
    public void setLayoutManager() {

        profileFrame.setLayout(null);
    }

    //Declares the size for the elements
    public void setLocationAndSize() {

        exitButton.setBounds(0, 0, 80, 25);

        nameText.setBounds(155, 65, 120,25);
        titleName.setBounds(5, 65, 80,30);

        phoneText.setBounds(155, 95, 120,25);
        titlePhone.setBounds(5, 95, 80,30);

        emailText.setBounds(155, 125, 120,25);
        titleEmail.setBounds(5, 125, 80,30);

        ageText.setBounds(155, 155, 120,25);
        titleAge.setBounds(5, 155, 80,30);

        heightText.setBounds(155, 185, 120,25);
        titleHeight.setBounds(5, 185, 80,30);

        cWeightText.setBounds(155, 215, 120,25);
        titleCWeight.setBounds(5, 215, 80,30);

        bmiText.setBounds(155, 245, 120,25);
        titleBMI.setBounds(5, 245, 80,30);

        gWeightText.setBounds(155, 275, 120,25);
        titleGWeight.setBounds(5, 275, 80,30);
    }

    //Adds all the elements to the JFrame
    public void addHomeComponentsToContainer() {
        profileFrame.add(titleName);
        profileFrame.add(titlePhone);
        profileFrame.add(titleEmail);
        profileFrame.add(titleAge);
        profileFrame.add(titleHeight);
        profileFrame.add(titleCWeight);
        profileFrame.add(titleBMI);
        profileFrame.add(titleGWeight);

        profileFrame.add(exitButton);

        profileFrame.add(nameText);
        profileFrame.add(phoneText);
        profileFrame.add(emailText);
        profileFrame.add(ageText);
        profileFrame.add(heightText);
        profileFrame.add(cWeightText);
        profileFrame.add(bmiText);
        profileFrame.add(gWeightText);

    }

    //Adds an action listener to the buttons
    public void addActionEvent() {
        exitButton.addActionListener(this);
    }

    //Setting the action in which each button will do.
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitButton) {
            profileFrame.dispose();
            new SettingsFrame();
        }
    }

    public static void main(String[] args) {
        new ProfilePage();
    }
}
