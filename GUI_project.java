/**
 *Text genereted by Simple GUI Extension for BlueJ
 */
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;
import java.util.*;

//public class GUI_project {
public class GUI_project extends JFrame {
    private JMenuBar menuBar;
    private JButton add_button;
    private JComboBox combobox1, sort_combobox1;
    private JButton delete_button;
    //private JEditorPane editorpane1;
    private JList list1;// list of items
    private JLabel label1;
    private JLabel label11;
    private JLabel background;
    private JButton modify_button;
    //private JPanel panel2;
    private JCheckBox rev_checkbox, search_checkbox;
    private JButton search_button;
    private JButton sort_button;
    private JTextField textfield1;
    private JTextField search_textfield;
    // panel2 : add item
    private JComboBox combobox2;
    private JButton ok_button2;
    private JButton cancel_button2;
    //panel3
    JButton okButton3;

    Inventory inv = new Inventory();
    boolean itemTypeGui_done;
    DefaultListModel dlm = new DefaultListModel();
    int selected_item=-1;
    String searchStr="";
    Boolean searchMatchCase=false;
    JFrame frame;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    //? more specific than *
    public static boolean match(String text, String pattern, Boolean match_case)
    // searches for String "pattern" ( what you're searching for ) within the String text
    // match case checks if cares if uppercase or not
    // if match case = true cares about case
    {
        if (match_case) 
            return text.matches(pattern.replace("?", ".?").replace("*", ".*?")); // matches is a pre-existing java function
        else //forces both text and pattern to lowercase
            return (text.toLowerCase()).matches(pattern.replace("?", ".?").replace("*", ".*?").toLowerCase());
    }
    
    //defaultListCellRenderer is part of library
    private class MyListRenderer extends DefaultListCellRenderer
    {
        public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) 
        {
            Component c = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );

            //System.out.println(">>>"+value.toString()+"<<< search:"+searchStr);
            if (match(value.toString(),searchStr,searchMatchCase))
            {
                c.setBackground( Color.yellow );
            }
            else if ( index % 2 == 0 ) //if even index then grey
            {
                c.setBackground(new Color(240,240,240) );

            }
            else 
            {
                c.setBackground( Color.white );
            }
            return c;
        }       
    }
    
    public GUI_project(){
        //frame 1
        
        //this.setTitle("GUI_project");
        //this.setSize(935,563);
        //menu generate method
        //generateMenu();
        //this.setJMenuBar(menuBar);
        frame = new JFrame();
        frame.setTitle("GUI_project");
        frame.setSize(935,563);
        frame.setJMenuBar(menuBar);

        //pane with null layout
        panel1 = new JPanel(null);
        panel1.setPreferredSize(new Dimension(935,563));
        panel1.setBackground(new Color(192,192,192));
        //--------------- Sub-panel add ---------------
        panel2 = new JPanel(null);
        panel2.setPreferredSize(new Dimension(450,300));
        panel2.setBackground(new Color(192,192,192));

        panel3 = new JPanel(null);

        //-------------------------- panel 1 (Main)----------------------
        JLabel background=new JLabel(new ImageIcon("C:\\Users\\trixieprixie\\Pictures\\b\\Image003.png"));//C:\\Users\\Computer\\Downloads\\colorful_design.png"));
        background.setLayout(new FlowLayout());
        background.setBounds(0,0,935,563);
        background.setIcon(new ImageIcon("http://static.tumblr.com/eab424c90c1a13d63c2c00e5470cf2fa/dc5jxmq/vuFmpal8b/tumblr_static_color_ombre_bg.jpg"));
        background.setEnabled(true);
        background.setVisible(true);
        
        add_button = new JButton();
        add_button.setBounds(60,115,90,35);
        add_button.setBackground(new Color(214,217,223));
        add_button.setForeground(new Color(0,0,0));
        add_button.setEnabled(true);
        add_button.setFont(new Font("sansserif",0,12));
        add_button.setText("Add");
        add_button.setVisible(true);

        delete_button = new JButton();
        delete_button.setBounds(173,115,90,35);
        delete_button.setBackground(new Color(214,217,223));
        delete_button.setForeground(new Color(0,0,0));
        delete_button.setEnabled(true);
        delete_button.setFont(new Font("sansserif",0,12));
        delete_button.setText("Delete");
        delete_button.setVisible(true);

        label1 = new JLabel();
        label1.setBounds(58,148,90,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("sansserif",0,12));
        label1.setText("Inventory");
        label1.setVisible(true);

        label11 = new JLabel();
        label11.setBounds(58,148+15,800,35);
        label11.setBackground(new Color(214,217,223));
        label11.setForeground(new Color(0,0,0));
        label11.setEnabled(true);
        label11.setFont(new Font("Courier New",0,12));
        label11.setText(Item.getGuiListTitle());
        label11.setVisible(true);

        //DefaultListModel<String> dlm = new DefaultListModel<String>();
        //JList<String> list1 = new JList<>(dlm);
        JList list1 = new JList(dlm);

        //list1 = new JList();
        list1.setBounds(58,192,800,255); // list = place where inventory items are listed
        list1.setBackground(new Color(214,217,223));
        list1.setForeground(new Color(0,0,0));
        list1.setEnabled(true);
        list1.setFont(new Font("Courier New",0,12));
        list1.setCellRenderer( new MyListRenderer() ); // to change colors
        list1.setVisible(true);

        modify_button = new JButton();
        modify_button.setBounds(286,115,90,35);
        modify_button.setBackground(new Color(214,217,223));
        modify_button.setForeground(new Color(0,0,0));
        modify_button.setEnabled(true);
        modify_button.setFont(new Font("sansserif",0,12));
        modify_button.setText("Modify");
        modify_button.setVisible(true);

        search_button = new JButton();
        search_button.setBounds(60,71,90,35);
        search_button.setBackground(new Color(214,217,223));
        search_button.setForeground(new Color(0,0,0));
        search_button.setEnabled(true);
        search_button.setFont(new Font("sansserif",0,12));
        search_button.setText("search");
        search_button.setVisible(true);
        
        search_textfield = new JTextField();
        search_textfield.setBounds(60+114,70,90,35);
        search_textfield.setBackground(new Color(255,255,255));
        search_textfield.setForeground(new Color(0,0,0));
        search_textfield.setEnabled(true);
        search_textfield.setFont(new Font("sansserif",0,12));
        search_textfield.setText("b*");
        search_textfield.setVisible(true);

        search_checkbox = new JCheckBox();
        search_checkbox.setBounds(60+114*2,72,120,35);
        search_checkbox.setBackground(new Color(214,217,223));
        search_checkbox.setForeground(new Color(0,0,0));
        search_checkbox.setEnabled(true);
        search_checkbox.setFont(new Font("sansserif",0,12));
        search_checkbox.setText("match case");
        search_checkbox.setVisible(true);

        sort_button = new JButton();
        sort_button.setBounds(60,26,90,35);
        sort_button.setBackground(new Color(214,217,223));
        sort_button.setForeground(new Color(0,0,0));
        sort_button.setEnabled(true);
        sort_button.setFont(new Font("sansserif",0,12));
        sort_button.setText("sort");
        sort_button.setVisible(true);

        sort_combobox1 = new JComboBox();
        sort_combobox1.addItem("Name");
        sort_combobox1.addItem("Shelf price");
        sort_combobox1.addItem("Purchase price");
        sort_combobox1.addItem("Quantity");
        sort_combobox1.addItem("ID");
        sort_combobox1.addItem("Type");

        sort_combobox1.setBounds(60+114,26,90,35);
        sort_combobox1.setBackground(new Color(214,217,223));
        sort_combobox1.setForeground(new Color(0,0,0));
        sort_combobox1.setEnabled(true);
        sort_combobox1.setFont(new Font("sansserif",0,12));
        sort_combobox1.setVisible(true);

        rev_checkbox = new JCheckBox();
        rev_checkbox.setBounds(60+114*2,28,120,35);
        rev_checkbox.setBackground(new Color(214,217,223));
        rev_checkbox.setForeground(new Color(0,0,0));
        rev_checkbox.setEnabled(true);
        rev_checkbox.setFont(new Font("sansserif",0,12));
        rev_checkbox.setText("reverse order");
        rev_checkbox.setVisible(true);

        // inventory summary
        textfield1 = new JTextField();
        textfield1.setBounds(58,467,800,40);
        textfield1.setBackground(new Color(255,255,255));
        textfield1.setForeground(new Color(0,0,0));
        textfield1.setEnabled(true);
        textfield1.setFont(new Font("sansserif",0,12));
        textfield1.setText("text");
        //textfield1.setText(inv.toString());
        textfield1.setVisible(true);

        // add item list to gui list1
        refresh_panel1(dlm);

        //-------------------------- panel 2 (Add Item sub-panel)----------------------
        combobox2 = new JComboBox();
        combobox2.addItem("Food - Perishable");
        combobox2.addItem("Food - Non-perishable");
        combobox2.addItem("Clothing - Tops");
        combobox2.addItem("Clothing - Bottoms");
        combobox2.addItem("Electronics - Hardware");
        combobox2.addItem("Electronics - Software");
        combobox2.setBounds(60,70,150,35);
        combobox2.setBackground(new Color(214,217,223));
        combobox2.setForeground(new Color(0,0,0));
        combobox2.setEnabled(true);
        combobox2.setFont(new Font("sansserif",0,12));
        combobox2.setVisible(true);

        ok_button2 = new JButton();
        ok_button2.setBounds(60,115,150,35);
        ok_button2.setBackground(new Color(214,217,223));
        ok_button2.setForeground(new Color(0,0,0));
        ok_button2.setEnabled(true);
        ok_button2.setFont(new Font("sansserif",0,12));
        ok_button2.setText("OK");
        ok_button2.setVisible(true);

        cancel_button2 = new JButton();
        cancel_button2.setBounds(260,115,150,35);
        cancel_button2.setBackground(new Color(214,217,223));
        cancel_button2.setForeground(new Color(0,0,0));
        cancel_button2.setEnabled(true);
        cancel_button2.setFont(new Font("sansserif",0,12));
        cancel_button2.setText("Cancel");
        cancel_button2.setVisible(true);

        //-------------------------- panel 3 (Modify Item sub-panel)----------------------
        okButton3 = new JButton();
        okButton3.setBounds(60,170,150,35);
        okButton3.setBackground(new Color(214,217,223));
        okButton3.setForeground(new Color(0,0,0));
        okButton3.setEnabled(true);
        okButton3.setFont(new Font("sansserif",0,12));
        okButton3.setText("OK");
        okButton3.setVisible(true);

        //-------------------------- methods for mouse events ----------------------
        //Set methods for mouse events
        //Call defined methods
        add_button.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    frame.remove(panel1);
                    frame.add(panel2);
                    // below needs to be done every time new panels are added/removed in frame
                    frame.revalidate(); // revalidate is pre-existing GUI function
                    frame.repaint();  // repaint is pre-existing GUI function
                    frame.pack();  // pack is pre-existing GUI function           
                    //add_button_event(evt);
                }
            });
        //Set methods for mouse events
        //Call defined methods
        delete_button.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    System.out.println(" delete item index ="+ list1.getSelectedIndex());
                    selected_item = list1.getSelectedIndex(); // item index to delete
                    if (selected_item>=0) 
                        inv.removeFromInventory(selected_item);
                    refresh_panel1(dlm);
                    //delete_button_event(evt);
                }
            });
        //Set methods for mouse events
        //Call defined methods
        modify_button.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    selected_item = list1.getSelectedIndex(); // item index to modify
                    System.out.println(" modify item index ="+ selected_item);

                    int y;
                    panel3 = new JPanel(null); // clear panel
                    //Add item related fields
                    y=(inv.List.get(selected_item)).setGuiPanel(panel3); // load panel 3 gui fields with selected item values
                    // add ok button
                    okButton3.setBounds(60,y+20,150,35);
                    panel3.add(okButton3);

                    frame.remove(panel1);
                    frame.add(panel3);
                    frame.revalidate();
                    frame.repaint();
                    frame.pack();            
                }
            });

        //Set methods for mouse events
        //Call defined methods
        ok_button2.addMouseListener(new MouseAdapter() { // panel2 (add, choose item type)
                public void mouseClicked(MouseEvent evt) {
                    //combobox is drop down menu
                    inv.addToInventory(combobox2.getSelectedIndex()); // type of item is selected in combobox2
                    selected_item = inv.List.size() -1; // will modify the newly added item at end of list.
                    //inv.List.add(perish)
                    //perish.
                    // panel2 : add item
                    //---------------------------
                    panel3 = new JPanel(null); // create empty panel
                    int y;
                    //Add item related fields
                    y=(inv.List.get(selected_item)).setGuiPanel(panel3);
                    okButton3.setBounds(60,y+20,150,35);
                    panel3.add(okButton3);
                    okButton3.setText("=OK=");

                    //----------------------------------
                    frame.remove(panel2);
                    frame.add(panel3);
                    frame.revalidate();
                    frame.repaint();
                    frame.pack();        
                    //modify_button_event(evt);
                }
            });

        //Set methods for mouse events
        //Call defined methods
        okButton3.addMouseListener(new MouseAdapter() { //panel3
                public void mouseClicked(MouseEvent evt) {
                    int i = list1.getSelectedIndex(); // item index to modify
                    (inv.List.get(selected_item)).getGuiPanel(); // sets item values to GUI fields
                    // -----------------------------
                    if (inv.List.get(selected_item).getQuantity()>0) //makes sure that the quantitiy supplied by the user is greater
                    // than zero
                    {
                        frame.remove(panel3);
                        frame.add(panel1);
                        //do following each time you change panels in a jframe
                        frame.revalidate();
                        frame.repaint();
                        frame.pack();
                        refresh_panel1(dlm); //refreshes List1 which is the List of Items
                    }
                    else
                    {
                        Item.inputQuantField.setBackground(new Color(255,125,125)); //changes quant field to red if quant<=0
                    }
                    //delete_button_event(evt);
                }
            });

        //Set methods for mouse events
        //Call defined methods
        cancel_button2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    frame.remove(panel2);
                    frame.add(panel1);
                    frame.revalidate();
                    frame.repaint();
                    frame.pack();            
                    refresh_panel1(dlm);
                    //modify_button_event(evt);
                }
            });

        //Set methods for mouse events
        //Call defined methods
        sort_button.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    //sort_button_event(evt);
                    inv.quickSort(rev_checkbox.isSelected(), sort_combobox1.getSelectedIndex()); // type of item is selected in sort_combobox1
                    refresh_panel1(dlm);
                }
            });

        search_button.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    //sort_button_event(evt);
                    searchStr = search_textfield.getText();
                    searchMatchCase = search_checkbox.isSelected();
                    //inv.search(search_textfield.getText());//, sort_combobox1.getSelectedIndex()); // type of item is selected in sort_combobox1
                    refresh_panel1(dlm);
                }
            });

        //-------------------------- adding components to panels ----------------------

        //adding components to panel1 panel
        panel1.add(add_button);
        //panel1.add(combobox1);
        panel1.add(sort_combobox1);
        panel1.add(delete_button);
        panel1.add(list1);
        panel1.add(label1);
        panel1.add(label11);
        panel1.add(modify_button);
        //panel1.add(panel2);
        panel1.add(rev_checkbox);
        panel1.add(search_button);
        panel1.add(search_checkbox);
        panel1.add(sort_button);
        panel1.add(textfield1);
        panel1.add(search_textfield);
        panel1.add(background);
        panel2.add(combobox2);
        panel2.add(ok_button2);
        panel2.add(cancel_button2);

        frame.add(panel1);
        //frame.add(panel2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    //Method to refresh List1 (list of items)
    private void refresh_panel1 (DefaultListModel dlm) 
    // this is called everytime a change is made to the inventory list
    // - regenerates the dlm DefaultListModel object from the array of string describing the inventory,
    //     this will automatically update  GUI list1 list of items.
    // - regenerates the inventory totals displayed in textfield1
    {
        //dlm is a list of strings that will be displayed in the GUI list1
        dlm.removeAllElements();
        String[] string_array=inv.print_to_string_array();
        // enhanced loop!
        for (String element: string_array)
        {
            dlm.addElement(element);
        }
        //refresh inventory summary
        textfield1.setText(inv.toString()); 
    }

    public static void main(String[] args) //simple GUI application created this.
    {
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new GUI_project();
                }
            });
    }

}