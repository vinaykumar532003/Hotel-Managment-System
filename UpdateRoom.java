
package hotel.management.system;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener{
  Choice room;
  JTextField tfbed,tfavailable,tfstatus,tfprice,tfroom;
  JButton check,update ,back;
    UpdateRoom()
    {
         setResizable(false);
        getContentPane().setBackground(Color.WHITE);
       setLayout(null);
        
         JLabel heading=new JLabel("UPDATE ROOM STATUS");
heading.setBounds(100,0,250,30);
heading.setForeground(Color.BLUE);
heading.setFont(new Font("Tahoma", Font.BOLD, 18));
add(heading);

     JLabel lblid=new JLabel("Room Number");
lblid.setBounds(30,80,100,20);
add(lblid);

room=new Choice();
room.setBounds(200,80,150,25);
add(room);

try{
   Conn c=new Conn();
   ResultSet rs=c.s.executeQuery("select * from room");
   while(rs.next())
   {
       room.add(rs.getString("roomnumber"));
   }
   
   
}
catch(Exception e)
{
    e.printStackTrace();
}

JLabel lblbed=new JLabel("Bed Type");
lblbed.setBounds(30,120,100,20);
add(lblbed);

 tfbed=new JTextField();
tfbed.setBounds(200, 120, 150, 25);
add(tfbed);

JLabel lblavailable=new JLabel("Availability");
 lblavailable.setBounds(30,160,100,20);
add( lblavailable);

tfavailable=new JTextField();
tfavailable.setBounds(200,160,150,25);
add(tfavailable);

JLabel lblcheckin=new JLabel("Cleaning Status");
lblcheckin.setBounds(30,200,100,20);
add(lblcheckin);

tfstatus=new JTextField();
tfstatus.setBounds(200,200,150,25);
add(tfstatus);

JLabel lblprice=new JLabel("Room Price");
lblprice.setBounds(30,240,100,20);
add(lblprice);

tfprice=new JTextField();
tfprice.setBounds(200,240,150,25);
add(tfprice);

JLabel lblroom=new JLabel("Room Type");
lblroom.setBounds(30,280,100,20);
add(lblroom);

tfroom=new JTextField();
tfroom.setBounds(200,280,150,25);
add(tfroom);

check=new JButton("Check");
check.setBounds(30, 350, 100, 30);
check.setBackground(Color.BLACK);
check.setForeground(Color.WHITE);
check.addActionListener(this);
add(check);

update=new JButton("Update");
update.setBounds(150, 350, 100, 30);
update.setBackground(Color.BLACK);
update.setForeground(Color.WHITE);
update.addActionListener(this);
add(update);

back=new JButton("Back");
back.setBounds(270, 350, 100, 30);
back.setBackground(Color.BLACK);
back.setForeground(Color.WHITE);
back.addActionListener(this);
add(back);

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
         Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);
               
        setBounds(300,200,980,450);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae)
         {
              if(ae.getSource()==check)
              {
             String num=room.getSelectedItem();
             String query="select * from room where roomnumber ='"+num+"'";
           try{
           Conn c=new Conn();
           
        ResultSet rs2=c.s.executeQuery(query);
            while(rs2.next())
            {
                tfbed.setText(rs2.getString("bed_type"));
                tfavailable.setText(rs2.getString("Availability"));
                tfstatus.setText(rs2.getString("Cleaning_status"));
                tfprice.setText(rs2.getString("price"));
                tfroom.setText(rs2.getString("room_type"));
            }
           
          }  
         catch(Exception e)
      {
            
         e.printStackTrace();
    }
              }
                  else if(ae.getSource()==update)
                  {
                       String num=room.getSelectedItem();
                String bed=tfbed.getText();
               String status=tfstatus.getText();
                String available=tfavailable.getText();
                String pr=tfprice.getText();
                String rtype=tfroom.getText();
                  
                  try{
               Conn c=new Conn();
     c.s.executeUpdate("update room set bed_type='"+bed+"',Cleaning_status='"+status+"',Availability='"+available+"',price='"+pr+"',room_type='"+rtype+"' where roomnumber='"+num+"'");
         
     JOptionPane.showMessageDialog(null, "Room Status updated successfully");
                 setVisible (false);
                  new Reception();
                  
                  
          
          }  
         catch(Exception e)
      {
            
         e.printStackTrace();
    }
                  }
             else if(ae.getSource()==back)
    {
        setVisible(false);
        new Reception();
    }
  
         }  public static void main(String args[])
    {
        new UpdateRoom();
                
    }
}
