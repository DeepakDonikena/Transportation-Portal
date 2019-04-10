
import java.io.*;
import java.util.*;

interface Tickethandler
{
//Methods required to be implemented by all classes that implement ticket handler
    void bookticket();
    int cancelticket();
    void displayticket();
}



abstract class bus //Class from which GreyHound classes are derived.
{
 //Attributes common to all derived classes
 protected String typef ;
 protected String sourcef;
 protected String destinationf;
 protected String starttimef;
 protected String endtimef;
 protected String routenof;
 protected char seatmatrixf[][];
 protected String uniqKeyf;
 protected int seatsf;
 static int countf= 0;
 int rowsf = 0;
 int columnsf = 0;
 int pricef = 0;
 //Methods common to all derived classes
 abstract public void adddetails();
 abstract public void typechange(String str);
 abstract public void sourcechange(String str);
 abstract public void destinationchange(String str);
 abstract public void starttimechange(String str);
 abstract public void endtimechange(String str);
 abstract public void routechange(String str);
 abstract public void pricechange(int i);
 abstract public void createseatmatrix(int rows,int columns);
 abstract public void search();
 abstract public void getprice();
}
class GreyHound extends bus implements Tickethandler , Serializable
{   //Attributes
    private Boolean hastv , haslight , haschargepoint;
    private String pass_name, pass_age , pass_mail , pass_phone;
    private char sex ;
    protected String key;
    protected String type ;
    protected String source;
    protected String destination;
    protected String starttime;
    protected String endtime;
    protected String routeno;
   protected char seatmatrix[][] = new char[40][40];
    protected String uniqKey;
   protected int seats;
 static int count= 0;
 int rows = 0;
 int columns = 0;
 int price;
    @Override
    public void adddetails() // Method to add details of a bus
    {    Scanner scan = new Scanner(System.in);
         type = scan.nextLine();
         destination = scan.nextLine();
         starttime = scan.nextLine();
         endtime = scan.nextLine();
         routeno = scan.nextLine();
         key = scan.nextLine();
         price = scan.nextInt();
         source = scan.nextLine();

    }

    @Override
    public void typechange(String str) // method to change the type
    {
      this.type = str;
    }

    @Override
    public void sourcechange(String str) // method to change the source
    {
     this.source = str;
    }
    @Override
    public void destinationchange(String str) // method to change the destination
    {
     this.destination = str;
    }

    @Override
    public void starttimechange(String str) // method to change the starttime
    {
        this.starttime = str;
    }

    @Override
    public void endtimechange(String str) //method to change the end time 
    {
       this.endtime = str;
    }

    @Override
    public void routechange(String str) // method to change the route
    {
        this.routeno = str;
    }

  
    @Override
    public void createseatmatrix(int rows,int columns)//method to create the seat matrix of a given bus
    {
      Scanner scan = new Scanner(System.in);
 
      seatmatrix = new char[rows][columns];
      for(int i = 0;i<rows;i++)
      {
          for(int j = 0;j<columns;j++)
          {
            seatmatrix[i][j] = 'X'; // 'X' signifies that the seat is vacant 
          }
      }
    }



public void displayall() // method to display the details of the bus
{

         displayseatmatrix();
}
public void displayseatmatrix() //method to display the seat matrix
{

  for (int i = 0;i<rows;i++)
  {
    for(int j = 0;j<columns;j++)
      System.out.print(seatmatrix[i][j]);
       System.out.println("\n");
  }
}

public void alterseatmatrix() // method to alter the seat matrix
{ int choice;
  Scanner scan = new Scanner(System.in);
  do
  {
 
   choice = scan.nextInt();
    switch(choice)
    {
        case 1:
            rows = scan.nextInt();
            break;
        case 2:
            columns = scan.nextInt();
            break;
        case 3:
            seatmatrix = new char[rows][columns];
            for(int i = 0;i<rows;i++)
             {
               for(int j = 0;j<columns;j++)
               {
                seatmatrix[i][j] = 'X';
               }
             }
            break;
   }
  }while(choice<=3);

}

    @Override
    public void pricechange(int i) 
    {
     this.price = i;  
    }

    @Override
    public void search() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getprice() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bookticket() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int cancelticket() {
        return 0;//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayticket() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}


class PassDtls implements Serializable //class for storing passenger details
{
    String name;
    String contactno;
    String gender;
    String mail;
    int seatrow;
    int seatcol;
    int seat;
    String age;
    String rte;//For route
    
}






public class BussMod
{
    

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        
        ArrayList<GreyHound> greylist = new ArrayList<GreyHound>();//holds list of GreyHound buses

        ArrayList<PassDtls> greyp = new ArrayList();

        
        GreyHound scust = new GreyHound();
        ArrayList<GreyHound> gcustlist = new ArrayList<GreyHound>();
       
        int i;
        int choice;
       String type[] = {"AC SLEEPER","AC SEMI SLEEPER","NON AC SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER","AC SEMI SLEEPER","NON AC SLEEPER","AC SLEEPER","AC SLEEPER","NON AC SLEEPER","NON AC SLEEPER","AC SLEEPER","AC SEMI SLEEPER","NON AC SLEEPER","AC SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER","AC SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER","AC SEMI SLEEPER","NON AC SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER","AC SLEEPER","NON AC SEMI SLEEPER","NON AC  SLEEPER","AC SLEEPER","AC SEMI SLEEPER","AC SLEEPER"};
        String source[] = {"Toronto","Toronto","Toronto","Toronto","Toronto","Toronto","Toronto","Toronto","Toronto","Toronto","Toronto","Toronto","Brampton","Brampton","Brampton","Brampton","Brampton","Brampton","Missisauga","Missisauga","Missisauga","Missisauga","Missisauga","Missisauga","Ottawa","Ottawa","Ottawa","Ottawa","Ottawa","Ottawa","Ottawa","Ottawa","Montreal","Montreal","Montreal","Montreal","Montreal","Montreal","Montreal"};
        String []destination = {"Brampton","Brampton","Brampton","Ottawa","Ottawa","Missisauga","Missisauga","Missisauga","Montreal","Montreal","Montreal","Montreal","Toronto","Toronto","Toronto","Ottawa","Missisauga","Missisauga","Toronto","Toronto","Brampton","Missisauga","Montreal","Montreal","Toronto","Toronto","Toronto","Brampton","Brampton","Ottawa","Montreal","Manipal","Toronto","Toronto","Toronto","Toronto","Ottawa","Ottawa","Missisauga"};       
        String []startime3 = {"16:00","14:00","23:10","22:00","23:00","16:00","12:00","20:00","22:00","23:15","21:20","21:00","16:30","15:30","23:00","22:40","21:15","13:00","21:00","23:00","22:40","21:00","13:00","13:00","14:30","12:00","23:40","22:45","13:20","21:50","14:00","13:00","22:30","22:45","21:40","20:45","00:30","01:30","15:00"};
        String []endtime3 = {"22:50","20:00","05:00","08:20","08:30","22:30","18:55","06:15","06:00","06:30","06:05","05:30","22:00","20:00","05:40","09:30","05:30","19:00","07:00","08:20","09:30","06:45","17:30","18:00","21:30","18:30","06:55","06:10","19:40","08:00","06:25","06:20","06:40","07:00","06:15","04:30","17:45","17:30","19:25"};
        String [][]seatmatrix = new String[20][20];
        String []uniquekey2= {"G1","G2","G3","G4","G5","G6","G7","G8","G9","G10","G11","G12","G13","G14","G15","G16","G17","G18","G19","G20","G21","G22","G23","G24","G25","G26","G27","G28","G29","G30","G31","G32","G33","G34","G35","G36","G37","G38","G39"};
        int []prices3 =       {620,750,500,620,750,620,750,500,620,620,500,500,620,750,500,620,620,750,620,750,620,620,620,750,620,750,500,620,750,620,620,750,620,620,500,500,620,750,620,750,620};
        
        
        int []rows   =  {4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4};
        int []columns = {8,10,8,8,10,8,10,8,8,8,8,8,8,10,8,8,8,10,8,10,8,8,8,10,8,10,8,8,10,8,8,10,8,8,8,8,8,10,8};
        int j,k;
        
        
 
        for(i=0;i<39;i++)      
        {  
            GreyHound obj2=new GreyHound();                        
           
            obj2.type = type[i];
            obj2.source = source[i];
            obj2.destination = destination[i];
            obj2.starttime = startime3[i];
            obj2.endtime = endtime3[i];
            obj2.key = uniquekey2[i];//GreyHound buses are inputted here
            obj2.price = prices3[i];
            obj2.rows = rows[i];
            obj2.columns = columns[i];
             for(j = 0;j<obj2.rows;j++)
             { 
                 for(k = 0;k<obj2.columns;k++)
                     obj2.seatmatrix[j][k] = 'X';
             }
            greylist.add(obj2);//GreyHound buses added to this list
        }
        
       File f2=new File("Greyhound.dat"); // file to store GreyHound buses
       if(!f2.exists())
       { 
        f2.createNewFile();   
        OutputStream file2 = new FileOutputStream(f2);
        OutputStream buffer2 = new BufferedOutputStream(file2);
        ObjectOutput output2 = new ObjectOutputStream(buffer2);
        output2.writeObject(greylist); // file to store GreyHound buses
        output2.close();
        buffer2.close();
        file2.close();
       } 
    
      Main ob=new Main();
       }







 
     public static  void sugadminmenu() throws IOException,EOFException, ClassNotFoundException
    {

        GreyHound obj1 = new GreyHound();
        Scanner scan = new Scanner(System.in);
        int i;
        int choice;
        int count = 0;

        do
        {
         /* System.out.println("1.Add a new bus ");
          System.out.println("2.Modify the details of existing bus");
          System.out.println("3.Remove a bus");
          System.out.println("4.Display a list of all the buses");
          System.out.println("5. Exit");
          System.out.println("Enter your choice ");*/
          i = scan.nextInt();
          switch(i)
          {
              case 1:
             GreyHound obj = new GreyHound();
              FileInputStream f = new FileInputStream("Greyhound.dat");//opening file to read buses
              ObjectInputStream objectinput = new ObjectInputStream(f);
              ArrayList<GreyHound> read = (ArrayList<GreyHound>) objectinput.readObject();
              objectinput.close();
              obj.adddetails();
              read.add(obj);//adding new object to the list
              
              OutputStream file = new FileOutputStream("Greyhound.dat");
              OutputStream buffer = new BufferedOutputStream(file);
              ObjectOutput output = new ObjectOutputStream(buffer);
             
              output.writeObject(read);//rewriting modified list to the file
              
              output.close();
             
              break;
              case 2:
              sugamodifymenu();
              break;
              case 3:

              break;
              case 4:
                   FileInputStream f1 = new FileInputStream("Greyhound.dat");
        
                  try
                   {   
                    ObjectInputStream objectinputstream = new ObjectInputStream(f1);
                    ArrayList<GreyHound> readCase = (ArrayList<GreyHound>) objectinputstream.readObject();
                    System.out.println(readCase.size());
                    objectinputstream .close();
          for(i = 0;i<readCase.size();i++)
          {
    
            readCase.get(i).displayseatmatrix();
          }

        }
               catch (Exception e) 
               {
                 e.printStackTrace();
               }
        break; 

          }
        }while(i<=4);

    }
     
    
 public static void sugaremove(String uniq) throws FileNotFoundException, IOException, ClassNotFoundException
 {

   GreyHound obj = new GreyHound();
   FileInputStream f = new FileInputStream("Greyhound.dat");
   ObjectInputStream objectinput = new ObjectInputStream(f);
   ArrayList<GreyHound> read = (ArrayList<GreyHound>) objectinput.readObject();
   objectinput.close();


   for(int i = 0;i<read.size();i++)
    {  GreyHound obj1 = new GreyHound();
       obj1 = (GreyHound)read.get(i);
       if(obj1.key.equals(uniq))
       read.remove(i);//remove the selected bus
   }
              OutputStream file = new FileOutputStream("Greyhound.dat");
              OutputStream buffer = new BufferedOutputStream(file);
              ObjectOutput output = new ObjectOutputStream(buffer);
             
              output.writeObject(read);//re write the modified list back to thefile
              
              output.close();
   
 }
 

 public static void sugamodifymenu() throws FileNotFoundException, IOException, ClassNotFoundException
 {
        GreyHound obj1 = new GreyHound();
        Scanner scan1 = new Scanner(System.in);
        int i;
        int choice;
        String routesearch;
        String typemod;
        String sourcemod;
        String destmod;
        String startmod, endmod , routemod;
        int pricemod;

        do
        {

          i = scan1.nextInt();

          switch(i)
          {
              case 1:

               GreyHound obj = new GreyHound();
              FileInputStream f = new FileInputStream("Greyhound.dat");
              ObjectInputStream objectinput = new ObjectInputStream(f);
              ArrayList<GreyHound> read = (ArrayList<GreyHound>) objectinput.readObject();
              objectinput.close();
              
              
            for(int j = 0;j<read.size();j++)
              {
                 obj1 = (GreyHound)read.get(j);
               //  if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                     //System.out.println("Enter the type of bus ");
                     typemod = scan1.nextLine();
                     
                     obj1.typechange(typemod);//change type
                 }
              }
              OutputStream file = new FileOutputStream("Greyhound.dat");
              OutputStream buffer = new BufferedOutputStream(file);
              ObjectOutput output = new ObjectOutputStream(buffer);
             
              output.writeObject(read);// re write contents back to the file
              
              output.close();
              break;
              case 2:
             // System.out.println("Enter the unique key of the bus whose type you wish to modify");
              
             // routesearch = scan1.nextLine();
             // routesearch = scan1.nextLine();
              GreyHound obj3 = new GreyHound();
              FileInputStream f1 = new FileInputStream("Greyhound.dat");
              ObjectInputStream objectinput2 = new ObjectInputStream(f1);
              ArrayList<GreyHound> read2 = (ArrayList<GreyHound>) objectinput2.readObject();
              objectinput2.close();
              
              for(int j = 0;j<read2.size();j++)
              {
                 obj1 = (GreyHound)read2.get(j);
                // if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                  //   System.out.println("Enter the new source of bus ");
                     sourcemod=scan1.nextLine();
                     obj1.sourcechange(sourcemod);
                 }
              }
              OutputStream file2 = new FileOutputStream("Greyhound.dat");
              OutputStream buffer2 = new BufferedOutputStream(file2);
              ObjectOutput output2 = new ObjectOutputStream(buffer2);
             
              output2.writeObject(read2);// re write contents back to the file
              
              output2.close();
              break;
             case 3:
              
             // System.out.println("Enter the unique key of the bus whose type you wish to modify");
              //routesearch = scan1.nextLine();
              //routesearch = scan1.nextLine();
              GreyHound obj4 = new GreyHound();
              FileInputStream f2 = new FileInputStream("Greyhound.dat");
              ObjectInputStream objectinput3 = new ObjectInputStream(f2);
              ArrayList<GreyHound> read3 = (ArrayList<GreyHound>) objectinput3.readObject();
              objectinput3.close();
              for(int j = 0;j<read3.size();j++)
              {
                 obj1 = (GreyHound)read3.get(j);
              //   if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                  //   System.out.println("Enter the new destination of bus ");
                     destmod=scan1.nextLine();
                     obj1.destinationchange(destmod);//change destination
                 }
              }
              OutputStream file3 = new FileOutputStream("Greyhound.dat");
              OutputStream buffer3 = new BufferedOutputStream(file3);
              ObjectOutput output3 = new ObjectOutputStream(buffer3);
             
              output3.writeObject(read3);//// re write contents back to the file
              
              output3.close();
              
              break;
           case 4:
             // System.out.println("Enter the unique key of the bus whose type you wish to modify");
              //routesearch = scan1.nextLine();
             // routesearch = scan1.nextLine();
              GreyHound obj5 = new GreyHound();
              FileInputStream f3 = new FileInputStream("Greyhound.dat");
              ObjectInputStream objectinput4 = new ObjectInputStream(f3);
              ArrayList<GreyHound> read4 = (ArrayList<GreyHound>) objectinput4.readObject();
              objectinput4.close();
              
              
              for(int j = 0;j<read4.size();j++)
              {
                 obj1 = (GreyHound)read4.get(j);
               //  if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                  //   System.out.println("Enter the new start time of bus ");
                     destmod=scan1.nextLine();
                     obj1.starttimechange(destmod);
                 }
              }
               OutputStream file4 = new FileOutputStream("Greyhound.dat");
              OutputStream buffer4 = new BufferedOutputStream(file4);
              ObjectOutput output4 = new ObjectOutputStream(buffer4);
             
              output4.writeObject(read4);// re write contents back to the file
              
              output4.close();
              break;
           case 5:
              //System.out.println("Enter the unique key of the bus whose type you wish to modify");
              //routesearch = scan1.nextLine();
              //routesearch = scan1.nextLine();
              GreyHound obj6 = new GreyHound();
              FileInputStream f4 = new FileInputStream("Greyhound.dat");
              ObjectInputStream objectinput5 = new ObjectInputStream(f4);
              ArrayList<GreyHound> read5 = (ArrayList<GreyHound>) objectinput5.readObject();
              objectinput5.close();
              for(int j = 0;j<read5.size();j++)
              {
                 obj1 = (GreyHound)read5.get(j);
                 //if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                 //    System.out.println("Enter the new end time of bus ");
                     endmod=scan1.nextLine();
                     obj1.endtimechange(endmod);//change end time 
                 }
              }
              OutputStream file5 = new FileOutputStream("Greyhound.dat");
              OutputStream buffer5 = new BufferedOutputStream(file5);
              ObjectOutput output5 = new ObjectOutputStream(buffer5);
             
              output5.writeObject(read5);// re write contents back to the file
              
              output5.close();
              
              break;
            case 6:
              //System.out.println("Enter the unique key of the bus whose type you wish to modify");

              GreyHound obj7 = new GreyHound();
              FileInputStream f5 = new FileInputStream("Greyhound.dat");
              ObjectInputStream objectinput6 = new ObjectInputStream(f5);
              ArrayList<GreyHound> read6 = (ArrayList<GreyHound>) objectinput6.readObject();
              objectinput6.close();
              for(int j = 0;j<read6.size();j++)
              {
                 obj1 = (GreyHound)read6.get(j);
                // if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                  //   System.out.println("Enter the new price per ticket of bus ");
                     pricemod=scan1.nextInt();
                     obj1.pricechange(pricemod);//// re write contents back to the file
                 }
              }
              OutputStream file6 = new FileOutputStream("Greyhound.dat");
              OutputStream buffer6 = new BufferedOutputStream(file6);
              ObjectOutput output6 = new ObjectOutputStream(buffer6);
             
              output6.writeObject(read6);// re write contents back to the file
              
              output6.close();
              
              break;
            case 7:
              //System.out.println("Enter the unique key of the bus whose type you wish to modify");
              //routesearch = scan1.nextLine();
              //routesearch = scan1.nextLine();
              GreyHound obj8 = new GreyHound();
              FileInputStream f6 = new FileInputStream("Greyhound.dat");
              ObjectInputStream objectinput7 = new ObjectInputStream(f6);
              ArrayList<GreyHound> read7 = (ArrayList<GreyHound>) objectinput7.readObject();
              objectinput7.close();
              for(int j = 0;j<read7.size();j++)
              {
                 obj1 = (GreyHound)read7.get(j);
                // if(obj1.key.equalsIgnoreCase(routesearch))
                 {
                  obj1.alterseatmatrix();
                 } 
              }
              OutputStream file7 = new FileOutputStream("Greyhound.dat");
              OutputStream buffer7 = new BufferedOutputStream(file7);
              ObjectOutput output7 = new ObjectOutputStream(buffer7);
             
              output7.writeObject(read7);// re write contents back to the file
              
              output7.close();
          }
        }while(i<=7);
      
}

 //Customer Menus
 public static  void customermenu(ArrayList<PassDtls> greyp,ArrayList<GreyHound> greylist ) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        int i;
        String key;
        int choice;
        do
        {

          i = scan.nextInt();
          switch(i)
          {
              case 1:
              key = searchbus();
             /// bookTicket(key);
              break;
              case 2:
             // cancelTicket();
              break;


          }
        }while(i<=2);


       }


//searchbus method for customer
  public static String searchbus() throws FileNotFoundException, IOException, ClassNotFoundException
     {   String uniqkey;
         
         FileInputStream f2 = new FileInputStream("Greyhound.dat");
         ObjectInputStream objectinput2 = new ObjectInputStream(f2);
         ArrayList<GreyHound> read2 = (ArrayList<GreyHound>) objectinput2.readObject();
         objectinput2.close();
        
         Scanner scan=new Scanner(System.in);
         int choice;
        
         ArrayList<GreyHound> reqdSugam=new ArrayList();//the list of GreyHound buses on this route

         int i=0;
         String src;//the start point
         String dest;//the end point

         //System.out.println("Enter the source station");
         src=scan.nextLine();
         //System.out.println("Enter the destination");
         dest=scan.nextLine();

         //Adding the objects to reqdSugam list
        
         while(i<read2.size())
         {   GreyHound obj3 = new GreyHound();
              obj3 = (GreyHound)read2.get(i);
              if(obj3.source.equals(src) && obj3.destination.equals(dest))
               reqdSugam.add((obj3));//add to searchlist
              obj3.displayall();
             i++;
         }
         i=0;
         
        
uniqkey = searchuniqkey();
//System.out.println(uniqkey);
return uniqkey;
}
public static String searchuniqkey() throws FileNotFoundException, IOException, ClassNotFoundException
{
  String uniqkey;
  Scanner scan = new Scanner(System.in);
         
         FileInputStream f2 = new FileInputStream("Greyhound.dat");
         ObjectInputStream objectinput2 = new ObjectInputStream(f2);
         ArrayList<GreyHound> read2 = (ArrayList<GreyHound>) objectinput2.readObject();
         objectinput2.close();
        
        // System.out.println("enter the unique key of the bus you wish to travel in");
         uniqkey = scan.nextLine();
  int i = 0;

  
  for(i=0;i<read2.size();i++)
  {  //System.out.println("entered sugama list");
     GreyHound obj2 = new GreyHound();
     obj2 = (GreyHound)read2.get(i);
    if(obj2.key.equals(uniqkey))
    {
      return obj2.key;
    }
   
  }
 

  
return null;
}

  
 public static int bookTicket(String key,int x,int y) throws FileNotFoundException, IOException, ClassNotFoundException
 {
         Scanner scan=new Scanner(System.in);
        // Page3 ob=new Page3();
        // System.out.println("Transfer passed");//customer details
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
         int v=0,s=0,d=0;
         //files of buses
       
         FileInputStream f2 = new FileInputStream("Greyhound.dat");
         ObjectInputStream objectinput2 = new ObjectInputStream(f2);
         ArrayList<GreyHound> read2 = (ArrayList<GreyHound>) objectinput2.readObject();
         objectinput2.close();


                ArrayList<PassDtls> gcustlist=new ArrayList();
                PassDtls obj = new PassDtls();
               
                int flag1=0;
                int flag2=0;
         
                
       
         if(flag2==0)
         {    
          for(i=0;i<read2.size();i++)
          {   
             //GreyHound obj1 = new GreyHound();
             //obj1 = (GreyHound)read2.get(i);
             if(read2.get(i).key.equals(key))
             {   
                //System.out.println("Choose your seat by selecting the row and column of your seat");
                //x = scan.nextInt();
                //y = scan.nextInt();
                System.out.println("Entered the seatmatrix loop");
                
                    if(read2.get(i).seatmatrix[x][y]=='X')
                    {
                      read2.get(i).seatmatrix[x][y] = 'O';
                      obj.seatcol = y;
                      obj.seatrow = x;
                      obj.seat = ((x*read2.get(i).columns)+y+1);
                      System.out.println("Your seat is "+obj.seat);
                       obj.rte=read2.get(i).key;
                       s=1;
                    }
                    else
                    {    
                     System.out.println("Occupied book again");
                    }
                read2.get(i).displayseatmatrix();
                //gcustlist.add(obj);
                break;
              } 
         }
         }  
     
        if(s==1)
        {
            OutputStream file2 = new FileOutputStream("Greyhound.dat");
        OutputStream buffer2 = new BufferedOutputStream(file2);
        ObjectOutput output2 = new ObjectOutputStream(buffer2);
        output2.writeObject(read2);
        output2.close();
            
        }
        return obj.seat;
     //   Page3 ob=new Page3(obj); //Pass passenger details to the Page
     
      
    
      }
  


     public static  int cancelTicket(String Key,int x,int y) throws FileNotFoundException, IOException, ClassNotFoundException
     {   
        // System.out.println("cancel ticket entered");
         //String Key;
         String seat;
         String bus;
         int i=0;
         int ret=0;
         int flag=0;
         //int x, y ;
         
         FileInputStream f2 = new FileInputStream("Greyhound.dat");
         ObjectInputStream objectinput2 = new ObjectInputStream(f2);
         ArrayList<GreyHound> read2 = (ArrayList<GreyHound>) objectinput2.readObject();
         objectinput2.close();
        
         Scanner in=new Scanner(System.in);
       //  System.out.println("Enter the unique key number");
         //Key=in.next();
       //  System.out.println("Key received is"+Key);   
         
         
           for(i = 0;i<read2.size();i++)
           {     
           GreyHound obj2 = new GreyHound();
           obj2 = (GreyHound)read2.get(i);
           if(obj2.key.equals(Key))
           {
                // System.out.println("enter your seat row and seat column");
              //   x = in.nextInt();
               //  y = in.nextInt();
                 if(obj2.seatmatrix[x][y]=='O')
                 {
                     greypremove(x,y,Key);
                     return 3;
                 }
                 return 2;  
             }
           }
         
        
                if(flag==0)
         {
             return 1;
         }
         return 0;
        
     }            
   
   
   public static void greypremove(int x,int y,String key) throws FileNotFoundException, IOException, ClassNotFoundException
   {   int i,j ;
       FileInputStream f1 = new FileInputStream("GreyhoundPassenger.dat");
       ObjectInputStream objectinput1 = new ObjectInputStream(f1);
       ArrayList<PassDtls> read1 = (ArrayList<PassDtls>) objectinput1.readObject();
       objectinput1.close();
       FileInputStream f = new FileInputStream("Greyhound.dat");
       ObjectInputStream objectinput = new ObjectInputStream(f);
         ArrayList<GreyHound> read = (ArrayList<GreyHound>) objectinput.readObject();
         objectinput1.close();
         OutputStream file1 = new FileOutputStream("Greyhound.dat");
         OutputStream buffer1 = new BufferedOutputStream(file1);
         ObjectOutput output1 = new ObjectOutputStream(buffer1);
       for(i = 0;i<read1.size();i++)
       { 
          PassDtls p = new PassDtls();       
          p = (PassDtls)read1.get(i);
          if(p.seatcol==y&&p.seatrow==x)
          {   
              read1.remove(p);
              for(j = 0;j<read.size();j++)
              {
                GreyHound Object = new GreyHound();
                Object = read.get(j);
                if(Object.key.equals(key))
                {
                
                Object.seatmatrix[x][y]='X';
                break;
                }
                
              }
              
          }
       }
       
       output1.writeObject(read);
       output1.close();
              
              OutputStream filegreyp = new FileOutputStream("GreyhoundPassenger.dat");
              OutputStream buffers = new BufferedOutputStream(filegreyp);
              ObjectOutput outputgreyp = new ObjectOutputStream(buffers);
              outputgreyp.writeObject(read1);
              outputgreyp.close();
        
       
       
   }
}