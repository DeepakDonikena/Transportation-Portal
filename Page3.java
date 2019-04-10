import java.awt.*;

import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Page3 {
    JFrame frame3=new JFrame("ENTER PASSENGER DETAILS");
    JPanel windowContent=new JPanel();
    JButton back=new JButton("BACK");
    JButton bookagain=new JButton("BOOK AGAIN");
    JLabel name=new JLabel("NAME :");
    JLabel email=new JLabel("E-MAIL :");
    JLabel contactNo=new JLabel("CONTACT No. :");
    JLabel gender=new JLabel("GENDER :");
    JLabel age=new JLabel("AGE :");
    JPanel panel2=new JPanel();
    int X,Y;
    
    JTextField inputName=new JTextField(10);
    JTextField inputEmail=new JTextField(10);
    JTextField inputContact=new JTextField(10);
    JTextField inputGender=new JTextField(10);
    JTextField inputAge=new JTextField(10);
    
    JButton confirm=new JButton("CONFIRM");
    ButtonHandler listener=new ButtonHandler();
    ButtonHandler2 listener1=new ButtonHandler2();
    ButtonHandler3 listener2=new ButtonHandler3();
    int r,c;//r -row,c-column
    //int x1;
    int seat1;
    String rt;//for route
    int x;
    String Bname;//for Bus name
    String Starttime;//For Start time
    String Endtime;//for End Time
    String src;//for Source
    String dest;//for Destination
    String Btype;//for Bus Type
    String mail;
     String svar1,dvar1;
     String date1;
    public Page3(String rte,int row,int col,String svar,String dvar,String date)
    {
      Toolkit toolKit = Toolkit.getDefaultToolkit();
      java.awt.Dimension screenSize =
      toolKit.getScreenSize();
      X = screenSize.height;
      Y = screenSize.width;
      frame3.setVisible(true);
      frame3.setSize(X,Y);
      frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      svar1=svar;
      dvar1=dvar;
      date1=date;
      confirm.addActionListener(listener);
      back.addActionListener(listener1);
      bookagain.addActionListener(listener2);
      windowContent.setLayout(new FlowLayout());      
      windowContent.add(name);
      windowContent.add(inputName);
      windowContent.add(email);
      windowContent.add(inputEmail);
      windowContent.add(gender);
      windowContent.add(inputGender);
      windowContent.add(age);
      windowContent.add(inputAge);
      windowContent.add(contactNo);
      windowContent.add(inputContact);
      panel2.add(confirm);
      panel2.add(back);
      panel2.add(bookagain);
      frame3.setLayout(new BorderLayout());
      frame3.add(windowContent,BorderLayout.NORTH);
      frame3.add(panel2,BorderLayout.SOUTH);
      frame3.setVisible(true);
      frame3.setBounds(0,0,2*X,Y-630);
      frame3.setIconImage(new ImageIcon("C:\\Users\\user\\Desktop\\java\\TPortal\\bus.jpg").getImage());
      //seat1=obj.seat;
      rt=rte;
      r=row;
      c=col;
      frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      x=10;
      //System.out.println("Route is "+rt);
     // System.out.println("Seat is "+seat1);
      //r=ob.x
      //c=ob.y  
    }
    
      private class ButtonHandler implements ActionListener
       {
           String name,mail,gender,phno,age; 
           @Override
          public void actionPerformed(ActionEvent e)
           {
               //String name,mail,gender,phno,age;               
               name=inputName.getText();
               mail=inputEmail.getText();
               gender=inputGender.getText();
               phno=inputContact.getText();
               age=inputAge.getText();
               //BusMod.f1(name,mail,gender,phno,age,r,c); put when p's code comes
               Pattern phone = Pattern.compile("\\d{10}");
               Matcher matcher = phone.matcher(phno);
               if (!(matcher.matches())) {
            	   JOptionPane.showMessageDialog(windowContent,"Phone Number must Contain 10 numbers","ERROR",JOptionPane.ERROR_MESSAGE);
                   return;
               }
               
               Pattern email = Pattern.compile( "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                       "[a-zA-Z0-9_+&*-]+)*@" + 
                       "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                       "A-Z]{2,7}$");
               Matcher matcher1 = email.matcher(mail);
               if (!(matcher1.matches())) {
            	   JOptionPane.showMessageDialog(windowContent,"enter Valid email","ERROR",JOptionPane.ERROR_MESSAGE);
                   return;
               }
               
               if(name.equals("")) {
            	   JOptionPane.showMessageDialog(windowContent,"Enter Name","ERROR",JOptionPane.ERROR_MESSAGE);
                   return;
               }
               if(!(gender.equals("F") || gender.equals("M"))) {
            	   JOptionPane.showMessageDialog(windowContent,"Enter Gender F or M","ERROR",JOptionPane.ERROR_MESSAGE);
                   return;
               }
               if(age.equals("")) {
            	   JOptionPane.showMessageDialog(windowContent,"Enter AGE","ERROR",JOptionPane.ERROR_MESSAGE);
                   return;
               }
               //obj.name=inputName.getText();
               System.out.println(x);       
               //JOptionPane.showMessageDialog(windowContent,display,"TICKET DETAILS",JOptionPane.PLAIN_MESSAGE);
               try {   
                   f1();
               } catch (IOException ex) {
                   Logger.getLogger(Page3.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(Page3.class.getName()).log(Level.SEVERE, null, ex);
               }
               String display="DATE: "+ date1+  "\n "+"NAME: "+inputName.getText()+ "\t GENDER: "+inputGender.getText()+ "\nSOURCE: "+src+ "\t DESTINATION: "+dest+"\n"+"ROUTE NO: "+ rt +"\t SEAT NO: "+ seat1 + "\n" + "BUS NAME:" +Bname + "\t BUS TYPE: " + Btype + "\n\t\t\tThank you for Using our Software,Wish you a Happy Journey!"; 
               JOptionPane.showMessageDialog(windowContent,display,"TICKET DETAILS",JOptionPane.PLAIN_MESSAGE);
           }
         void f1()     throws IOException, ClassNotFoundException
         {
             PassDtls ob=new PassDtls();
             ob.name=name;
             ob.contactno=phno;
             ob.gender=gender;
             ob.mail=mail;
             ob.age=age;
             ob.rte=rt;
             //ob.seat=seat1;
             ob.seatrow=r;
             ob.seatcol=c;
            // System.out.println(ob.seatrow + ob.seatcol);
             //x=299;
             if(ob.rte.charAt(0)=='G' || ob.rte.charAt(0)=='g' )
             {
                 ob.seat=BussMod.bookTicket(rt, r, c);
                 seat1=ob.seat;               
                 File f1=new File("GreyhoundPassenger.dat");
                 if(!f1.exists())
                 {
                   ArrayList<PassDtls>list=new ArrayList<PassDtls>();
                   list.add(ob);   
                   OutputStream file1 = new FileOutputStream(f1);
                   OutputStream buffer1 = new BufferedOutputStream(file1);
                   ObjectOutput output1 = new ObjectOutputStream(buffer1);
                   output1.writeObject(list);
                   output1.close();
                   buffer1.close();
                   file1.close();
                   
                 }
                else
                 {
                     FileInputStream f = new FileInputStream(f1);
                     ObjectInputStream objectinput1 = new ObjectInputStream(f);
                     ArrayList<PassDtls> read1 = (ArrayList<PassDtls>) objectinput1.readObject();
                     objectinput1.close();
                     f.close();
                     read1.add(ob);
                     OutputStream file1 = new FileOutputStream(f1);
                     OutputStream buffer1 = new BufferedOutputStream(file1);
                     ObjectOutput output1 = new ObjectOutputStream(buffer1);
                     output1.writeObject(read1);
                     output1.close();
                     buffer1.close();
                     file1.close();
                 }
               File f2=new File("Greyhound.dat")  ;
               {
                     FileInputStream f = new FileInputStream(f2);
                     ObjectInputStream objectinput1 = new ObjectInputStream(f);
                     ArrayList<GreyHound> read1 = (ArrayList<GreyHound>) objectinput1.readObject();
                     objectinput1.close();
                     f.close();
                     int i=0;
                     for(i=0;i<read1.size();i++)
                     {
                         if(rt.equals(read1.get(i).key))
                         {
                             Bname="GreyHound";
                             Starttime=read1.get(i).starttime;
                             Endtime=read1.get(i).endtime;
                             src=read1.get(i).source;
                             dest=read1.get(i).destination;
                             Btype=read1.get(i).type;
                             break;
                         }
                     }
               }   
                 
             }         //END OF IF WHICH TELLS YOU ITS SUGAMA
             
             
         }
           
       }
  /* public static void main(String[] args)
    {
        //PassDtls ob=new PassDtls(); 
        //Page3 obj=new Page3(ob);
        //System.out.println("Hello");
        //System.out.println(obj.a);//Page2 ob=new Page2();  // TODO code application logic here
    }*/
    private class ButtonHandler2 implements ActionListener
    {
       // String newSelection;
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            try {
                Page2 ob=new Page2(svar1,dvar1,date1);
            } catch (IOException ex) {
                Logger.getLogger(Page3.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Page3.class.getName()).log(Level.SEVERE, null, ex);
            }
          frame3.dispose();
         
        }
        
      
    }
    
    private class ButtonHandler3 implements ActionListener
    {
       // String newSelection;
        @Override
        public void actionPerformed(ActionEvent e) 
        {
           Main ob=new Main();
          frame3.dispose();
         
        }
        
      
    }  
    
      
      
}
