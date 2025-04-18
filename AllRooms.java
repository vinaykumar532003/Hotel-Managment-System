
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class AllRooms extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    
    AllRooms()
    {
        JLabel heading=new JLabel("ALL ROOM DETAILS");
heading.setBounds(150,10,200,20);
heading.setFont(new Font("Tahoma", Font.BOLD, 18));
add(heading);

         setResizable(false);
        getContentPane().setBackground(Color.WHITE);
       setLayout(null);
                      
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
         Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);
        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(0,40,100,20);
        add(l1);
        
         JLabel l2=new JLabel("Availability");
        l2.setBounds(90,40,100,20);
        add(l2);
        
         JLabel l3=new JLabel("Cleaning Status");
        l3.setBounds(165,40,100,20);
        add(l3);
        
         JLabel l4=new JLabel("Price");
        l4.setBounds(280,40,100,20);
        add(l4);
        
         JLabel l5=new JLabel("Bed Type");
        l5.setBounds(350,40,100,20);
        add(l5);
        
         JLabel l6=new JLabel("Room Type");
        l6.setBounds(420,40,100,20);
        add(l6);
        
        table=new JTable();
        table.setBounds(0, 60, 500, 400);
        add(table);
        
        try{
    Conn conn=new Conn();
    ResultSet rs=conn.s.executeQuery("select * from room ");
    table.setModel(DbUtils.resultSetToTableModel(rs));
    
}
catch(Exception e)
{
    e.printStackTrace();
}

 back=new JButton("Back");
back.setBounds(150, 500, 100, 30);
back.setBackground(Color.BLACK);
back.setForeground(Color.WHITE);
back.addActionListener(this);
add(back); 
        
        
     setBounds(300,200,1050,600);
     setVisible(true);
        
      
       
     
        
    }
    
    public void actionPerformed(ActionEvent ae)
         {
         setVisible(false);
        new Reception();
              }
    public static void main(String arg[])
    {
        new AllRooms();
    }
    
}
