import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Ticket_SQL
{
    private static Connection con=null;
    private static Statement stmt=null;
    private static PreparedStatement ps=null;
    private static ResultSet rs = null;

    public static void Print_Ticket()  {




        try{
            con = SQL.getConnection();
            stmt=con.createStatement();
            rs=stmt.executeQuery("select *from ticket");
            while(rs.next())
                System.out.println("Tichet_ID: "+rs.getInt(1)+" | Seat_Number : "+rs.getString(2)+" | Type :  "+rs.getString(3)+" | Meal :  "+rs.getString(4)+" | Price :  "+rs.getInt(5)+" | Flight_ID :  "+rs.getInt(6)+" | Customer_ID :  "+rs.getInt(7));

            con.close();

        }catch(Exception e){ System.out.println(e);}
        finally {
            try
            {
                if(rs!=null){
                    rs.close();
                }if (ps!=null){
                ps.close();
            }if(con!=null){
                con.close();
            }

            }
            catch (Exception e)
            {
                System.out.println(e);
            }

        }

    }
    public static void Add_Ticket(int ticket_ID,String seat_Number,String type,String meal,int price,int flight_ID,int customer_ID)  {




        try{
            con = SQL.getConnection();
            ps=con.prepareStatement("insert into (Tichet_ID,Seat_Number,Type,Meal,Price,Flight_ID,Customer_ID )values(?,?,?,?,?,?,?)");
            ps.setInt(1,ticket_ID);
            ps.setString(2,seat_Number);
            ps.setString(3,type);
            ps.setString(4,meal);
            ps.setInt(5,price);
            ps.setInt(6,flight_ID);
            ps.setInt(7,customer_ID);


            int result=ps.executeUpdate();
            System.out.println(result+" records affected");
            con.close();

        }catch(Exception e){ System.out.println(e);}
        finally {
            try
            {
                if(rs!=null){
                    rs.close();
                }if (ps!=null){
                ps.close();
            }if(con!=null){
                con.close();
            }

            }
            catch (Exception e)
            {
                System.out.println(e);
            }

        }

    }


}
