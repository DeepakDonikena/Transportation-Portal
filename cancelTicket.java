
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.GridBagConstraints;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;


public class cancelTicket
{

    JFrame frame=new JFrame("CANCEL TICKET");
    JPanel windowContent=new JPanel();
    JButton ret=new JButton("BACK TO BOOKING PAGE");
    
//    JLabel cancel=new JLabel("CANCEL TICKET");
   // ButtonHandler cancelListener=new ButtonHandler();
    
    JLabel rtNo=new JLabel("ENTER ROUTE NO.");
    ButtonHandler1 rtListener=new ButtonHandler1();
    
    JLabel rowNo=new JLabel("ENTER ROW NO. OF YOUR SEAT");
   // ButtonHandler2 rwListener=new ButtonHandler2();
    
    JLabel colNo=new JLabel("ENTER COLUMN NO. OF YOUR SEAT");
   // ButtonHandler3 colListener=new ButtonHandler3();
  
    JTextField inputArea=new JTextField(20);   // FOR ROUTE
    JTextField inputArea2=new JTextField(20);   // FOR ROW NUMBER
    JTextField inputArea3=new JTextField(20);   // FOR COLUMN NUMBER
    JButton confirm=new JButton("CONFIRM");
    String date,rowno,colno; 
    JComboBox dateList;
    Combo1 dateListener=new Combo1();//For the JComboBox2,i.e.date
    ButtonHandler1 listener=new ButtonHandler1();
    ButtonHandler2 listener1=new ButtonHandler2();
   int X,Y;
   String route;
   int row,col;
   private final JDateChooser dateChooser = new JDateChooser();
  
    cancelTicket()
    {
         Toolkit toolKit = Toolkit.getDefaultToolkit();
      java.awt.Dimension screenSize =
      toolKit.getScreenSize();
      X = screenSize.height;
      Y = screenSize.width;
      frame.setVisible(true);
      frame.setSize(X,Y);
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      
       //windowContent.setLayout(new GridLayout(0,1));
      
      //cancel.setMaximumSize(new Dimension(50,20));
      rtNo.setMaximumSize(new Dimension(50,20));
      rowNo.setMaximumSize(new Dimension(50,20));
      colNo.setMaximumSize(new Dimension(50,20));
      confirm.setMaximumSize(new Dimension(50,20));
      confirm.addActionListener(listener);
      ret.addActionListener(listener1);
      //windowContent.add(cancel)
      
      windowContent.add(dateChooser);
      windowContent.add(rtNo);
      windowContent.add(inputArea);
      windowContent.add(rowNo);
      windowContent.add(inputArea2);
      windowContent.add(colNo);
      windowContent.add(inputArea3);
      windowContent.add(confirm);
      windowContent.add(ret);
     
       frame.setContentPane(windowContent);
       frame.setVisible(true);
       frame.setBounds(0,0,2*X,Y);
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       frame.setIconImage(new ImageIcon("C:\\Users\\user\\Desktop\\java\\TPortal\\bus.jpg").getImage());
       
    }
     
     private class Combo1 implements ActionListener
    {
       // String newSelection;
        @Override
        public void actionPerformed(ActionEvent e) 
        {
          JComboBox cb = (JComboBox)e.getSource();
          date = (String)cb.getSelectedItem();
         
        }
        
      
    }
     
         /* private class ButtonHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               //Insert code to cancel tickethere
           }
     }*/
     
     private class ButtonHandler1 implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
                 //rowno=(String)JOptionPane.showInputDialog(windowContent,"ENTER ROW NO.","INPUT", JOptionPane.PLAIN_MESSAGE);
               int ck;
               route=inputArea.getText();
               
               try 
               {
                   row=Integer.parseInt(inputArea2.getText());
               col = Integer.parseInt(inputArea3.getText());
                   if(route.charAt(0)=='G' )
                   {
                       ck=BussMod.cancelTicket(route,row,col);
                       switch (ck)
                       {
                           case 1: JOptionPane.showMessageDialog(windowContent,"Invalid Route Number","ERROR",JOptionPane.ERROR_MESSAGE);  
                                   break;
                           case 2: JOptionPane.showMessageDialog(windowContent,"Seat is not occupied","ERROR",JOptionPane.ERROR_MESSAGE);  
                                   break;
                           case 3: JOptionPane.showMessageDialog(windowContent,"Ticket Cancelled","CONFIRMATION",JOptionPane.PLAIN_MESSAGE);  
                                   break;    
                       }
                   }
                   else
                     JOptionPane.showMessageDialog(windowContent,"Invalid Route Number","ERROR",JOptionPane.PLAIN_MESSAGE);   
                 //  System.out.println("did something");
                   
               }
               catch (FileNotFoundException ex) 
               {
                   Logger.getLogger(cancelTicket.class.getName()).log(Level.SEVERE, null, ex);
               } 
               catch (IOException ex) 
               {
                   Logger.getLogger(cancelTicket.class.getName()).log(Level.SEVERE, null, ex);
               } 
               catch (ClassNotFoundException ex) 
               {
                   Logger.getLogger(cancelTicket.class.getName()).log(Level.SEVERE, null, ex);
               }
                catch (NumberFormatException e1) 
               {
                  JOptionPane.showMessageDialog(windowContent,"Invalid Row/Column Number","ERROR",JOptionPane.ERROR_MESSAGE);  
               }
              
                   
               
           }
     }
     
     private class ButtonHandler2 implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
                 //colno=(String)JOptionPane.showInputDialog(windowContent,"ENTER COLUMN NO.","INPUT", JOptionPane.PLAIN_MESSAGE);
              // System.out.println("ENtered this part");  
               Main ob=new Main();
                 frame.dispose();
           }
     }
    
     
     
   
     
     public static void main(String[] args){
         cancelTicket ob=new cancelTicket();
     }
}
