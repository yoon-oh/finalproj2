public class NonPerishable extends FoodItem
{
    int expiration;
    public NonPerishable(String itemName, double itemPrice,double purchfor, int numItem, String IDnum)//,String itemtype)
    {
        super(itemName,itemPrice,purchfor,numItem,IDnum);//,itemtype);
        this.itemtype = "NonPerishable";
    }

    public NonPerishable()
    {
        super();
        this.itemtype = "NonPerishable";
    }

    public String getLocation()
    {
        return "Aisle 2"; 
    }

    public int getexpire()
    {
        return -1;
    }

    public String toString ()
    {
        String str = super.toString();
        str += String.format("%-10s", getLocation());
        return str;
    }
}
