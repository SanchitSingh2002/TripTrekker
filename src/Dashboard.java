import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton personalDetails, viewpersonalDetails, updatepersonalDetails, checkPackages,bookpackages, viewpackages;
    Dashboard(String username)
    {
        this.username = username;
        //setBounds(0,0, 1366, 768);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        //panel for displaying the logo
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0, 102));
        p1.setBounds(0, 0, 1366, 50);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(85, 12, 200, 30);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        p1.add(heading);

        //Panel for displaying all the buttons

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0, 102));
        p2.setBounds(0, 50, 250, 900);
        add(p2);

        //add personal details
        personalDetails = new JButton("Add Personal Details");
        personalDetails.setBounds(0, 0, 265, 44);
        personalDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
        personalDetails.setBackground(Color.PINK);
        personalDetails.setMargin(new Insets(0,0, 0, 50));
        personalDetails.addActionListener(this);
        p2.add(personalDetails);

        //update personal details
        updatepersonalDetails = new JButton("Update Personal Details");
        updatepersonalDetails.setBounds(0, 44, 265, 44);
        updatepersonalDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
        updatepersonalDetails.setBackground(Color.PINK);
        updatepersonalDetails.setMargin(new Insets(0,0, 0, 30));
        updatepersonalDetails.addActionListener(this);
        p2.add(updatepersonalDetails);

        //view personal details
        viewpersonalDetails = new JButton("View Personal Details");
        viewpersonalDetails.setBounds(0, 88, 265, 44);
        viewpersonalDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
        viewpersonalDetails.setBackground(Color.PINK);
        viewpersonalDetails .setMargin(new Insets(0,0, 0, 50));
        viewpersonalDetails.addActionListener(this);
        p2.add(viewpersonalDetails);

        //delete personal details
        JButton deletepersonalDetails = new JButton("Delete Personal Details");
        deletepersonalDetails.setBounds(0, 132, 265, 44);
        deletepersonalDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
        deletepersonalDetails.setBackground(Color.PINK);
        deletepersonalDetails .setMargin(new Insets(0,0, 0, 38));
        p2.add(deletepersonalDetails);

        //check Package
        checkPackages = new JButton("Check Packages");
        checkPackages.setBounds(0, 176, 265, 44);
        checkPackages.setFont(new Font("Tahoma", Font.BOLD, 16));
        checkPackages.setBackground(Color.PINK);
        checkPackages.setMargin(new Insets(0,0, 0, 99));
        checkPackages.addActionListener(this);
        p2.add(checkPackages);

        //book Packages
        bookpackages = new JButton("Book Package");
        bookpackages.setBounds(0, 220, 265, 44);
        bookpackages.setFont(new Font("Tahoma", Font.BOLD, 16));
        bookpackages.setBackground(Color.PINK);
        bookpackages.setMargin(new Insets(0,0, 0, 112));
        bookpackages.addActionListener(this);
        p2.add(bookpackages);

        //view Packages
        viewpackages = new JButton("View Package");
        viewpackages.setBounds(0, 264, 265, 44);
        viewpackages.setFont(new Font("Tahoma", Font.BOLD, 16));
        viewpackages.setBackground(Color.PINK);
        viewpackages.setMargin(new Insets(0,0, 0, 112));
        viewpackages.addActionListener(this);
        p2.add(viewpackages);

        //view hotels
        JButton viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0, 308, 265, 44);
        viewhotels.setFont(new Font("Tahoma", Font.BOLD, 16));
        viewhotels.setBackground(Color.PINK);
        viewhotels.setMargin(new Insets(0,0, 0, 125));
        p2.add(viewhotels);

        //Book Hotels
        JButton bookhotels = new JButton("Book Hotel");
        bookhotels.setBounds(0, 352, 265, 44);
        bookhotels.setFont(new Font("Tahoma", Font.BOLD, 16));
        bookhotels.setBackground(Color.PINK);
        bookhotels.setMargin(new Insets(0,0, 0, 126));
        p2.add(bookhotels);

        //view Booked Hotels
        JButton viewbookedhotel = new JButton("View Booked Hotel");
        viewbookedhotel.setBounds(0, 396, 265, 44);
        viewbookedhotel.setFont(new Font("Tahoma", Font.BOLD, 16));
        viewbookedhotel.setBackground(Color.PINK);
        viewbookedhotel.setMargin(new Insets(0,0, 0, 65));
        p2.add(viewbookedhotel);

        //Destinations
        JButton destinations = new JButton("Destinations");
        destinations.setBounds(0, 440, 265, 44);
        destinations.setFont(new Font("Tahoma", Font.BOLD, 16));
        destinations.setBackground(Color.PINK);
        destinations.setMargin(new Insets(0,0, 0, 112));
        p2.add(destinations);

        //Payments
        JButton payments = new JButton("Payments");
        payments.setBounds(0, 484, 265, 44);
        payments.setFont(new Font("Tahoma", Font.BOLD, 16));
        payments.setBackground(Color.PINK);
        payments.setMargin(new Insets(0,0, 0, 128));
        p2.add(payments);

        //calculator
        JButton calculator = new JButton("Calculator");
        calculator.setBounds(0, 528, 265, 44);
        calculator.setFont(new Font("Tahoma", Font.BOLD, 16));
        calculator.setBackground(Color.PINK);
        calculator.setMargin(new Insets(0,0, 0, 124));
        p2.add(calculator);

        //notepad
        JButton notepad = new JButton("Notepad");
        notepad.setBounds(0, 572, 265, 44);
        notepad.setFont(new Font("Tahoma", Font.BOLD, 16));
        notepad.setBackground(Color.PINK);
        notepad.setMargin(new Insets(0,0, 0, 131));
        p2.add(notepad);

        //about
        JButton about = new JButton("About");
        about.setBounds(0, 616, 265, 44);
        about.setFont(new Font("Tahoma", Font.BOLD, 16));
        about.setBackground(Color.PINK);
        about.setMargin(new Insets(0,0, 0, 148));
        p2.add(about);

        ImageIcon i4 =new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1600, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);

        JLabel text = new JLabel("TripTrekker Management System");
        text.setBounds(480, 10, 800, 150);
        text.setFont(new Font("Raleway", Font.PLAIN, 45));
        text.setForeground(Color.WHITE);
        image.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        
        if(ae.getSource() == personalDetails)
            new UpdateCustomer(username);
        else if(ae.getSource() == viewpersonalDetails)
            new ViewCustomer(username);

        else if (ae.getSource() == updatepersonalDetails)
            new UpdateCustomer("");

        else if(ae.getSource() == checkPackages)
            new Checkpackage();
        else if (ae.getSource() == bookpackages)
            new BookPackage("sanchit@123");
        else if (ae.getSource() == viewpackages)
            new ViewPackage("sanchit@123");
    }

    public static void main(String[] args) {
        new Dashboard("sanchit@123");
    }
}
