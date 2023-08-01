
import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JFrame implements Runnable {

    SplashScreen(){
//        setSize(1000, 500);
//        setLocation(200, 150);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2  = i1.getImage().getScaledInstance(1000, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        setVisible(true);

        Thread t = new Thread(this);
        t.start();

    }

    public void run()
    {
        try{
            Thread.sleep(7000);
            setVisible(false);
        }catch(Exception e){}
    }

    public static void main(String[] args) {
        SplashScreen frame = new SplashScreen();
        frame.setIconImage(null);

        int x = 1;
        for(int i = 1; i<=470; i+=6, x+=7)
        {
            frame.setLocation(650-(x+i)/2, 400-(i/2));
            frame.setSize(x+i, i);

            try
            {
                Thread.sleep(15);
            }
            catch(Exception e){}
        }

    }
}
