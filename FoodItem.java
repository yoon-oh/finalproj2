import java.util.*;
public abstract class FoodItem extends Item
{
    public FoodItem(String itemName, double itemPrice,double purchfor, int numItem, String IDnum)//,String itemtype)
    {
        super(itemName,itemPrice,purchfor,numItem,IDnum);//,itemtype);
        this.itemtype = "FoodItem";
    }
    
    public FoodItem()
    {
        super();
        this.itemtype = "FoodItem";
    }
    
    public String toString ()
    {
        String str = super.toString();
        return str;
    }

    public abstract String getLocation();
}