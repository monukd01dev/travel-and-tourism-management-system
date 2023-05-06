package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import static java.lang.Thread.sleep;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel labelusername,labelname;
    JTextField tfnumber,tfcountry,tfaddress,tfphone,tfemail;
    JComboBox comboid;
    JRadioButton male,female;
    JButton btnadd,btnback;



    public AddCustomer( String username) {
        setSize(1000,750);
        getContentPane().setBackground(Color.white);
        setLayout(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //form
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60,50,200,40);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblusername);

        labelusername = new JLabel("");
        labelusername.setBounds(260,50,200,40);
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(labelusername);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(60,110,200,40);
        lblid.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblid);

        comboid = new JComboBox(new String[]{"Passport","Aadhar Card","Pan Card","Ration Card"});
        comboid.setBounds(260,110,200,30);//30 up
        comboid.setBackground(Color.white);
        comboid.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(comboid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(60,170,200,40);//20 up
        lblnumber.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(260,175,200,30);//30 up
        tfnumber.setBackground(Color.white);
        tfnumber.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,230,200,40);
        lblname.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(260,230,200,40);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(labelname);


        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,290,200,40);
        lblgender.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblgender);

        male = new JRadioButton("Male");
        male.setBounds(260,290,90,40);
        male.setBackground(Color.white);
        male.setFocusPainted(false);
        male.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(360,290,90,40);
        female.setBackground(Color.white);
        female.setFocusPainted(false);
        female.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(female);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);


        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(60,350,200,40);//20 up
        lblcountry.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(260,355,200,30);//30 up
        tfcountry.setBackground(Color.white);
        tfcountry.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,410,200,40);//20 up
        lbladdress.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(260,415,200,30);//30 up
        tfaddress.setBackground(Color.white);
        tfaddress.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(60,470,200,40);//20 up
        lblphone.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(260,475,200,30);//30 up
        tfphone.setBackground(Color.white);
        tfphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(tfphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(60,530,200,40);//20 up
        lblemail.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(260,535,200,30);//30 up
        tfemail.setBackground(Color.white);
        tfemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(tfemail);

        btnadd = new JButton("ADD");
        btnadd.setBounds(80,610,150,40);//30 up
        btnadd.setBackground(Color.black);
        btnadd.setForeground(Color.white);
        btnadd.setFocusPainted(false);
        btnadd.setFont(new Font("Tahoma",Font.PLAIN,17));
        btnadd.addActionListener(this);
        add(btnadd);

        btnback = new JButton("BACK");
        btnback.setBounds(270,610,150,40);//30 up
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setFont(new Font("Tahoma",Font.PLAIN,17));
        btnback.addActionListener(this);
        add(btnback);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/vectortravel.png"));
        Image i2= i1.getImage().getScaledInstance(500, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(480,50,500,550);
        add(image);

        //        endline
        setVisible(true);

        //DB code
        try {
            Conn c = new Conn();
            String query = "select * from account where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            } else {
                JOptionPane.showMessageDialog(this,"Can't find your details -_- lol");
                setVisible(false);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnadd) {

            String username = labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;
            if (male.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            String query = "insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Details Added Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (actionEvent.getSource() == btnback) {
            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new AddCustomer("");
    }
}
