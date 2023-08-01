
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener {

    JTextField tfusername, tfname, tfsecurityquestion, tfanswer, tfpassword;
    JButton search, retrieve, back;
    ForgetPassword()
    {
        setBounds(300, 200, 850, 380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 280);
        add(p1);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 18));
        p1.add(lblusername);

        //username textfield
        tfusername = new JTextField();
        tfusername.setBounds(220, 20, 150, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        //search button
        search = new JButton("Search");
        search.setBounds(380, 20, 100, 25);
        search.setForeground(Color.WHITE);
        search.setBackground(Color.GRAY);
        search.addActionListener(this);
        p1.add(search);

        JLabel name = new JLabel("Name");
        name.setBounds(40, 55, 100, 25);
        name.setFont(new Font("Tahoma", Font.BOLD, 18));
        p1.add(name);

        tfname = new JTextField();
        tfname.setBounds(220, 55, 150, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel securityqtn = new JLabel("Security Question");
        securityqtn.setBounds(40, 90, 200, 25);
        securityqtn.setFont(new Font("Tahoma", Font.BOLD, 18));
        p1.add(securityqtn);

        tfsecurityquestion = new JTextField();
        tfsecurityquestion.setBounds(220, 90, 150, 25);
        tfsecurityquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfsecurityquestion);


        JLabel lblanswer = new JLabel("Your Answer");
        lblanswer.setBounds(40, 125, 200, 25);
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 18));
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(220, 125, 150, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);


        retrieve = new JButton("Retrieve");
        retrieve.setBounds(380, 125, 100, 25);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBackground(Color.GRAY);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 160, 200, 25);
        password.setFont(new Font("Tahoma", Font.BOLD, 18));
        p1.add(password);

        tfpassword = new JTextField();
        tfpassword.setBounds(220, 160, 150, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        back = new JButton("Back");
        back.setBounds(170, 220, 100, 25);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.GRAY);
        back.addActionListener(this);
        p1.add(back);




        setVisible(true);
    }

    public static void main(String[] args) {
        new ForgetPassword();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == search)
        {
            try
            {
                String query = "select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next())
                {
                    tfname.setText(rs.getString("name"));
                    tfsecurityquestion.setText(rs.getString("security"));
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back)
        {
            setVisible(false);
            new Login();
        }
        else if(ae.getSource() == retrieve)
        {
            try
            {
                String query = "select * from account where answer = '"+tfanswer.getText()+"' AND username ='"+tfusername.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next())
                {
                    tfpassword.setText(rs.getString("password"));
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
