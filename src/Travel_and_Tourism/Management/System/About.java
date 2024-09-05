package Travel_and_Tourism.Management.System;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {

    private JLabel titleLabel;
    private Font titleFont = new Font("Arial", Font.BOLD, 35);


    public About() {
        setTitle("About");
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650, 700);
        setLocationRelativeTo(null);


        titleLabel = new JLabel("ABOUT");
        titleLabel.setBounds(240,40,150,40);
        titleLabel.setForeground(Color.red);
        titleLabel.setFont(titleFont);
        add(titleLabel);

        String s = "The Travel and Tourism Management System is a standalone application built using Java Swing that provides a comprehensive solution for managing hotel reservations and travel itineraries. The system offers a user-friendly interface for customers to browse hotels and destinations, make reservations, and plan travel itineraries. The application has been designed to cater to the needs of both customers and travel agents, making it a valuable tool for the travel industry.\n\n"+
                "The application allows users to add, edit, and delete hotel and destination records using the Java Standalone CRUD functionality. This feature enables users to manage customer data, hotel details, and other relevant information easily.\n\n"+
                "The Travel and Tourism Management System offers a range of functionalities to its users, such as browsing available hotels and destinations, booking hotels, making payments, and generating reports. The application also features a search function that enables users to quickly find the information they need.\n\n"+
                "In addition, the system provides a secure login system that ensures the privacy and security of user data. Users can create their accounts and log in to access their bookings and account information.\n\n"+
                "Overall, this project offers a robust solution for managing hotel reservations and travel itineraries. With its user-friendly interface, powerful functionality, and secure login system, the Travel and Tourism Management System is an essential tool for the travel industry.";

        TextArea area = new TextArea(s,10,40,TextArea.SCROLLBARS_VERTICAL_ONLY);
        area.setBounds(30,130,570,400);
        area.setFont(new Font("Raleways",Font.PLAIN,15));
        area.setBackground(Color.white);
        area.setEditable(false);
        add(area);

        this.setVisible(true);
    }

//    public static void main(String[] args) {
//        new About();
//    }
}

