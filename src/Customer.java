import java.util.ArrayList;

public class Customer
{

    private String Name;
    private String Email;
    private static int count=1;
    private int Customer_id=-1;
    private ArrayList<Ticket> customerTickets= new ArrayList<>();

    public Customer(String name, String email)
    {
        Name = name;
        Email = email;
        try
        {
            if(Customer_id==-1)
            {
                Customer_id=count;
            }
            Customer_SQL.Add_Customer(count,name,email);
            count++;
        }
        catch (Exception e)
        {
         System.out.println();
        }

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(int customer_id) {
        Customer_id = customer_id;
    }

    public void addTicket(Ticket ticket)
    {
        customerTickets.add(ticket);
    }


}
