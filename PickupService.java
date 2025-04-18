
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class PickupService extends JFrame implements ActionListener {
    JTable table;
    JButton back,search;
    Choice cartype;
    
    PickupService ()
    {
        JLabel heading=new JLabel("PICKUP SERVICE");
heading.setBounds(400,0,200,20);
heading.setFont(new Font("Tahoma", Font.BOLD, 18));
add(heading);

JLabel lblbed =new JLabel("Car Type");
lblbed.setBounds(70,30,100,20);
add(lblbed);

cartype=new Choice();
cartype.setBounds(170,30,100,20);
add(cartype);

try{
   Conn c=new Conn();
   ResultSet rs=c.s.executeQuery("select * from drivers");
   while(rs.next())
   {
       cartype.add(rs.getString("carmodel"));
   }
   
   
}
catch(Exception e)
{
    e.printStackTrace();
}
 setResizable(false);
getContentPane().setBackground(Color.WHITE);
       setLayout(null);
                     
       JLabel l1=new JLabel("Driver Name");
        l1.setBounds(10,100,100,20);
        add(l1);
        
         JLabel l2=new JLabel("Age");
        l2.setBounds(150,100,100,20);
        add(l2);
        
         JLabel l3=new JLabel("Gender");
        l3.setBounds(280,100,100,20);
        add(l3);
        
         JLabel l4=new JLabel("Car Compnay");
        l4.setBounds(380,100,100,20);
        add(l4);
        
         JLabel l5=new JLabel("Car Model");
        l5.setBounds(520,100,100,20);
        add(l5);
        
         JLabel l6=new JLabel("Availability");
        l6.setBounds(640,100,100,20);
        add(l6);
        
        JLabel l7=new JLabel("Location");
        l7.setBounds(780,100,100,20);
        add(l7);
        
         JLabel l8=new JLabel("Mobile No.");
        l8.setBounds(900,100,100,20);
        add(l8);
        
        
        table=new JTable();
        table.setBounds(0, 130, 1000, 400);
        add(table);
        
        try{
    Conn conn=new Conn();
    ResultSet rs=conn.s.executeQuery("select * from drivers");
    table.setModel(DbUtils.resultSetToTableModel(rs));
    
}
catch(Exception e)
{
    e.printStackTrace();
}
        search=new JButton("Search");
search.setBounds(300, 525, 100, 30);
search.setBackground(Color.BLACK);
search.setForeground(Color.WHITE);
search.addActionListener(this);
add(search); 
        

 back=new JButton("Back");
back.setBounds(500, 525, 100, 30);
back.setBackground(Color.BLACK);
back.setForeground(Color.WHITE);
back.addActionListener(this);
add(back); 
        
        
     setBounds(300,200,1000,600);
     setVisible(true);
         }
     public void actionPerformed(ActionEvent ae)
         {
              if(ae.getSource()==back)
    {
        setVisible(false);
        new Reception();
              }
            else if(ae.getSource()==search)
    {
         
        try{
   Conn conn=new Conn();
       
 String query="select * from drivers where carmodel='"+cartype.getSelectedItem()+"'";
 
ResultSet rs =conn.s.executeQuery(query);
   table.setModel(DbUtils.resultSetToTableModel(rs));
            }
       catch(Exception e)
      {
               e.printStackTrace();
      }
        
    }  
         }
    
    public static void main(String arg[])
    {
        new  PickupService ();
    }
    
}
