import java.awt.*;
import java.awt.event.*;
class mycalc extends Frame implements ActionListener
{
    float i,j,k;
    int count = 1, s;
    TextField T;
    Button b[];
    Panel P;
    String S1;
    mycalc()
    {
        P = new Panel(new GridLayout(4,4));
        b = new Button[16];
        T = new TextField(10);
        b[10] = new Button(".");
        b[11] = new Button("*");
        b[12] = new Button("/");
        b[13] = new Button("-");
        b[14] = new Button("+");
        b[15] = new Button("=");
        for(s = 0; s<16; s++)
        {
            if(s <10)
                b[s] = new Button("" + s);
            P.add(b[s]);
            b[s].addActionListener(this);
        }
        add(T,BorderLayout.NORTH);
        add(P);
    }
    public void actionPerformed(ActionEvent e)
    {
        String S = e.getActionCommand();
        if(S.equals("+") || S.equals("-") || S.equals("*") || S.equals("/"))
        {
            S1 = S;
            i = Integer.parseInt(T.getText());
            T.setText("");
            count = 1;
        }
        else
        {
            if(S.equals("="))
            {
                j = Integer.parseInt(T.getText());
                if(S1.equals("+"))
                    k = i + j;
                else
                {
                    if(S1.equals("-"))
                        k = i - j;
                    else
                    {
                        if(S1.equals("*"))
                            k = i * j;
                        else
                            k = i / j;
                    }
                }
                T.setText("" + k);
            }
            else
            {
                if(S == "." && count >= 2)
                {
                    T.setText(T.getText());
                }
                else
                {
                    if(S == "." && count <= 1)
                    {
                        count = count + 1;
                        T.setText(T.getText() + S);
                    }
                    else
                        T.setText(T.getText() + S);
                }
            }
        }

    }
}
class calculator
{
    public static void main(String[] args)
    {
        mycalc c = new mycalc();
        c.setSize(300,400);
        c.setVisible(true);
    }
}
