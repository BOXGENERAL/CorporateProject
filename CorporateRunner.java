   import java.util.*;
   import java.lang.*;
   import java.io.*;

    public class CorporateRunner 
   {
       public static void main(String[] args)
      {
         Scanner input = new Scanner (System.in);
         Time currentTime;
      
      //set current time:
         java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM");
         Calendar cal = Calendar.getInstance();	
         currentTime = new Time(format.format(cal.getTime()));
      
         Corporate ay = new Corporate();
         Time time = new Time("2017-06");
         int option1;
         boolean confirm1; 
			int option2;
			
         do
         {
            try
            {
               confirm = true;
               System.out.println ("--------------Menu-------------");
               System.out.println ("Option 1: Manage Budget and Expenditure Input 1");
               System.out.println ("Option 2: Overview Report Input 2");
               System.out.println ("Option 3: Manage Revenue Input 4");
               System.out.println ("Option 4: Manage Cashflow and Debt");
               System.out.println ("Option 5: Exit the program Input 5");
               option1 = input.nextInt ();
            }
                catch (InputMismatchException ex)
               {
                  System.out.println ("Error Processing File");
                  String flush = input.next();
                  confirm = false;
               }
         }while (confirm == false);
         if (option1 == 1)
         {
         	System.out.println ("--Select change in Budget and Category--");
         	
         }
      
      }
   } // CorporateRunner class
