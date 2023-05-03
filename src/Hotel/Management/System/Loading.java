package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{

    Thread t;
    JProgressBar bar;

    public void run() {
        try {
            int max = bar.getMaximum();
            int value;
            for (int i = 1; i <= 101; i++) {
                value = bar.getValue();
                if (value < max) {
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false);
                    //new
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Loading(String username) {
        t = new Thread(this);
        setSize(600, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel text = new JLabel("Travel and Tourism Management");
        text.setForeground(Color.blue);
        text.setFont(new Font("Raleways",Font.BOLD,30));
        text.setBounds(55,30,500,40);
        add(text);

        bar = new JProgressBar();
        bar.setBounds(90,90,400,30);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("loading please wait...");
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleways",Font.BOLD,16));
        loading.setBounds(200,120,500,30);
        add(loading);

        JLabel welcome = new JLabel("Welcome "+username);
        welcome.setForeground(Color.RED);
        welcome.setFont(new Font("Raleways",Font.BOLD,20));
        welcome.setBounds(55,300,500,25);
        add(welcome);

        t.start();

        //end line
        setVisible(true);

    }


    public static void main(String[] args) {
        new Loading("Monu KD");
    }
}
