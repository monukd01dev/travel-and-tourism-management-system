package Hotel.Management.System;

import com.mysql.cj.callback.UsernameCallback;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener {

     JButton search,retrieve,back;
     private JTextField tfusername,tfname,tfquestion,tfanswer,tfpassword;

    public ForgetPassword() {
        setSize(900, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panel
        JPanel p1 = new JPanel();
        p1.setBounds(10, 10, 590, 340);
        p1.setLayout(null);
        p1.setBackground(new Color(131,193,233));
        add(p1);

        JPanel p2 = new JPanel();
        p2.setBounds(600, 0, 300, 400);
        p2.setLayout(null);
        p2.setBackground(Color.white);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgot-password.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,40,250, 250);
        p2.add(image);
        add(p2);

        // panel 1 form
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20,20,140,30);
        lblusername.setFont(new Font("Thoma",Font.BOLD,16));
        p1.add(lblusername);

        tfusername = new JTextField();
//        tfusername.setText("monukd");
        tfusername.setBounds(220,20,220,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(20,70,140,30);
        lblname.setFont(new Font("Thoma",Font.BOLD,16));
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220,70,220,30);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        tfname.setEditable(false);
        p1.add(tfname);

        JLabel lblquestion = new JLabel("Your Security Question");
        lblquestion.setBounds(20,120,200,30);
        lblquestion.setFont(new Font("Thoma",Font.BOLD,16));
        p1.add(lblquestion);

        tfquestion = new JTextField();
        tfquestion.setBounds(220,120,320,30);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        tfquestion.setEditable(false);
        p1.add(tfquestion);

        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setBounds(20,170,200,30);
        lblanswer.setFont(new Font("Thoma",Font.BOLD,16));
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(220,170,220,30);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        tfanswer.setEditable(false);
        p1.add(tfanswer);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(20,220,200,30);
        lblpassword.setFont(new Font("Thoma",Font.BOLD,16));
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(220,220,220,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        tfpassword.setEditable(false);
        p1.add(tfpassword);

        //buttons
        search = new JButton("Search");
        search.setBounds(460,20,100,30);
        search.setBackground(Color.gray);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        p1.add(search);

        retrieve = new JButton("Retrieve");
        retrieve.setBounds(460,170,100,30);
        retrieve.setBackground(Color.gray);
        retrieve.setForeground(Color.WHITE);
        retrieve.addActionListener(this);
        retrieve.setEnabled(false);
        p1.add(retrieve);

        back = new JButton("Back");
        back.setBounds(160,280,110,35);
//        back.setFont(new Font("Thoma",Font.BOLD,15));
        back.setBackground(Color.gray);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        p1.add(back);

        //frame visibility
        setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == search) {

            if (tfusername.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(ForgetPassword.this, "Please Enter Username");
                reset();
            } else {

                String query = "select * from account where username = '"+tfusername.getText().trim()+"'";
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()) {
//                        while (rs.next()) {
                            tfusername.setText(rs.getString("username"));
                            tfname.setText(rs.getString("name"));
                            tfquestion.setText(rs.getString("security"));
                            tfanswer.setEditable(true);
                            retrieve.setEnabled(true);
//                        }
                    } else {
                        JOptionPane.showMessageDialog(this,"Try Hard & Enter Correct Username..");
                        reset();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        } else if (actionEvent.getSource() == retrieve) {

            String query = "select * from account where username = '"+tfusername.getText().trim()+"'";
            if (tfanswer.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this,"Please Enter the Answer...");
            } else {

            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    if (rs.getString("answer").trim().equals(tfanswer.getText().trim())) {
                        tfpassword.setText(rs.getString("password"));
                        tfanswer.setEditable(false);
                    } else {
                        JOptionPane.showMessageDialog(ForgetPassword.this,"Password Doesn't Match :(");
                        tfanswer.setText("");
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            }

        } else if (actionEvent.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    void reset() {
        tfusername.setText("");
        tfname.setText("");
        tfquestion.setText("");
        tfanswer.setEditable(false);
        tfanswer.setText("");
        retrieve.setEnabled(false);
    }

//    public static void main(String[] args) {
//        new ForgetPassword();
//
//    }
}
