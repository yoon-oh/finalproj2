//gui
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Software extends Electronic
{
    protected String link;

    static protected JLabel inputLinkLabel;
    static protected JTextField inputLinkField;
	
    public Software(String itemName, double itemPrice,double purchfor, int numItem, String IDnum, String link)//,String itemtype)
    {
        super(itemName,itemPrice,purchfor,numItem,IDnum);//,itemtype);
        this.itemtype = "Software";
        this.link=link;
    }

    public Software()
    {
        super();
        this.itemtype = "Software";
        this.link = "";
    }

    public void getGuiPanel()
    {
		super.getGuiPanel();
        // this.name = inputNameField.getText();
        // this.shelfprice = Double.parseDouble(inputPriceField.getText());
        // this.purchasedfor = Double.parseDouble(inputOrigPriceField.getText());
        // this.quantity = Integer.parseInt(inputQuantField.getText());
        // this.ID= Integer.parseInt(inputIDField.getText());
        this.itemtype = "Software";
        this.link = inputLinkField.getText();
    }

    public int setGuiPanel(JPanel contentPane)//, Item inputItem)
    {            //gui
        int y = super.setGuiPanel(contentPane);

        inputLinkLabel = new JLabel("Enter download link:");
        inputLinkLabel.setBounds(10,y,200,35);
        inputLinkField = new JTextField(5);
        inputLinkField.setBounds(250,y,200,35);
        inputLinkField.setText(this.link);
        y+=30;

        contentPane.add(inputLinkLabel);
        contentPane.add(inputLinkField);
		
        return y;
    }
    
    public String getLink()
    {
        return this.link;
    }
    
       public int getexpire()
   {
       return -1;
   }

   public String getLocation()
    {
        return "online"; 
    }
    
   public String toString ()
    {
        String str = super.toString();
        str += String.format("%-15s", getLocation());
        str += String.format("%-15s", getLink());
        return str;
    }
}
