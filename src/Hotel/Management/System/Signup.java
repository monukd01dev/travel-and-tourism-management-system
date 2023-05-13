package Hotel.Management.System;



import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{

    final JButton create,back;
    private JTextField tfusername,tfname,tfpassword,tfanswer;
    private Choice security;

    public Signup() {
        //frame code
        setSize(800, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        //panels
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,500,400);
        p1.setBackground(new Color(131,193,233));
        add(p1);



        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(500, 0, 400, 400);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/add-group.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(10,10,300,300);
        p2.add(image);
        add(p2);

        //labels
        JLabel lblusername = new JLabel("<html><font size='4' color=black>Username</font> <font size='5' color=red>*</font></html>");
        lblusername.setFont(new Font("Thoma",Font.BOLD,14));
        lblusername.setBounds(50,20,125,25);
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(190,20,200,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        JLabel lblname = new JLabel("<html><font size='4' color=black>Name</font> <font size='5' color=red>*</font></html>");
        lblname.setBounds(50,65,125,25);
        lblname.setFont(new Font("Thoma",Font.BOLD,14));
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(190,65,200,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lblpassword = new JLabel("<html><font size='4' color=black>Password</font> <font size='5' color=red>*</font></html>");
        lblpassword.setBounds(50,110,125,25);
        lblpassword.setFont(new Font("Thoma",Font.BOLD,14));
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(190,110,200,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        JLabel lblsecurity = new JLabel("<html><font size='4' color=black>Question</font> <font size='5' color=red>*</font></html>");
        lblsecurity.setBounds(50,155,125,25);
        lblsecurity.setFont(new Font("Thoma",Font.BOLD,14));
        p1.add(lblsecurity);

        security = new Choice();
        security.add("Fav Character From The Boys?");
        security.add("Fav Character From Marvel?");
        security.add("What is your lucky number?");
        security.setBounds(190,155,200,25);
        p1.add(security);

        JLabel lblanswer = new JLabel("<html><font size='4' color=black>Answer</font> <font size='5' color=red>*</font></html>");
        lblanswer.setBounds(50,200,125,25);
        lblanswer.setFont(new Font("Thoma",Font.BOLD,14));
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(190,200,200,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

//        Buttons
        create = new JButton("Create");
        create.setBounds(90,280,100,30);
        create.setBackground(Color.white);
        create.setForeground(new Color(131,193,233));
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBounds(240,280,100,30);
        back.setBackground(Color.white);
        back.setForeground(new Color(131,193,233));
        back.addActionListener(this);
        p1.add(back);


        //last line of code must be
        setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == create) {
            if (tfusername.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Fill Mandatory Fields");
            } else {
                if (tfanswer.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(this, "Fill Mandatory Fields");
                } else {
                    if (tfpassword.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(this, "Fill Mandatory Fields");
                    } else {
                        if (tfanswer.getText().trim().equals("")) {
                            JOptionPane.showMessageDialog(this, "Fill Mandatory Fields");
                        } else {
                            startCreating();
                        }
                    }
                }
            }
        } else if (actionEvent.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    void startCreating() {
        //local for storing values
        String username = tfusername.getText().trim();
        String name = tfname.getText().trim();
        String password = tfpassword.getText().trim();
        String question = security.getSelectedItem();// value from drop down
        String answer = tfanswer.getText().trim();

        //creating query
        String query = "insert into account values('" + username +
                "','" + name + "','" + password + "','" + question + "','" + answer + "')";
        //connection
        try {
            Conn c = new Conn();
            c.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Account created successfully...");
            setVisible(false);
            new Login();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Username already Exists...");
            tfusername.setText("");
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        new Signup();
//    }
}
