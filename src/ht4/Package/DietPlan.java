/*  */
package ht4.Package;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DietPlan extends JFrame implements ActionListener {
    //instantiating all of our elements
    JFrame dietFrame = new JFrame();
    //JPanel DietPlan = new JPanel(Boolean.parseBoolean("DIETPLAN: "));
    JButton backButton = new JButton("Back");

    JComboBox<String> monList;
    JComboBox<String> tueList;
    JComboBox<String> wedList;
    JComboBox<String> thuList;
    JComboBox<String> friList;
    JComboBox<String> satList;
    JComboBox<String> sunList;

    //private JList<String> itemList;
    JScrollPane monMenu;
    JScrollPane tueMenu;
    JScrollPane wedMenu;
    JScrollPane thuMenu;
    JScrollPane friMenu;
    JScrollPane satMenu;
    JScrollPane sunMenu;

    //array to hold labels for each day
    JLabel[] days = {new JLabel("Monday"), new JLabel("Tuesday"), new JLabel("Wednesday"), new JLabel("Thursday"), new JLabel("Friday"), new JLabel("Saturday"), new JLabel("Sunday")};
//    JLabel Mon = new JLabel("Monday");
//    JLabel Tue = new JLabel("Tuesday");
//    JLabel Wed = new JLabel("Wednesday");
//    JLabel Thu = new JLabel("Thursday");
//    JLabel Fri = new JLabel("Friday");
//    JLabel Sat = new JLabel("Saturday");
//    JLabel Sun = new JLabel("Sunday");
    JLabel calorieGoalLabel = new JLabel("Calorie Goal: " + DietTrackerSettingsFrame.calorieGoal);

    JTextArea monCal = new JTextArea("Calories: ");
    JTextArea tueCal = new JTextArea("Calories: ");
    JTextArea wedCal = new JTextArea("Calories: ");
    JTextArea thuCal = new JTextArea("Calories: ");
    JTextArea friCal = new JTextArea("Calories: ");
    JTextArea satCal = new JTextArea("Calories: ");
    JTextArea sunCal = new JTextArea("Calories: ");


    //Creating the constructor and setting the size of the JFrame along with calling our helper methods
    DietPlan() {
        //dark theme from settings check
        if (SettingsFrame.darkThemeClicked) {
            dietFrame.getContentPane().setBackground(Color.DARK_GRAY);
            for (JLabel day : days) {
                day.setForeground(Color.WHITE);
            }
            calorieGoalLabel.setForeground(Color.WHITE);
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

    //Setting visible row counts in JList
//    public void setVisibleRows() {
//        monList.setVisibleRowCount(7);
//        tueList.setVisibleRowCount(7);
//        wedList.setVisibleRowCount(7);
//        thuList.setVisibleRowCount(7);
//        friList.setVisibleRowCount(7);
//        satList.setVisibleRowCount(7);
//        sunList.setVisibleRowCount(7);
//
//        JScrollPane monScroll = new JScrollPane(monList);
//        JScrollPane tueScroll = new JScrollPane(tueList);
//        JScrollPane wedScroll = new JScrollPane(wedList);
//        JScrollPane thuScroll = new JScrollPane(thuList);
//        JScrollPane friScroll = new JScrollPane(friList);
//        JScrollPane satScroll = new JScrollPane(satList);
//        JScrollPane sunScroll = new JScrollPane(sunList);
//    }

    //Declares the size for the elements
    public void setLocationAndSize() {
        //DietPlan.setBounds(10, 10, 100, 30);
        backButton.setBounds(265, 0, 80, 22);
        for (int i=0; i<7; i++) {
            days[i].setBounds(10,80*i,250,25);
        }
//        Mon.setBounds(10, 0,60,25);
//        Tue.setBounds(10, 80,60,25);
//        Wed.setBounds(10, 160,80,25);
//        Thu.setBounds(10, 240,60,25);
//        Fri.setBounds(10, 320,60,25);
//        Sat.setBounds(10, 400,60,25);
//        Sun.setBounds(10, 480,60,25);

//        monText.setBounds(10, 25, 250, 50);
//        tueText.setBounds(10, 105, 250, 50);
//        wedText.setBounds(10, 185, 250, 50);
//        thuText.setBounds(10, 265, 250, 50);
//        friText.setBounds(10, 345, 250, 50);
//        satText.setBounds(10, 425, 250, 50);
//        sunText.setBounds(10, 505, 250, 50);
        try {
            monList = new JComboBox<>(fileToArray());
            tueList = new JComboBox<>(fileToArray());
            wedList = new JComboBox<>(fileToArray());
            thuList = new JComboBox<>(fileToArray());
            friList = new JComboBox<>(fileToArray());
            satList = new JComboBox<>(fileToArray());
            sunList = new JComboBox<>(fileToArray());
            //itemList = new JList<>(fileToArray());
            //itemList.setPreferredSize(new Dimension(10,20));

            //itemList.setVisibleRowCount(3);
            monMenu = new JScrollPane(monList);
            tueMenu = new JScrollPane(tueList);
            wedMenu = new JScrollPane(wedList);
            thuMenu = new JScrollPane(thuList);
            friMenu = new JScrollPane(friList);
            satMenu = new JScrollPane(satList);
            sunMenu = new JScrollPane(sunList);
            //itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            //itemList.addListSelectionListener((ListSelectionListener) monCal);

        } catch (IOException e) {
            //itemList = new JList<>();
            monList = new JComboBox<>();
            tueList = new JComboBox<>();
            wedList = new JComboBox<>();
            thuList = new JComboBox<>();
            friList = new JComboBox<>();
            satList = new JComboBox<>();
            sunList = new JComboBox<>();
        }

        //itemList.setBounds(10, 25, 250, 50);
        monMenu.setBounds(10, 25, 250, 50);
        tueMenu.setBounds(10, 105, 250, 50);
        wedMenu.setBounds(10, 185, 250, 50);
        thuMenu.setBounds(10, 265, 250, 50);
        friMenu.setBounds(10, 345, 250, 50);
        satMenu.setBounds(10, 425, 250, 50);
        sunMenu.setBounds(10, 505, 250, 50);

        monCal.setBounds(265, 25, 250, 50);
        tueCal.setBounds(265, 105, 250, 50);
        wedCal.setBounds(265, 185, 250, 50);
        thuCal.setBounds(265, 265, 250, 50);
        friCal.setBounds(265, 345, 250, 50);
        satCal.setBounds(265, 425, 250, 50);
        sunCal.setBounds(265, 505, 250, 50);

    }
    //Adds all the elements to the JFrame
    public void addPlanComponentsToContainer() {
        //dietFrame.add(DietPlan);
        dietFrame.add(backButton);
        for (JLabel day: days) {
            dietFrame.add(day);
        }
//        dietFrame.add(Mon);
//        dietFrame.add(Tue);
//        dietFrame.add(Wed);
//        dietFrame.add(Thu);
//        dietFrame.add(Fri);
//        dietFrame.add(Sat);
//        dietFrame.add(Sun);

        //adds calorie goal display if enabled in settings, right justifies text along ComboBox)
        if (DietTrackerSettingsFrame.displayCalorieTotalButton.isSelected()) {
            for (JLabel day: days) {
                if (day.getText().contains("Wednesday")) {
                    day.setText(day.getText() + "                        Calorie Goal: " + DietTrackerSettingsFrame.calorieGoal);
                    continue;
                }
                day.setText(day.getText() + "                            Calorie Goal: " + DietTrackerSettingsFrame.calorieGoal);
            }
        }

        dietFrame.add(monMenu);
        dietFrame.add(tueMenu);
        dietFrame.add(wedMenu);
        dietFrame.add(thuMenu);
        dietFrame.add(friMenu);
        dietFrame.add(satMenu);
        dietFrame.add(sunMenu);

        dietFrame.add(monCal);
        dietFrame.add(tueCal);
        dietFrame.add(wedCal);
        dietFrame.add(thuCal);
        dietFrame.add(friCal);
        dietFrame.add(satCal);
        dietFrame.add(sunCal);


    }
    //Adds an action listener to the buttons
    public void addActionEvent() {
        backButton.addActionListener(this);
        monList.addActionListener(this);
        tueList.addActionListener(this);
        wedList.addActionListener(this);
        thuList.addActionListener(this);
        friList.addActionListener(this);
        satList.addActionListener(this);
        sunList.addActionListener(this);
        //int totalCalo = getTotalCalories();
        //monCal.append(String.valueOf(totalCalo));

    }

//    private int getTotalCalories() {
//        monList.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String str = (String) itemList.getSelectedItem();
//                String[] string = str.split(",");
//                calories = Integer.parseInt(string[1].trim());
//                caloSum += calories;
//            }
//        });
//        return caloSum;
//    }

    // This is the action of clicking on the back button.
    // It will drive the user back to Home page
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dietFrame.dispose();
            new BrowsePage();
        }

        if (e.getSource() == monList) {
            int calories = 0;
            int caloSum = 0;
            String str = (String) monList.getSelectedItem();
            String[] string = str.split(",");
            calories = Integer.parseInt(string[1].trim());
            caloSum += calories;
            monCal.append(String.valueOf(caloSum) + "\n");
        }
        if (e.getSource() == tueList) {
            int calories = 0;
            int caloSum = 0;
            String str = (String) tueList.getSelectedItem();
            String[] string = str.split(",");
            calories = Integer.parseInt(string[1].trim());
            caloSum += calories;
            tueCal.append(String.valueOf(caloSum) + "\n");
        }

        if (e.getSource() == wedList) {
            int calories = 0;
            int caloSum = 0;
            String str = (String) wedList.getSelectedItem();
            String[] string = str.split(",");
            calories = Integer.parseInt(string[1].trim());
            caloSum += calories;
            wedCal.append(String.valueOf(caloSum) + "\n");
        }

        if (e.getSource() == thuList) {
            int calories = 0;
            int caloSum = 0;
            String str = (String) thuList.getSelectedItem();
            String[] string = str.split(",");
            calories = Integer.parseInt(string[1].trim());
            caloSum += calories;
            thuCal.append(String.valueOf(caloSum) + "\n");
        }

        if (e.getSource() == friList) {
            int calories = 0;
            int caloSum = 0;
            String str = (String) friList.getSelectedItem();
            String[] string = str.split(",");
            calories = Integer.parseInt(string[1].trim());
            caloSum += calories;
            friCal.append(String.valueOf(caloSum) + "\n");
        }

        if (e.getSource() == satList) {
            int calories = 0;
            int caloSum = 0;
            String str = (String) satList.getSelectedItem();
            String[] string = str.split(",");
            calories = Integer.parseInt(string[1].trim());
            caloSum += calories;
            satCal.append(String.valueOf(caloSum) + "\n");
        }

        if (e.getSource() == sunList) {
            int calories = 0;
            int caloSum = 0;
            String str = (String) sunList.getSelectedItem();
            String[] string = str.split(",");
            calories = Integer.parseInt(string[1].trim());
            caloSum += calories;
            sunCal.append(String.valueOf(caloSum) + "\n");
        }

    }

    private String[] fileToArray() throws IOException {
        Path filePath = new File("FoodList.txt").toPath();
        Charset charset = Charset.defaultCharset();
        List<String> stringList = Files.readAllLines(filePath, charset);
        return stringList.toArray(new String[] {});
    }


    //Test single frame
    public static void main(String[] args) {
        DietPlan frame = new DietPlan();
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

