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
      	//Menu Options
         int option1 = 0;
         boolean confirm1; 
         int option2 = 0;
         boolean confirm2, confirm3;
      	//Changing Properties Option
         String name;
         double amount1= 0.00;
         String date;
         double rate;
      	//The Main Menu Screen 1-1
         do
         {
         	
            try
            {
               confirm1 = true;
               System.out.println ("--------------Menu-------------");
               System.out.println ("Option 1: Manage Expenditure Input 1");
               System.out.println ("Option 2: Overview Report Input 2");
               System.out.println ("Option 3: Manage Revenue Input 3");
               System.out.println ("Option 4: Manage Cashflow and Debt Input 4");
               System.out.println ("Option 5: Exit the program Input 5");
               option1 = input.nextInt ();
            }
                catch (InputMismatchException ex)
               {
                  System.out.println ("Invalid Input try again");
                  String flush = input.next();
                  confirm1 = false;
               }
         }while (confirm1 == false);
      	//Sub Menu 2-1 Manage Expenditure
         if (option1 == 1)
         {
            do
            {
               try
               {
                  confirm2 = true;
                  System.out.println ("--Select properties to Manage--");
                  System.out.println ("Option 1: Add Category to the Expenditure");
                  System.out.println ("Option 2: Change Category to the Expenditure");
                  option2 = input.nextInt();
               }
                   catch (InputMismatchException ex)
                  {
                     System.out.println ("Invalid Input try again");
                     confirm2 = false;
                  }
            }while (confirm2 == false);
         	//Adding Category Selection
            if (option2 == 1)
            {
               System.out.println ("Input the Category name to add");
               name = input.nextLine();
               ay.addExpCategory(name);
            }
         	//Manages the Category Selection
            if (option2 == 2)
            {
               System.out.println ("\n2Input the Category name to change");
               input.next();
               name = input.nextLine();
               do
               {
                  try
                  {
                     confirm3 = true;
                     System.out.println ("Input the amount to change the Category");
                     amount1 = input.nextDouble();
                  }
                      catch (InputMismatchException ex)
                     {
                        System.out.println ("Invalid input please try again");
                        String flush = input.next();
                        confirm3 = false;
                     }
               }while (confirm3 == false);
               System.out.println ("Input the year amd month in yyyy-mm format");
               date = input.nextLine();
               ay.setExp (name, new Time(input.nextLine()), amount1);
            	
            	
            }
         }
         //Sub Menu 2-2 Output a report
         else if (option1 == 2)
         {
            do
            {
               try
               {
                  confirm2 = true;
                  System.out.println ("--Select data to Report--");
                  System.out.println ("Option 1: Expenditure Categories");
                  System.out.println ("Option 2: Revenue Categories");
                  System.out.println ("Option 3: Cashflow and Debt");
                  System.out.println ("Option 4: Highest Expenditure to Lowest Expenditure");
                  option2 = input.nextInt ();
               }
                   catch (InputMismatchException ex)
                  {
                     System.out.println ("Invalid Input try again");
                     confirm2 = false;
                  }
            }while (confirm2 == false);
            //Sub menu 3-1 Reports Expenditure Categories in the Run menu
            if (option2 == 1)
            {
               System.out.println ("--Expenditure Category Report--");
            //Insert method to update
            
            }
            else if (option2 == 2)
            {
               System.out.println ("--Revenue Categories Report--");
            //Insert method to update
            }
            else if (option2 == 3)
            {
               System.out.println ("--CashFlow and Debt Report--");
            }
         	
         	
         	
         }
         else if (option1 == 3)
         {
            do
            {
               try
               {
                  confirm2 = true;
                  System.out.println ("--Select properties to Manage--");
                  System.out.println ("Option 1: Add Category to the Revenue");
                  System.out.println ("Option 2: Change Category to the Revenue");
                  option2 = input.nextInt();
               }
                   catch (InputMismatchException ex)
                  {
                     System.out.println ("Invalid Input try again");
                     confirm2 = false;
                  }
            }while (confirm2 == false);
         	//Adding Category Selection
            if (option2 == 1)
            {
               System.out.println ("Input the Category name to add");
               name = input.nextLine();
               ay.addRevCategory(name);
            }
            //Manages the Category Selection
            else if (option2 == 2)
            {
               System.out.println ("\n2Input the Category name to change");
               input.next();
               name = input.nextLine();
               do
               {
                  try
                  {
                     confirm3 = true;
                     System.out.println ("Input the amount to change the Category");
                     amount1 = input.nextDouble();
                  }
                      catch (InputMismatchException ex)
                     {
                        System.out.println ("Invalid input please try again");
                        String flush = input.next();
                        confirm3 = false;
                     }
               }while (confirm3 == false);
               System.out.println ("Input the year amd month in yyyy-mm format");
               date = input.nextLine();
               ay.setRev (name, new Time(input.nextLine()), amount1);
            
            }
         }
            //Sub Menu 2- 4 Manage Debt and CashFlow Method
         else if (option1 == 4)
         {
            do
            {
               try
               {
                  confirm2 = true;
                  System.out.println ("--Debt and CashFlow--");
                  System.out.println ("Select Option in Manage");
                  System.out.println ("Option1 : Change the CashFlow Interest rate debt");
                  option2 = input.nextInt();
               }//Try Method
                   catch (InputMismatchException ex)
                  {
                     System.out.println ("Invalid Input");
                     String flush = input.next();
                     confirm2 = false;
                  }//Catch Method
                 
            }while (confirm2 == false);
            if (option2 == 1)
            {
               do
               {
                  try
                  {
                     confirm3 = true;
                     System.out.println ("Input the interest rate");
                     rate = input.nextDouble();
                  }
                      catch (InputMismatchException ex)
                     {
                        System.out.println ("Invalid Input");
                        String flush = input.next();
                        confirm3 = false;
                     }
               }while (confirm3 == false);
               // Insert calling methods to change Debt and the interest rate
               
               
            }
         }
      }
   } // CorporateRunner class
