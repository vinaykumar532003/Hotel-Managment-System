
package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class Reception extends JFrame implements ActionListener{
     JButton newcustomer,rooms,department,employee,manager,customers,search,status,roomstatus,pickup,checkout,back;
    
    Reception()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);
        
         newcustomer=new JButton("New Customer Form");
        newcustomer.setBounds(10,30,200,30);
        newcustomer.setBackground(Color.BLACK);
        newcustomer.setForeground(Color.WHITE);
        newcustomer.addActionListener(this);
        add(newcustomer);
        
          rooms=new JButton("All Room Details");
       rooms.setBounds(10,70,200,30);
       rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
         rooms.addActionListener(this);
        add(rooms);
        
         department=new JButton("All Department");
       department.setBounds(10,110,200,30);
       department.setBackground(Color.BLACK);
       department.setForeground(Color.WHITE);
      department.addActionListener(this);
        add(department);
        
         employee=new JButton("All Employee");
       employee.setBounds(10,150,200,30);
      employee.setBackground(Color.BLACK);
       employee.setForeground(Color.WHITE);
         employee.addActionListener(this);
        add(employee);
        
         customers=new JButton("Customers Info");
       customers.setBounds(10,190,200,30);
       customers.setBackground(Color.BLACK);
      customers.setForeground(Color.WHITE);
      customers.addActionListener(this);
        add( customers);
        
        manager=new JButton("Manager Info");
       manager.setBounds(10,230,200,30);
       manager.setBackground(Color.BLACK);
       manager.setForeground(Color.WHITE);
         manager.addActionListener(this);
        add(  manager);
        
          
      
        
          status=new JButton("Update Status");
       status.setBounds(10,270,200,30);
       status.setBackground(Color.BLACK);
       status.setForeground(Color.WHITE);
       status.addActionListener(this); 
       add(status);
        
        
        
           roomstatus=new JButton("Update Room Status");
       roomstatus.setBounds(10,310,200,30);
       roomstatus.setBackground(Color.BLACK);
       roomstatus.setForeground(Color.WHITE);
          roomstatus.addActionListener(this);
        add(roomstatus);
        
        
          pickup=new JButton("Pickup Service");
      pickup.setBounds(10,350,200,30);
       pickup.setBackground(Color.BLACK);
       pickup.setForeground(Color.WHITE);
       pickup.addActionListener(this);
        add(pickup);
        
        
       search=new JButton("Search Rooms");
       search.setBounds(10,390,200,30);
       search.setBackground(Color.BLACK);
       search .setForeground(Color.WHITE);
         search.addActionListener(this);
        add(search);
        
        checkout=new JButton("Checkout");
       checkout.setBounds(10,430,200,30);
       checkout.setBackground(Color.BLACK);
       checkout.setForeground(Color.WHITE);
       checkout.addActionListener(this);
        add(  checkout);
        
        back=new JButton("Go To Dashboard");
      back.setBounds(10,470,200,30);
      back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
        add(back); 
        
                       
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
         JLabel image=new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
        
        setBounds(350,200,800,570);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==newcustomer)
    {
        setVisible(false);
    
      new AddCustomers();
      
      
  }
    else if(e.getSource()==rooms)
    {
        setVisible(false);
    
      new AllRooms();
  }
    else if(e.getSource()==department)
    {
        setVisible(false);
    
      new AllDepartments();
  }
    else if(e.getSource()==employee)
    {
        setVisible(false);
    
      new AllEmployees();
  }
    else if(e.getSource()==manager)
    {
        setVisible(false);
    
      new ManagerInfo();
  }
    else if(e.getSource()==customers)
    {
        setVisible(false);
    
      new CustomerInfo();
  }
     else if(e.getSource()==search)
    {
        setVisible(false);
    
      new SearchForRoom();
  }
    else if(e.getSource()==status)
    {
        setVisible(false);
    
      new UpdateCheck();
  }
    else if(e.getSource()==roomstatus)
    {
        setVisible(false);
    
      new UpdateRoom();
  }
    else if(e.getSource()==pickup)
    {
        setVisible(false);
    
      new PickupService();
  }
        else if(e.getSource()==checkout)
    {
        setVisible(false);
    
      new CheckOut();
  }
      else if(e.getSource()==back)
    {
        setVisible(false);
    
      
  }
      
  }
  
    public static void main(String arg[])
    {
        new Reception();
    }
}
