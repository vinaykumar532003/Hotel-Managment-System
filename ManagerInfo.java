
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class ManagerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    
  ManagerInfo ()
    {
        JLabel heading=new JLabel("ALL MANAGERS INFORMATION");
heading.setBounds(500,0,300,20);
heading.setFont(new Font("Tahoma", Font.BOLD, 18));
add(heading);

         setResizable(false);
        getContentPane().setBackground(Color.WHITE);
       setLayout(null);
                      
JLabel l1=new JLabel("Name");
        l1.setBounds(40,40,100,20);
        add(l1);
        
         JLabel l2=new JLabel("Age");
        l2.setBounds(170,40,100,20);
        add(l2);
        
         JLabel l3=new JLabel("Gender");
        l3.setBounds(300,40,100,20);
        add(l3);
        
         JLabel l4=new JLabel("Job Profile");
        l4.setBounds(430,40,100,20);
        add(l4);
        
         JLabel l5=new JLabel("Salary");
        l5.setBounds(550,40,100,20);
        add(l5);
        
         JLabel l6=new JLabel("Phone no.");
        l6.setBounds(680,40,100,20);
        add(l6);
        
          JLabel l7=new JLabel("Email ID");
        l7.setBounds(820,40,100,20);
        add(l7);
        
          JLabel l8=new JLabel("Aadhar no.");
        l8.setBounds(950,40,100,20);
        add(l8);
        
        JLabel l9=new JLabel("Employee ID");
        l9.setBounds(1080,40,100,20);
        add(l9);
        
        table=new JTable();
        table.setBounds(0,70, 1200, 400);
        add(table);
        
        
        try{
    Conn conn=new Conn();
    ResultSet rs=conn.s.executeQuery("select * from employee where job='Manager'");
    table.setModel(DbUtils.resultSetToTableModel(rs));
    
}
catch(Exception e)
{
    e.printStackTrace();
}

 back=new JButton("Back");
back.setBounds(520, 500, 120, 30);
back.setBackground(Color.BLACK);
back.setForeground(Color.WHITE);
back.addActionListener(this);
add(back); 
        
        
     setBounds(200,200,1200,600);
     setVisible(true);
        
      
       
     
        
    }
    
    public void actionPerformed(ActionEvent ae)
         {
         setVisible(false);
        new Reception();
              }
    public static void main(String arg[])
    {
        new ManagerInfo();
    }
    
}




