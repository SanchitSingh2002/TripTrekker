import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{

    Thread t;
    JProgressBar bar;
    String username;

    public void run()
    {
        try
        {
            int max = bar.getMaximum(); //100
            for(int i = 1; i<=101; i++)
            {
                int value = bar.getValue();

                if(value < max)
                {
                    bar.setValue(bar.getValue() + 1);
                }
                else
                {
                    setVisible(false);
                    // new class object
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    Loading(String username)
    {
        username = this.username;

        setBounds(350, 200, 700, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("TripTrekker Application");
        text.setBounds(150, 20, 600, 40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

        bar = new JProgressBar();
        bar.setBounds(200, 100, 300, 35);
        bar.setForeground(Color.GREEN);
        bar.setStringPainted(true);
        add(bar);

        //loading
        JLabel loading = new JLabel("Loading, Please Wait...");
        loading.setBounds(200, 145, 600, 20);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway", Font.BOLD, 16));
        add(loading);

        JLabel usrname = new JLabel("Welcome "+username);
        usrname.setBounds(40, 300, 600, 40);
        usrname.setForeground(Color.RED);
        usrname.setFont(new Font("Raleway", Font.BOLD, 16));
        add(usrname);

        //creating object for thread class
        t = new Thread(this);
        t.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new Loading("username");
    }
}
