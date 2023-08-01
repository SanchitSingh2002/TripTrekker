import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewPackage extends JFrame implements ActionListener {

    JButton back;
    String username;
    ViewPackage(String username)
    {

        this.username = username;
        setBounds(230, 65, 870, 650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("VIEW PACKAGE DETAILS");
        heading.setBounds(240, 3, 450, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);

        //username

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 40, 100, 30);
        lblusername.setFont(new Font("", Font.BOLD, 20));
        lblusername.setForeground(Color.RED);
        add(lblusername);

        JLabel labelusername = new JLabel("");
        labelusername.setBounds(150, 40, 200, 30);
        labelusername.setFont(new Font("", Font.PLAIN, 20));
        add(labelusername);

        //Package

        JLabel lblpackage = new JLabel("Package");
        lblpackage.setBounds(20, 100, 100, 30);
        lblpackage.setFont(new Font("", Font.BOLD, 20));
        lblpackage.setForeground(Color.RED);
        add(lblpackage);

        JLabel labelpackage = new JLabel("");
        labelpackage.setBounds(150, 100, 200, 30);
        labelpackage.setFont(new Font("", Font.PLAIN, 20));
        add(labelpackage);

        //Total Number of persons

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(20, 160, 150, 30);
        lblpersons.setFont(new Font("", Font.BOLD, 20));
        lblpersons.setForeground(Color.RED);
        add(lblpersons);

        JLabel labelpersons = new JLabel("");
        labelpersons.setBounds(180, 160, 200, 30);
        labelpersons.setFont(new Font("", Font.PLAIN, 20));
        add(labelpersons);

        //Id
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(20, 220, 100, 30);
        lblid.setFont(new Font("", Font.BOLD, 20));
        lblid.setForeground(Color.RED);
        add(lblid);

        JLabel labelid = new JLabel("");
        labelid.setBounds(150, 220, 200, 30);
        labelid.setFont(new Font("", Font.PLAIN, 20));
        add(labelid);

        //id Number

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(20, 280, 100, 30);
        lblnumber.setFont(new Font("", Font.BOLD, 20));
        lblnumber.setForeground(Color.RED);
        add(lblnumber);

        JLabel labelnumber = new JLabel("");
        labelnumber.setBounds(150, 280, 200, 30);
        labelnumber.setFont(new Font("", Font.PLAIN, 20));
        add(labelnumber);

        //Right Hand side

        //phoneno

        JLabel lblphone = new JLabel("PhoneNo");
        lblphone.setBounds(350, 40, 100, 30);
        lblphone.setFont(new Font("", Font.BOLD, 20));
        lblphone.setForeground(Color.RED);
        add(lblphone);

        JLabel labelphone = new JLabel("");
        labelphone.setBounds(480, 40, 200, 30);
        labelphone.setFont(new Font("", Font.PLAIN, 20));
        add(labelphone);

        //price

        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(350, 100, 100, 30);
        lblprice.setFont(new Font("", Font.BOLD, 20));
        lblprice.setForeground(Color.RED);
        add(lblprice);

        JLabel labelprice = new JLabel("");
        labelprice.setBounds(480, 100, 200, 30);
        labelprice.setFont(new Font("", Font.PLAIN, 20));
        add(labelprice);



        //Back Button
        back = new JButton("Back");
        back.setBounds(410, 280, 100, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Raleway", Font.BOLD, 20));
        back.addActionListener(this);
        add(back);

        //adding image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(870, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,220, 870 , 500);
        add(image);

        try
        {
            Conn c = new Conn();
            String query = "select * from BookPackage where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelpackage.setText(rs.getString("package"));
                labelpersons.setText(rs.getString("persons"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == back)
        {
            setVisible(false);
            new Dashboard("");
        }
    }

    public static void main(String[] args) {
        new ViewPackage("sanchit@123");
    }
}
