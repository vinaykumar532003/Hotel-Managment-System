package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {

JTextField tfage, tfsalary, tfgender, tfphone, tfemail, tfname,tfaadhar,tfid;
JRadioButton rbmale,rbfemale;
 JButton submit,cancel;
JComboBox cbjob;
AddEmployee()
{
setLayout(null);
 setResizable(false);

JLabel heading=new JLabel("ADD EMPLOYEE");
heading.setBounds(150,0,200,20);
heading.setFont(new Font("Tahoma", Font.BOLD, 18));
add(heading);

JLabel lblid=new JLabel("EMPLOYEE ID");
lblid.setBounds(60,40,120,30);
lblid.setFont(new Font("Tahoma", Font.PLAIN, 17));
add(lblid);

  tfid=new JTextField();
tfid.setBounds(200,40,150,30);
add(tfid);

JLabel lblname=new JLabel("NAME");
lblname.setBounds(60,80,120,30);
lblname.setFont(new Font("Tahoma", Font.PLAIN, 17));
add(lblname);

  tfname=new JTextField();
tfname.setBounds(200,80,150,30);
add(tfname);
 

JLabel lblage=new JLabel("AGE");
lblage.setBounds(60,120,120,30);
 lblage.setFont(new Font("Tahoma", Font.PLAIN, 17));
 add(lblage);

tfage=new JTextField();
 tfage.setBounds(200,120,150,30);
add( tfage);


JLabel lblgender=new JLabel("GENDER");
lblgender.setBounds(60,160,120,30);
 lblgender.setFont(new Font("Tahoma", Font.PLAIN, 17));
 add(lblgender);

  rbmale=new JRadioButton("Male");
     rbmale.setBounds(200,160,70,30);
      rbmale.setBackground(Color.WHITE);
    rbmale.setFont(new Font("Tahoma", Font.PLAIN, 14));
      add(rbmale);

 rbfemale=new JRadioButton("Female");
     rbfemale.setBounds(280,160,70,30);
      rbfemale.setBackground(Color.WHITE);
    rbfemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
      add(rbfemale);
      
      ButtonGroup bg=new ButtonGroup();
      bg.add(rbmale);
      bg.add(rbfemale);
      
      
JLabel lbljob=new JLabel("JOB");
 lbljob.setBounds(60,200,120,30);
 lbljob.setFont(new Font("Tahoma", Font.PLAIN, 17));
 add(lbljob);


String str[]={"Front Desk Clerks", "Porters" , "HouseKeeping","Kitchen Staff ","Room Service","Manager","Chefs","Waiter/Waitress","Accountant"};
cbjob=new JComboBox(str);
cbjob.setBounds(200, 200, 150,30);
cbjob.setBackground(Color.WHITE);
add(cbjob);

 JLabel lblsalary=new JLabel("SALARY");
 lblsalary.setBounds(60,250,120,30);
 lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
 add(lblsalary);

 tfsalary=new JTextField();
tfsalary.setBounds(200,250,150,30);
add( tfsalary);

  JLabel lblphone=new JLabel("PHONE NO.");
lblphone.setBounds(60,300,120,30);
 lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
 add(lblphone);

 tfphone=new JTextField();
 tfphone.setBounds(200,300,150,30);
add(tfphone);



 JLabel lblemail=new JLabel("EMAIL ID");
 lblemail.setBounds(60,350,120,30);
 lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
 add(lblemail);

 tfemail=new JTextField();
tfemail.setBounds(200,350,150,30);
add(tfemail);

JLabel lblaadhar=new JLabel("AADHAR NO.");
lblaadhar.setBounds(60,400,120,30);
 lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
 add(lblaadhar);

tfaadhar=new JTextField();
 tfaadhar.setBounds(200,400,150,30);
add( tfaadhar);

    submit=new JButton("SUBMIT");
        submit.setBounds(60,460,130,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
 submit.addActionListener(this);
       add( submit);
       
        cancel=new JButton("Cancel");
       cancel.setBounds(220,460,130,30);
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
               add( cancel);

ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
         Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);
        
   

getContentPane().setBackground(Color.WHITE);
setBounds(350,200,850,550);
setVisible(true);


}
public void actionPerformed(ActionEvent e)
{
    if(e.getSource()==submit)
    {
        String id=tfid.getText();
     String name=tfname.getText();
  String age=tfage.getText();
  String salary=tfsalary.getText();  
  String phone=tfphone.getText();
  String email=tfemail.getText();
  String aadhar=tfaadhar.getText();
  
  if(id.equals(""))
  {
       JOptionPane.showMessageDialog(null, "Employee id should not be empty");
       return;
  }
  if(name.equals(""))
  {
       JOptionPane.showMessageDialog(null, "Name should not be empty");
       return;
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
if(aadhar.equals(""))
  {
       JOptionPane.showMessageDialog(null, "Aadhar No. should not be empty");
       return;
  }
for(int i=0;i<aadhar.length();i++)
   {
   if((aadhar.charAt(i)>='a'&&aadhar.charAt(i)<='z')||(aadhar.charAt(i)>='A'&&aadhar.charAt(i)<='Z'))
   {
      JOptionPane.showMessageDialog(null, "Invalid Aadhar No.");
       return;   
   } 
   }
if(phone.length()!=10)
{
  JOptionPane.showMessageDialog(null, "Invalid Mobile No.");
       return;  
}
if(aadhar.length()!=12)
{
  JOptionPane.showMessageDialog(null, "Invalid Aadhar No.");
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
    
      String job=(String) cbjob.getSelectedItem();
      try{
       Conn conn=new Conn();
       
       String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"','"+id+"')";
       conn.s.executeUpdate(query);
             
       JOptionPane.showMessageDialog(null, "Employee added successfully");
                 setVisible (false);
      }
      catch(Exception ae)
      {
               ae.printStackTrace();
      }
    }
    else if(e.getSource()==cancel)
    {
        setVisible(false);
    }
}
public static void main(String arg[])
    {
            new AddEmployee();
}
}
