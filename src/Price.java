public class Price
{

    public static int CalculatePrice(Ticket ticket)
    {
        int x=ticket.getFlight().getBasePrice();
        int sum =ticket.base(x);
        return sum;
    }


}
// A x =new B
// B x = new A
