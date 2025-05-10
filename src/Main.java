// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Customer customer1 = new Customer("Ahmed","ahmd@gmail.com");
        Customer customer2 = new Customer("mohamed","mohamed@gmail.com");
        Customer customer3 = new Customer("Mahmoud","Mahmoud@gmail.com");


        Plane p1= new Plane(2,18);  // NoBusinessSeats - NoEconomySeats
        Plane p2= new Plane(4,8);

        Flight flight1 = new Flight(p1,"CAI","ITA","2023-08-24T22:45:00",100); // Plane - Origin - Destination - Time
        Flight flight2 = new Flight(p2,"CAI","MGD","2023-08-29T20:15:00",50);

        Ticket ticket1 = new BusinessTicket(flight2,"A1"); // Flight, Seat Number
        // Note that Ticket class cannot be initialized.
        customer1.addTicket(ticket1);
        Ticket ticket2 = new EconomyTicket(flight2,"B2");
        customer1.addTicket(ticket2);
        ticket1.printTicket();
        BusinessTicket ticket3 = new BusinessTicket(flight1,"C3");
        customer2.addTicket(ticket3);
        ticket3.addSpecialMeal("sushi");
        ticket3.printTicket();

        Flight.showAllFlights();

        flight1.showNumberOfAvailableSeats();
       boolean isAvailable = flight1.CheckEconomyTicketsAvailability(2);// number of reservation needed seats
        System.out.println(isAvailable);
        int numberOfAvailableTickets = flight1.CheckEconomyTicketsAvailability();
        System.out.println(numberOfAvailableTickets);

          ReservationSystem.showCustomerDetails(customer3);
       try {
           ReservationSystem.reserve(1,customer3, flight2, "b"); // Number of Seats,Customer ,flight, Ticket Type
       }catch(NoAvailableTicketsException e ){
           System.out.println("no Tickets Enough");
       }
       ReservationSystem.showCustomerDetails(customer3);
       ReservationSystem.showTicketDetails(ticket1);
       ReservationSystem.showTicketDetails(ticket2);
//       //System.out.println(ticket3.getClass()== BusinessTicket.class);
   //  Customer_SQL.Print_Customer();
      //Customer_SQL.Add_Customer(4,"Soufi","So@gmail");
     // Customer_SQL.Print_Customer();
      // Customer_SQL.Update_Customer(3,"Ali","");

    }
}