package Travel_and_Tourism.Management.System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{

    Thread thread;
    public Splash(){

        //icon code
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bg = new JLabel(i3);
//        setBounds(0,0,1200,600);
        add(bg);

        //frame code
//        setSize(1200,600);
//        setLocation(760,432);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thread = new Thread(this);
        thread.start();
    }

    public void run(){
        try{
            Thread.sleep(7000);
        }catch(Exception e){}
        setVisible(false);
        new Login();

    }

    public static void main(String[] args) {

        Splash frame = new Splash();

        for(int i =0; i<=600;i++){
//            frame.setLocation((760-i),(1000-i)/4); //laptop
            frame.setLocation((960-i),(1400-i)/4); //PC

            frame.setSize(i*2,i);
            try{
                Thread.sleep(1);
            }catch(Exception e){}
        }

    }

}
