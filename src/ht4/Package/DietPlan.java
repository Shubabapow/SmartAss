package ht4Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DietPlan extends JFrame implements ActionListener {
    //instantiating all of our elements
    JFrame frame = new JFrame();
    JPanel DietPlan = new JPanel(Boolean.parseBoolean("DIETPLAN: "));
    JButton backButton = new JButton("Back");
    JList Menu_Mon;
    JList Menu_Tue;
    JList Menu_Wed;
    JList Menu_Thu;
    JList Menu_Fri;
    JList Menu_Sat;
    JList Menu_Sun;
    JLabel Mon = new JLabel("Monday");
    JLabel Tue = new JLabel("Tuesday");
    JLabel Wed = new JLabel("Wednesday");
    JLabel Thu = new JLabel("Thursday");
    JLabel Fri = new JLabel("Friday");
    JLabel Sat = new JLabel("Saturday");
    JLabel Sun = new JLabel("Sunday");

    JLabel Cal_Mon;
    JLabel Cal_Tue;
    JLabel Cal_Wed;
    JLabel Cal_Thu;
    JLabel Cal_Fri;
    JLabel Cal_Sat;
    JLabel Cal_Sun;

    //Creating the constructor and setting the size of the JFrame along with calling our helper methods
    DietPlan() {
        frame.setTitle("Diet Plan");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        setLayoutManager();
        setLocationAndSize();
    }
    //Setting layout to null, which ends up just using the default layout
    public void setLayoutManager() {
        frame.setLayout(null);
    }
    //Declares the size for the elements
    public void setLocationAndSize() {
        DietPlan.setBounds(10, 10, 100, 30);
        backButton.setBounds(310, 365, 50, 30);
        Mon.setBounds(10, 50,30,80);
        Tue.setBounds(10, 130,30,80);
        Wed.setBounds(10, 210,30,80);
        Thu.setBounds(10, 290,30,80);
        Fri.setBounds(10, 370,30,80);
        Sat.setBounds(10, 450,30,80);
        Sun.setBounds(10, 530,30,80);

        Menu_Mon.setBounds(45, 50,280,80);
        Menu_Tue.setBounds(45, 130,280,80);
        Menu_Wed.setBounds(45, 210,280,80);
        Menu_Thu.setBounds(45, 290,280,80);
        Menu_Fri.setBounds(45, 370,280,80);
        Menu_Sat.setBounds(45, 450,280,80);
        Menu_Sun.setBounds(45, 530,280,80);

        Cal_Mon.setBounds(325, 50,40,80);
        Cal_Tue.setBounds(325, 130,40,80);
        Cal_Wed.setBounds(325, 210,40,80);
        Cal_Thu.setBounds(325, 290,40,80);
        Cal_Fri.setBounds(325, 370,40,80);
        Cal_Sat.setBounds(325, 450,40,80);
        Cal_Sun.setBounds(325, 530,40,80);
    }
    //Adds all the elements to the JFrame
    public void addPlanComponentsToContainer() {
        frame.add(DietPlan);
        frame.add(backButton);
        frame.add(Mon);
        frame.add(Tue);
        frame.add(Wed);
        frame.add(Thu);
        frame.add(Fri);
        frame.add(Sat);
        frame.add(Sun);
        frame.add(Menu_Mon);
        frame.add(Menu_Tue);
        frame.add(Menu_Wed);
        frame.add(Menu_Thu);
        frame.add(Menu_Fri);
        frame.add(Menu_Sat);
        frame.add(Menu_Sun);
        frame.add(Cal_Mon);
        frame.add(Cal_Tue);
        frame.add(Cal_Wed);
        frame.add(Cal_Thu);
        frame.add(Cal_Fri);
        frame.add(Cal_Sat);
        frame.add(Cal_Sun);
    }
    //Adds an action listener to the buttons
    public void addActionEvent() {
        backButton.addActionListener(this);
    }

    // This is the action of clicking on the back button.
    // It will drive the user back to Home page
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if ( cmd.equals("Back") ) {
            dispose();
            //new Main().setVisible(true);
        }
    }
}
