
package hotel.management.system;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener{
  Choice ccustomer;
  JTextField tfroom,tfname,tfcheckin,tfpaid,tfday;
  JButton check,update ,back;
  JLabel tftam,tfpending;
  static int totalam;
    UpdateCheck()
    {
         setResizable(false);
        getContentPane().setBackground(Color.WHITE);
       setLayout(null);
        
         JLabel heading=new JLabel("UPDATE STATUS");
heading.setBounds(100,0,200,20);
heading.setForeground(Color.BLUE);
heading.setFont(new Font("Tahoma", Font.BOLD, 18));
add(heading);

     JLabel lblid=new JLabel("Customer ID");
lblid.setBounds(30,80,100,20);
add(lblid);

ccustomer=new Choice();
ccustomer.setBounds(200,80,150,25);
add(ccustomer);

try{
   Conn c=new Conn();
   ResultSet rs=c.s.executeQuery("select * from customer");
   while(rs.next())
   {
       ccustomer.add(rs.getString("idnumber"));
   }
   
   
}
catch(Exception e)
{
    e.printStackTrace();
}

JLabel lblroom=new JLabel("Room Number");
lblroom.setBounds(30,120,100,20);
add(lblroom);

 tfroom=new JTextField();
tfroom.setBounds(200, 120, 150, 25);
add(tfroom);

JLabel lblname=new JLabel("Name");
 lblname.setBounds(30,160,100,20);
add(lblname);

tfname=new JTextField();
tfname.setBounds(200,160,150,25);
add(tfname);

JLabel lblcheckin=new JLabel("Checkin Time");
lblcheckin.setBounds(30,200,100,20);
add(lblcheckin);

tfcheckin=new JTextField();
tfcheckin.setBounds(200,200,150,25);
add(tfcheckin);

JLabel lblday=new JLabel("Days Stay");
lblday.setBounds(30,240,100,20);
add(lblday);

tfday=new JTextField();
tfday.setBounds(200,240,150,25);
add(tfday);

JLabel lbltam=new JLabel("Total Amount");
lbltam.setBounds(30,280,100,20);
add(lbltam);

tftam=new JLabel();
tftam.setBounds(200,280,150,25);
add(tftam);

JLabel lblpaid=new JLabel("Amount Paid");
lblpaid.setBounds(30,320,100,20);
add(lblpaid);

tfpaid=new JTextField();
tfpaid.setBounds(200,320,150,25);
add(tfpaid);

JLabel lblpending=new JLabel("Pending Amount");
lblpending.setBounds(30,360,100,20);
add(lblpending);

tfpending=new JLabel();
tfpending.setBounds(200,360,150,25);
add(tfpending);

check=new JButton("Check");
check.setBounds(50, 420, 100, 30);
check.setBackground(Color.BLACK);
check.setForeground(Color.WHITE);
check.addActionListener(this);
add(check);

update=new JButton("Update");
update.setBounds(200, 420, 100, 30);
update.setBackground(Color.BLACK);
update.setForeground(Color.WHITE);
update.addActionListener(this);
add(update);

back=new JButton("Back");
back.setBounds(350, 420, 100, 30);
back.setBackground(Color.BLACK);
back.setForeground(Color.WHITE);
back.addActionListener(this);
add(back);

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        
        JLabel image=new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
               
        setBounds(300,200,980,500);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae)
         {
              if(ae.getSource()==check)
              {
             String id=ccustomer.getSelectedItem();
             String query="select * from customer where idnumber ='"+id+"'";
           try{
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery(query);
           while(rs.next())
           {
               tfroom.setText(rs.getString("roomnumber"));
                tfname.setText(rs.getString("name"));
                 tfcheckin.setText(rs.getString("checkintime"));
                  tfpaid.setText(rs.getString("deposit"));
                  tfday.setText(rs.getString("daystay"));
           }     
           
            ResultSet rs2=c.s.executeQuery("select * from room where roomnumber='"+tfroom.getText()+"'");
            while(rs2.next())
            {
                String price=rs2.getString("price");
                
                
                  totalam=Integer.parseInt(price)*Integer.parseInt(tfday.getText());
                  tftam.setText(""+totalam);
                  int amountpaid=totalam-Integer.parseInt(tfpaid.getText());
                tfpending.setText(""+amountpaid);
            }
           
          }  
         catch(Exception e)
      {
            
         e.printStackTrace();
    }
              }
                  else if(ae.getSource()==update)
                  {
                String id=ccustomer.getSelectedItem();
               String room=tfroom.getText();
                String name=tfname.getText();
                 String checkin=tfcheckin.getText();
                  String deposited=tfpaid.getText();
                  String day=tfday.getText();
                  
                  try{
               Conn c=new Conn();
           c.s.executeUpdate("update customer set roomnumber='"+room+"',name='"+name+"',checkintime='"+checkin+"',deposit='"+deposited+"',daystay='"+day+"' where idnumber='"+id+"'");
         
            JOptionPane.showMessageDialog(null, "Data updated successfully");
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
        new UpdateCheck();
                
    }
}
