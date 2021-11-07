package ht4.Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ProgressPic extends JFrame implements ActionListener{

    JFrame progressPic = new JFrame();
    ImageIcon img = new ImageIcon(("./Resources/healtech1-removebg-preview.png"));
    JLabel jlPic = new JLabel(img);
    int indexy=0;
    private JButton homeButton = new JButton("Home");
    private JButton browseButton = new JButton("Browse");
    private JButton nextButton = new JButton("Next");
    private JButton previousButton = new JButton("Previous");

    ProgressPic() {
        progressPic.setTitle("SmartAss");
        progressPic.setVisible(true);
        progressPic.setBounds(10, 10, 370, 600);
        progressPic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        progressPic.setResizable(false);

        setLayoutManager();
        setLocationAndSize();
        addHomeComponentsToContainer();
        addActionEvent();
        showImage();
    }

    public String[] getImages()
    {
        File directoryPath=new File("./Resources/ProgressPictures");
        String[] imagesList=directoryPath.list();
        return imagesList;
    }
    public void showImage()
    {
        String [] imageList=getImages();
        if(indexy>imageList.length-1)
        {
            indexy=0;
        }
        else if(indexy<0)
        {
            indexy=imageList.length-1;
        }
        String imageName=imageList[indexy];
        ImageIcon icon=new ImageIcon("./Resources/ProgressPictures/"+imageName);
        Image image = icon.getImage().getScaledInstance(jlPic.getWidth(),jlPic.getHeight(),Image.SCALE_SMOOTH);
        jlPic.setIcon(new ImageIcon(image));
    }

    public void setLayoutManager() {
        progressPic.setLayout(null);
    }

    public void setLocationAndSize() {
        homeButton.setBounds(5, 510, 150, 30);
        browseButton.setBounds(205, 510, 150, 30);
        previousButton.setBounds(5, 400, 100, 50);
        nextButton.setBounds(250, 400, 100, 50);
        jlPic.setBounds(20, 50, 325, 300);
    }

    public void addHomeComponentsToContainer() {
        progressPic.add(homeButton);
        progressPic.add(browseButton);
        progressPic.add(previousButton);
        progressPic.add(nextButton);
        progressPic.add(jlPic);
    }
    public void addActionEvent() {
        homeButton.addActionListener(this);
        browseButton.addActionListener(this);
        nextButton.addActionListener(this);
        previousButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == browseButton) {
            progressPic.dispose();
            new BrowsePage();
        }
        if (e.getSource() == homeButton) {
            progressPic.dispose();
            new FrameHome();
        }
        if(e.getSource()==nextButton)
        {
            indexy++;
            showImage();
        }
        if(e.getSource()==previousButton)
        {
            indexy--;
            showImage();
        }
    }
}
