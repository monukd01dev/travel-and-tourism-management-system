package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

    private JButton login,signup,password;
    private JTextField tfusername;
    private JPasswordField tfpassword;

    public Login(){
        //frame code
        setSize(900,400);
        setLayout(null);
        setLocationRelativeTo(null);//display frame in center
        setResizable(false);//cannot change the size of frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit on close

        getContentPane().setBackground(Color.WHITE);

        //Panel
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,400,400);// we use setBounds for creating own layouts
//        p1.setBackground(Color.WHITE);
        p1.setBackground(new Color(131,193,233));// for using RGB values we can create color class object
        add(p1);

        //image login
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(80,60,250,250);
        p1.add(image);

        //2nd panel
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);

        //form
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60,20,100,25);
        lblusername.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        p2.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(60,60,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60,110,100,25);
        lblpassword.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        p2.add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(60,150,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        //Button
        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(131,193,233));
        login.setForeground(Color.white);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Sign Up");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(131,193,233));
        signup.setForeground(Color.white);
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.addActionListener(this);
        p2.add(signup);

        password = new JButton("Forgot Password");
        password.setBounds(145,245,130,30);
        password.setBackground(new Color(131,193,233));
        password.setForeground(Color.white);
        password.setBorder(BorderFactory.createEmptyBorder());
        password.addActionListener(this);
        p2.add(password);

        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(300,245,100,30);
        text.setForeground(Color.red);
        p2.add(text);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == login) {
            String password = tfpassword.getText().trim();
//            String query = "select * from account where username = '"+tfusername.getText().trim()+"' and password = '"+tfpassword.getText().trim()+"'";

            String query = "select * from account where username = '"+tfusername.getText().trim()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    if (password.equals(rs.getString("password").trim())) {
                        setVisible(false);
                        new Loading(rs.getString("name").toUpperCase(), rs.getString("username"));
                    } else {
                        JOptionPane.showMessageDialog(Login.this, "Invalid Username or Password :(");

                    }
                } else {
                    JOptionPane.showMessageDialog(this,"Username doesn't exits... Pls Signup");
                    tfusername.setText(null);
                    tfpassword.setText(null);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        } else if (actionEvent.getSource() == signup) {
            setVisible(false);
            new Signup();
        }else  if (actionEvent.getSource() == password) {
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String[] args){
        Login l1 = new Login();
    }

}
