import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener {

    JButton back;
    ViewCustomer(String username)
    {
        setBounds(230, 65, 870, 650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

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

        //id

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(20, 100, 100, 30);
        lblid.setFont(new Font("", Font.BOLD, 20));
        lblid.setForeground(Color.RED);
        add(lblid);

        JLabel labelid = new JLabel("");
        labelid.setBounds(150, 100, 200, 30);
        labelid.setFont(new Font("", Font.PLAIN, 20));
        add(labelid);

        //Number

        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(20, 160, 100, 30);
        lblNumber.setFont(new Font("", Font.BOLD, 20));
        lblNumber.setForeground(Color.RED);
        add(lblNumber);

        JLabel labelNumber = new JLabel("");
        labelNumber.setBounds(150, 160, 200, 30);
        labelNumber.setFont(new Font("", Font.PLAIN, 20));
        add(labelNumber);

        //name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(20, 220, 100, 30);
        lblname.setFont(new Font("", Font.BOLD, 20));
        lblname.setForeground(Color.RED);
        add(lblname);

        JLabel labelname = new JLabel("");
        labelname.setBounds(150, 220, 200, 30);
        labelname.setFont(new Font("", Font.PLAIN, 20));
        add(labelname);

        //gender

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(20, 280, 100, 30);
        lblgender.setFont(new Font("", Font.BOLD, 20));
        lblgender.setForeground(Color.RED);
        add(lblgender);

        JLabel labelgender = new JLabel("");
        labelgender.setBounds(150, 280, 200, 30);
        labelgender.setFont(new Font("", Font.PLAIN, 20));
        add(labelgender);

        //Right Hand side

        //country

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(350, 40, 100, 30);
        lblcountry.setFont(new Font("", Font.BOLD, 20));
        lblcountry.setForeground(Color.RED);
        add(lblcountry);

        JLabel labelcountry = new JLabel("");
        labelcountry.setBounds(480, 40, 200, 30);
        labelcountry.setFont(new Font("", Font.PLAIN, 20));
        add(labelcountry);

        //Address

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(350, 100, 100, 30);
        lbladdress.setFont(new Font("", Font.BOLD, 20));
        lbladdress.setForeground(Color.RED);
        add(lbladdress);

        JLabel labeladdress = new JLabel("");
        labeladdress.setBounds(480, 100, 200, 30);
        labeladdress.setFont(new Font("", Font.PLAIN, 20));
        add(labeladdress);

        //phone

        JLabel lblphone = new JLabel("PhoneNo");
        lblphone.setBounds(350, 160, 100, 30);
        lblphone.setFont(new Font("", Font.BOLD, 20));
        lblphone.setForeground(Color.RED);
        add(lblphone);

        JLabel labelphone = new JLabel("");
        labelphone.setBounds(480, 160, 200, 30);
        labelphone.setFont(new Font("", Font.PLAIN, 20));
        add(labelphone);

        //email

        JLabel lblEmail = new JLabel("Emailid");
        lblEmail.setBounds(350, 220, 100, 30);
        lblEmail.setFont(new Font("", Font.BOLD, 20));
        lblEmail.setForeground(Color.RED);
        add(lblEmail);

        JLabel labelemail = new JLabel("");
        labelemail.setBounds(480, 220, 300, 30);
        labelemail.setFont(new Font("", Font.PLAIN, 20));
        add(labelemail);

        //Back Button
        back = new JButton("Back");
        back.setBounds(350, 340, 100, 30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Raleway", Font.BOLD, 20));
        back.addActionListener(this);
        add(back);

        //adding image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(870, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,200, 870, 650);
        add(image);

        try
        {
            Conn c = new Conn();
            String query = "select * from Customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelname.setText(rs.getString("name"));
                labelNumber.setText(rs.getString("number"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
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
        }
    }

    public static void main(String[] args) {
        new ViewCustomer("");
    }
}
