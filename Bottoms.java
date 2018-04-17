public class Bottoms extends ClothItem
{
    public Bottoms(String itemName, double itemPrice,double purchfor, int numItem, String IDnum, String size)//,String itemtype)
    {
        super(itemName,itemPrice,purchfor,numItem,IDnum,size);//,itemtype);
        this.itemtype = "Bottoms";
    }

    public Bottoms()
    {
        super();
        this.itemtype = "Bottoms";
    }

    public int getexpire()
    {
        return -1;
    }

    //public abstract String getLocation();
        public String getLocation()
    {
        return "Aisle 3"; 
    }

}
