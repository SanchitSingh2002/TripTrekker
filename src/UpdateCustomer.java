
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener {


    JLabel lblusername, labelname, labelgender, labeladdress, labelcountry, labelemail, labelphone;
    JTextField tfcountry, tfaddress, tfemail, tfphone, tfnumber, tfid, tfgender;

    JButton update, back;

    UpdateCustomer(String usrname)
    {
        setBounds(250, 50, 850, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

//        JLabel text = new JLabel("Update Customer Details");
//        text.setBounds(27, 0, 400, 20);
//        text.setFont(new Font("Raleway", Font.BOLD, 20));
//        text.setForeground(Color.BLUE);
//        add(text);

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

        tfid = new JTextField();
        tfid.setBounds(270, 70, 200, 30);
        tfid.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(tfid);


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

        tfgender = new JTextField();
        tfgender.setBounds(270, 220, 200, 30);
        tfgender.setFont(new Font("Raleway", Font.PLAIN, 15));
        tfgender.setBackground(Color.WHITE);
        add(tfgender);


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

        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(70, 500, 100, 30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(230, 500, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(410, 20, 500, 500);
        add(image);

        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Customer where username='"+usrname+"'");
            while(rs.next())
            {
                lblusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfemail.setText(rs.getString("email"));
                tfnumber.setText(rs.getString("number"));
                tfphone.setText(rs.getString("phone"));
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
        if(ae.getSource() == update)
        {
            String username = lblusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            try
            {
                Conn c = new Conn();
                String query = "update Customer set username = '"+username+"', id='"+id+"', number='"+number+"', name='"+name+"', gender='"+gender+"', country= '"+country+"', address='"+address+"', phone='"+phone+"', email= '"+email+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Customer Details Updated Successfully");
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
