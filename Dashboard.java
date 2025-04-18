package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
Dashboard()
{
    setBounds(0,0,1550,1000);
    setLayout(null);
    setResizable(false);
    
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
         Image i2=i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
        
         JLabel text =new JLabel("ROYAL ORCHID WELCOMES YOU");
      text.setBounds(320,80,1000,50);
      text.setForeground(Color.WHITE);
      text.setFont(new Font("Tahoma", Font.PLAIN, 55));
      image.add(text);
      
      JMenuBar mb=new JMenuBar();
      mb.setBounds(0,0,1550,30);
      image.add(mb);
      
         JMenu hotel =new JMenu("HOTEL MANAGEMENT");
      hotel.setForeground(Color.RED);
      mb.add(hotel);
      
      JMenuItem reception=new JMenuItem("RECEPTION");
           reception.addActionListener(this);
      hotel.add(reception);
      
     
      
         JMenu admin =new JMenu("ADMIN");
      admin.setForeground(Color.BLUE);
      mb.add(admin);
      
           JMenuItem addemployee=new JMenuItem("ADD EMPLOYEE");
           addemployee.addActionListener(this);
      admin.add(addemployee);
      
     JMenuItem addrooms=new JMenuItem("ADD ROOMS");
      addrooms.addActionListener(this);
      admin.add(addrooms);
      
       JMenuItem adddrivers=new JMenuItem("ADD DRIVERS");
        adddrivers.addActionListener(this);
      admin.add(adddrivers);
      
      JMenu logout=new JMenu("LOGOUT");
      logout.setForeground(Color.BLACK);
      mb.add(logout); 
      
      JMenuItem yes=new JMenuItem("YES");
      yes.addActionListener(this);
      logout.add(yes);
      
      
      JMenuItem no=new JMenuItem("NO");
      no.addActionListener(this);
      logout.add(no);
      
        setVisible(true);
}
  public void actionPerformed(ActionEvent e)
  {
      if(e.getActionCommand().equals("ADD EMPLOYEE")){
          new AddEmployee();
      }
      else if(e.getActionCommand().equals("ADD ROOMS")){
          new AddRooms();
      }
      else if(e.getActionCommand().equals("ADD DRIVERS")){
          new AddDrivers();
  }
      else if(e.getActionCommand().equals("RECEPTION")){
          new Reception();
      }
      else if(e.getActionCommand().equals("YES")){
          setVisible(false);
      }
  }
public static void main(String arg[])
{
    new Dashboard();
}
}
