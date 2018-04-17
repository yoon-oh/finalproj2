import java.text.NumberFormat;
import java.util.*;
//gui
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class Item implements interfaceItem
{

    public String name;
    protected double shelfprice;
    protected double purchasedfor;
    protected int quantity;
    protected String ID;
    protected String itemtype;
    Scanner scan = new Scanner(System.in);

    // static -> shared among all Item objects, because there is only one GUI for all item objects.
    static protected int WIDTH=200;
    static protected int HEIGHT = 400;
    static protected JFrame frame;
    protected JPanel contentPane;// = new JPanel(null);
    static protected JLabel inputNameLabel,inputPriceLabel,inputOrigPriceLabel,inputQuantLabel,inputIDLabel;//,inputExpireLabel,inputTypeLabel,inputEmptyLabel;
    static protected JButton okButton;
    static protected JTextField inputNameField,inputPriceField,inputOrigPriceField,inputQuantField,inputIDField;//,inputExpireField,inputTypeField;

    // parameters to be an Item (name, shelf price, purchased for, quantity, ID number, item type)
    public Item (String itemName, double itemPrice,double purchfor, int numItem, String IDnum)//, String type )
    {
        this.name = itemName;
        this.shelfprice = itemPrice;
        this.purchasedfor = purchfor;
        this.quantity = numItem;
        this.ID=IDnum;
        this.itemtype = "???";//type, will be overriden by children classes
    }

    public Item()
    //overloaded constructor
    {
        this.shelfprice = 0;
        this.name = "";
        this.purchasedfor = 0;
        this.quantity = 0;
        this.ID="";
        this.itemtype = "???";
    }

    
    public void getGuiPanel()
    //used when adding or modifying items
    // taking variables user inputs into the textfields and puts them into variable names
    {
        //gets the fields from the gui and copies them into item object variables
        this.name = inputNameField.getText();
        this.shelfprice = Double.parseDouble(inputPriceField.getText());
        this.purchasedfor = Double.parseDouble(inputOrigPriceField.getText());
        this.quantity = Integer.parseInt(inputQuantField.getText());
        this.ID= inputIDField.getText();
        //this.itemtype = type;
    }

    public int setGuiPanel(JPanel contentPane)//, Item inputItem)
    {            
        
        //GUI project is using this to set up panel 3 (adding.modyfying panel) with the appropriate item field specific to items, 
        // sets up all gui fields and labels and copies the parameters from the item object to populate the gui

        //panel3
        contentPane.setPreferredSize(new Dimension(600,500));
        contentPane.setBackground(new Color(192,192,192));
        //contentPane.setBackground(Color.lightGray);
        int y=20;
        inputNameLabel = new JLabel("Enter Name:");
        inputNameLabel.setBounds(10,y,200,35);
        inputNameField = new JTextField(5);
        inputNameField.setBounds(250,y,200,35);
        inputNameField.setText(this.name);//copies object variable into GUI field
        y+=30;
        inputPriceLabel = new JLabel("Enter Price:");
        inputPriceLabel.setBounds(10,y,200,35);
        inputPriceField = new JTextField(5);
        inputPriceField.setBounds(250,y,200,35);
        inputPriceField.setText(Double.toString(this.shelfprice)); //text expects a string
        y+=30;
        inputOrigPriceLabel = new JLabel("Enter Original Price:");
        inputOrigPriceLabel.setBounds(10,y,200,35);
        inputOrigPriceField = new JTextField(5);
        inputOrigPriceField.setBounds(250,y,200,35);
        inputOrigPriceField.setText(Double.toString(this.purchasedfor));
        y+=30;
        inputQuantLabel = new JLabel("Enter Quantity:");
        inputQuantLabel.setBounds(10,y,200,35);
        inputQuantField = new JTextField(5);
        inputQuantField.setBounds(250,y,200,35);
        inputQuantField.setText(Integer.toString(this.quantity));
        y+=30;
        inputIDLabel = new JLabel("Enter ID num:");
        inputIDLabel.setBounds(10,y,200,35);
        inputIDField = new JTextField(5);
        inputIDField.setBounds(250,y,200,35);
        inputIDField.setText(this.ID);
        y+=30;

        //adding components to contentPane panel
        contentPane.add(inputNameLabel);
        contentPane.add(inputNameField);
        contentPane.add(inputPriceLabel);
        contentPane.add(inputPriceField);
        contentPane.add(inputOrigPriceLabel);
        contentPane.add(inputOrigPriceField);
        contentPane.add(inputQuantLabel);
        contentPane.add(inputQuantField);
        contentPane.add(inputIDLabel);
        contentPane.add(inputIDField);
        //contentPane.add(inputTypeLabel);
        //contentPane.add(inputTypeField);

        //contentPane.add(okButton);
        return y;
    }

    public String toString ()
    {
        String str;
        
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        str = String.format("%-15s", name); //padding after the string, fills until length = 15
        str += String.format("%-15s", fmt.format(shelfprice));
        str += String.format("%-15s", Integer.toString(quantity));
        str += String.format("%-15s", fmt.format(shelfprice*quantity));
        str += String.format("%-15s", ID);
        return str;        
    }

    public static String getGuiListTitle()
    {
        String str;
        
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        str = String.format("%-15s", "name");
        str += String.format("%-15s", "shelf $");
        str += String.format("%-15s", "quant.");
        str += String.format("%-15s", "total");
        str += String.format("%-15s", "ID num");
        str += String.format("%-15s", "location");
        str += String.format("%-15s", "custom");
        return str;
    }

    public String getType ()
    {
        return  itemtype;
    }

    public double getshelfPrice()
    {
        return shelfprice;
    }

    public double getPurchfor()
    {
        return purchasedfor;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public String getID()
    {
        return ID;
    }

    public abstract int getexpire();

    public abstract String getLocation();

}