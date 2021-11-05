package ht4.Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommunityFrame extends JFrame implements ActionListener {
    JFrame communityFrame = new JFrame();
    JLabel communityLabel = new JLabel("Community");
    JButton createPostButton = new JButton("Create Post");
    JLabel searchLabel = new JLabel("Search");
    JTextField searchField = new JTextField();
    JLabel newsFeedLabel = new JLabel("News Feed");
    JTextArea newsFeedArea = new JTextArea("7 Healthy Alternatives to Vegetable Oil\n\n" + "3 Ab Workouts to Burn Fat at Home");
    JLabel notificationLabel = new JLabel("Notifications (4)");
    JTextArea notificationArea = new JTextArea("- Friend Requests (1)\n\n" + "- 3 People interacted with your post (3 hr. ago)");
    JButton backButton = new JButton("Back");

    CommunityFrame() {
        communityFrame.setTitle("Community");
        communityFrame.setVisible(true);
        communityFrame.setBounds(10, 10, 370, 600);
        communityFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        communityFrame.setResizable(false);
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        communityFrame.setLayout(null);
    }

    public void setLocationAndSize() {
        communityLabel.setBounds(10,10,100,50);
        createPostButton.setBounds(10,60,120,30);
        searchLabel.setBounds(150,60,50,30);
        searchField.setBounds(195,60,155,30);
        backButton.setBounds(280,25,70,20);
        newsFeedLabel.setBounds(10,100,100,50);
        newsFeedArea.setBounds(10,140,340,150);
        notificationLabel.setBounds(10,260,340,150);
        notificationArea.setBounds(10,350,340,150);
    }

    public void addComponentsToContainer() {
        communityFrame.add(communityLabel);
        communityFrame.add(backButton);
        communityFrame.add(createPostButton);
        communityFrame.add(searchLabel);
        communityFrame.add(searchField);
        communityFrame.add(newsFeedLabel);
        communityFrame.add(newsFeedArea);
        communityFrame.add(notificationLabel);
        communityFrame.add(notificationArea);
    }

    public void addActionEvent() {
        createPostButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            communityFrame.dispose();
            BrowsePage browse = new BrowsePage();
        }
    }
}

class Community {
    public static void main(String[] args) {
        CommunityFrame communityFrame = new CommunityFrame();

    }
}
