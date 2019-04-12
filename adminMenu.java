 	//Admin menu
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


class adminMenu{
    JFrame frame;
    JPanel windowContent=new JPanel();
    
    //JButton but1,but2,but3,but4;
    
    JButton but1=new JButton("ADD A BUS");
    JButton but2=new JButton("MODIFY A BUS");
    JButton but3=new JButton("REMOVE A BUS");
    JButton but4=new JButton("BOOK A TICKET");
    JButton backbut = new JButton("Back");
    ButtonHandler5 butlistener = new ButtonHandler5();
    int flag=0;
    JLabel welcome;
    
    String company;
    ButtonHandler1 listener1=new ButtonHandler1();
    ButtonHandler2 listener2=new ButtonHandler2();
    ButtonHandler3 listener3=new ButtonHandler3();
    ButtonHandler4 listener4=new ButtonHandler4();
  
    int X,Y;
    
    adminMenu(String company)
    {
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        java.awt.Dimension screenSize =
        toolKit.getScreenSize();
        X = screenSize.height;
        Y = screenSize.width;
        frame=new JFrame(company+" ADMIN");
        frame.setVisible(true);
        frame.setSize(X,Y);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         frame.setIconImage(new ImageIcon("C:\\Users\\user\\Desktop\\java\\TPortal\\bus.jpg").getImage());
        this.company=company;
        welcome=new JLabel("WELCOME TO "+company.toUpperCase()+" ADMIN MENU");
        but1.setForeground(new Color(0, 128, 0));
        but1.setBackground(new Color(250, 240, 230));
        but1.addActionListener(listener1);
        but2.setBackground(new Color(250, 240, 230));
        but2.setForeground(new Color(0, 128, 0));
        but2.addActionListener(listener2);
        but3.setBackground(new Color(250, 240, 230));
        but3.setForeground(new Color(220, 20, 60));
        but3.addActionListener(listener3);
        but4.setForeground(new Color(0, 128, 0));
        but4.setBackground(new Color(250, 240, 230));
        but4.addActionListener(listener4);
        backbut.setForeground(new Color(220, 20, 60));
        backbut.setBackground(new Color(250, 240, 230));
        backbut.addActionListener(butlistener);
        
        welcome.setForeground(Color.BLUE);
        welcome.setFont(new Font("Helvetica",Font.BOLD,18));
        windowContent.setLayout(new GridLayout(0,1));
       
        windowContent.add(welcome);
        windowContent.add(but1);
        windowContent.add(but2);
        windowContent.add(but3);
        windowContent.add(but4);
        windowContent.add(backbut);
        frame.setContentPane(windowContent);
        windowContent.setBackground(new Color(250, 240, 230));
        frame.setBounds(0,0,X/2,Y/2);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private class ButtonHandler1 implements ActionListener
    {
           @Override
          public void actionPerformed(ActionEvent e)
           {
             addBus obj=new addBus(company);
              frame.dispose();
           }
       }
      
       private class ButtonHandler2 implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
              modify obj=new modify();
              frame.dispose();
           }
       }
  
       private class ButtonHandler3 implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               NullPointerException q=new NullPointerException();
              String rem=(String)JOptionPane.showInputDialog(windowContent,"Enter the unique key of the bus you wish to remove","INPUT UNIQUE KEY",JOptionPane.PLAIN_MESSAGE, null,null, "");
              try{
                  if(rem.length()==0){
                      flag=1;throw q;}
              }catch(NullPointerException ex){
                  JOptionPane.showMessageDialog(windowContent,"ENTER A NON NULL VALUE FOR KEY");
              }
                  
              BussMod ob=new BussMod();
              
               if(rem.charAt(0)=='G')
              {
                  try {
                      
                      if(flag==0)
                      {
                    	  GreyHound obj = new GreyHound();
                          FileInputStream f = new FileInputStream("Greyhound.dat");
                          ObjectInputStream objectinput = new ObjectInputStream(f);
                          ArrayList<GreyHound> read = (ArrayList<GreyHound>) objectinput.readObject();
                          objectinput.close();
                          boolean exists=false;
                          for(int i=0;i<read.size();i++){
                              if(rem.equals(read.get(i).key))
                                  exists=true;
                          }
                          
                          if(exists){
                          JOptionPane.showMessageDialog(windowContent,"THE BUS "+rem+" WAS REMOVED","SUCCESS",JOptionPane.PLAIN_MESSAGE);
                      BussMod.sugaremove(rem);
                          }
                          
                      else
                          JOptionPane.showMessageDialog(windowContent,"THE BUS WITH KEY "+rem+" DOESNT EXIST IN THE LIST");
                       
                      } }catch (FileNotFoundException ex) {
                      Logger.getLogger(adminMenu.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (IOException ex) {
                      Logger.getLogger(adminMenu.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (ClassNotFoundException ex) {
                      Logger.getLogger(adminMenu.class.getName()).log(Level.SEVERE, null, ex);
                  }
              }
           }
       }
       
       private class ButtonHandler4 implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
      
               Main ob=new Main();
               frame.dispose();
           }            
       }
       private class ButtonHandler5 implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
           Main ob=new Main();
          frame.dispose();         
        }
    }  
 }