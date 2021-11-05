package ht4.Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BrowsePage extends JFrame implements ActionListener {
    JFrame browseFrame = new JFrame();
    private JButton homeButton = new JButton("Home");
    private JButton browseButton = new JButton("Browse");
    private JButton profileButton = new JButton("Profile");
    private JButton journalButton = new JButton("Journal");
    private JButton dietButton = new JButton("Diet");
    private JButton statsButton = new JButton("Stats");
    private JButton socialButton = new JButton("Social");

    BrowsePage() {
        browseFrame.setTitle("SmartAss");
        browseFrame.setBounds(10, 10, 370, 600);
        browseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        browseFrame.setVisible(true);
        browseFrame.setResizable(false);

        setLayoutManager();
        setLocationAndSize();
        addHomeComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {

        browseFrame.setLayout(null);
    }

    public void setLocationAndSize() {
        homeButton.setBounds(5, 510, 150, 30);
        browseButton.setBounds(205, 510, 150, 30);
        profileButton.setBounds(100, 350, 150, 30);
        journalButton.setBounds(100, 310, 150, 30);
        dietButton.setBounds(100, 270, 150, 30);
        statsButton.setBounds(100, 230, 150, 30);
        socialButton.setBounds(100, 190, 150, 30);
    }
    public void addHomeComponentsToContainer() {
        browseFrame.add(homeButton);
        browseFrame.add(browseButton);
        browseFrame.add(profileButton);
        browseFrame.add(journalButton);
        browseFrame.add(dietButton);
        browseFrame.add(statsButton);
        browseFrame.add(socialButton);
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
        if (e.getSource() == dietButton) {
            browseFrame.dispose();
            DietPlan dietPlan = new DietPlan();
        }
        if (e.getSource() == homeButton) {
            browseFrame.dispose();
            FrameHome home = new FrameHome();
        }
        if (e.getSource() == journalButton) {
            browseFrame.dispose();
            JournalPage journal = new JournalPage();
        }
    }

    public static void main(String[] args) {
        BrowsePage frame = new BrowsePage();
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

