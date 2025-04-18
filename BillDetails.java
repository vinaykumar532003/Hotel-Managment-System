
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;



public class BillDetails extends JFrame implements ActionListener{
       JLabel lblname,lblgender,lblcoun,lblcheckin,lblcheckout,lblroomnum,lblbed,lblroomtype,lblprice,lbltamt,lblday;
     JButton print;
     int totalam;
BillDetails()
{
     setResizable(false);
   getContentPane().setBackground(Color.WHITE);
    setLayout(null);
   
     JLabel heading=new JLabel("HOTEL METROPOLE");
heading.setBounds(210,0,300,30);
heading.setForeground(Color.BLACK);
heading.setFont(new Font("Tahoma", Font.BOLD, 30));
add(heading);
     
  JLabel adrs=new JLabel("15 ,Lakshmipuram, Mysuru -570005");
adrs.setBounds(250,20,300,40);
add(adrs);

    JLabel head=new JLabel("BILL DETAILS:-");
head.setBounds(0,30,250,30);
head.setForeground(Color.BLUE);
head.setFont(new Font("Tahoma", Font.BOLD, 18));
add(head);
    
JLabel star=new JLabel("********************************************************************");
 star.setFont(new Font("Tahoma", Font.BOLD, 18));
star.setBounds(0, 50,700 ,20);
   add(star);
   
JLabel cd=new JLabel("Customer Details:-");
cd.setFont(new Font("Tahoma", Font.BOLD, 17));
cd.setBounds(0,70,200,20);
add(cd);

JLabel name=new JLabel("Name:");
name.setBounds(0,90,100,40);
add(name);

lblname=new JLabel();
lblname.setBounds(40,100,100,20);
add(lblname);

JLabel gender=new JLabel("Gender:");
gender.setBounds(0,130,100,40);
add(gender);

lblgender=new JLabel();
lblgender.setBounds(50,140,100,20);
add(lblgender);

JLabel country=new JLabel("Country:");
country.setBounds(0,170,100,40);
add(country);

lblcoun=new JLabel();
lblcoun.setBounds(50,180,100,20);
add(lblcoun);

JLabel checkin=new JLabel("CheckIN Time:");
checkin.setBounds(0,210,100,40);
add(checkin);
 
lblcheckin=new JLabel();
lblcheckin.setBounds(85,220,200,20);
add(lblcheckin);

  
   
 JLabel checkout=new JLabel("CheckOUT Time:");
checkout.setBounds(0,250,100,40);
add(checkout);
 
lblcheckout=new JLabel();
lblcheckout.setBounds(100,260,200,20);
add(lblcheckout);

JLabel day=new JLabel("Days Stay:");
day.setBounds(0,290,100,20);
add(day);


lblday=new JLabel();
lblday.setBounds(65,290,100,20);
add(lblday);


JLabel star2=new JLabel("********************************************************************");
 star2.setFont(new Font("Tahoma", Font.BOLD, 18));
star2.setBounds(0, 310,700 ,20);
   add(star2);
   
 JLabel room=new JLabel("Room Details:-");
room.setFont(new Font("Tahoma", Font.BOLD, 17));
room.setBounds(0,320,200,20);
add(room);

JLabel roomnum=new JLabel("Room Number:");
roomnum.setBounds(0,350,100,40);
add(roomnum);

lblroomnum=new JLabel();
lblroomnum.setBounds(87,360,100,20);
add(lblroomnum);

JLabel bed=new JLabel("Bed Type:");
bed.setBounds(0,390,100,40);
add(bed);

lblbed=new JLabel();
lblbed.setBounds(60,400,100,20);
add(lblbed);

JLabel roomtype=new JLabel("Room Type:");
roomtype.setBounds(0,430,100,40);
add(roomtype);

lblroomtype=new JLabel();
lblroomtype.setBounds(70,440,100,20);
add(lblroomtype);

JLabel price=new JLabel("Price:");
price.setBounds(0,470,100,40);
add(price);

lblprice=new JLabel();
lblprice.setBounds(37,480,100,20);
add(lblprice);

JLabel star3=new JLabel("********************************************************************");
 star3.setFont(new Font("Tahoma", Font.BOLD, 18));
star3.setBounds(0, 510,700 ,20);
   add(star3);
   
   JLabel tam=new JLabel("Total Amount:");
tam.setBounds(0,520,300,40);
add(tam);

lbltamt=new JLabel();
lbltamt.setBounds(80,530,100,20);
add(lbltamt);

  
 JLabel msg=new JLabel("Thank You,Please Visit Again.");
 msg.setFont(new Font("Tahoma", Font.BOLD, 17));
msg.setBounds(400,520,300,40);
add(msg);  
 
JLabel contact=new JLabel("Contact No. :1234567890");
contact.setBounds(450,540,200,40);
add(contact);

   print=new JButton("Print");
 print.setBounds(250, 570, 100, 30);
 print.setBackground(Color.BLACK);
 print.setForeground(Color.WHITE);
 print.addActionListener(this);
add( print);

setBounds(400,150,700,650);
 setVisible(true);

     
               lblcheckout.setText(""+CheckOut.date);
                    String id=CheckOut.ccustomer.getSelectedItem();
              String query="select * from customer where idnumber='"+id+"'";
            try{
                 Conn c=new Conn();
   ResultSet rs=c.s.executeQuery(query);
   while(rs.next())
   {
       
            
       lblname.setText (rs.getString("name"));  
       lblgender.setText (rs.getString("gender"));  
   lblcheckin.setText(rs.getString("checkintime"));
       lblcoun.setText(rs.getString("country"));
    lblday.setText(rs.getString("daystay"));
    
       
   }
   
   ResultSet rs2=c.s.executeQuery("select * from room where roomnumber='"+CheckOut.lblroomnum.getText()+"'");
            while(rs2.next())
            {
               lblroomnum.setText (rs2.getString("roomnumber"));    
       lblbed.setText(rs2.getString("bed_type"));
        lblroomtype.setText(rs2.getString("room_type"));
       lblprice.setText(rs2.getString("price"));
             
                
                
                  totalam=Integer.parseInt(lblprice.getText())*Integer.parseInt(lblday.getText()); 
                  lbltamt.setText(""+totalam);
            }
   
}
catch(Exception e)
{
    e.printStackTrace();
}
}
  public void actionPerformed(ActionEvent ae)
         {
             
              if(ae.getSource()==print)
             {
                 try
   {
   Conn c=new Conn();
  
                  String query="delete from customer where idnumber='"+CheckOut.ccustomer.getSelectedItem()+"'";
                   c.s.executeUpdate(query);
    JOptionPane.showMessageDialog(null, "Printout done successfully");
                 setVisible (false);
                  new Reception(); 
             }
                            
   catch(Exception e)
{
    e.printStackTrace();
}

         }
         }

public static void main(String arg[])
{
    new BillDetails();
}
}
