package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DeleteAccount extends JFrame implements ActionListener {

    JButton btndelete,btnback;
    String username;
    public DeleteAccount(String username) {
            this.username = username;
            setSize(1000,720);
            getContentPane().setBackground(Color.white);
            setLayout(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            JLabel lblusername = new JLabel("Username");
            lblusername.setBounds(60,50,200,40);
            lblusername.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lblusername);

            JLabel labelusername = new JLabel();
            labelusername.setBounds(260,50,200,40);
            labelusername.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labelusername);

            JLabel lblid = new JLabel("ID");
            lblid.setBounds(60,110,200,40);
            lblid.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lblid);

            JLabel labelid = new JLabel();
            labelid.setBounds(260,110,200,40);
            labelid.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labelid);

            JLabel lblnumber = new JLabel("Number");
            lblnumber.setBounds(60,170,200,40);
            lblnumber.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lblnumber);

            JLabel labelnumber = new JLabel();
            labelnumber.setBounds(260,170,200,40);
            labelnumber.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labelnumber);

            JLabel lblname = new JLabel("Name");
            lblname.setBounds(60,230,200,40);
            lblname.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lblname);

            JLabel labelname = new JLabel();
            labelname.setBounds(260,230,200,40);
            labelname.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labelname);

            JLabel lblgender = new JLabel("Gender");
            lblgender.setBounds(60,290,200,40);
            lblgender.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lblgender);

            JLabel labelgender = new JLabel();
            labelgender.setBounds(260,290,200,40);
            labelgender.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labelgender);

//        2nd half

            JLabel lblcountry = new JLabel("Country");
            lblcountry.setBounds(560,50,200,40);
            lblcountry.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lblcountry);

            JLabel labelcountry = new JLabel();
            labelcountry.setBounds(760,50,200,40);
            labelcountry.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labelcountry);

            JLabel lbladdress = new JLabel("Address");
            lbladdress.setBounds(560,110,200,40);
            lbladdress.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lbladdress);

            JLabel labeladdress = new JLabel();
            labeladdress.setBounds(760,110,200,40);
            labeladdress.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labeladdress);

            JLabel lblphone = new JLabel("Phone");
            lblphone.setBounds(560,230,200,40);
            lblphone.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lblphone);

            JLabel labelphone = new JLabel();
            labelphone.setBounds(760,230,200,40);
            labelphone.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labelphone);

            JLabel lblemail = new JLabel("Email");
            lblemail.setBounds(560,290,200,40);
            lblemail.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lblemail);

            JLabel labelemail = new JLabel();
            labelemail.setBounds(760,290,200,40);
            labelemail.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labelemail);

            //Button
            btndelete = new JButton("DELETE");
            btndelete.setBounds(330,400,150,40);//30 up
            btndelete.setBackground(Color.black);
            btndelete.setForeground(Color.white);
            btndelete.setFocusPainted(false);
            btndelete.setFont(new Font("Tahoma",Font.PLAIN,17));
            btndelete.addActionListener(this);
            add(btndelete);

            btnback = new JButton("BACK");
            btnback.setBounds(505,400,150,40);//30 up
            btnback.setBackground(Color.black);
            btnback.setForeground(Color.white);
            btnback.setFocusPainted(false);
            btnback.setFont(new Font("Tahoma",Font.PLAIN,17));
            btnback.addActionListener(this);
            add(btnback);

            //image
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ViewDetails.png"));
            Image i2 = i1.getImage().getScaledInstance(1000, 280, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);

            JLabel image = new JLabel(i3);
            image.setBounds(0,402,1000,280);
            add(image);

            //endline
            setVisible(true);

//        db code
            try {
                String query = "select * from customer where username = '"+username+"'";

                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    labelusername.setText(rs.getString("username"));
                    labelid.setText(rs.getString("id"));
                    labelnumber.setText(rs.getString("number"));
                    labelname.setText(rs.getString("name"));
                    labelgender.setText(rs.getString("gender"));
                    labelcountry.setText(rs.getString("country"));
                    labeladdress.setText(rs.getString("address"));
                    labelphone.setText(rs.getString("phone"));
                    labelemail.setText(rs.getString("email"));
                } else {
                    JOptionPane.showMessageDialog(this,"Clicking On Delete Will Permanently Delete Your Account...");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }





        }

        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == btndelete) {
                try {
                    Conn c = new Conn();
                    c.s.executeUpdate("delete from account where username = '" + username + "'");
                    c.s.executeUpdate("delete from customer where username = '" + username + "'");
                    c.s.executeUpdate("delete from bookhotel where username = '" + username + "'");
                    c.s.executeUpdate("delete from bookpackage where username = '" + username + "'");

                    JOptionPane.showMessageDialog(this, "Account Deleted Successfully");

                    System.exit(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                setVisible(false);
            } else {
                dispose();
            }
        }

    public static void main(String[] args) {
        new DeleteAccount("monukd");
    }
}
