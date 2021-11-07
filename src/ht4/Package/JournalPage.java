package ht4.Package;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JournalPage extends JFrame implements ActionListener {
    JFrame journalFrame = new JFrame();
    JLabel titlePage = new JLabel("Daily Journal");
    JLabel titleMot = new JLabel("Motivation:");
    JLabel titleDate = new JLabel("Date:");
    JLabel titleProg = new JLabel("Notes:");

    JTextArea motText = new JTextArea();
    JTextArea dateText = new JTextArea();
    JTextArea progText = new JTextArea();

    private JButton saveButton = new JButton("Save");
    private JButton exitButton = new JButton("Exit");

    JournalPage() {
        journalFrame.setTitle("SmartAss");
        journalFrame.setBounds(10, 10, 370, 600);
        journalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        journalFrame.setVisible(true);
        journalFrame.setResizable(false);

        setLayoutManager();
        setLocationAndSize();
        addHomeComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {

        journalFrame.setLayout(null);
    }

    public void setLocationAndSize() {
        titlePage.setBounds(145,25,85, 35);
        titleMot.setBounds(35, 45, 75, 25);
        titleDate.setBounds(35, 145, 50, 25);
        titleProg.setBounds(35, 245, 50, 25);

        saveButton.setBounds(145, 530, 85, 25);
        exitButton.setBounds(0, 0, 80, 25);

        motText.setBounds(35, 65, 300,80);
        dateText.setBounds(35, 165, 300,60);
        progText.setBounds(35, 265, 300,260);

    }
    public void addHomeComponentsToContainer() {
        journalFrame.add(titlePage);
        journalFrame.add(titleMot);
        journalFrame.add(titleDate);
        journalFrame.add(titleProg);

        journalFrame.add(saveButton);
        journalFrame.add(exitButton);

        journalFrame.add(motText);
        journalFrame.add(dateText);
        journalFrame.add(progText);

    }

    public void addActionEvent() {
        saveButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            JOptionPane.showMessageDialog(this, "Saved");
        }
        if (e.getSource() == exitButton) {
            journalFrame.dispose();
            new BrowsePage();
        }
    }

    public static void main(String[] args) {
        JournalPage frame = new JournalPage();
    }
}
