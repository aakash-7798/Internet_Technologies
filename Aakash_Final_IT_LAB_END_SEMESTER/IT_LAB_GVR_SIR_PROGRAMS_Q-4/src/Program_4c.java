import java.awt.*; import java.awt.event.*;
import java.io.Serializable;

public class Program_4c extends Frame implements ActionListener

{

    private Integer res,res1; int op;

    TextField tf=new TextField("0",20); Button b1=new Button("1");

    Button b2=new Button("2"); Button b3=new Button("3"); Button b4=new Button("4"); Button b5=new Button("5"); Button b6=new Button("6"); Button b7=new Button("7"); Button b8=new Button("8");

    Button b9=new Button("9");
    Button b0=new Button("0");

    Button b11=new Button("+");
    Button b12=new Button("-");

    Button b13=new Button("x");
    Button b14=new Button("/");
    Button b15=new Button("=");

    public Program_4c()
    {

        setLayout(new GridLayout(6,6)); setSize(500,500); setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        add(b0);
        add(b1);

        add(b2);
        add(b3);
        add(b4);

        add(b5);
        add(b6);

        add(b7);
        add(b8);
        add(b9);

        add(b11);
        add(b12);

        add(b13);
        add(b14);
        add(b15);

        add(tf);
        b0.addActionListener(this);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        b4.addActionListener(this);
        b5.addActionListener(this);

        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);

        b9.addActionListener(this);
        b11.addActionListener(this);

        b12.addActionListener(this);
        b13.addActionListener(this);

        b14.addActionListener(this);

        b15.addActionListener(this); res=0;
    }

    public void actionPerformed(ActionEvent ae)
    {

        String cmd=ae.getActionCommand(); if(cmd.equals("0"))

    { res=Integer.parseInt(res.toString()+"0"); tf.setText(res.toString()); } else if(cmd.equals("1"))

    { res=Integer.parseInt(res.toString()+"1"); tf.setText(res.toString()); } else if(cmd.equals("2"))

    { res=Integer.parseInt(res.toString()+"2");  tf.setText(res.toString()); }


else if(cmd.equals("3"))

    { res=Integer.parseInt(res.toString()+"3"); tf.setText(res.toString()); } else if(cmd.equals("4"))

    { res=Integer.parseInt(res.toString()+"4"); tf.setText(res.toString()); } else if(cmd.equals("5"))

    { res=Integer.parseInt(res.toString()+"5"); tf.setText(res.toString()); } else if(cmd.equals("6"))

    { res=Integer.parseInt(res.toString()+"6"); tf.setText(res.toString()); } else if(cmd.equals("7"))

    { res=Integer.parseInt(res.toString()+"7"); tf.setText(res.toString()); } else if(cmd.equals("8"))

    { res=Integer.parseInt(res.toString()+"8"); tf.setText(res.toString()); } else if(cmd.equals("9"))

    { res=Integer.parseInt(res.toString()+"9"); tf.setText(res.toString()); } else if(cmd.equals("+"))

    { res1=res; res=0;  tf.setText("0");  op=0; }

    else if(cmd.equals("-"))

    { res1=res; res=0; tf.setText("0"); op=1;} else if(cmd.equals("x"))

    { res1=res; res=0; tf.setText("0"); op=2;} else if(cmd.equals("/"))

    { res1=res; res=0; tf.setText("0"); op=3;} else if(cmd.equals("="))

    {

        res=Integer.parseInt(tf.getText()); if(op==0) res=res1+res;

    else if(op==1) res=res1-res; else if(op==2) res=res*res1; else if(op==3)
    { if(res!=0)   res=res1/res;
    else System.out.println("Div Zero");

    }
        tf.setText(res.toString());
    }

    }

    public void setRes(Integer r) { res=r; }

    public Integer getRes() { return res; }

    public static void main(String[] args)
    {

        Program_4c p = new Program_4c();
    }

}

