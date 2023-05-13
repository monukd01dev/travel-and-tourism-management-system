package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {

    JButton btncheckprice,btnbookpackage,btnback;
    JComboBox combopackage;
    JTextField tftotalpersons;
    JLabel labeltotalprice,labelusername,labelid,labelnumber,labelphone;
    String username;

    public BookPackage(String username) {
        this.username = username;
        setSize(1200, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);

//        image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookingvector.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(560,50,600,400);
        add(image);


//      labels
        JLabel lbltitle = new JLabel("BOOK PACKAGE");
        lbltitle.setBounds(100,10,200,40);
        lbltitle.setFont(new Font("Tahoma",Font.PLAIN,25));
        add(lbltitle);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,85,200,40);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(270,85,200,40);
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(labelusername);

        JLabel lblselectPackage = new JLabel("Select Package");
        lblselectPackage.setBounds(40,125,200,40);
        lblselectPackage.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblselectPackage);

        combopackage = new JComboBox(new String[]{"Gold Package","Silver Package","Bronze Package"});
        combopackage.setBounds(270,140,250,20);//30 up
        combopackage.setBackground(Color.white);
        combopackage.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(combopackage);

        JLabel lbltotalpersons = new JLabel("<html><font size='5' color=black>Total Persons</font> <font size='4' color=red>*</font></html>");
        lbltotalpersons.setBounds(40,165,200,40);
        lbltotalpersons.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lbltotalpersons);

        tftotalpersons = new JTextField();
        tftotalpersons.setBounds(270,177,250,23);//30 up
        tftotalpersons.setBackground(Color.white);
        tftotalpersons.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(tftotalpersons);

        JLabel lblid = new JLabel("ID:");
        lblid.setBounds(40,205,200,40);
        lblid.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(270,205,200,40);
        labelid.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40,245,200,40);
        lblnumber.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(270,245,200,40);
        labelnumber.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40,285,200,40);
        lblphone.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(270,285,200,40);
        labelphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(labelphone);

        JLabel lbltotalprice = new JLabel("Total Price");
        lbltotalprice.setBounds(40,325,200,40);
        lbltotalprice.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lbltotalprice);

        labeltotalprice = new JLabel();
        labeltotalprice.setBounds(270,325,200,40);
        labeltotalprice.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(labeltotalprice);

//        Buttons
        btncheckprice = new JButton("Check Price");
        btncheckprice.setBounds(60,410,130,35);//30 up
        btncheckprice.setBackground(Color.black);
        btncheckprice.setForeground(Color.white);
        btncheckprice.setFocusPainted(false);
        btncheckprice.setFont(new Font("Tahoma",Font.PLAIN,15));
        btncheckprice.addActionListener(this);
        add(btncheckprice);

        btnbookpackage = new JButton("Book Package");
        btnbookpackage.setBounds(210,410,130,35);//30 up
        btnbookpackage.setBackground(Color.black);
        btnbookpackage.setForeground(Color.white);
        btnbookpackage.setFocusPainted(false);
        btnbookpackage.setFont(new Font("Tahoma",Font.PLAIN,15));
        btnbookpackage.addActionListener(this);
        add(btnbookpackage);

        btnback = new JButton("BACK");
        btnback.setBounds(360,410,130,35);//30 up
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.white);
        btnback.setFocusPainted(false);
        btnback.setFont(new Font("Tahoma",Font.PLAIN,15));
        btnback.addActionListener(this);
        add(btnback);

//        endline
        setVisible(true);


//      DB code
        try {
            String query = "select * from customer where username = '"+username+"'";
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);

        if (rs.next()) {

            labelusername.setText(rs.getString("username"));
            labelid.setText(rs.getString("id"));
            labelnumber.setText(rs.getString("number"));
            labelphone.setText(rs.getString("phone"));
        } else {
            JOptionPane.showMessageDialog(this,"Please Add Your Details...");
            dispose();

        }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource() == btncheckprice) {

            if (tftotalpersons.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Fill Mandatory Fields");
            } else {
            String Package = (String) combopackage.getSelectedItem();
            int cost = 0;
            int persons = Integer.parseInt(tftotalpersons.getText());

            if (Package.equals("Gold Package")) {
                cost += 12000;
            } else if (Package.equals("Silver Package")) {
                cost += 24000;
            } else {
                cost += 36000;
            }
            cost *= persons;
            labeltotalprice.setText("" + cost);
          }
          }else if (actionEvent.getSource() == btnbookpackage) {

            if (tftotalpersons.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Fill Mandatory Fields");
            } else {
                btncheckprice.doClick();
            try {
                Conn c = new Conn();
                String query = "insert into bookpackage values('"+labelusername.getText()+"','"+((String) combopackage.getSelectedItem())+"','"+tftotalpersons.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labeltotalprice.getText()+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(this,"Package Booked Successfully...");
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, "You Have Already Booked A Package...");

                setVisible(false);
                new ViewPackage(username);
                e.printStackTrace();
            }
            }
        } else {
            setVisible(false);
        }
    }

//    public static void main(String[] args) {
//        new BookPackage("monukd");
//    }
}
