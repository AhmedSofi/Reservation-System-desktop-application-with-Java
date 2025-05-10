import java.util.ArrayList;

public class EconomyChildTicket extends EconomyTicket implements specialMeal
{
    String specialMeal="";


    public EconomyChildTicket(Flight flight, String seatNumber) {
        super(flight, seatNumber);

    }


    public void addSpecialMeal(String s)
    {
        specialMeal=s;
        super.meal=s;
    }

    public int base(int x)
   {
       int d=0;
       if(!specialMeal.isEmpty())
       {
           d=(x-(x*(10/100)));
       }
       return ((x/2)+d);
   }


}
