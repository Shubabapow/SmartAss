/*  */
package ht4.Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DietPlan extends JFrame implements ActionListener {
    //instantiating all of our elements
    JFrame dietFrame = new JFrame();
    //JPanel DietPlan = new JPanel(Boolean.parseBoolean("DIETPLAN: "));
    JButton backButton = new JButton("Back");
    JTextArea monText = new JTextArea("Enter Meal Plan");
    JTextArea tueText = new JTextArea("Enter Meal Plan");
    JTextArea wedText = new JTextArea("Enter Meal Plan");
    JTextArea thuText = new JTextArea("Enter Meal Plan");
    JTextArea friText = new JTextArea("Enter Meal Plan");
    JTextArea satText = new JTextArea("Enter Meal Plan");
    JTextArea sunText = new JTextArea("Enter Meal Plan");

    JLabel Mon = new JLabel("Monday");
    JLabel Tue = new JLabel("Tuesday");
    JLabel Wed = new JLabel("Wednesday");
    JLabel Thu = new JLabel("Thursday");
    JLabel Fri = new JLabel("Friday");
    JLabel Sat = new JLabel("Saturday");
    JLabel Sun = new JLabel("Sunday");

    //Creating the constructor and setting the size of the JFrame along with calling our helper methods
    DietPlan() {
        if (SettingsFrame.darkThemeClicked) {
            dietFrame.getContentPane().setBackground(Color.DARK_GRAY);
            Mon.setForeground(Color.WHITE);
            Tue.setForeground(Color.WHITE);
            Wed.setForeground(Color.WHITE);
            Thu.setForeground(Color.WHITE);
            Fri.setForeground(Color.WHITE);
            Sat.setForeground(Color.WHITE);
            Sun.setForeground(Color.WHITE);
        }
        dietFrame.setTitle("Diet Plan");
        dietFrame.setVisible(true);
        dietFrame.setBounds(10, 10, 370, 600);
        dietFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dietFrame.setResizable(false);
        setLayoutManager();
        setLocationAndSize();
        addPlanComponentsToContainer();
        addActionEvent();
    }
    //Setting layout to null, which ends up just using the default layout
    public void setLayoutManager() {

        dietFrame.setLayout(null);
    }
    //Declares the size for the elements
    public void setLocationAndSize() {
        //DietPlan.setBounds(10, 10, 100, 30);
        backButton.setBounds(265, 0, 80, 22);
        Mon.setBounds(10, 0,60,25);
        Tue.setBounds(10, 80,60,25);
        Wed.setBounds(10, 160,80,25);
        Thu.setBounds(10, 240,60,25);
        Fri.setBounds(10, 320,60,25);
        Sat.setBounds(10, 400,60,25);
        Sun.setBounds(10, 480,60,25);
        monText.setBounds(10, 25, 250, 50);
        tueText.setBounds(10, 105, 250, 50);
        wedText.setBounds(10, 185, 250, 50);
        thuText.setBounds(10, 265, 250, 50);
        friText.setBounds(10, 345, 250, 50);
        satText.setBounds(10, 425, 250, 50);
        sunText.setBounds(10, 505, 250, 50);
    }
    //Adds all the elements to the JFrame
    public void addPlanComponentsToContainer() {
        //dietFrame.add(DietPlan);
        dietFrame.add(backButton);
        dietFrame.add(Mon);
        dietFrame.add(Tue);
        dietFrame.add(Wed);
        dietFrame.add(Thu);
        dietFrame.add(Fri);
        dietFrame.add(Sat);
        dietFrame.add(Sun);
        dietFrame.add(monText);
        dietFrame.add(tueText);
        dietFrame.add(wedText);
        dietFrame.add(thuText);
        dietFrame.add(friText);
        dietFrame.add(satText);
        dietFrame.add(sunText);

    }
    //Adds an action listener to the buttons
    public void addActionEvent() {

        backButton.addActionListener(this);
    }

    // This is the action of clicking on the back button.
    // It will drive the user back to Home page
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dietFrame.dispose();
            new BrowsePage();
        }
    }
    //Test single frame
//    public static void main(String[] args) {
//        DietPlan frame = new DietPlan();
//        frame.setBounds(10, 10, 370, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//
//    }
}

