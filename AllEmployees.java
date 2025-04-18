
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class AllEmployees extends JFrame implements ActionListener 
{

    JTable table;
    JButton back,search;
Choice id;
    
   AllEmployees ()
    {
        JLabel heading=new JLabel("ALL EMPLOYEES");
heading.setBounds(500,0,200,20);
heading.setFont(new Font("Tahoma", Font.BOLD, 18));
add(heading);

         setResizable(false);
        getContentPane().setBackground(Color.WHITE);
       setLayout(null);

JLabel lblid =new JLabel("Employee ID");
lblid.setBounds(70,30,100,20);
add(lblid);

id=new Choice();
id.setBounds(170,30,100,20);
add(id);

try{
   Conn conn=new Conn();
   ResultSet rs=conn.s.executeQuery("select * from employee");
   while(rs.next())
   {
       id.add(rs.getString("employee_id"));
   }
   
   
}
catch(Exception e)
{
    e.printStackTrace();
}
                      
JLabel l1=new JLabel("Name");
        l1.setBounds(40,80,100,20);
        add(l1);
        
         JLabel l2=new JLabel("Age");
        l2.setBounds(170,80,100,20);
        add(l2);
        
         JLabel l3=new JLabel("Gender");
        l3.setBounds(300,80,100,20);
        add(l3);
        
         JLabel l4=new JLabel("Job Profile");
        l4.setBounds(430,80,100,20);
        add(l4);
        
         JLabel l5=new JLabel("Salary");
        l5.setBounds(550,80,100,20);
        add(l5);
        
         JLabel l6=new JLabel("Phone no.");
        l6.setBounds(680,80,100,20);
        add(l6);
        
          JLabel l7=new JLabel("Email ID");
        l7.setBounds(820,80,100,20);
        add(l7);
        
          JLabel l8=new JLabel("Aadhar no.");
        l8.setBounds(950,80,100,20);
        add(l8);
        
        JLabel l9=new JLabel("Employee ID");
        l9.setBounds(1080,80,100,20);
        add(l9);
        
        table=new JTable();
        table.setBounds(0, 110, 1200, 400);
        add(table);
        
        
        try{
    Conn conn=new Conn();
    ResultSet rs1=conn.s.executeQuery("select * from employee ");
    table.setModel(DbUtils.resultSetToTableModel(rs1));
    
}
catch(Exception e)
{
    e.printStackTrace();
}
        search=new JButton("Search");
search.setBounds(350, 510, 120, 30);
search.setBackground(Color.BLACK);
search.setForeground(Color.WHITE);
search.addActionListener(this);
add(search);

 back=new JButton("Back");
back.setBounds(550, 510, 120, 30);
back.setBackground(Color.BLACK);
back.setForeground(Color.WHITE);
back.addActionListener(this);
add(back); 
        
        
     setBounds(200,200,1200,600);
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
       
 String query="select * from employee where employee_id='"+id.getSelectedItem()+"'";
 ResultSet rs2 =conn.s.executeQuery(query);
   table.setModel(DbUtils.resultSetToTableModel(rs2));
            }
       catch(Exception e)
      {
               e.printStackTrace();
      }
        
        
    }  
         }


    public static void main(String arg[])
    {
        new AllEmployees ();
    }
    
}


