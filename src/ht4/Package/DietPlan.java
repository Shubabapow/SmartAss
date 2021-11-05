package ht4.Package;

import javax.swing.*;
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
//    JList Menu_Mon;
//    JList Menu_Tue;
//    JList Menu_Wed;
//    JList Menu_Thu;
//    JList Menu_Fri;
//    JList Menu_Sat;
//    JList Menu_Sun;
    JLabel Mon = new JLabel("Monday");
    JLabel Tue = new JLabel("Tuesday");
    JLabel Wed = new JLabel("Wednesday");
    JLabel Thu = new JLabel("Thursday");
    JLabel Fri = new JLabel("Friday");
    JLabel Sat = new JLabel("Saturday");
    JLabel Sun = new JLabel("Sunday");

//    JLabel Cal_Mon;
//    JLabel Cal_Tue;
//    JLabel Cal_Wed;
//    JLabel Cal_Thu;
//    JLabel Cal_Fri;
//    JLabel Cal_Sat;
//    JLabel Cal_Sun;

    //Creating the constructor and setting the size of the JFrame along with calling our helper methods
    DietPlan() {
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


//        Menu_Mon.setBounds(45, 50,280,80);
//        Menu_Tue.setBounds(45, 130,280,80);
//        Menu_Wed.setBounds(45, 210,280,80);
//        Menu_Thu.setBounds(45, 290,280,80);
//        Menu_Fri.setBounds(45, 370,280,80);
//        Menu_Sat.setBounds(45, 450,280,80);
//        Menu_Sun.setBounds(45, 530,280,80);

//        Cal_Mon.setBounds(325, 50,40,80);
//        Cal_Tue.setBounds(325, 130,40,80);
//        Cal_Wed.setBounds(325, 210,40,80);
//        Cal_Thu.setBounds(325, 290,40,80);
//        Cal_Fri.setBounds(325, 370,40,80);
//        Cal_Sat.setBounds(325, 450,40,80);
//        Cal_Sun.setBounds(325, 530,40,80);
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
//        frame.add(Menu_Mon);
//        frame.add(Menu_Tue);
//        frame.add(Menu_Wed);
//        frame.add(Menu_Thu);
//        frame.add(Menu_Fri);
//        frame.add(Menu_Sat);
//        frame.add(Menu_Sun);
//        frame.add(Cal_Mon);
//        frame.add(Cal_Tue);
//        frame.add(Cal_Wed);
//        frame.add(Cal_Thu);
//        frame.add(Cal_Fri);
//        frame.add(Cal_Sat);
//        frame.add(Cal_Sun);
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
            BrowsePage browse = new BrowsePage();
        }
    }
    public static void main(String[] args) {
        DietPlan dietFrame = new DietPlan();
//        frame.setBounds(10, 10, 370, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);

    }
}

