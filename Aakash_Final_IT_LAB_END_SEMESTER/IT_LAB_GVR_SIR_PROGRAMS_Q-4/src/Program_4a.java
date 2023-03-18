//a. Create a JavaBean which gives the exchange value of INR(Indian Rupees) into
//        equivalent American/Canadian/Australian Dollar value


//https://stackoverflow.com/questions/5281262/how-to-close-the-window-in-awt

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Program_4a {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Currency Converter");
        JLabel l1,l2,l3,l4;
        JTextField t1,t2,t3,t4;
        JButton b1;

        l1 = new JLabel("Rupees:");
        l2 = new JLabel("American Dollar : ");
        l3 = new JLabel("Canadian Dollar : ");
        l4 = new JLabel("Australian Dollar : ");

        l1.setBounds(100,40,100,30);
        l2.setBounds(100,120,100,30);
        l3.setBounds(100,180,120,30);
        l4.setBounds(100,240,120,30);


        t1 = new JTextField("");
        t2 = new JTextField("");
        t3 = new JTextField("");
        t4 = new JTextField("");

        t1.setBounds(200,40,100,30);
        t2.setBounds(200,120,100,30);
        t3.setBounds(200,180,100,30);
        t4.setBounds(200,240,100,30);



        b1 = new JButton("Convert");
        b1.setBounds(150,80,100,30);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double d = Double.parseDouble(t1.getText());
                double can_d = (d / 60.22 );
                double ame_d = (d/82.33);
                double aus_d = (d/55);
                String str1 = String.valueOf(String.format("%.02f",ame_d));
                String str2 = String.valueOf(String.format("%.02f",can_d));
                String str3 = String.valueOf(String.format("%.02f",aus_d));
                t2.setText(str1+" "+"$");
                t3.setText(str2+" "+"C$");
                t4.setText(str3+" "+"A$");
            }
        });

        jf.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        jf.add(l1);
        jf.add(l2);
        jf.add(l3);
        jf.add(l4);
        jf.add(t1);
        jf.add(t2);
        jf.add(t3);
        jf.add(t4);
        jf.add(b1);
        jf.setLayout(null);
        jf.setSize(500,380);
        jf.setVisible(true);




//        Frame f = new Frame();
//        Button bt = new Button("Click Here");
//        bt.setBounds(20,50,80,20);
//        f.add(bt);
//        f.setSize(300,250);
//        f.setTitle("Aakash_AWT");
//        f.setLayout(null);
//        f.setVisible(true);
//        f.addWindowListener(new WindowAdapter() {
//                                public void windowClosing(WindowEvent we) {
//                                    f.dispose();
//                                }
//                            }
//        );

}
}
