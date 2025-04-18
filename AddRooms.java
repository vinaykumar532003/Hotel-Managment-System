
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddRooms extends JFrame implements ActionListener {

JButton add,cancel;
JRadioButton rbac,rbnonac;
JTextField tfroom,tfprice;
JComboBox typecombo,availablecombo,cleancombo;
 
    AddRooms()
    {
        setLayout(null);
getContentPane().setBackground(Color.WHITE);
 setResizable(false);

JLabel heading=new JLabel("ADD ROOMS");
heading.setBounds(150,20,200,20);
heading.setFont(new Font("Tahoma", Font.BOLD, 18));
add(heading);

JLabel lblroomno=new JLabel("Room Number");
lblroomno.setBounds(60,80,120,30);
lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
add(lblroomno);

 tfroom=new JTextField();
tfroom.setBounds(200, 80, 150, 30);
add(tfroom);

JLabel lblavailable=new JLabel("Availability");
 lblavailable.setBounds(60,130,120,30);
 lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
add( lblavailable);

String availableOptions[]={"Available","Occupied"};
 availablecombo=new JComboBox(availableOptions);
availablecombo.setBounds(200,130,150,30);
availablecombo.setBackground(Color.WHITE);
add(availablecombo);


JLabel lblroomtype=new JLabel("Room Type");
lblroomtype.setBounds(60,180,120,30);
lblroomtype.setFont(new Font("Tahoma", Font.PLAIN, 17));
 add(lblroomtype);

  rbac=new JRadioButton("AC");
     rbac.setBounds(200,180,70,30);
      rbac.setBackground(Color.WHITE);
    rbac.setFont(new Font("Tahoma", Font.PLAIN, 14));
      add(rbac);

 rbnonac=new JRadioButton("Non AC");
      rbnonac.setBounds(270,180,100,30);
       rbnonac.setBackground(Color.WHITE);
     rbnonac.setFont(new Font("Tahoma", Font.PLAIN, 14));
      add( rbnonac);
      
      ButtonGroup bg=new ButtonGroup();
      bg.add(rbac);
      bg.add(rbnonac);

JLabel lblclean=new JLabel("Cleaning Status");
lblclean.setBounds(60,230,120,30);
 lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
add( lblclean);

String cleanOptions[]={"Cleaned","Dirty"};
 cleancombo=new JComboBox(cleanOptions);
cleancombo.setBounds(200,230,150,30);
cleancombo.setBackground(Color.WHITE);
add(cleancombo);


JLabel lblprice=new JLabel("Price");
lblprice.setBounds(60,280,120,30);
lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
add(lblprice);

 tfprice=new JTextField();
 tfprice.setBounds(200, 280, 150, 30);
add( tfprice);

JLabel lbltype=new JLabel("Bed Type");
 lbltype.setBounds(60,330,120,30);
 lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
add(  lbltype);

String typeOptions[]={"Single Bed","Double Bed"};
 typecombo=new JComboBox(typeOptions);
 typecombo.setBounds(200,330,150,30);
 typecombo.setBackground(Color.WHITE);
add( typecombo);
       
 add=new JButton("Add");
       add.setBounds(60,380,130,30);
       add.setBackground(Color.BLACK);
       add.setForeground(Color.WHITE);
        add.addActionListener(this);
               add(add);
      
                
 cancel=new JButton("Cancel");
       cancel.setBounds(220,380,130,30);
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
               add( cancel);
     
               
ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
         Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,70,500,300);
        add(image);
               
        setBounds(330,200,940,470);
        setVisible(true);
    }
              
     public void actionPerformed(ActionEvent ae)
{ 
    
  
    if(ae.getSource()==add){
      
          String room=tfroom.getText();

  String price=tfprice.getText();
  String availability=(String) availablecombo.getSelectedItem();
   String status=(String) cleancombo.getSelectedItem();
    String type=(String) typecombo.getSelectedItem();
    
    if(room.equals(""))
  {
       JOptionPane.showMessageDialog(null, "Room No. should not be empty");
       return;
  }
   
    if(price.equals(""))
  {
       JOptionPane.showMessageDialog(null, "Price should not be empty");
       return;
  }
    
    String roomtype="";
      if(rbac.isSelected()){
      roomtype="AC";
      
  }
  else if(rbnonac.isSelected()){
      roomtype="Non AC";
  }
            
    if(roomtype.isEmpty())
  {
       JOptionPane.showMessageDialog(null,"Room Type is not selected");
       return;
  }
    try{
         Conn conn=new Conn();
        
 String query="insert into room values('"+room+"','"+availability+"','"+status+"','"+price+"','"+type+"','"+roomtype+"')";
 conn.s.executeUpdate(query);
             
       JOptionPane.showMessageDialog(null, "New Room added successfully");
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
new AddRooms();
}
}
