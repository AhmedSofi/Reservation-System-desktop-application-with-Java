import java.sql.*;

public class Flight_SQL
{
//    public static void print_flight()
//    {
//        try
//        {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con= DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/reservationsystem?characterEncoding=utf8","root","Sofi@123");
//            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery("SELECT * FROM flight");
//            while(rs.next())
//                System.out.println("Flight_ID: "+rs.getInt(1)+" | Origin:  "+rs.getString(2)+" | Destination:  "+rs.getString(3)+" | Time: "+rs.getString(4)+" | Base: "+rs.getInt(5)+" | Plane_ID: "+rs.getInt(6));
//            con.close();
//        }
//        catch(Exception e){ System.out.println(e);}
//
//
//
//
//    }

    private static Connection con=null;
    private static Statement stmt=null;
    private static PreparedStatement ps=null;
    private static ResultSet rs = null;
    public static void Print_flight() {


        try
        {
            con = SQL.getConnection();
            stmt=con.createStatement();
            rs=stmt.executeQuery("select *from flight");
            while(rs.next())
                System.out.println("flight_ID: "+rs.getInt(1)+" | Origin : "+rs.getString(2)+" | Destination :  "+rs.getString(3)+" | Time: "+rs.getString(4)+" | Base: "+rs.getInt(5)+" | Plane_Id: "+rs.getInt(6));

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
    public static void Add_flight(int flight_id,String origin,String destination,String time,int base,int plane_id)  {




        try{

            con = SQL.getConnection();
            ps=con.prepareStatement("insert into flight( Flight_ID, Origin, Destination, Time, Base, Plane_ID )values(?,?,?,?,?,?)");
            ps.setInt(1,flight_id);
            ps.setString(2,origin);
            ps.setString(3,destination);
            ps.setString(4,time);
            ps.setInt(5,base);
            ps.setInt(6,plane_id);
            int result=ps.executeUpdate();
            System.out.println(result+" records affected");
            con.close();

        }catch(Exception e){
            System.out.println(e);
        }
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

    public static void Delete_plane(int plane_id) {
        try {
            con = SQL.getConnection();
            ps=con.prepareStatement("delete from plane where Plane_ID='"+plane_id+"'");
            int result=ps.executeUpdate();
            System.out.println(result+" records affected");
            con.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
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

    public static void Update_Customer(int plane_id,int noBusinessSeats,int noEconomySeats)  {
        try {
            con = SQL.getConnection();
            ps=con.prepareStatement("update plane set  NoBusinessSeats =?,NoEconomySeats=? where Plane_ID='"+plane_id+"'");
            ps.setInt(1,noBusinessSeats);
            ps.setInt(2,noEconomySeats);
            int result=ps.executeUpdate();
            System.out.println(result+" records affected");
            con.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
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
