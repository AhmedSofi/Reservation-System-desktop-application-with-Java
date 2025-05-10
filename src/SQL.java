import java.sql.*;

class SQL {

   private static Connection con=null;

    public static Connection getConnection()throws ClassNotFoundException, SQLException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/reservationsystem?characterEncoding=utf8","root","Sofi@123");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return con;

    }




}