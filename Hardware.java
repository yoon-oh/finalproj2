//gui
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hardware extends Electronic
{
    protected String modeltype;
	
    static protected JLabel inputModelLabel;
    static protected JTextField inputModelField;
	
    public Hardware(String itemName, double itemPrice,double purchfor, int numItem, String IDnum, String model)//,String itemtype)
    {
        super(itemName,itemPrice,purchfor,numItem,IDnum);//,itemtype);
        this.itemtype = "Hardware";
        this.modeltype = model;
    }

    public Hardware()
    {
        super();
        this.itemtype = "Hardware";
        this.modeltype = "";
    }

    public void getGuiPanel()
    {
		super.getGuiPanel();
        // this.name = inputNameField.getText();
        // this.shelfprice = Double.parseDouble(inputPriceField.getText());
        // this.purchasedfor = Double.parseDouble(inputOrigPriceField.getText());
        // this.quantity = Integer.parseInt(inputQuantField.getText());
        // this.ID= Integer.parseInt(inputIDField.getText());
        this.itemtype = "Hardware";
        this.modeltype = inputModelField.getText();
    }

    public int setGuiPanel(JPanel contentPane)//, Item inputItem)
    {            //gui
        int y = super.setGuiPanel(contentPane);

        inputModelLabel = new JLabel("Enter Model Type:");
        inputModelLabel.setBounds(10,y,200,35);
        inputModelField = new JTextField(5);
        inputModelField.setBounds(250,y,200,35);
        inputModelField.setText(this.modeltype);
        y+=30;

        contentPane.add(inputModelLabel);
        contentPane.add(inputModelField);
		
        return y;
    }

    public String getLocation()
    {
        return "Aisle 9"; 
    }

    public int getexpire()
    {
        return -1;
    }

    public String getModeltype()
    {
        return modeltype;
    }
    
    public String toString ()
    {
        String str = super.toString();
        str += String.format("%-15s", getLocation());
        str += String.format("%-15s", getModeltype());
        return str;
    }
}
