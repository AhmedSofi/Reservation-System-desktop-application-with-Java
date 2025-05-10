public class ReservationSystem
{


    public static void showCustomerDetails(Customer customer)
    {
//        System.out.println(customer.getName()+" "+customer.getEmail());
        Customer_SQL.Print_Customer();
    }

    public static void reserve(int NumberOfSeats, Customer customer, Flight flight, String TicketType) throws NoAvailableTicketsException
    {
        int sum=0;
        Ticket ticket;
        if(TicketType=="economy")
        {
            ticket=new EconomyTicket(flight,"AA");


        }
        else
        {
            ticket=new BusinessTicket(flight,"BB");

        }

        while (ticket.CheckSeats()&NumberOfSeats>0)
        {


            customer.addTicket(ticket);
            ReservationSystem_SQL.Add_Ticket(ticket.getTicket_id(),ticket.getSeatNumber(),TicketType,ticket.meal,Price.CalculatePrice(ticket),flight.getFlight_id(),customer.getCustomer_id());
            NumberOfSeats--;
            ticket.ReserveTicket();
            sum+=Price.CalculatePrice(ticket);


        }
        if(NumberOfSeats>0)
        {
            throw new NoAvailableTicketsException();
        }
        else
        {
            System.out.println(sum);
        }
    }
    public static void showTicketDetails(Ticket ticket)
    {
        //ticket.printTicket();
        Ticket_SQL.Print_Ticket();
    }

}
