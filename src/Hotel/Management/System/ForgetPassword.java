package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ForgetPassword extends JFrame implements ActionListener {

    public ForgetPassword() {
        setSize(800, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panel
        JPanel p1 = new JPanel();
        p1.setBounds(10, 10, 490, 340);
        p1.setLayout(null);
        p1.setBackground(new Color(131,193,233));
        add(p1);

        JPanel p2 = new JPanel();
        p2.setBounds(500, 0, 300, 400);
        p2.setLayout(null);
        p2.setBackground(Color.white);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgot-password.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,40,250, 250);
        p2.add(image);
        add(p2);
        //frame visibility
        setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
    }

    public static void main(String[] args) {
        new ForgetPassword();

    }
}
