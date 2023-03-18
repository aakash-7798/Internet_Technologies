import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseListener;

public class Program_4d extends Frame implements MouseListener {

    private Color col=Color.red;
    Choice sgen=new Choice();

    Label l1=new Label("Stop");
    public Program_4d()
    {
        setSize(500,500);
        setVisible(true);
        setLayout(new FlowLayout());
        add(l1);
        l1.setBounds(100,40,100,30);
        this.addMouseListener(this);
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void mousePressed(MouseEvent me)
    {

        Color c;
        if(col==Color.red)
        {
            c=Color.yellow;
            l1.setText("Ready");
        }
        else if(col==Color.yellow)
        {
            c=Color.green;
            l1.setText("Move");
        }
        else if(col==Color.green)
        {
            c=Color.red;
            l1.setText("Stop");
        }
        else
        {
            c=Color.red;
            l1.setText("Stop");
        }

        setCol(c);
        repaint();

    }

    public void mouseEntered(MouseEvent me) { }
    public void mouseExited(MouseEvent me) { }
    public void mouseReleased(MouseEvent me) { }
    public void mouseClicked(MouseEvent me) { }
    public void setCol(Color c)
    {
    col=c;
    repaint();
    }

    public Color getCol()
    {

        return col;
    }

    public void paint(Graphics g)
    {
        System.out.println(col.toString());
        g.setColor(col);
        g.fillOval(100,80,300,400);

    }
    public static void main(String[] args)
    {
        Program_4d c=new Program_4d();
    }
}
