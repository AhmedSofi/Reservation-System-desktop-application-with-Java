import java.sql.*;

public class Plane_SQL
{
//    public static void print_plane()
//    {
//        try
//        {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con=DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/reservationsystem?characterEncoding=utf8","root","Sofi@123");
//            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery("SELECT * FROM plane");
//            while(rs.next())
//                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3));
//            con.close();
//        }
//        catch(Exception e){ System.out.println(e);}
//
//    }
    private static Connection con=null;
    private static Statement stmt=null;
    private static PreparedStatement ps=null;
    private static ResultSet rs = null;
    public static void Print_Plane() {




        try{
            con = SQL.getConnection();
            stmt=con.createStatement();
            rs=stmt.executeQuery("select *from plane");
            while(rs.next())
                System.out.println("plane_ID: "+rs.getInt(1)+" | NoBusinessSeats : "+rs.getInt(2)+" | NoEconomySeats :  "+rs.getInt(3));

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
    public static void Add_Plane(int plane_id,int noBusinessSeats,int noEconomySeats)  {




        try{

            con = SQL.getConnection();
            ps=con.prepareStatement("insert into plane(Plane_ID,NoBusinessSeats,NoEconomySeats )values(?,?,?)");
            ps.setInt(1,plane_id);
            ps.setInt(2,noBusinessSeats);
            ps.setInt(3,noEconomySeats);
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
    public static void Update_Plane(int plane_id,int noBusinessSeats,int noEconomySeats)  {
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
    public static int NumberOfAvailableSeats(int id)
    {
        int sum=0;
        try {
            con = SQL.getConnection();
            ps=con.prepareStatement("select * from plane where Plane_ID=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();
            rs.next();
            sum= (rs.getInt(2)+rs.getInt(3));
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
        return sum;
    }
    public static int NumberOfEconomy(int id)
    {
        int sum=0;
        try {
            con = SQL.getConnection();
            ps=con.prepareStatement("select * from plane where Plane_ID=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();
            rs.next();
            sum= rs.getInt(3);
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
        return sum;
    }
    public static int NumberOfBusiness(int id)
    {
        int sum=0;
        try {
            con = SQL.getConnection();
            ps=con.prepareStatement("select * from plane where Plane_ID=?");
            ps.setInt(1,id);
            rs=ps.executeQuery();
            rs.next();
            sum= rs.getInt(2);
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
        return sum;
    }

}
