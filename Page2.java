
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.GridBagConstraints;
import java.io.*;
import java.lang.String;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Page2 
{
    JFrame frame2;//=new JFrame("BUS DETAILS");
    JPanel windowContent=new JPanel();
    
    JButton rowNo=new JButton("ENTER ROW NO.");
    JButton colNo=new JButton("ENTER COLUMN NO.");
    
    JButton confirm=new JButton("Confirm");
    JButton show=new JButton("Seat Matrix");
    
    ButtonHandler listener=new ButtonHandler();//actionListener for confirm
    ButtonHandler2 listener2=new ButtonHandler2();//actionListener for showSeatMatrix
    
    ButtonHandler3 rowListener=new ButtonHandler3();
    ButtonHandler4 colListener=new ButtonHandler4();
    
    JLabel temp=new JLabel("ENTER ROUTE.No");
    JLabel temp2=new JLabel("ENTER SEAT No.");
    JLabel temp3=new JLabel("              ");
    
    JTextField inputArea=new JTextField();   // FOR ROUTE NUMBER
   // JTextField inputArea2=new JTextField();  // FOR SEAT NUMBER
    
    String rowno,colno;
    int X,Y;
       
    String svar1,dvar1;
    JButton back=new JButton("BACK");
    ButtonHandler5 listener3=new ButtonHandler5();
    //String svar1;
    //String dvar1;
    String date1;
  Page2(String svar,String dvar,String date) throws IOException, ClassNotFoundException
  {
      svar1=svar;
      dvar1=dvar;
      date1=date;
      Toolkit toolKit = Toolkit.getDefaultToolkit();
    //  System.out.println("SVAR IS- " +svar);
     // System.out.println("DVAR IS- " +dvar);
      java.awt.Dimension screenSize =
      toolKit.getScreenSize();
      X = screenSize.height;
      Y = screenSize.width;
      String check="Buses On "+svar+" -"+dvar;
      frame2=new JFrame(check);
     // frame2.setVisible(true);
      //frame2.setBounds(0,0,2*X,Y);
      //frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      confirm.addActionListener(listener);
      show.addActionListener(listener2);
      back.addActionListener(listener3);
       windowContent.setLayout(new GridLayout(0,8));
     
         FileInputStream f2 = new FileInputStream("Greyhound.dat");
        ArrayList<GreyHound> read;
        ObjectInputStream objectinput2 = new ObjectInputStream(f2); 
        read = (ArrayList<GreyHound>) objectinput2.readObject();
        objectinput2.close();
        //System.out.println(read.size());
        //System.out.println(read1.size());
        //System.out.println(read2.size());
       
        rowNo.addActionListener(rowListener);
        colNo.addActionListener(colListener);
        
        JLabel tempCompany=new JLabel("COMPANY");
          tempCompany.setFont(new Font("Serif", Font.BOLD, 18));
          tempCompany.setForeground(Color.red);
          tempCompany.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempCompany);
          JLabel tempAmmenities=new JLabel("AMMENITIES");
          tempAmmenities.setFont(new Font("Serif", Font.BOLD, 18));
          tempAmmenities.setForeground(Color.red);
          tempAmmenities.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempAmmenities);
          
          JLabel tempRoute=new JLabel("ROUTE NUMBER");
          tempRoute.setFont(new Font("Serif", Font.BOLD, 18));
          tempRoute.setForeground(Color.red);
          tempRoute.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempRoute);
          JLabel tempType=new JLabel("TYPE");
          tempType.setFont(new Font("Serif", Font.BOLD, 18));
          tempType.setForeground(Color.red);
          tempType.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempType);
          JLabel tempPrice=new JLabel("PRICE"); // Change this
          tempPrice.setFont(new Font("Serif", Font.BOLD, 18));
          tempPrice.setForeground(Color.red);
          tempPrice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempPrice);
          
          JLabel tempDate=new JLabel("DATE");
          tempDate.setFont(new Font("Serif", Font.BOLD, 18));
          tempDate.setForeground(Color.red);
          tempDate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempDate);
          
          
          JLabel tempStrt=new JLabel("START TIME");
          tempStrt.setFont(new Font("Serif", Font.BOLD, 18));
          tempStrt.setForeground(Color.red);
          tempStrt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempStrt);
          
          
          JLabel tempEnd=new JLabel("END TIME");
          tempEnd.setFont(new Font("Serif", Font.BOLD, 18));
          tempEnd.setForeground(Color.red);
          tempEnd.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempEnd);
          frame2.setIconImage(new ImageIcon("C:\\Users\\user\\Desktop\\java\\TPortal\\bus.jpg").getImage());
          
          
      
       for(int i=0;i<read.size();i++)
      {
   
         if(svar.equals (read.get(i).source) && dvar.equals (read.get(i).destination))     
         {
          tempCompany=new JLabel("GreyHound");
          tempCompany.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempCompany);
          
          String ammenities;
          ammenities="CHARGING POINT";
          
          if(read.get(i).type.equals("AC SLEEPER"))
              ammenities="chargePoint&readLight";
          else if(read.get(i).type.equals("AC SEMI SLEEPER"))
              ammenities="chargePoint&readLight";
          else if(read.get(i).type.equals("NON AC SLEEPER"))
              ammenities="chargePoint";
          
          tempAmmenities=new JLabel(ammenities);
          tempAmmenities.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempAmmenities);
          
          
          tempRoute=new JLabel(read.get(i).key);
          tempRoute.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempRoute);
          tempType=new JLabel(read.get(i).type);
          tempType.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempType);
          
          
          Integer k=read.get(i).price;
          
          tempPrice=new JLabel(k.toString());
          tempPrice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempPrice);
          
          tempDate=new JLabel(date);
          tempDate.setBorder(BorderFactory.createLineBorder(Color.BLACK));
          windowContent.add(tempDate);
          
          
          
         tempStrt=new JLabel(read.get(i).starttime);
         tempStrt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
         windowContent.add(tempStrt);
         
         tempEnd=new JLabel(read.get(i).endtime);
         tempEnd.setBorder(BorderFactory.createLineBorder(Color.BLACK));
         windowContent.add(tempEnd);
         
         } 
     }
      
      //date,
      
       windowContent.add(back);
       windowContent.add(temp);
       windowContent.add(inputArea);
       windowContent.add(temp3);
       //windowContent.add(temp3);
       windowContent.add(show);
      // windowContent.add(temp3);
//       windowContent.add(temp2);
      // windowContent.add(temp3);
     //  windowContent.add(inputArea2);
       //windowContent.add(temp3);
       windowContent.add(rowNo);
       windowContent.add(colNo);
       windowContent.add(confirm);
       
       frame2.setContentPane(windowContent);
       frame2.setVisible(true);
       frame2.setBounds(0,0,X,Y);
       frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
  
   
  
}
  
   private class ButtonHandler2 implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
             //int i=0;
             //JOptionPane.showMessageDialog(windowContent,"Hey","SEAT MATRIX",JOptionPane.PLAIN_MESSAGE);
               
              
         FileInputStream f2 = null;
               try {
                   f2 = new FileInputStream("Greyhound.dat");
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               }
        ArrayList<GreyHound> read = null;
        ObjectInputStream objectinput2 = null; 
               try {
                   objectinput2 = new ObjectInputStream(f2);
               } catch (IOException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               }
               try {
                   read = (ArrayList<GreyHound>) objectinput2.readObject();
               } catch (IOException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               }
               try {
                   objectinput2.close();
               } catch (IOException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               }
               
               
               
               String key=inputArea.getText();
               
               char[][] seat;
              
               String work="";
               
               
               for(int i=0;i<read.size();i++)
               {
                   if(read.get(i).key.equalsIgnoreCase(key))
                   {
                       seat=read.get(i).seatmatrix;
                       
                       for(int k=0;k<read.get(i).rows;k++)
                       {
                           for(int j=0;j<read.get(i).columns;j++)
                           work=work+seat[k][j]+" ";
                           work=work+"\n";
                       }
                      
                   }
               }
               
               JOptionPane.showMessageDialog(windowContent,work+"\n"+"X=>FREE,O=>OCCUPIED","SEAT MATRIX", JOptionPane.PLAIN_MESSAGE);
             
               
               //seatMatrix ob=new seatMatrix(seat);
              // g=ob.getGraphics();
              // ob.paint(g);
               
               
           }
       }


      private class ButtonHandler3 implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
             try
             { 
                 while(true)
               {
                 rowno=(String)JOptionPane.showInputDialog(windowContent,"ENTER THE ROW NO.(0-3) ","INPUT ROW", JOptionPane.QUESTION_MESSAGE);
                 
                 int i=Integer.parseInt(rowno);
                 
                 if(i>3||i<0)
                 {
                     JOptionPane.showMessageDialog(windowContent,"PLEASE INPUT NO.S IN THE RANGE 0-3");
                     continue;
                 }
                 else
                     break;
               }
             
             }catch(NumberFormatException e1)
             {
                    JOptionPane.showMessageDialog(windowContent,"Invalid Entry");
             }
           }
       }

   private class ButtonHandler4 implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
             try
             {
                 while(true)
               {
                 colno=(String)JOptionPane.showInputDialog(windowContent,"ENTER THE COLUMN NO.(0-9) ","INPUT ROW", JOptionPane.QUESTION_MESSAGE);
                 
                 int i=Integer.parseInt(colno);
                 
                 if(i>9||i<0)
                 {
                     JOptionPane.showMessageDialog(windowContent,"PLEASE INPUT NO.S IN THE RANGE 0-9");
                     continue;
                 }
                 else
                     break;
               }
             
             
             }catch(NumberFormatException e1)
             {
                    JOptionPane.showMessageDialog(windowContent,"Invalid Entry");
             }
           }    
       }

   
  private class ButtonHandler  implements ActionListener
  {
           @Override
          public void actionPerformed(ActionEvent e) 
           {
             String g1=inputArea.getText(); // for route number
       //      String s2=inputArea2.getText();
           //  System.out.println("The values taken are " + s1);
               try 
               {
                    Scanner scan=new Scanner(System.in);
        // Page3 ob=new Page3();
         //System.out.println("Transfer passed");//customer details
         String name;
         String contactNo;
         String gender;
         String email;
         //int x,y;
         int i=0;
         int k=0;
         int j = 0;
         int l = 0;
         int flag = 0;
         //files of buses
        
         FileInputStream f2 = new FileInputStream("Greyhound.dat");
         ObjectInputStream objectinput2 = new ObjectInputStream(f2);
         ArrayList<GreyHound> read = (ArrayList<GreyHound>) objectinput2.readObject();
         objectinput2.close();
         
         Boolean ischanged=false;      
                int flag1=0;
                int flag2=0;
               
         
         if(flag2==0)
         {    
          for(i=0;i<read.size();i++)
          {  
            
             GreyHound obj1 = new GreyHound();
             obj1 = (GreyHound)read.get(i);
             if(obj1.key.equals(g1))
             {   
                if(!((obj1.source.equals(svar1))&&(obj1.destination.equals(dvar1))))
                 {
                     JOptionPane.showMessageDialog(windowContent,"BUS NOT PRESENT ON THIS ROUTE","ERROR",JOptionPane.ERROR_MESSAGE);
                     return;
                 }
     
                    if(obj1.seatmatrix[Integer.parseInt(rowno)][Integer.parseInt(colno)]=='X')
                    {
                      
                    ischanged=true;
                  //    f1(s1,s2);
                      
                      //System.out.println("Your seat is "+obj.seat);
                      
                    }
                    else
                    {    
                   //  System.out.println("Occupied book again");
                      JOptionPane.showMessageDialog(windowContent,"Occupied Book Again","ERROR",JOptionPane.ERROR_MESSAGE);
                    }                
                
              //}
              //if(ischanged==true)
                     //f1(s1,s2);
                    //break;   
           }             //END OF IF
         
          }
         } //END OF IF  
      if(ischanged==true)
      {
           f1(g1);
           
         
        }
        
      
      
        
                     
               } catch (IOException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(Page2.class.getName()).log(Level.SEVERE, null, ex);
               }
               catch(NullPointerException ex)
               {
                JOptionPane.showMessageDialog(windowContent,"Invalid Entry");
               }
               catch(NumberFormatException e2)
               {
                   JOptionPane.showMessageDialog(windowContent,"Invalid Entry");
               }
             //Page3 ob=new Page3();       
           //    System.out.println("Sup");
           //   frame2.dispose();   
           }
           void f1(String rno) throws IOException, ClassNotFoundException
           {
              
              
               FileInputStream f2 = new FileInputStream("Greyhound.dat");
               ArrayList<GreyHound> read;
               ObjectInputStream objectinput2 = new ObjectInputStream(f2); 
               read = (ArrayList<GreyHound>) objectinput2.readObject();
               objectinput2.close();
              // BusMod.bookTicket("hey");
               int i=0;
               int flag=0,flag1=0;
               
              if(flag==0)
              {    
               
                
              
                  for(i=0;i<read.size();i++)
               {
                   //System.out.println("Entered the GreyHound loop");
                   if(rno.equals(read.get(i).key))
                   {
                	   flag1=1;
                     //  System.out.println("Working!!!");
                     //BusMod.bookTicket(rno,Integer.parseInt(rowno),Integer.parseInt(colno));
                       Page3 ob=new Page3(rno,Integer.parseInt(rowno),Integer.parseInt(colno),svar1,dvar1,date1);
                       frame2.dispose(); 
                       break;
                   }
               }
                 
              }  
           }
           
       }
  
     private class ButtonHandler5 implements ActionListener
    {
       // String newSelection;
        @Override
        public void actionPerformed(ActionEvent e) 
        {
          Main ob=new Main();
          frame2.dispose();
         
        }
        
      
    }
  
/* public static void main(String[] args)
    {
        //Page2 obj=new Page2();
        System.out.println("Hello");//Page2 ob=new Page2();  // TODO code application logic here
    }*/
}
