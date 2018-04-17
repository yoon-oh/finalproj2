import java.text.NumberFormat;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.*;
import java.lang.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
//gui
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Inventory
{
    //gui
    private int WIDTH=300;
    private int HEIGHT = 75;
    //private JFrame frame;
    private JPanel panel;
    private JLabel inputLabel;//, outputLabel, resultLabel;
    private JComboBox typeComboBox;
    private JButton okButton;
    private boolean itemTypeGui_done;
    //private JTextField inputNameField;
    //
    public ArrayList <Item> List = new <Item> ArrayList();

    ArrayList invList = new ArrayList();

    public Inventory () 
    // constructor which adds in items to array list
    {      
        List.add(new Perishable ("peach",0.99,0.25,45,"450000",1));
        List.add(new Perishable ("eggs",2.99,1.00,3,"900000",4));
        List.add(new Tops ("red",15.76, 10.56,5,"340000","small"));  
        List.add(new NonPerishable ("soup", 1.00, 0.99, 7, "333300"));
        List.add(new Software ("blueJ", 0.00, 0.00, 2, "190087", "blueJ/download.com"));
        List.add(new Hardware ("laptop", 235.30, 140.00, 9, "890123", "acer"));
    }

    public void removeFromInventory(int i)
    // removes 'i'th item in inventory list
    {
        List.remove(i);
    }

    public void addToInventory(int type)
    //adds to inventory list a prepopulated item depending on the type chosen in the drop down menu (combobox2) 
    {
        Item tmpItem;
        switch (type)
        {
            case 0: tmpItem = new Perishable("banana",1.99,1.25,15,"450011",1); break;
            case 1: tmpItem = new NonPerishable("soda",0.99,0.25,40,"00800"); break;
            case 2: tmpItem = new Tops("jacket",7.99,4.80,45,"451000","small"); break;
            case 3: tmpItem = new Bottoms("pants",5.99,4.00,10,"450090","medium"); break;
            case 4: tmpItem = new Hardware("computer",100.99,90.25,45,"450000","acer"); break;
            case 5: tmpItem = new Software("linux",20.99,10.25,15,"450600","ubuntu.org"); break;
            default: tmpItem= new Perishable(); break;
        }        
        List.add(tmpItem);
    }

    public String toString () 
    //outputs string with inventory totals
    // called by GUI to display totals in textfield1 
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        double totalcost=0.0;
        double totalvalue=0.0;
        double potentprof=0.0;
        int totalquan=0;
        Integer totalQuan=null;//wrapper class
        for (int i=0; i<List.size();i++)
        {
            System.out.println(List.get(i));
            totalvalue+=(List.get(i).getshelfPrice()*List.get(i).getQuantity());
            totalcost+=(List.get(i).getQuantity()*List.get(i).getPurchfor());
            totalquan+=(List.get(i).getQuantity());
            totalQuan =Integer.valueOf(totalquan); //wrapper class!
        }
        potentprof=(totalvalue - totalcost);

        String str;
        str  = "Total Cost: " +fmt.format(totalcost);
        str += "       Total Value: " +fmt.format(totalvalue);
        str += "       Potential Profit: "+fmt.format(potentprof);
        str += "       Total Quantity: " + totalQuan;

        return str;        
    }

    public String[] print_to_string_array()
    // outputs an array of strings describing each item in the list
    // used in the refresh
    {
        String[] string_array = new String[List.size()];
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        double totalprice=0.0;
        double totalpay=0.0;
        double potentprof=0.0;
        int totalquan=0;
        System.out.println("print_to_string . nb of items="+List.size());

        for (int i=0; i<List.size();i++)
        {
            string_array[i] = (List.get(i)).toString();
        }
        //iterator
        Iterator iterator = List.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next());
        return string_array;
    }

    public void quickSort (boolean reverse, int field_index)
    // sorts inventory list 
    // reverse: if true sorts in reverse order
    // field index: selects which item parameter to sort from
    {
        System.out.println("---- quickSort ----");

        doQuickSort(0, List.size() - 1, reverse, field_index);
        
        Iterator iterator = List.iterator(); //ITERATOR

        while (iterator.hasNext())
            System.out.print(iterator.next());
    }

    private void doQuickSort (int start, int end, boolean reverse, int field_index)
    {
        //System.out.println("Start="+start+"  stop="+end);
        if (start < end)
        {
            int middle = partition( start, end, reverse, field_index);
            //System.out.println("middle="+middle);
            doQuickSort( start, middle, reverse, field_index);
            doQuickSort( middle + 1, end, reverse, field_index);
        }
    }

    // -----------------------------------------------------------------
    // Partitions the array such that each value in [start, middle]
    // is less than or equal to each value in [middle + 1, end].
    // The index middle is determined in the procedure and returned.
    // -----------------------------------------------------------------
    private int partition (int start, int end, boolean reverse, int field_index)
    {
        //String pivotstr = List.get(start).getName();
        int pivot = start;
        //int pivot = numbers[start];
        int i = start - 1;
        int j = end + 1;

        // As the loop progresses, the indices i and j move towards each other.
        // Elements at i and j that are on the wrong side of the partition are
        // exchanged. When i and j pass each other, the loop ends and j is
        // returned as the index at which the elements are partitioned around.
        while (true)
        {
            i = i + 1;
            //while (numbers[i] < pivot)
            while (compareItem(i,pivot,field_index,reverse))
            // if true and reverse is false then i < pivot
            // 
            {
                //System.out.println("pivotstr="+pivotstr+"  name[i]="+List.get(i).getName()+ "  i="+i);
                i = i + 1;

            }
            j = j - 1;
            //while (numbers[j] > pivot)
            while (compareItem(pivot,j,field_index,reverse))
            {
                //System.out.println("pivotstr="+pivotstr+"  name[i]="+List.get(j).getName()+ "  j="+j);
                j = j - 1;
            }
            if (i < j)
            {
                Item tmpItem = List.get(i);

                tmpItem= List.set(j,tmpItem);
                tmpItem= List.set(i,tmpItem);
                //int tmp = numbers[i];
                //numbers[i] = numbers[j];
                //numbers[j] = tmp;

            }
            else return j;
        }
    }

    private Boolean compareItem (int i, int j, int field_index, Boolean reverse)
    // field_index: 0:Item Name, 1:Shelf price, 2:Purchase price, 3:Quantity, 4:ID
    // i,j : item index in inventory
    // if reverse=false returns true if item[i]<item[j] 
    // if reverse=true returns true if item[i]>item[j] 
    {
        Boolean cmp=false;
        if (!reverse)
        {
            switch (field_index) {
                //depending on field, compare strings or integers.
                case 0: cmp = (List.get(j).getName().compareTo(List.get(i).getName()))>0; break;
                case 1: cmp = List.get(j).getshelfPrice()>List.get(i).getshelfPrice(); break;
                case 2: cmp = List.get(j).getPurchfor()>List.get(i).getPurchfor(); break;
                case 3: cmp = List.get(j).getQuantity()>List.get(i).getQuantity(); break;
                case 4: cmp = List.get(j).getID().compareTo(List.get(i).getID())>0; break;
                case 5: cmp = (List.get(j).getType().compareTo(List.get(i).getType()))>0; break;
            }
        } else {
            switch (field_index) {
                case 0: cmp = (List.get(j).getName().compareTo(List.get(i).getName()))<0; break;
                case 1: cmp = List.get(j).getshelfPrice()<List.get(i).getshelfPrice(); break;
                case 2: cmp = List.get(j).getPurchfor()<List.get(i).getPurchfor(); break;
                case 3: cmp = List.get(j).getQuantity()<List.get(i).getQuantity(); break;
                case 4: cmp = List.get(j).getID().compareTo(List.get(i).getID())<0; break;
                case 5: cmp = (List.get(j).getType().compareTo(List.get(i).getType()))<0; break;
            }

        }

        return cmp;
    }

}
