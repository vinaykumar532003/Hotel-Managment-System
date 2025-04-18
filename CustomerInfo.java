
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class CustomerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    
 CustomerInfo ()
    {
        JLabel heading=new JLabel("ALL CUSTOMERS INFORMATION");
heading.setBounds(500,0,400,20);
heading.setFont(new Font("Tahoma", Font.BOLD, 18));
add(heading);

         setResizable(false);
        getContentPane().setBackground(Color.WHITE);
       setLayout(null);
                      
JLabel l1=new JLabel("Customer ID");
        l1.setBounds(40,25,100,20);
        add(l1);
        
         JLabel l2=new JLabel("ID Number");
        l2.setBounds(180,25,100,20);
        add(l2);
        
         JLabel l3=new JLabel("Name");
        l3.setBounds(360,25,100,20);
        add(l3);
        
         JLabel l4=new JLabel("Gender");
        l4.setBounds(550,25,100,20);
        add(l4);
        
         JLabel l5=new JLabel("Country");
        l5.setBounds(700,25,100,20);
        add(l5);
        
         JLabel l6=new JLabel("Room Number");
        l6.setBounds(900,25,100,20);
        add(l6);
        
          JLabel l7=new JLabel("Check IN Time");
        l7.setBounds(1050,25,100,20);
        add(l7);
        
          
         JLabel l8=new JLabel("Deposit Amount");
        l8.setBounds(1200,25,100,20);
        add(l8);
        
         JLabel l9=new JLabel("Days Stay");
        l9.setBounds(1360,25,100,20);
        add(l9);
        
        table=new JTable();
        table.setBounds(0, 50, 1520, 400);
        add(table);
        
        
        try{
    Conn conn=new Conn();
    ResultSet rs=conn.s.executeQuery("select * from customer");
    table.setModel(DbUtils.resultSetToTableModel(rs));
    
}
catch(Exception e)
{
    e.printStackTrace();
}

 back=new JButton("Back");
back.setBounds(600, 500, 120, 30);
back.setBackground(Color.BLACK);
back.setForeground(Color.WHITE);
back.addActionListener(this);
add(back); 
        
        
     setBounds(0,200,1450,600);
     setVisible(true);
        
      
       
     
        
    }
    
    public void actionPerformed(ActionEvent ae)
         {
         setVisible(false);
        new Reception();
              }
    public static void main(String arg[])
    {
        new CustomerInfo();
    }
    
}




