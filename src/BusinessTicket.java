import java.util.ArrayList;

public class BusinessTicket extends Ticket implements specialMeal
{


    public String SpecialMeal="";

    public String getSpecialMeal() {
        return SpecialMeal;
    }

    public void setSpecialMeal(String specialMeal) {
        SpecialMeal = specialMeal;
    }

    public BusinessTicket(Flight flight, String seatNumber)
    {
        super(flight,seatNumber);

    }
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getSeatNumber() {
        return SeatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        SeatNumber = seatNumber;
    }

    public void printTicket()
    {
        System.out.println(getFlight().getPlane().getNoBusinessSeats()+" "+getFlight().getPlane().getNoEconomySeats()+" "+getFlight().getOrigin()+" "+getFlight().getDestination()+" "+getFlight().getTime()+" "+getSeatNumber());
    }


    public void setNumberBusinessSeats(int x)
    {
        this.flight.getPlane().setNoBusinessSeats((this.flight.getPlane().getNoBusinessSeats()-x));
    }
    public void ReserveTicket()
    {
        flight.ReserveBusinessTicket();
    }
    public boolean CheckSeats()
    {
        return (flight.getPlane().NoBusinessSeats>0);
    }
    public void addSpecialMeal(String s)
    {
        this.SpecialMeal=s;
        super.meal=s;
    }
    public int base(int x)
    {
        int d=0;
        if(!SpecialMeal.isEmpty())
        {
            d=(x-(x*(10/100)));
        }
        return ((x*2)+d);
    }



}
