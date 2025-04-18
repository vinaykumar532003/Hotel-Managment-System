

package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDrivers extends JFrame implements ActionListener {

JButton add,cancel;
JRadioButton rbmale,rbfemale;
JTextField tfname,tfcompany,tfage,tfgender,tfmodel,tflocation,tfphone;
JComboBox availablecombo;

    AddDrivers ()
    {
        setLayout(null);
getContentPane().setBackground(Color.WHITE);
 setResizable(false);

JLabel heading=new JLabel("ADD DRIVERS");
heading.setBounds(150,0,200,20);
heading.setFont(new Font("Tahoma", Font.BOLD, 18));
add(heading);

JLabel lblroomno=new JLabel("Name");
lblroomno.setBounds(60,50,120,30);
lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
add(lblroomno);

 tfname=new JTextField();
 tfname.setBounds(200, 50, 150, 30);
add (tfname);

JLabel lblage=new JLabel("Age");
 lblage.setBounds(60,100,120,30);
 lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
add( lblage);


 tfage=new JTextField();
 tfage.setBounds(200, 100, 150, 30);
add (tfage);

JLabel lblgender=new JLabel("Gender");
lblgender.setBounds(60,150,120,30);
lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
 add(lblgender);

  rbmale=new JRadioButton("Male");
    rbmale.setBounds(200,150,70,30);
    rbmale.setBackground(Color.WHITE);
    rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
      add(rbmale);

 rbfemale=new JRadioButton("Female");
     rbfemale.setBounds(270,150,100,30);
    rbfemale.setBackground(Color.WHITE);
     rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
      add( rbfemale);
      
      ButtonGroup bg=new ButtonGroup();
      bg.add(rbmale);
      bg.add(rbfemale);

  JLabel lblphone=new JLabel("Mobile No.");
lblphone.setBounds(60,200,120,30);
 lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
 add(lblphone);

 tfphone=new JTextField();
 tfphone.setBounds(200,200,150,30);
add(tfphone);



JLabel lblcompany=new JLabel("Car Company");
lblcompany.setBounds(60,250,120,30);
lblcompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
add(lblcompany);

 tfcompany=new JTextField();
 tfcompany.setBounds(200, 250, 150, 30);
add( tfcompany);

JLabel lblmodel=new JLabel("Car Model");
 lblmodel.setBounds(60,300,120,30);
 lblmodel.setFont(new Font("Tahoma", Font.PLAIN, 16));
add(  lblmodel);


 tfmodel=new JTextField();
 tfmodel.setBounds(200, 300, 150, 30);
add (tfmodel);

JLabel lbldriver=new JLabel("Availability");
 lbldriver.setBounds(60,350,120,30);
 lbldriver.setFont(new Font("Tahoma", Font.PLAIN, 16));
add( lbldriver);

String driverOptions[]={"Available","Busy"};
availablecombo=new JComboBox(driverOptions);
availablecombo.setBounds(200,350,150,30);
availablecombo.setBackground(Color.WHITE);
add(availablecombo);

JLabel lbllocation=new JLabel("Location");
 lbllocation.setBounds(60,400,120,30);
 lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
add(  lbllocation);


 tflocation=new JTextField();
 tflocation.setBounds(200, 400, 150, 30);
add (tflocation);
 
       
 add=new JButton("Add");
       add.setBounds(60,460,130,30);
       add.setBackground(Color.BLACK);
       add.setForeground(Color.WHITE);
        add.addActionListener(this);
               add(add);
      
                
 cancel=new JButton("Cancel");
       cancel.setBounds(220,460,130,30);
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
               add( cancel);
     
               
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
         Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,70,500,300);
        add(image);
               
        setBounds(300,200,980,550);
        setVisible(true);
    }
              
     public void actionPerformed(ActionEvent ae)
{ 
    if(ae.getSource()==add){
          String name=tfname.getText();
  String age=tfage.getText();
 String carcompany=tfcompany.getText();
    String carmodel=tfmodel.getText();
  String availability=(String) availablecombo.getSelectedItem();
 String location=tflocation.getText();
 String phone=tfphone.getText();
 
   if(name.equals(""))
  {
       JOptionPane.showMessageDialog(null, "Name should not be empty");
       return;
  }
   if(phone.equals(""))
  {
       JOptionPane.showMessageDialog(null, "Phone No. should not be empty");
       return;
  }
   for(int i=0;i<phone.length();i++)
   {
   if((phone.charAt(i)>='a'&&phone.charAt(i)<='z')||(phone.charAt(i)>='A'&&phone.charAt(i)<='Z'))
   {
      JOptionPane.showMessageDialog(null, "Invalid Mobile No.");
       return;   
   } 
   }
   if(age.equals(""))
  {
       JOptionPane.showMessageDialog(null, "Age should not be empty");
       return;
  }
   for(int i=0;i<age.length();i++)
   {
   if((age.charAt(i)>='a'&&age.charAt(i)<='z')||(age.charAt(i)>='A'&&age.charAt(i)<='Z'))
   {
      JOptionPane.showMessageDialog(null, "Invalid Age");
       return;   
   } 
   }
  if(location.equals(""))
  {
       JOptionPane.showMessageDialog(null, "Location should not be empty");
       return;
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
       
 String query="insert into drivers values('"+name+"','"+age+"','"+gender+"','"+carcompany+"','"+carmodel+"','"+availability+"','"+location+"','"+phone+"')";
 conn.s.executeUpdate(query);
             
       JOptionPane.showMessageDialog(null, "New Driver added successfully");
                 setVisible (false);
        
    }
    catch(Exception e)
      {
               e.printStackTrace();
      }
    
    
    
    }
    else if(ae.getSource()==cancel)
    {
        setVisible(false);
    }
 
   
    }

public static void main(String args[])
{
new AddDrivers();
}
}
