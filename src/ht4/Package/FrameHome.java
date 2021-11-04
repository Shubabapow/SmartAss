package ht4.Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameHome extends JFrame implements ActionListener {

    JFrame frameHome = new JFrame();
    //Container containerHome = getContentPane();
    private JButton homeButton = new JButton("Home");
    private JButton browseButton = new JButton("Browse");

    FrameHome() {

        frameHome.setTitle("SmartAss");
        frameHome.setVisible(true);
        frameHome.setBounds(10, 10, 370, 600);
        frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameHome.setResizable(false);

        setLayoutManager();
        setLocationAndSize();
        addHomeComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        frameHome.setLayout(null);
    }

    public void setLocationAndSize() {
        homeButton.setBounds(5, 510, 150, 30);
        browseButton.setBounds(205, 510, 150, 30);
    }
    public void addHomeComponentsToContainer() {
        frameHome.add(homeButton);
        frameHome.add(browseButton);
    }

    public void addActionEvent() {
        homeButton.addActionListener(this);
        browseButton.addActionListener(this);
    }

    public void changePanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().doLayout();
        update(getGraphics());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == browseButton) {
            frameHome.dispose();
            BrowsePage browseFrame = new BrowsePage();
        }

    }
}

