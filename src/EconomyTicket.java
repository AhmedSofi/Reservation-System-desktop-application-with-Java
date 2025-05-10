public class EconomyTicket extends Ticket
{

    public EconomyTicket(Flight flight, String seatNumber) {
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
    public void setNumberSeats(int x)
    {
        this.flight.getPlane().setNoEconomySeats((this.flight.getPlane().getNoEconomySeats()-x));
    }
    public void ReserveTicket()
    {
        flight.ReserveEconomyTicket();
    }
    public boolean CheckSeats()
    {
        return (flight.getPlane().NoEconomySeats>0);
    }
    public int base(int x)
    {

        return (x);
    }

}
