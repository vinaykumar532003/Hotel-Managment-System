
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class AddCustomers extends JFrame implements ActionListener {
    JComboBox comboid,combocountry;
    JTextField tfnum,tfname,tfdeposit,tfday;
    JRadioButton rbmale,rbfemale;
    Choice croom;
    JButton add,back;
    JLabel checkintime;
    
    AddCustomers()
    {
        setLayout(null);
         setResizable(false);
        
        JLabel heading=new JLabel("NEW CUSTOMER FORM");
heading.setBounds(100,20,300,30);
heading.setFont(new Font("Tahoma", Font.BOLD, 18));
add(heading);


JLabel lblid=new JLabel("Customer ID");
 lblid.setBounds(35,80,100,20);
 lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
add( lblid);

String Options[]={"Aadhar Card","PAN Card","Passport","Driving Licence","Voter ID","Ration Card"};
 comboid=new JComboBox(Options);
comboid.setBounds(200,80,150,25);
add(comboid);

JLabel lblnum=new JLabel("ID Number");
 lblnum.setBounds(35,120,100,20);
 lblnum.setFont(new Font("Tahoma", Font.PLAIN, 16));
add( lblnum);

tfnum=new JTextField();
tfnum.setBounds(200,120,150,25);
add(tfnum);

JLabel lblname=new JLabel("Name");
 lblname.setBounds(35,160,100,20);
  lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
add(  lblname);

tfname=new JTextField();
tfname.setBounds(200,160,150,25);
add(tfname);


JLabel lblgender=new JLabel("Gender");
 lblgender.setBounds(35,200,100,20);
  lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
add(  lblgender);

  rbmale=new JRadioButton("Male");
    rbmale.setBounds(200,200,60,25);
    rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
      add(rbmale);

 rbfemale=new JRadioButton("Female");
     rbfemale.setBounds(270,200,100,25);
   rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
      add( rbfemale);
      
      ButtonGroup bg=new ButtonGroup();
      bg.add(rbmale);
      bg.add(rbfemale);

      JLabel lblcountry=new JLabel("Country");
  lblcountry.setBounds(35,240,100,20);
 lblcountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
add(lblcountry);

String countryOpt[]={"India","Pakistan","Bangladesh","Italy","Japan","USA","UK","Russia","France","Germany","Canada","Australia","Spain","Kenya","Austria","Norway"};
 combocountry=new JComboBox(countryOpt);
combocountry.setBounds(200,240,150,25);
add(combocountry);

JLabel lblroom=new JLabel("Room Number");
 lblroom.setBounds(35,280,150,20);
 lblroom.setFont(new Font("Tahoma", Font.PLAIN, 16));
add(lblroom);
      
croom=new Choice();

try{
    Conn conn=new Conn();
    String query="select * from room where Availability='Available'";
    ResultSet rs=conn.s.executeQuery(query);
    while(rs.next())
    {
        croom.add(rs.getString("roomnumber"));
        }
}
catch(Exception e)
{
    e.printStackTrace();
}
croom.setBounds(200,280,150,25);
add(croom);
  
JLabel lbltime=new JLabel("Checkin time");
  lbltime.setBounds(35,320,150,20);
  lbltime.setFont(new Font("Tahoma", Font.PLAIN, 16));
add(lbltime);

Date date =new Date();

checkintime =new JLabel("" +date);
checkintime.setBounds(200,320,150,25);
 checkintime.setFont(new Font("Tahoma", Font.PLAIN, 16));
add(checkintime);

JLabel lblday=new JLabel("Days Stay");
 lblday.setBounds(35,360,150,20);
 lblday.setFont(new Font("Tahoma", Font.PLAIN, 16));
add( lblday);

tfday=new JTextField();
tfday.setBounds(200,360,150,25);
add(tfday);

JLabel lbldeposit=new JLabel("Deposit amount");
 lbldeposit.setBounds(35,400,150,20);
lbldeposit.setFont(new Font("Tahoma", Font.PLAIN, 16));
add( lbldeposit);


tfdeposit=new JTextField();
tfdeposit.setBounds(200,400,150,25);
add(tfdeposit);

add=new JButton("Add");
add.setBounds(50, 460, 100, 30);
add.setBackground(Color.BLACK);
add.setForeground(Color.WHITE);
add.addActionListener(this);
add(add);

back=new JButton("Back");
back.setBounds(200, 460, 100, 30);
back.setBackground(Color.BLACK);
back.setForeground(Color.WHITE);
back.addActionListener(this);
add(back);

               
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
         Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);

setBounds(350,200,800,550);
        setVisible(true);
        
    }
         public void actionPerformed(ActionEvent ae)
         {
            
     
  
     if(ae.getSource()==add)
    {
        String number=tfnum.getText();
  String name=tfname.getText();
  String deposit=tfdeposit.getText();
   String room=croom.getSelectedItem();
   String time=checkintime.getText();
  String id=(String) comboid.getSelectedItem();
   String country=(String) combocountry.getSelectedItem();
   String day=tfday.getText();
   
     if(name.equals(""))
  {
       JOptionPane.showMessageDialog(null, "Name should not be empty");
       return;
  }
  if(number.equals(""))
  {
       JOptionPane.showMessageDialog(null, "ID Number should not be empty");
       return;
  }
   if(deposit.equals(""))
  {
       JOptionPane.showMessageDialog(null, "Deposit Amount should not be empty");
       return;
  }
    for(int i=0;i<deposit.length();i++)
   {
   if((deposit.charAt(i)>='a'&&deposit.charAt(i)<='z')||(deposit.charAt(i)>='A'&&deposit.charAt(i)<='Z'))
   {
      JOptionPane.showMessageDialog(null, "Invalid Amount");
       return;   
   } 
   }
    if(day.equals(""))
  {
       JOptionPane.showMessageDialog(null, "Days Stay should not be empty");
       return;
  }
     
  
  if("Aadhar Card".equals(id))
  {
if(number.length()!=12)
{
  JOptionPane.showMessageDialog(null, "Invalid Aadhar No.");
       return;  
}
  
  for(int i=0;i<number.length();i++)
   {
   if((number.charAt(i)>='a'&&number.charAt(i)<='z')||(number.charAt(i)>='A'&&number.charAt(i)<='Z'))
   {
      JOptionPane.showMessageDialog(null, "Invalid Aadhar No.");
       return;   
   } 
   }
}
  else if("PAN Card".equals(id))
  {
if(number.length()!=10)
{
  JOptionPane.showMessageDialog(null, "Invalid PAN No.");
       return;  
}
  } 
  else if("Passport".equals(id))
  {
if(number.length()!=12)
{
  JOptionPane.showMessageDialog(null, "Invalid Passport No.");
       return;  
}
  } 
  else if("Driving Licence".equals(id))
  {
if(number.length()!=16)
{
  JOptionPane.showMessageDialog(null, "Invalid Licence No.");
       return;  
}
  } 
  else if("Voter ID".equals(id))
  {
if(number.length()!=10)
{
  JOptionPane.showMessageDialog(null, "Invalid Voter ID No.");
       return;  
}
  } 
  else if("Ration Card".equals(id))
  {
if(number.length()!=12)
{
  JOptionPane.showMessageDialog(null, "Invalid Ration Card No.");
       return;  
}
  } 

 
   String gender="";
      if(rbmale.isSelected()){
      gender="Male";
      
  }
  else if(rbfemale.isSelected()){
      gender="Female";
  }
      
      
    if(gender.isEmpty())
  {
       JOptionPane.showMessageDialog(null,"Gender is not selected");
       return;
  }
        try{
         Conn conn=new Conn();
       
 String query1="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"','"+day+"')";
 String query2="update room set Availability='Occupied' where roomnumber='"+room+"'";
 conn.s.executeUpdate(query1);
    conn.s.executeUpdate(query2);         
       JOptionPane.showMessageDialog(null, "New Customer added successfully");
                 setVisible (false);
                  new Reception();
        
    }
    catch(Exception e)
      {
            
         e.printStackTrace();
    } 
    }
     else if(ae.getSource()==back){
        setVisible(false);
        new Reception();
            }
         }
  public static void main(String arg[])
  {
      new AddCustomers();
  }
   
}