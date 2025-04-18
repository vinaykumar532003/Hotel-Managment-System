
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class AllDepartments extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    
    AllDepartments()
    {
        JLabel heading=new JLabel("ALL DEPARTMENTS");
heading.setBounds(200,0,200,20);
heading.setFont(new Font("Tahoma", Font.BOLD, 18));
add(heading);

        
        getContentPane().setBackground(Color.WHITE);
       setLayout(null);
         setResizable(false);              

        JLabel l1=new JLabel("Departments");
        l1.setBounds(100,20,100,20);
        add(l1);
        
         JLabel l2=new JLabel("Budget");
        l2.setBounds(420,20,100,20);
        add(l2);
        
         
        
        table=new JTable();
        table.setBounds(0, 50, 700, 350);
        add(table);
        
        try{
    Conn conn=new Conn();
    ResultSet rs=conn.s.executeQuery("select * from department ");
    table.setModel(DbUtils.resultSetToTableModel(rs));
    
}
catch(Exception e)
{
    e.printStackTrace();
}

 back=new JButton("Back");
back.setBounds(280, 400, 120, 30);
back.setBackground(Color.BLACK);
back.setForeground(Color.WHITE);
back.addActionListener(this);
add(back); 
        
        
     setBounds(400,200,700,480);
     setVisible(true);
        
      
       
     
        
    }
    
    public void actionPerformed(ActionEvent ae)
         {
         setVisible(false);
        new Reception();
              }
    public static void main(String arg[])
    {
        new AllDepartments();
    }
    
}


