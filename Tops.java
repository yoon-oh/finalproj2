public class Tops extends ClothItem
{
    public Tops(String itemName, double itemPrice,double purchfor, int numItem, String IDnum, String size)//,String itemtype)
    {
        super(itemName,itemPrice,purchfor,numItem,IDnum,size);//,itemtype);
        this.itemtype = "Tops";
    }

    public Tops()
    {
        super();
        this.itemtype = "Tops";
    }

    //public abstract String getLocation();
        public String getLocation()
    {
        return "Aisle 4"; 
    }


    public int getexpire()
    {
        return -1;
    }

    public String toString ()
    {
        String str = super.toString();
        return str;
    }
}
