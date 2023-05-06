package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {

    public CheckPackage() {
        setSize(1000, 720);
        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tab = new JTabbedPane();
        add(tab);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        JLabel p1image = new JLabel(getImage("icons/gold.png"));
        p1image.setBounds(0,0,980,650);
        p1.add(p1image);


        JPanel p2 = new JPanel();
        p2.setLayout(null);
        JLabel p2image = new JLabel(getImage("icons/silver.png"));
        p2image.setBounds(0,0,980,670);
        p2.add(p2image);

        JPanel p3 = new JPanel();
        p3.setLayout(null);
        JLabel p3image = new JLabel(getImage("icons/bronze.png"));
        p3image.setBounds(0,0,980,670);
        p3.add(p3image);

        tab.addTab("Package 1",null,p1);
        tab.addTab("Package 2",null,p2);
        tab.addTab("Package 3",null,p3);





        //endline of code
        setVisible(true);
    }

    ImageIcon getImage(String address) {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(address));
        Image i2 = i1.getImage().getScaledInstance(980, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        return i3;
    }

    public static void main(String[] args) {
        new CheckPackage();
    }

}
