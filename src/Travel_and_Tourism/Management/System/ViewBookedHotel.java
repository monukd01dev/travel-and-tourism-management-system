package Travel_and_Tourism.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewBookedHotel extends JFrame implements ActionListener {


        JButton btnback;

        JLabel labeltotalprice,labelusername,labelid,labelnumber,labelphone,labelhotel,labelac,labelfood,labeltotalpersons,labelday;

        public ViewBookedHotel(String username) {

            setSize(1000, 625);
            setLayout(null);
            getContentPane().setBackground(Color.white);
            setLocationRelativeTo(null);

//        image
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewbookedhotel.png"));
            Image i2 = i1.getImage().getScaledInstance(580, 580, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(400,0,580,580);
            add(image);


//      labels
            JLabel lbltitle = new JLabel("BOOKED HOTEL");
            lbltitle.setBounds(100,10,200,40);
            lbltitle.setFont(new Font("Tahoma",Font.BOLD,25));
            add(lbltitle);

            JLabel lblusername = new JLabel("Username");
            lblusername.setBounds(40,75,200,40);
            lblusername.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lblusername);

            labelusername = new JLabel();
            labelusername.setBounds(270,75,200,40);
            labelusername.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labelusername);

            JLabel lblhotel = new JLabel("Hotel");
            lblhotel.setBounds(40,115,200,40);
            lblhotel.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lblhotel);

            labelhotel = new JLabel();
            labelhotel.setBounds(270,115,200,40);//30 up
            labelhotel.setBackground(Color.white);
            labelhotel.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labelhotel);

            JLabel lbltotalpersons = new JLabel("Total Persons");
            lbltotalpersons.setBounds(40,165,200,40);
            lbltotalpersons.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lbltotalpersons);

            labeltotalpersons = new JLabel();
            labeltotalpersons.setBounds(270,165,200,40);//30 up
            labeltotalpersons.setBackground(Color.white);
            labeltotalpersons.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labeltotalpersons);
//        new
            JLabel lblday = new JLabel("Day");
            lblday.setBounds(40,205,200,40);
            lblday.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lblday);

            labelday = new JLabel();
            labelday.setBounds(270,205,200,40);
            labelday.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labelday);

            JLabel lblac = new JLabel("AC");
            lblac.setBounds(40,245,200,40);
            lblac.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lblac);

            labelac = new JLabel();
            labelac.setBounds(270,245,200,40);//30 up
            labelac.setBackground(Color.white);
            labelac.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labelac);

            JLabel lblfood = new JLabel("Food Include");
            lblfood.setBounds(40,285,200,40);
            lblfood.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lblfood);

            labelfood = new JLabel();
            labelfood.setBounds(270,285,200,40);//30 up
            labelfood.setBackground(Color.white);
            labelfood.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labelfood);

//        old
            JLabel lblid = new JLabel("ID:");
            lblid.setBounds(40,325,200,40);
            lblid.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lblid);

            labelid = new JLabel();
            labelid.setBounds(270,325,200,40);
            labelid.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labelid);

            JLabel lblnumber = new JLabel("Number");
            lblnumber.setBounds(40,365,200,40);
            lblnumber.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lblnumber);

            labelnumber = new JLabel();
            labelnumber.setBounds(270,365,200,40);
            labelnumber.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labelnumber);

            JLabel lblphone = new JLabel("Phone");
            lblphone.setBounds(40,405,200,40);
            lblphone.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lblphone);

            labelphone = new JLabel();
            labelphone.setBounds(270,405,200,40);
            labelphone.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labelphone);

            JLabel lbltotalprice = new JLabel("Total Price");
            lbltotalprice.setBounds(40,445,200,40);
            lbltotalprice.setFont(new Font("Tahoma",Font.BOLD,17));
            add(lbltotalprice);

            labeltotalprice = new JLabel();
            labeltotalprice.setBounds(270,445,200,40);
            labeltotalprice.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(labeltotalprice);

//        Buttons

            btnback = new JButton("BACK");
            btnback.setBounds(130,515,130,35);//30 up
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
                String query = "select * from bookhotel where username = '"+username+"'";

                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {

                    labelusername.setText(rs.getString("username"));
                    labelhotel.setText(rs.getString("hotel"));
                    labeltotalpersons.setText(rs.getString("person"));
                    labelday.setText(rs.getString("day"));
                    labelac.setText(rs.getString("ac"));
                    labelfood.setText(rs.getString("food"));
                    labelid.setText(rs.getString("id"));
                    labelnumber.setText(rs.getString("number"));
                    labelphone.setText(rs.getString("phone"));
                    labeltotalprice.setText(rs.getString("price"));
                } else {
                    JOptionPane.showMessageDialog(this,"Haven't Booked Yet...");
                    dispose();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        public void actionPerformed(ActionEvent actionEvent) {

                setVisible(false);
                dispose();

        }

//        public static void main(String[] args) {
//            new ViewBookedHotel("");
//        }
    }

