import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {

    JButton create;
    JButton back;

    JTextField tfname, tfusername, tfpassword, tfanswer;

    Choice security;

    Signup()
    {
        setBounds(250, 200, 900, 360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblusername.setBounds(50, 20, 125, 25);
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(190, 20, 200, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        //name field
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblname.setBounds(50, 75, 125, 25);
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(190, 75, 200, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        //password field
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblpassword.setBounds(50, 130, 125, 25);
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(190, 130, 200, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        //security question
        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblsecurity.setBounds(50, 180, 125, 25);
        p1.add(lblsecurity);

        //choice
        security = new Choice();
        security.add("Fav character from THE BOYS");
        security.add("Favourite Marvel superhero");
        security.add("your lucky number");
        security.add("your childhood superhero");
        security.setBounds(190, 180, 200, 25);
        p1.add(security);

        //security answer
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblanswer.setBounds(50, 230, 125, 25);
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(190, 230, 200, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        //create button
        create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133, 193, 233));
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.setBounds(80, 280, 120, 30);
        create.addActionListener(this);
        p1.add(create);

        //back button
        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133, 193, 233));
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBounds(240, 280, 120, 30);
        back.addActionListener(this);
        p1.add(back);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);


        setVisible(true);
    }



    public static void main(String[] args) {
        new Signup();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == create)
        {
            String username = tfusername.getText();
            String name = tfname.getText();
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name Field should not be Empty");
                return;
            } else if (name.length() < 3) {
                JOptionPane.showMessageDialog(null, "Please Enter your Full Name");
                return;
            }
            String password = tfpassword.getText();
            if(password.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Password Field Cannot be Empty");
                return;
            }
            String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
            if(!password.matches(pattern)) {
                JOptionPane.showMessageDialog(null, "Password is Weak");
                return;
            }
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();
            if(answer.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Answer Field Cannot be Empty");
                return;
            }

            String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
            try{
                Conn c = new Conn();
                //step4-> executing the mysql query
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new Login();
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
    }
}
