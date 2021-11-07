package ht4.Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StepPage extends JFrame implements ActionListener {
    JFrame stepFrame = new JFrame();
    private JButton saveButton = new JButton("Save");
    private JButton exitButton = new JButton("Exit");


    StepPage() {
        stepFrame.setTitle("SmartAss");
        stepFrame.setBounds(10, 10, 370, 600);
        stepFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stepFrame.setVisible(true);
        stepFrame.setResizable(false);

        setLayoutManager();
        setLocationAndSize();
        addActionEvent();
    }

    public void setLayoutManager() {
        stepFrame.setLayout(null);
    }

    public void setLocationAndSize() {
        exitButton.setBounds(0, 0, 80, 25);

    }

    public void addActionEvent() {
        saveButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {

        }
        if (e.getSource() == exitButton) {
            stepFrame.dispose();
            new BrowsePage();
        }
    }

    public static void main(String[] args) {
        new StepPage();
    }
}

