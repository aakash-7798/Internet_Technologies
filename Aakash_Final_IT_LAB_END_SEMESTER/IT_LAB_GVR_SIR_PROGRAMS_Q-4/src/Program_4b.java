import javax.swing.*;
import java.awt.event.*;

public class Program_4b {
    public static int ct = 1;
    public static void main(String[] args) {

        JFrame jf = new JFrame("Count Event");
        JLabel jl = new JLabel("Click Count : ");
        JTextField jtf = new JTextField("");
        JButton jb = new JButton("Click Me");

        jb.setBounds(80,100,100,30);
        jl.setBounds(80,150,100,30);
        jtf.setBounds(130,150,100,30);

        jf.add(jl);
        jf.add(jtf);
        jf.add(jb);


        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = String.valueOf(ct++);
                jtf.setText(str);
            }
        });

        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
        jf.setLayout(null);
        jf.setSize(300,300);
        jf.setVisible(true);

    }
}
