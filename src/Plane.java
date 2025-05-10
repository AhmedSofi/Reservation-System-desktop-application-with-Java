public class Plane
{
    protected   int NoBusinessSeats;
    protected   int NoEconomySeats;
    private static int count=100;
    protected int plane_id=-1;

    public int getPlane_id() {
        return plane_id;
    }

    public void setPlane_id(int plane_id) {
        this.plane_id = plane_id;
    }

    public Plane(int noBusinessSeats, int noEconomySeats)
    {

        NoBusinessSeats = noBusinessSeats;
        NoEconomySeats = noEconomySeats;
        try
        {
            if(plane_id==-1)
            {
                plane_id=count;
            }
            Plane_SQL.Add_Plane(count,NoBusinessSeats,NoEconomySeats);

            count++;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    public int getNoBusinessSeats() {
        return NoBusinessSeats;
    }

    public void setNoBusinessSeats(int noBusinessSeats) {
        NoBusinessSeats = noBusinessSeats;
    }

    public int getNoEconomySeats() {
        return NoEconomySeats;
    }

    public void setNoEconomySeats(int noEconomySeats)
    {
        NoEconomySeats = noEconomySeats;
    }




}
