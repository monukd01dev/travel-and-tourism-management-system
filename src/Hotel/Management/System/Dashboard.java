package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;

public class Dashboard extends JFrame implements ActionListener {

    JButton addPersonalDetails,updatePersonalDetails,viewDetails,deletePersonalDetails,checkPackage,bookPackage,viewPackage,viewHotels,bookHotel,viewBookedHotel,destinations,payments,calculator,notepad,about;
    String username;

    public Dashboard(String username) {
        this.username= username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/airplane.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,10,70,70);


        //Panels
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,1920,100);
        p1.setBackground(new Color(0,0,103));
        p1.add(image);
        add(p1);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(110,15,300,60);
        heading.setFont(new Font("Tahoma",Font.BOLD,50));
        heading.setForeground(Color.white);
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(0,100,325,918);
        p2.setBackground(new Color(0,0,103));
        add(p2);

        JPanel p3 = new JPanel();
        p3.setLayout(null);
        p3.setBounds(325,100,1595,918);
        p3.setBackground(new Color(0,100,103));
        add(p3);


        // buttons

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, 0, 325, 61);
        addPersonalDetails.setForeground(Color.white);
        addPersonalDetails.setFont(new Font("Tahoma",Font.BOLD,20));
        addPersonalDetails.setBackground(new Color(0,0,103));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.setFocusPainted(false);
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 61, 325, 61);
        updatePersonalDetails.setForeground(Color.white);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.BOLD,20));
        updatePersonalDetails.setBackground(new Color(0,0,103));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
        updatePersonalDetails.setFocusPainted(false);
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewDetails = new JButton("View Details");
        viewDetails.setBounds(0, 122, 325, 61);
        viewDetails.setForeground(Color.white);
        viewDetails.setFont(new Font("Tahoma",Font.BOLD,20));
        viewDetails.setBackground(new Color(0,0,103));
        viewDetails.setMargin(new Insets(0,0,0,140));
        viewDetails.setFocusPainted(false);
        viewDetails.addActionListener(this);
        p2.add(viewDetails);

        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0, 183, 325, 61);
        deletePersonalDetails.setForeground(Color.white);
        deletePersonalDetails.setFont(new Font("Tahoma",Font.BOLD,20));
        deletePersonalDetails.setBackground(new Color(0,0,103));
        deletePersonalDetails.setMargin(new Insets(0,0,0,30));
        deletePersonalDetails.setFocusPainted(false);
        p2.add(deletePersonalDetails);

        checkPackage = new JButton("Check Package");
        checkPackage.setBounds(0, 244, 325, 61);
        checkPackage.setForeground(Color.white);
        checkPackage.setFont(new Font("Tahoma",Font.BOLD,20));
        checkPackage.setBackground(new Color(0,0,103));
        checkPackage.setMargin(new Insets(0,0,0,110));
        checkPackage.setFocusPainted(false);
        checkPackage.addActionListener(this);
        p2.add(checkPackage);

        bookPackage = new JButton("Book Package");
        bookPackage.setBounds(0, 305, 325, 61);
        bookPackage.setForeground(Color.white);
        bookPackage.setFont(new Font("Tahoma",Font.BOLD,20));
        bookPackage.setBackground(new Color(0,0,103));
        bookPackage.setMargin(new Insets(0,0,0,120));
        bookPackage.setFocusPainted(false);
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewPackage = new JButton("View Package");
        viewPackage.setBounds(0, 366, 325, 61);
        viewPackage.setForeground(Color.white);
        viewPackage.setFont(new Font("Tahoma",Font.BOLD,20));
        viewPackage.setBackground(new Color(0,0,103));
        viewPackage.setMargin(new Insets(0,0,0,120));
        viewPackage.setFocusPainted(false);
        p2.add(viewPackage);

        viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0, 427, 325, 61);
        viewHotels.setForeground(Color.white);
        viewHotels.setFont(new Font("Tahoma",Font.BOLD,20));
        viewHotels.setBackground(new Color(0,0,103));
        viewHotels.setMargin(new Insets(0,0,0,140));
        viewHotels.setFocusPainted(false);
        p2.add(viewHotels);

        bookHotel = new JButton("Book Hotel");
        bookHotel.setBounds(0, 488, 325, 61);
        bookHotel.setForeground(Color.white);
        bookHotel.setFont(new Font("Tahoma",Font.BOLD,20));
        bookHotel.setBackground(new Color(0,0,103));
        bookHotel.setMargin(new Insets(0,0,0,145));
        bookHotel.setFocusPainted(false);
        p2.add(bookHotel);

        viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setBounds(0, 549, 325, 61);
        viewBookedHotel.setForeground(Color.white);
        viewBookedHotel.setFont(new Font("Tahoma",Font.BOLD,20));
        viewBookedHotel.setBackground(new Color(0,0,103));
        viewBookedHotel.setMargin(new Insets(0,0,0,60));
        viewBookedHotel.setFocusPainted(false);
        p2.add(viewBookedHotel);

        destinations = new JButton("Destinations");
        destinations.setBounds(0, 610, 325, 61);
        destinations.setForeground(Color.white);
        destinations.setFont(new Font("Tahoma",Font.BOLD,20));
        destinations.setBackground(new Color(0,0,103));
        destinations.setMargin(new Insets(0,0,0,120));
        destinations.setFocusPainted(false);
        p2.add(destinations);

        payments = new JButton("Payments");
        payments.setBounds(0, 671, 325, 61);
        payments.setForeground(Color.white);
        payments.setFont(new Font("Tahoma",Font.BOLD,20));
        payments.setBackground(new Color(0,0,103));
        payments.setMargin(new Insets(0,0,0,140));
        payments.setFocusPainted(false);
        p2.add(payments);

        calculator = new JButton("Calculator");
        calculator.setBounds(0, 732, 325, 61);
        calculator.setForeground(Color.white);
        calculator.setFont(new Font("Tahoma",Font.BOLD,20));
        calculator.setBackground(new Color(0,0,103));
        calculator.setMargin(new Insets(0,0,0,140));
        calculator.setFocusPainted(false);
        p2.add(calculator);

        notepad = new JButton("Notepad");
        notepad.setBounds(0, 793, 325, 61);
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("Tahoma",Font.BOLD,20));
        notepad.setBackground(new Color(0,0,103));
        notepad.setMargin(new Insets(0,0,0,160));
        notepad.setFocusPainted(false);
        p2.add(notepad);

        about = new JButton("About");
        about.setBounds(0, 854, 325, 61);
        about.setForeground(Color.white);
        about.setFont(new Font("Tahoma",Font.BOLD,20));
        about.setBackground(new Color(0,0,103));
        about.setMargin(new Insets(0,0,0,180));
        about.setFocusPainted(false);
        p2.add(about);

        //home image
        JLabel homeTitle = new JLabel("Travel and Tourism Management System");
        homeTitle.setBounds(170, 0, 1400, 150);
        homeTitle.setFont(new Font("Raleway",Font.BOLD,65));
        homeTitle.setForeground(Color.white);
        p3.add(homeTitle);

        ImageIcon take1 = new ImageIcon(ClassLoader.getSystemResource("icons/homeroad.jpg"));
        Image take2 = take1.getImage().getScaledInstance(1595, 917, Image.SCALE_DEFAULT);
        ImageIcon take3 = new ImageIcon(take2);
        JLabel home = new JLabel(take3);
        home.setBounds(0,0,1595,917);
        p3.add(home);



        //endline of code
        setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == addPersonalDetails) {
            new AddCustomer(Dashboard.this.username);
        } else if (actionEvent.getSource() == viewDetails) {
            new ViewCustomer(this.username);
        } else if (actionEvent.getSource() == updatePersonalDetails) {
            new UpdateCustomer(this.username);
        } else if (actionEvent.getSource() == checkPackage) {
            new CheckPackage();
        } else if (actionEvent.getSource() == bookPackage) {
            new BookPackage(this.username);
        }
    }

    public static void main(String[] args) {

    }
}
