import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;

public class BookPackage extends JFrame implements ActionListener {

    JButton checkprice, bookpackage, back;
    JTextField tftotalpersons;
    Choice selectpackage;
    JLabel lblprice, lblnumber, lblusername, lblphone, lblid;

    String username;

    BookPackage(String username)
    {
        this.username = username;
        setBounds(165, 30, 1000, 700);
        setLayout(null);

        JLabel heading = new JLabel("BOOK PACKAGE");
        heading.setBounds(20, 30, 400, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 45));
        add(heading);

        JLabel labelusername = new JLabel("Username");
        labelusername.setBounds(40, 150, 150, 20);
        labelusername.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(labelusername);

        lblusername = new JLabel("");
        lblusername.setBounds(220, 150, 150, 20);
        lblusername.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblusername);

        //select package

        JLabel labelselectpackage = new JLabel("Select Package");
        labelselectpackage.setBounds(40, 195, 150, 30);
        labelselectpackage.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(labelselectpackage);

        selectpackage = new Choice();
        selectpackage.add("Gold Package");
        selectpackage.add("Silver Package");
        selectpackage.add("Bronze");
        selectpackage.setBounds(220, 200, 150, 30);
        add(selectpackage);

        JLabel labeltotalpersons = new JLabel("Total Persons");
        labeltotalpersons.setBounds(40, 255, 150, 20);
        labeltotalpersons.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(labeltotalpersons);

        tftotalpersons = new JTextField();
        tftotalpersons.setBounds(220, 260, 150, 20);
        tftotalpersons.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(tftotalpersons);

        //label id

        JLabel labelid = new JLabel("ID:");
        labelid.setBounds(40, 310, 150, 20);
        labelid.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(labelid);

        lblid = new JLabel("");
        lblid.setBounds(220, 310, 250, 20);
        lblid.setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblid);

        // number

        JLabel labelnumber = new JLabel("Number");
        labelnumber .setBounds(40, 360, 150, 20);
        labelnumber .setFont(new Font("Raleway", Font.PLAIN, 20));
        add(labelnumber);

        lblnumber = new JLabel("");
        lblnumber .setBounds(220, 360, 250, 20);
        lblnumber .setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblnumber);

        //phone
        JLabel labelphone = new JLabel("Phone");
        labelphone .setBounds(40, 410, 150, 20);
        labelphone .setFont(new Font("Raleway", Font.PLAIN, 20));
        add(labelphone);

        lblphone = new JLabel("");
        lblphone .setBounds(220, 410, 250, 20);
        lblphone .setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblphone);

        //total price

        JLabel labelprice = new JLabel("Total Price");
        labelprice .setBounds(40, 460, 150, 20);
        labelprice .setFont(new Font("Raleway", Font.PLAIN, 20));
        add(labelprice);

        lblprice = new JLabel("");
        lblprice .setBounds(220, 460, 150, 20);
        lblprice .setFont(new Font("Raleway", Font.PLAIN, 20));
        add(lblprice);

        //check price button
        checkprice = new JButton("Check Price");
        checkprice.setBounds(60, 580, 170, 40);
        checkprice.setFont(new Font("Raleway", Font.BOLD, 20));
        checkprice.setForeground(Color.WHITE);
        checkprice.setBackground(Color.BLACK);
        checkprice.addActionListener(this);
        add(checkprice);

        //Book Package Button
        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(260, 580, 170, 40);
        bookpackage.setFont(new Font("Raleway", Font.BOLD, 20));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBackground(Color.BLACK);
        bookpackage.addActionListener(this);
        add(bookpackage);

        //Back Button
        back = new JButton("Back");
        back.setBounds(460, 580, 170, 40);
        back.setFont(new Font("Raleway", Font.BOLD, 20));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        //adding image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(650, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 32, 585, 500);
        add(image);


        try
        {
            Conn c = new Conn();
            String query = "select * from Customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                lblusername.setText(rs.getString("username"));
                lblid.setText(rs.getString("id"));
                lblnumber.setText(rs.getString("number"));
                lblphone.setText(rs.getString("phone"));
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

        if(ae.getSource() == checkprice)
        {
            if(tftotalpersons.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Total Persons Field Cannot be Empty");
                setVisible(false);
            }
            else
            {
                String pack = selectpackage.getSelectedItem();
                int cost = 0;
                if(pack.equals("Gold Package"))
                {
                    cost += 48000;
                }
                else if(pack.equals("Silver Package"))
                {
                    cost += 32000;
                }
                else //bronze package
                {
                    cost += 20000;
                }

                int persons = Integer.parseInt(tftotalpersons.getText());
                cost *= persons;
                lblprice.setText("Rs "+cost);
            }
        }
        else if(ae.getSource() == bookpackage)
        {
            try
            {
                Conn c = new Conn();
                c.s.executeUpdate("insert into Bookpackage values('"+lblusername.getText()+"', '"+selectpackage.getSelectedItem()+"', '"+tftotalpersons.getText()+"', '"+lblid.getText()+"', '"+lblnumber.getText()+"', '"+lblphone.getText()+"', '"+lblprice.getText()+"')");
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookPackage("sanchit@123");
    }
}
