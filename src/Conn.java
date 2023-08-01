import java.sql.*;
public class Conn {

    Connection c;
    Statement s;
    Conn()
    {
        try{
            //step1 -> registering the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            // step->2 creating the connection string
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem","root", "sanchitsingh");
            //step-3 executing the mysql queries
            s = c.createStatement();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
