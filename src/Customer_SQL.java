import java.sql.*;

public class Customer_SQL
{
    private static Connection con=null;
   private static Statement stmt=null;
   private static PreparedStatement ps=null;
    private static ResultSet rs = null;
    public static void Print_Customer()  {




            try{
                con = SQL.getConnection();

                stmt=con.createStatement();
                rs=stmt.executeQuery("select *from customer");
                while(rs.next())
                    System.out.println("Customer_ID: "+rs.getInt(1)+" | Name : "+rs.getString(2)+" | Email :  "+rs.getString(3));

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
    public static void Add_Customer(int customer_id,String Name,String Email)  {




        try{
            con = SQL.getConnection();
            ps=con.prepareStatement("insert into customer(Customer_ID,Name,Email )values(?,?,?)");
            ps.setInt(1,customer_id);
            ps.setString(2,Name);
            ps.setString(3,Email);
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

    public static void Delete_Customer(int customer_id) {
        try {
            con = SQL.getConnection();
            ps=con.prepareStatement("delete from customer where Customer_ID='"+customer_id+"'");
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
    public static void Update_Customer(int customer_id,String Name,String Email)  {
        try {
            con = SQL.getConnection();
            ps=con.prepareStatement("update customer set  Name =?,Email=? where Customer_ID='"+customer_id+"'");
            ps.setString(1,Name);
            ps.setString(2,Email);
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

