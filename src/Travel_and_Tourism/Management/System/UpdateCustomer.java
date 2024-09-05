package Travel_and_Tourism.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;



public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel labelusername,labelname;
    JTextField tfname,tfnumber,tfgender,tfcountry,tfaddress,tfphone,tfemail,tfid;

    JButton btnupdate,btnback;



    public UpdateCustomer( String username) {
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

        tfid = new JTextField();
        tfid.setBounds(260,115,200,30);//30 up
        tfid.setBackground(Color.white);
        tfid.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(tfid);

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

        tfname = new JTextField();
        tfname.setBounds(260,235,200,30);
        tfname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(tfname);


        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60,290,200,40);
        lblgender.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblgender);

        tfgender = new JTextField();
        tfgender.setBounds(260,295,200,30);//30 up
        tfgender.setBackground(Color.white);
        tfgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(tfgender);


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

        btnupdate = new JButton("UPDATE");
        btnupdate.setBounds(80,610,150,40);//30 up
        btnupdate.setBackground(Color.black);
        btnupdate.setForeground(Color.white);
        btnupdate.setFocusPainted(false);
        btnupdate.setFont(new Font("Tahoma",Font.PLAIN,17));
        btnupdate.addActionListener(this);
        add(btnupdate);

        btnback = new JButton("BACK");
        btnback.setBounds(270,610,150,40);//30 up
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setFont(new Font("Tahoma",Font.PLAIN,17));
        btnback.addActionListener(this);
        add(btnback);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/updatepanel.png"));
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
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                labelusername.setText(rs.getString("username"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfname.setText(rs.getString("name"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));

            }
            else {
                JOptionPane.showMessageDialog(this,"Please add your details...");
                dispose();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnupdate) {

            String username = labelusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            String query = "update customer set id ='"+id+"',number ='"+number+"',name = '"+name+"',gender ='"+gender+"',country = '"+country+"',address = '"+address+"',phone = '"+phone+"',email = '"+email+"'";

            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(this, "Details Updated Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (actionEvent.getSource() == btnback) {
            setVisible(false);
        }
    }


//    public static void main(String[] args) {
//        new UpdateCustomer("");
//    }
}