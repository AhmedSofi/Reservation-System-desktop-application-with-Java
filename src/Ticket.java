import java.util.ArrayList;

public abstract class Ticket
{
    protected Flight flight;
    protected String SeatNumber;
    String meal;

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }


    private static int count=300;
    private int Ticket_id=-1;
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


    public int getTicket_id() {
        return Ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        Ticket_id = ticket_id;
    }

    public Ticket(Flight flight, String seatNumber)
    {
        this.flight = flight;
        this.SeatNumber = seatNumber;
        if(Ticket_id==-1)
        {
            Ticket_id=count;
        }
        count++;
    }
    protected void printTicket()
    {
        System.out.println(flight.getPlane().getNoBusinessSeats()+" "+flight.getPlane().getNoEconomySeats()+" "+flight.getOrigin()+" "+flight.getDestination()+" "+flight.getTime()+" "+SeatNumber);

    }
    abstract void ReserveTicket();
    abstract boolean CheckSeats();
    abstract int base(int x);


}
