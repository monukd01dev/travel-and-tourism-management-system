package Travel_and_Tourism.Management.System;

import javax.swing.*;
import java.awt.*;

public class ViewHotels extends JFrame implements Runnable{
    Thread t;
    JLabel lbl_1,lbl_2,lbl_3,lbl_4,lbl_5,lbl_6,lbl_7,lbl_8,lbl_9,lbl_10;
    JLabel[] slide = new JLabel[]{lbl_1,lbl_2,lbl_3,lbl_4,lbl_5,lbl_6,lbl_7,lbl_8,lbl_9,lbl_10};
    JLabel caption;

    public void run() {
        String[] hotelName = {"The Night Rise Hotel","The Day Bringer Hotel","Loan Harper Motel","Seven Seas Motel","Neon Ring Hotel","Melano Heaven Motel","Eksa Red Hotel","Aeth Wonder Hotel","Deadly Moon Motel","KD's Love Motel"};
        for (;;) {
            for (int i = 0; i <= 9; i++) {
                slide[i].setVisible(true);
                caption.setText(hotelName[i]);
                try {
                    Thread.sleep(2500);
                    slide[i].setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public ViewHotels() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        caption = new JLabel () ;
        caption.setBounds(50, 480, 1000, 70) ;
        caption.setFont(new Font("Tahoma",Font.BOLD,40));
        caption.setForeground(Color.white);
        add(caption);

        //Imagea --> ImageIcon
        ImageIcon a1 = null, a2 = null, a3 = null, a4 = null, a5 = null, a6 = null, a7 = null, a8 = null, a9 = null, a10 = null;
        ImageIcon[] imagea = new ImageIcon[]{a1,a2,a3,a4,a5,a6,a7,a8,a9,a10};

        //Imageb --> Image
        Image b1= null, b2= null, b3= null, b4= null, b5= null, b6= null, b7= null, b8= null, b9= null, b10= null;
        Image[] imageb = new Image[]{b1, b2, b3, b4, b5, b6, b7, b8, b9, b10};

        //Imagec --> ImageIcon
        ImageIcon c1 = null, c2 = null, c3 = null, c4 = null, c5 = null, c6 = null, c7 = null, c8 = null, c9 = null, c10 = null;
        ImageIcon[] imagec = new ImageIcon[]{c1,c2,c3,c4,c5,c6,c7,c8,c9,c10};

        for (int i = 0; i<=9; i++) {

        imagea[i] = new ImageIcon(ClassLoader.getSystemResource("icons/hotel"+(i+1)+".jpg"));
        imageb[i] = imagea[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        imagec[i] = new ImageIcon(imageb[i]);
        slide[i] = new JLabel(imagec[i]);
        slide[i].setBounds(0, 0, 800, 600);
        add(slide[i]);

        }

        t = new Thread(this);
        t.start();

        //endline
        setVisible(true);
    }

}
