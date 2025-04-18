
package hotel.management.system;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener{
 public static Choice ccustomer;
    public static JLabel lblroomnum,lblcheckin,lblcheckout,lblpam,lbldeposit,lblday;
   public static JButton checkout,back,search;
  public static Date date;
    CheckOut()
    {
         setResizable(false);
         getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
        JLabel heading=new JLabel("CHECKOUT");
heading.setBounds(150,0,200,20);
heading.setForeground(Color.BLUE);
heading.setFont(new Font("Tahoma", Font.BOLD, 18));
add(heading);

     JLabel lblid=new JLabel("Customer ID");
lblid.setBounds(30,80,100,20);
add(lblid);

ccustomer=new Choice();
ccustomer.setBounds(160,80,150,25);
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

  lblroomnum=new JLabel();
lblroomnum.setBounds(160,120,100,20);
add(lblroomnum);

 JLabel lblcheckintime=new JLabel("Checkin Time");
lblcheckintime.setBounds(30,160,100,20);
add(lblcheckintime);

  lblcheckin=new JLabel();
lblcheckin.setBounds(160,160,200,20);
add(lblcheckin);

JLabel lblam=new JLabel("Pending Amount");
lblam.setBounds(30,200,100,20);
add(lblam);

  lblpam=new JLabel();
lblpam.setBounds(160,200,200,20);
add(lblpam);

lbldeposit=new JLabel();
add(lbldeposit);

 lblday=new JLabel();
add(lblday);

    JLabel lblcheckouttime=new JLabel("Checkout Time");
lblcheckouttime.setBounds(30,240,100,20);
add(lblcheckouttime);

 date=new Date();  
lblcheckout=new JLabel(""+date);
lblcheckout.setBounds(160,240,200,20);
add(lblcheckout);

checkout=new JButton("Checkout");
checkout.setBounds(120, 300, 100, 30);
checkout.setBackground(Color.BLACK);
checkout.setForeground(Color.WHITE);
checkout.addActionListener(this);
add(checkout);

back=new JButton("Back");
back.setBounds(240, 300, 100, 30);
back.setBackground(Color.BLACK);
back.setForeground(Color.WHITE);
back.addActionListener(this);
add(back);

       search=new JButton("Search");
search.setBounds(0, 300, 100, 30);
search.setBackground(Color.BLACK);
search.setForeground(Color.WHITE);
search.addActionListener(this);
add(search); 

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
         Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
        JLabel image1=new JLabel(i3);
        image1.setBounds(320,80,20,20);
        add(image1);
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
         Image i5=i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
         ImageIcon i6=new ImageIcon(i5);
        JLabel image2=new JLabel(i6);
        image2.setBounds(350,50,400,250);
        add(image2);
                
       setBounds(300,200,800,400);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
         {
              if(ae.getSource()==search)
             {
               
                     try{
   Conn c=new Conn();
   ResultSet rs=c.s.executeQuery("select * from customer where idnumber='"+ccustomer.getSelectedItem()+"'");
   while(rs.next())
   {
       
            
       lbldeposit.setText (rs.getString("deposit"));    
       lblroomnum.setText(rs.getString("roomnumber"));
        lblcheckin.setText(rs.getString("checkintime"));
        lblday.setText(rs.getString("daystay"));
   }
   ResultSet rs2=c.s.executeQuery("select * from room where roomnumber='"+lblroomnum.getText()+"'");
            while(rs2.next())
            {
               
                 String price=rs2.getString("price");
                int totalam=Integer.parseInt(price)*Integer.parseInt(lblday.getText());
               int amountpaid=totalam-Integer.parseInt(lbldeposit.getText());
                lblpam.setText(""+amountpaid);
            }
   
}
catch(Exception e)
{
    e.printStackTrace();
}

                     }
             else if(ae.getSource()==checkout)
             {
        
        
    String query="update room set Availability='Available' where roomnumber='"+lblroomnum.getText()+"'";
   try
   {
   Conn c=new Conn();
  
    c.s.executeUpdate(query);
  
    JOptionPane.showMessageDialog(null, "Checkout done successfully");
                 setVisible (false);
                  new BillDetails();
   
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
         }
    public static void main(String arg[])
    {
        new CheckOut();
    }
}
