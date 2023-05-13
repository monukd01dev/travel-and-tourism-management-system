package Hotel.Management.System;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewPackage extends JFrame implements ActionListener {

    JButton btnback;
    JLabel labeltotalprice,labelusername,labelid,labelnumber,labelphone,labeltotalpersons, labelpackage;

    public ViewPackage(String username) {

        setSize(1000, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);

//        image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ViewPackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 0, 550, 550);
        add(image);


//      labels
        JLabel lbltitle = new JLabel("VIEW PACKAGE DETAILS");
        lbltitle.setBounds(100, 10, 400, 40);
        lbltitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
        add(lbltitle);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 85, 200, 40);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(270, 85, 200, 40);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelusername);

        JLabel lblselectPackage = new JLabel("Select Package");
        lblselectPackage.setBounds(40, 125, 200, 40);
        lblselectPackage.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(lblselectPackage);

        labelpackage = new JLabel();
        labelpackage.setBounds(270, 125, 200, 40);//30 up
        labelpackage.setBackground(Color.white);
        labelpackage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelpackage);

        JLabel lbltotalpersons = new JLabel("Total Persons");
        lbltotalpersons.setBounds(40, 165, 200, 40);
        lbltotalpersons.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(lbltotalpersons);

        labeltotalpersons = new JLabel();
        labeltotalpersons.setBounds(270, 165, 200, 40);
        labeltotalpersons.setBackground(Color.white);
        labeltotalpersons.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labeltotalpersons);

        JLabel lblid = new JLabel("ID:");
        lblid.setBounds(40, 205, 200, 40);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(270, 205, 200, 40);
        labelid.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40, 245, 200, 40);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(270, 245, 200, 40);
        labelnumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40, 285, 200, 40);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(270, 285, 200, 40);
        labelphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labelphone);

        JLabel lbltotalprice = new JLabel("Total Price");
        lbltotalprice.setBounds(40, 325, 200, 40);
        lbltotalprice.setFont(new Font("Tahoma", Font.BOLD, 17));
        add(lbltotalprice);

        labeltotalprice = new JLabel();
        labeltotalprice.setBounds(270, 325, 200, 40);
        labeltotalprice.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(labeltotalprice);

//        Buttons
        btnback = new JButton("Back");
        btnback.setBounds(150, 410, 130, 35);//30 up
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnback.addActionListener(this);
        add(btnback);

        setVisible(true);
        // db code
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bookpackage where username = '"+username+"'");
            if (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelpackage.setText(rs.getString("package"));
                labeltotalpersons.setText(rs.getString("person"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labeltotalprice.setText(rs.getString("price"));

            } else {
                JOptionPane.showMessageDialog(this, "You Haven't Booked Yet...");
                dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void actionPerformed(ActionEvent actionEvent) {
        setVisible(false);
    }

//    public static void main(String[] args) {
//        new ViewPackage("");
//    }

}
