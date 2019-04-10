import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.GridBagConstraints;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
class addBus {
    
    JFrame frame;
    JPanel windowContent=new JPanel();
    char[][] seatStruct=new char[10][10];
    int X,Y;
    
    JButton type=new JButton("Enter Bus Type");
   
    TypeHandler typeListener=new TypeHandler();
    String inputType;
    JButton sorc=new JButton("ADD THE SOURCE");
    srcHandler srcListener=new srcHandler();
    String src;
    
    JButton des=new JButton("ADD THE DESTINATION");
    destHandler destListener=new destHandler();
    String dest;
    
    JButton pric=new JButton("Enter the price");
    priceHandler priceListener=new priceHandler();
    String price;
    
    JButton strt=new JButton("Enter the Start Time");
    strtHandler strtListener=new strtHandler();
    String start;
    
    JButton end=new JButton("Enter the End Time");
    endHandler endListener=new endHandler();
    String etime;
    String rtNo;
    
    
   JLabel route=new JLabel("Enter Route No.");
    JTextField inputRt=new JTextField(10);
    JLabel uniq=new JLabel("Enter Unique Key");
    JTextField inputUniq=new JTextField(10);
    JButton rows=new JButton("ENTER THE NO. OF ROW");
    rowHandler rowListener=new rowHandler();
    String row;
    JButton columns=new JButton("ENTER THE NO. OF COLUMNS ");
    colHandler colListener=new colHandler();
    String column;
    
    
    JButton confirm=new JButton("CONFIRM");
    addBus.ButtonHandler listener=new addBus.ButtonHandler();
    JButton backbut = new JButton("Back");
    BackHandler1 butlistener = new BackHandler1();
    
    addBus(String company){
      
      frame=new JFrame("ADD A "+company+" BUS");  
      Toolkit toolKit = Toolkit.getDefaultToolkit();
      java.awt.Dimension screenSize =
      toolKit.getScreenSize();
      X = screenSize.height;
      Y = screenSize.width;
      frame.setVisible(true);
      frame.setSize(X,Y);
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       frame.setIconImage(new ImageIcon("C:\\Users\\user\\Desktop\\java\\TPortal\\bus.jpg").getImage());
      
      des.addActionListener(destListener);
      sorc.addActionListener(srcListener);
      pric.addActionListener(priceListener);
      strt.addActionListener(strtListener);
      end.addActionListener(endListener);
      rows.addActionListener(rowListener);
      columns.addActionListener(colListener);
      backbut.addActionListener(butlistener);
      
      confirm.addActionListener(listener);
      
      
       for(int i = 0;i<10;i++)
      {
          for(int j = 0;j<10;j++)
          {
            seatStruct[i][j] = 'X';//adding seats 
          }
      }
      
      windowContent.setLayout(new GridLayout(0,1));
      inputRt.setMaximumSize(new Dimension(250,20));
      inputUniq.setMaximumSize(new Dimension(250,20));
     
      windowContent.add(type);
      type.addActionListener(typeListener);
      
      windowContent.add(sorc);
      windowContent.add(des);
     windowContent.add(pric);
    
      windowContent.add(strt);
     // windowContent.add(inputStrt);
      windowContent.add(end);
    //  windowContent.add(inputEnd);
      windowContent.add(route);
      windowContent.add(inputRt);
      windowContent.add(rows);
     // windowContent.add(inputrow);
     //windowContent.add(Box.createRigidArea(new Dimension(250,50)));
      windowContent.add(columns);
     
     //windowContent.add(inputcolumn);
      windowContent.add(confirm);
      windowContent.add(backbut);
      
       frame.setContentPane(windowContent);
       frame.setVisible(true);
        frame.setBounds(0,0,2*X,Y);
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
    }
    
     private class TypeHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               String[] options={"AC SLEEPER","AC SEMI SLEEPER","NON AC SLEEPER","AC"};
               inputType=(String)JOptionPane.showInputDialog(windowContent,
"Choose One", "Input",
JOptionPane.INFORMATION_MESSAGE, null,
options, options[0]);
           }
       }
    
     
     private class rowHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               String[] options={"0","1","2","3"};
               row=(String)JOptionPane.showInputDialog(windowContent,
"Choose One", "Input",
JOptionPane.INFORMATION_MESSAGE, null,
options, options[0]);
           }
       }
     
     
     private class colHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               String[] options={"0","1","2","3","4","5","6","7","8","9"};
               column=(String)JOptionPane.showInputDialog(windowContent,
"Choose One", "Input",
JOptionPane.INFORMATION_MESSAGE, null,
options, options[0]);
           }
       }
     
     
     private class strtHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               String[] options={"00:00","00:30","01:00","01:30","02:00","02:30","03:00","03:30","04:00","04:30","05:00","05:30","06:00","06:30","07:00","07:30","08:00","08:30","09:00","09:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30","23:00","23:30"};
               start=(String)JOptionPane.showInputDialog(windowContent,
"Choose One", "Input",
JOptionPane.INFORMATION_MESSAGE, null,
options, options[0]);
           }
       }
     
     
     private class endHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               String[] options={"00:00","00:30","01:00","01:30","02:00","02:30","03:00","03:30","04:00","04:30","05:00","05:30","06:00","06:30","07:00","07:30","08:00","08:30","09:00","09:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30","22:00","22:30","23:00","23:30"};
              etime=(String)JOptionPane.showInputDialog(windowContent,
"Choose One", "Input",
JOptionPane.INFORMATION_MESSAGE, null,
options, options[0]);
           }
       }
     private class srcHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               String[] options={"Toronto","Brampton","Missisauga","Ottawa","Montreal"};
               src=(String)JOptionPane.showInputDialog(windowContent,
"Choose One", "Input",
JOptionPane.INFORMATION_MESSAGE, null,
options, options[0]);
           }
       }
     
      private class priceHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               String[] options={"250","300","350","400","450","500","550","600","650","700","750","800","850","900"};
               price=(String)JOptionPane.showInputDialog(windowContent,
"Choose One", "Input",
JOptionPane.INFORMATION_MESSAGE, null,
options, options[0]);
           }
       }
    
     
     private class destHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               String[] options={"Toronto","Brampton","Missisauga","Ottawa","Montreal"};
               dest=(String)JOptionPane.showInputDialog(windowContent,
"Choose One", "Input",
JOptionPane.INFORMATION_MESSAGE, null,
options, options[0]);
           }
       }
       private class BackHandler1 implements ActionListener
    {
       // String newSelection;
        @Override
        public void actionPerformed(ActionEvent e) 
        {
           Main ob=new Main();
          frame.dispose();
         
        }
        
      
    }  
    
     private class ButtonHandler implements ActionListener
       {
           @Override
          public void actionPerformed(ActionEvent e)
           {
               String type=inputType;
               int p=0;
               try{
                   
                    rtNo=inputRt.getText();
                   
               }
               catch(NullPointerException w){
                   JOptionPane.showMessageDialog(windowContent,"PLEASE ENTER ROUTE NO. STARTING WITH THE LETTERS 'G'");
               }
               
    
            
               
               
              if(rtNo.charAt(0)=='G'){
            	  GreyHound ob=new GreyHound();
              ob.destinationchange(dest);
              ob.pricechange(Integer.parseInt(price));
              ob.sourcechange(src);
              ob.typechange(type);
//              ob.starttimechange(strt);
  //            ob.endtimechange(end);
              ob.routechange(rtNo);
              ob.key=rtNo;
              
              ob.rows=Integer.parseInt(row);
              ob.columns=Integer.parseInt(column);
//             ob.createseatmatrix(rows,columns);
              p=1;
               try {
                   listener.addtrySug(ob);
               } catch (IOException ex) {
                   Logger.getLogger(addBus.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(addBus.class.getName()).log(Level.SEVERE, null, ex);
               }
                    }
             if(p==1)
             {    
              JOptionPane.showMessageDialog(windowContent,"THE BUS HAS BEEN ADDED");
              Main ob=new Main();
               frame.dispose();
             }
            
             else
             {
                  JOptionPane.showMessageDialog(windowContent,"ENTER ROUTE STARTING WITH G");
             }
           }
     
     
          
          public void addtrySug(GreyHound ob) throws IOException,EOFException, ClassNotFoundException
    {

        	  GreyHound obj1 = new GreyHound();
        Scanner scan = new Scanner(System.in);
        int i;
        int choice;
        int count = 0;

        GreyHound obj = new GreyHound();
              FileInputStream f = new FileInputStream("Greyhound.txt");
              ObjectInputStream objectinput = new ObjectInputStream(f);
              ArrayList<GreyHound> read = (ArrayList<GreyHound>) objectinput.readObject();
              objectinput.close();
              //obj.adddetails();
              read.add(ob);
              
              OutputStream file = new FileOutputStream("Greyhound.txt");
              OutputStream buffer = new BufferedOutputStream(file);
              ObjectOutput output = new ObjectOutputStream(buffer);
             
              output.writeObject(read);
              
              output.close();
          
}
     }
     


}
