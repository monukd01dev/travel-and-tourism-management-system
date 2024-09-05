package Travel_and_Tourism.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;

public class BookHotel extends JFrame implements ActionListener {

    JButton btncheckprice,btnbookpackage,btnback;
    JComboBox combohotel,comboac,combofood;
    JTextField tftotalpersons,tfday;
    JLabel labeltotalprice,labelusername,labelid,labelnumber,labelphone;
    String username;

    public BookHotel(String username) {
        this.username = username;
        setSize(1200, 625);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);

//        image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotelvector.jpg"));
        Image i2 = i1.getImage().getScaledInstance(580, 580, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(560,0,580,580);
        add(image);


//      labels
        JLabel lbltitle = new JLabel("BOOK HOTEL");
        lbltitle.setBounds(200,10,200,40);
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

        JLabel lblselecthotel = new JLabel("<html><font size='5' color=black weight ='100'>Select Hotel</font> <font size='4' color=red>*</font></html>");
        lblselecthotel.setBounds(40,120,200,40);
        lblselecthotel.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblselecthotel);

        combohotel = new JComboBox(new String[]{"The Night Rise Hotel","The Day Bringer Hotel","Loan Harper Motel"});
        combohotel.setBounds(270,130,250,25);//30 up
        combohotel.setBackground(Color.white);
        combohotel.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(combohotel);

        JLabel lbltotalpersons = new JLabel("<html><font size='5' color=black>Total Persons</font> <font size='4' color=red>*</font></html>");
        lbltotalpersons.setBounds(40,165,200,40);
        lbltotalpersons.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lbltotalpersons);

        tftotalpersons = new JTextField();
        tftotalpersons.setBounds(270,177,250,23);//30 up
        tftotalpersons.setBackground(Color.white);
        tftotalpersons.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(tftotalpersons);
//        new
        JLabel lblday = new JLabel("<html><font size='5' color=black weight ='100'>Day</font> <font size='4' color=red>*</font></html>");
        lblday.setBounds(40,205,200,40);
        lblday.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblday);

        tfday = new JTextField();
        tfday.setBounds(270,217,250,23);
        tfday.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(tfday);

        JLabel lblac = new JLabel("AC");
        lblac.setBounds(40,245,200,40);
        lblac.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblac);

        comboac = new JComboBox(new String[]{"Yes","No"});
        comboac.setBounds(270,255,250,25);//30 up
        comboac.setBackground(Color.white);
        comboac.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(comboac);

        JLabel lblfood = new JLabel("Food Include");
        lblfood.setBounds(40,285,200,40);
        lblfood.setFont(new Font("Tahoma",Font.BOLD,17));
        add(lblfood);

        combofood = new JComboBox(new String[]{"Yes","No"});
        combofood.setBounds(270,295,250,25);//30 up
        combofood.setBackground(Color.white);
        combofood.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(combofood);

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
        btncheckprice = new JButton("Check Price");
        btncheckprice.setBounds(60,515,130,35);//30 up
        btncheckprice.setBackground(Color.black);
        btncheckprice.setForeground(Color.white);
        btncheckprice.setFocusPainted(false);
        btncheckprice.setFont(new Font("Tahoma",Font.PLAIN,15));
        btncheckprice.addActionListener(this);
        add(btncheckprice);

        btnbookpackage = new JButton("Book Package");
        btnbookpackage.setBounds(210,515,130,35);//30 up
        btnbookpackage.setBackground(Color.black);
        btnbookpackage.setForeground(Color.white);
        btnbookpackage.setFocusPainted(false);
        btnbookpackage.setFont(new Font("Tahoma",Font.PLAIN,15));
        btnbookpackage.addActionListener(this);
//        btnbookpackage.setEnabled(false);
        add(btnbookpackage);

        btnback = new JButton("BACK");
        btnback.setBounds(360,515,130,35);//30 up
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

             try {

                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where hotel = '"+((String) combohotel.getSelectedItem())+"'");
                 while (rs.next()) {
                     int cost = 0;
                     int TotalDays = Integer.parseInt(tfday.getText().trim());
                     int TotalPerson = Integer.parseInt(tftotalpersons.getText().trim());
                     int CostPerPerson = Integer.parseInt(rs.getString("costperperson"));
                     int AcRoom = 0;
                     int Food = 0;
                     if (Objects.equals(((String) comboac.getSelectedItem()),"Yes")) {
                         AcRoom = Integer.parseInt(rs.getString("acroom"));
                     }
                     if (Objects.equals(((String) combofood.getSelectedItem()),"Yes")) {
                         Food = Integer.parseInt(rs.getString("food"));
                     }
                     cost = TotalDays * (TotalPerson * (CostPerPerson + AcRoom + Food));
                     labeltotalprice.setText("Rs "+cost+"/-");
//                     btnbookpackage.setEnabled(true);
                 }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Please Fill Mandatory Fields");

            }
        } else if (actionEvent.getSource() == btnbookpackage) {
             btncheckprice.doClick();
             if (tftotalpersons.getText().equals("") || tfday.getText().equals("")) {
                 System.out.println("bro mai chal raha hunee \n\n\n");
                 return;
             } else {

                try {
                    Conn c = new Conn();
                    String query = "insert into bookhotel values('"+labelusername.getText()+"','"+((String) combohotel.getSelectedItem())+"','"+tftotalpersons.getText()+"','"+tfday.getText()+"','"+((String) comboac.getSelectedItem())+"','"+((String) combofood.getSelectedItem())+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labeltotalprice.getText()+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(this,"Package Booked Successfully...");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "You Have Already Done Your Booking...");

                    setVisible(false);
                    new ViewBookedHotel(username);

                    e.printStackTrace();
                    }
                }
        } else {
            setVisible(false);
        }
    }

//    public static void main(String[] args) {
//        new BookHotel("monukd");
//    }
}

