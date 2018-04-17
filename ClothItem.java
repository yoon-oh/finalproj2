//gui
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class ClothItem extends Item
{
    protected String clothsize;

    static protected JLabel inputSizeLabel;
    static protected JTextField inputSizeField;

    public ClothItem(String itemName, double itemPrice,double purchfor, int numItem, String IDnum, String size)//, String itemtype)
    {
        super(itemName,itemPrice,purchfor,numItem,IDnum);//,itemtype);
        this.itemtype = "ClothItem";
        this.clothsize=size;

    }

    public ClothItem()
    {
        super();
        this.itemtype = "ClothItem";
        this.clothsize = "0";
    }

    public void getGuiPanel()
    {
		super.getGuiPanel();
        // this.name = inputNameField.getText();
        // this.shelfprice = Double.parseDouble(inputPriceField.getText());
        // this.purchasedfor = Double.parseDouble(inputOrigPriceField.getText());
        // this.quantity = Integer.parseInt(inputQuantField.getText());
        // this.ID= Integer.parseInt(inputIDField.getText());
        this.itemtype = "ClothItem";
        this.clothsize = inputSizeField.getText();
    }

    public int setGuiPanel(JPanel contentPane)//, Item inputItem)
    {            //gui
        int y = super.setGuiPanel(contentPane);

        inputSizeLabel = new JLabel("Enter Size:");
        inputSizeLabel.setBounds(10,y,200,35);
        inputSizeField = new JTextField(5);
        inputSizeField.setBounds(250,y,200,35);
        inputSizeField.setText(this.clothsize);
        y+=30;

        contentPane.add(inputSizeLabel);
        contentPane.add(inputSizeField);
		
        return y;
    }


    public String toString ()
    {
        String str = super.toString();
        //result+="\t \tn/a"+ "\t\t\t"+ getLocation()+"\t\t"+clothsize;
        //return result;
         
        str += String.format("%-15s", getLocation());
        str += String.format("%-15s", clothsize);
        
        return str;        
    }

    public String getSize()
    {
        return clothsize;
    }

    public abstract String getLocation();

    public int getexpire()
    {
        return -1;
    }
}
 