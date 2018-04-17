public abstract class Electronic extends Item
{
   public Electronic(String itemName, double itemPrice,double purchfor, int numItem, String IDnum)//,String itemtype)
   {
        super(itemName,itemPrice,purchfor,numItem,IDnum);//,itemtype);
        this.itemtype = "Electronic";

   }

    public Electronic()
    {
        super();
        this.itemtype = "Electronic";
    }
   
   public abstract int getexpire();
   
   public abstract String getLocation();
}