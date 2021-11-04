package ht4.Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrowsePage extends JFrame implements ActionListener {

    Container containerBrowse = getContentPane();
    private JButton homeButton = new JButton("Home");
    private JButton browseButton = new JButton("Browse");
    private JButton profileButton = new JButton("Profile");
    private JButton journalButton = new JButton("Journal");
    private JButton dietButton = new JButton("Diet");
    private JButton statsButton = new JButton("Stats");
    private JButton socialButton = new JButton("Social");

    BrowsePage() {
        setLayoutManager();
        setLocationAndSize();
        addHomeComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        containerBrowse.setLayout(null);
    }

    public void setLocationAndSize() {
        homeButton.setBounds(5, 510, 150, 30);
        browseButton.setBounds(205, 510, 150, 30);
        profileButton.setBounds(205, 350, 150, 30);
        journalButton.setBounds(205, 310, 150, 30);
        dietButton.setBounds(205, 270, 150, 30);
        statsButton.setBounds(205, 230, 150, 30);
        socialButton.setBounds(205, 190, 150, 30);
    }
    public void addHomeComponentsToContainer() {
        containerBrowse.add(homeButton);
        containerBrowse.add(browseButton);
        containerBrowse.add(profileButton);
        containerBrowse.add(journalButton);
        containerBrowse.add(dietButton);
        containerBrowse.add(statsButton);
        containerBrowse.add(socialButton);
    }

    public void addActionEvent() {
        homeButton.addActionListener(this);
        browseButton.addActionListener(this);
        profileButton.addActionListener(this);
        journalButton.addActionListener(this);
        dietButton.addActionListener(this);
        statsButton.addActionListener(this);
        socialButton.addActionListener(this);
    }

    public void changePanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().doLayout();
        update(getGraphics());
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        BrowsePage frame = new BrowsePage();
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

