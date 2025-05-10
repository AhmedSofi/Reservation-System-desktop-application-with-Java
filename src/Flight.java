import java.util.ArrayList;

public class Flight
{
    private Plane plane;
    private String Origin;
    private String Destination;
    private  String Time;
    private int BasePrice;
    private static int count=0;
    private int flight_id=-1;

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }





    //private static ArrayList<Flight>allFlight=new ArrayList<>();
    public Flight(Plane plane, String origin, String destination, String time,int baseprice) {
//        this.allFlight.add(this);
        this.plane = plane;
        this.Origin = origin;
        this.Destination = destination;
        this.Time = time;
        this.BasePrice=baseprice;
        try {
            if(flight_id==-1)
            {
                flight_id=count;
            }
            Flight_SQL.Add_flight(count,origin,destination,time,baseprice,plane.getPlane_id());
            count++;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }



    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
    public int getBasePrice()
    {
        return BasePrice;
    }

    public void setBasePrice(int basePrice)
    {
        BasePrice = basePrice;
    }

    public static void showAllFlights()
    {
//        for (Flight x:allFlight)
//        {
//            System.out.println(x.getPlane().getNoBusinessSeats()+" "+x.getPlane().getNoEconomySeats()+" "+x.getOrigin()+" "+x.getDestination()+" "+x.getTime());
//        }
        Flight_SQL.Print_flight();
    }
    public void showNumberOfAvailableSeats()
    {

//        int number=(plane.getNoBusinessSeats()+ plane.getNoEconomySeats());
        int number=(Plane_SQL.NumberOfAvailableSeats(plane.getPlane_id()));
        System.out.println(number);

    }
    public boolean CheckEconomyTicketsAvailability(int x)
    {
        return (x<=Plane_SQL.NumberOfEconomy(plane.getPlane_id()));
    }
    public int CheckEconomyTicketsAvailability()
    {
        return Plane_SQL.NumberOfEconomy(plane.getPlane_id());
    }
    public void ReserveBusinessTicket()
    {
        //plane.NoBusinessSeats--;
        int B=Plane_SQL.NumberOfBusiness(plane.getPlane_id());
        int E=Plane_SQL.NumberOfEconomy(plane.getPlane_id());
        Plane_SQL.Update_Plane(plane.getPlane_id(),(--B),(E));
    }
    public void ReserveEconomyTicket()
    {

       // plane.NoEconomySeats--;
        int B=Plane_SQL.NumberOfBusiness(plane.getPlane_id());
        int E=Plane_SQL.NumberOfEconomy(plane.getPlane_id());
        Plane_SQL.Update_Plane(plane.getPlane_id(),B,(--E));
    }
    public static void addFlight(Flight flight)
    {
      //  allFlight.add(flight);
    }

}
