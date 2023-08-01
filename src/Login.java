import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton fpassword, signup, login;
    JTextField tfusername, tfuserpassword;

    Login()
    {
        setSize(900, 400);
        setLocation(250, 200);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        //username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 20, 100, 25);
        lblusername.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        p2.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        //userpassword
        JLabel lbluserpasswd = new JLabel("Password");
        lbluserpasswd.setBounds(60, 115, 100, 25);
        lbluserpasswd.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        p2.add(lbluserpasswd);

        tfuserpassword = new JTextField();
        tfuserpassword.setBounds(60, 150, 300, 30);
        tfuserpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfuserpassword);

        //LoginButton
        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
        p2.add(login);

        //LoginButton
        signup = new JButton("Signup");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.addActionListener(this);
        p2.add(signup);

        //Forgot Password button
        fpassword = new JButton("Forgot Password");
        fpassword.setBounds(160, 250, 130, 30);
        fpassword.setBackground(new Color(133, 193, 233));
        fpassword.setForeground(Color.WHITE);
        fpassword.setBorder(BorderFactory.createEmptyBorder());
        fpassword.addActionListener(this);
        p2.add(fpassword);

        //text-> trouble in login

        JLabel text = new JLabel("trouble in login");
        text.setBounds(300, 250, 130, 30);
        text.setForeground(Color.RED);
        p2.add(text);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == fpassword)
        {
            setVisible(false);
            new ForgetPassword();
        }
        else if(ae.getSource() == signup)
        {
            setVisible(false);
            new Signup();
        }
        else if(ae.getSource() == login)
        {
            try
            {
                String username = tfusername.getText();
                String password = tfuserpassword.getText();

                String query = "select * from account where username= '"+username+"' and password =  '"+password+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Loading(username);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
