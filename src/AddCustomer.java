
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {


    JLabel lblusername, labelname, labelgender, labeladdress, labelcountry, labelemail, labelphone;
    JRadioButton rmale, rfemale;
    JComboBox comboid;
    JTextField tfcountry, tfaddress, tfemail, tfphone, tfnumber;

    JButton add, back;

    AddCustomer(String usrname)
    {
        setBounds(250, 50, 850, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel username = new JLabel("Username");
        username.setBounds(30, 20, 200, 30);
        username.setFont(new Font("Raleway", Font.BOLD, 22));
        add(username);

        lblusername = new JLabel("");
        lblusername.setBounds(270, 20, 200, 30);
        lblusername.setFont(new Font("Raleway", Font.BOLD, 22));
        lblusername.setForeground(Color.RED);
        add(lblusername);

        JLabel id = new JLabel("Identity Proof");
        id.setBounds(30, 70, 200, 30);
        id.setFont(new Font("Raleway", Font.BOLD, 22));
        add(id);

        comboid = new JComboBox(new String[] {"Passport", "Aadhar Card", "Ration Card", "Pan Card"});
        comboid.setBounds(270, 70, 200, 30);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel number = new JLabel("Number");
        number.setBounds(30, 125, 200, 30);
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        add(number);

        tfnumber = new JTextField();
        tfnumber.setBounds(270, 130, 200, 30);
        tfnumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(tfnumber);

        JLabel name = new JLabel("Name");
        name.setBounds(30, 170, 200, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        add(name);

        labelname = new JLabel("");
        labelname.setBounds(270, 170, 200, 30);
        labelname.setFont(new Font("Raleway", Font.BOLD, 22));
        labelname.setForeground(Color.RED);
        add(labelname);

        labelgender = new JLabel("Gender");
        labelgender.setBounds(30, 215, 200, 30);
        labelgender.setFont(new Font("Raleway", Font.BOLD, 22));
        add(labelgender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(270, 220, 100, 30);
        rmale.setFont(new Font("Raleway", Font.BOLD, 15));
        rmale.setBackground(Color.WHITE);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(380, 220, 100, 30);
        rfemale.setFont(new Font("Raleway", Font.BOLD, 15));
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        labelcountry = new JLabel("Country");
        labelcountry.setBounds(30, 260, 200, 30);
        labelcountry.setFont(new Font("Raleway", Font.BOLD, 22));
        add(labelcountry);

        tfcountry = new JTextField("");
        tfcountry.setBounds(270, 260, 200, 30);
        tfcountry.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(tfcountry);

        labeladdress = new JLabel("Address");
        labeladdress.setBounds(30, 310, 200, 30);
        labeladdress.setFont(new Font("Raleway", Font.BOLD, 22));
        add(labeladdress);

        tfaddress = new JTextField("");
        tfaddress.setBounds(270, 310, 200, 30);
        tfaddress.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(tfaddress);

        labelemail = new JLabel("Email");
        labelemail.setBounds(30, 360, 200, 30);
        labelemail.setFont(new Font("Raleway", Font.BOLD, 22));
        add(labelemail);

        tfemail = new JTextField("");
        tfemail.setBounds(270, 360, 200, 30);
        tfemail.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(tfemail);

        labelphone = new JLabel("Phone Number");
        labelphone.setBounds(30, 410, 200, 30);
        labelphone.setFont(new Font("Raleway", Font.BOLD, 22));
        add(labelphone);

        tfphone = new JTextField("");
        tfphone.setBounds(270, 410, 200, 30);
        tfphone.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(tfphone);

        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70, 500, 100, 30);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(230, 500, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 585, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(440, 60, 450, 420);
        add(image);

        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username='"+username+"'");
            while(rs.next())
            {
                lblusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
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
        if(ae.getSource() == add)
        {
            String username = lblusername.getText();
            String id = (String)comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;
            if(rmale.isSelected())
            {
                gender = "Male";
            }
            else
            {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            try
            {
                Conn c = new Conn();
                String query = "insert into Customer values('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                setVisible(false);
            }
            catch(Exception e)
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
        new UpdateCustomer("sanchit@123");
    }
}
