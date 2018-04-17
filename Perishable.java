//gui
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Perishable extends FoodItem
{
    protected int expiration;

    static protected JLabel inputExpireLabel;
    static protected JTextField inputExpireField;

    public Perishable(String itemName, double itemPrice,double purchfor, int numItem, String IDnum, int expire)//, String itemtype)
    {
        super(itemName,itemPrice,purchfor,numItem,IDnum);//,itemtype);
        this.itemtype = "Perishable";
        expiration = expire;
    }

    public Perishable()
    {
        super();
        // this.shelfprice = 0;
        // this.name = "";
        // this.purchasedfor = 0;
        // this.quantity = 0;
        // this.ID=0;
        this.itemtype = "Perishable";
        this.expiration = 0;
    }

    public void getGuiPanel()
    {
        super.getGuiPanel();
        // this.name = inputNameField.getText();
        // this.shelfprice = Double.parseDouble(inputPriceField.getText());
        // this.purchasedfor = Double.parseDouble(inputOrigPriceField.getText());
        // this.quantity = Integer.parseInt(inputQuantField.getText());
        // this.ID= Integer.parseInt(inputIDField.getText());
        this.itemtype = "Perishable";
        this.expiration = Integer.parseInt(inputExpireField.getText());
    }

    public int setGuiPanel(JPanel contentPane)//, Item inputItem)
    {            //gui
        int y = super.setGuiPanel(contentPane);
        //takes y from item setGUI to properly place more specific fields
        inputExpireLabel = new JLabel("Enter Expiration Date:");
        inputExpireLabel.setBounds(10,y,200,35);
        inputExpireField = new JTextField(5);
        inputExpireField.setBounds(250,y,200,35);
        inputExpireField.setText(Integer.toString(this.expiration));
        y+=30;

        contentPane.add(inputExpireLabel);
        contentPane.add(inputExpireField);
        
        return y;
    }

    public String getLocation()
    {
        return "Aisle 1"; 
    }

    public int getexpire()
    {
        return expiration;
    }

    public String toString ()
    {
        String str = super.toString(); //polymorphic?
        str += String.format("%-15s", getLocation());
        str += String.format("%-15s", getexpire()+" day(s)");
        return str;
    }

}
