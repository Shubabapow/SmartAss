package ht4.Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameHome extends JFrame implements ActionListener {

    Container containerHome = getContentPane();
    private JButton homeButton = new JButton("Home");
    private JButton browseButton = new JButton("Browse");

    FrameHome() {
        setLayoutManager();
        setLocationAndSize();
        addHomeComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        containerHome.setLayout(null);
    }

    public void setLocationAndSize() {
        homeButton.setBounds(5, 510, 150, 30);
        browseButton.setBounds(205, 510, 150, 30);
    }
    public void addHomeComponentsToContainer() {
        containerHome.add(homeButton);
        containerHome.add(browseButton);
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

    }
}

