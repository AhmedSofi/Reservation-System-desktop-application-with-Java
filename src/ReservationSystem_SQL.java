import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReservationSystem_SQL
{   private static Connection con=null;
    private static Statement stmt=null;
    private static PreparedStatement ps=null;
    private static ResultSet rs = null;


      public static void Add_Ticket(int ticket_id, String SeatNumber, String TicketType,String meal,int price,int flight_id,int customer_id)
      {



    try{
        con = SQL.getConnection();
        ps=con.prepareStatement("insert into ticket values(?,?,?,?,?,?,?)");
        ps.setInt(1,ticket_id);
        ps.setString(2,SeatNumber);
        ps.setString(3,TicketType);
        ps.setString(4,meal);
        ps.setInt(5,price);
        ps.setInt(6,flight_id);
        ps.setInt(7,customer_id);
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
