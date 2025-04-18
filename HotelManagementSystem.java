
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
JButton exit,next;
  HotelManagementSystem(){
      //setSize(1366, 565);
      //setLocation(100,100);
      setBounds(0,0,1550,870);
     // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(null);
      setResizable(false);
      
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
         Image i2=i1.getImage().getScaledInstance(1550,870,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1550,870);
        add(image);
      
      
      JLabel text =new JLabel("HOTEL MANAGEMENT SYSTEM");
      text.setBounds(20,680,1000,90);
      text.setForeground(Color.WHITE);
      text.setFont(new Font("serif", Font.PLAIN, 60));
      image.add(text);
      
      next=new JButton("Login");
      next.setBounds(1150,700,150,50);
      next.setBackground(Color.WHITE);
      next.setForeground(Color.BLACK);
      next.addActionListener(this);
      next.setFont(new Font("serif",Font.PLAIN,30));
      image.add(next);
      
       exit=new JButton("Exit");
      exit.setBounds(950,700,150,50);
      exit.setBackground(Color.WHITE);
      exit.setForeground(Color.BLACK);
      exit.addActionListener(this);
       exit.setFont(new Font("serif",Font.PLAIN,30));
      image.add(exit);
      
      //Cursor cur=new Cursor(Cursor.HAND_CURSOR);
      //next.setCursor(cur);
      
      setVisible(true);
      
      while(true)
      {
          text.setVisible(false);
          try{
              Thread.sleep(500);
}catch(Exception e){
    e.printStackTrace();
}
text.setVisible(true);
          try{
              Thread.sleep(500);
}catch(Exception e){
    e.printStackTrace();
}

          }
      }
  public void actionPerformed(ActionEvent e)
  {
    if(e.getSource()==next)
        //setVisible(false);
    {
      new login();
  }
    else if(e.getSource()==exit)
    {
        System.exit(0);
        
    }
  }

    public static void main(String[] args) {
      new HotelManagementSystem();
    }
}

