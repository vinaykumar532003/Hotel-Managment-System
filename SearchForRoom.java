
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class SearchForRoom extends JFrame implements ActionListener {
    JTable table;
    JButton back,search;
    JComboBox bedtype,roomtype;
    JCheckBox available;
    
    
   SearchForRoom()
    {
         setResizable(false);
         
        JLabel heading=new JLabel("SEARCH FOR ROOMS");
heading.setBounds(400,0,200,20);
heading.setFont(new Font("Tahoma", Font.BOLD, 18));
add(heading);

JLabel lblbed =new JLabel("Bed Type");
lblbed.setBounds(70,30,100,20);
add(lblbed);

bedtype=new JComboBox(new String[]{"Single Bed" , "Double Bed"});
bedtype.setBounds(170,30,100,20);
bedtype.setBackground(Color.WHITE);
add(bedtype);

available=new JCheckBox("Only display Available");
available.setBounds(400,30,200,20);
available.setBackground(Color.WHITE);
add(available);

JLabel lblroomtype=new JLabel("Room Type");
lblroomtype.setBounds(700,30,100,20);
add(lblroomtype);

roomtype=new JComboBox(new String[]{"AC" , "Non AC"});
roomtype.setBounds(800,30,100,20);
roomtype.setBackground(Color.WHITE);
add(roomtype);

        
        getContentPane().setBackground(Color.WHITE);
       setLayout(null);
                     
       JLabel l1=new JLabel("Room Number");
        l1.setBounds(0,100,100,20);
        add(l1);
        
         JLabel l2=new JLabel("Availability");
        l2.setBounds(180,100,100,20);
        add(l2);
        
         JLabel l3=new JLabel("Cleaning Status");
        l3.setBounds(360,100,100,20);
        add(l3);
        
         JLabel l4=new JLabel("Price");
        l4.setBounds(540,100,100,20);
        add(l4);
        
         JLabel l5=new JLabel("Bed Type");
        l5.setBounds(720,100,100,20);
        add(l5);
        
         JLabel l6=new JLabel("Room Type");
        l6.setBounds(900,100,100,20);
        add(l6);
        
        table=new JTable();
        table.setBounds(0, 130, 1000, 400);
        add(table);
        
        try{
    Conn conn=new Conn();
    ResultSet rs=conn.s.executeQuery("select * from room");
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
        
        
     setBounds(300,200,1050,600);
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
       
 String query1="select * from room where bed_type='"+bedtype.getSelectedItem()+"' AND room_type='"+roomtype.getSelectedItem()+"'";
 String query2="select * from room where Availability='Available' AND bed_type='"+bedtype.getSelectedItem()+"' AND room_type='"+roomtype.getSelectedItem()+"'";
ResultSet rs;
 if(available.isSelected())
 {    
 rs=conn.s.executeQuery(query2);
 }
  else 
 {
    rs=conn.s.executeQuery(query1);   
 }
 
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
        new SearchForRoom();
    }
    
}
