 /*
Class name: Corporate
Author: Daniel, Jonathan
Date: June 5, 2017
School: AYJackson
Purpose: The whole database for the Corporation
*/


   import java.io.*;
import java.util.*;

    public class Corporate
   {
   //field:
      protected String name;
      protected File corporate;	
      protected Expenditure expenditure;
      protected Revenue revenue;
      protected CashFlow cashflow;
      protected Debt debt;
      protected double balance;
   
   //time:
      protected static java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM");
      protected static Calendar cal = Calendar.getInstance();	
      protected static Time currentTime = new Time(format.format(cal.getTime()));
      protected Time payTime;
   
   //constructor:
       public Corporate(String name)
      {
         corporate = new File(name+".txt");
         debt = new Debt();
         expenditure = new Expenditure();
         revenue = new Revenue();
         cashflow = new CashFlow();
      
         try
         {
            BufferedReader br = new BufferedReader(new FileReader(corporate));
            payTime = new Time(br.readLine());
            balance = Double.parseDouble(br.readLine());
         }
             catch(IOException e)
            {
               System.out.println("corporate load file error");
            }
      
      } // Constructor I
   
   //accessor:
	//Decription: recives the parameter of time, String, and double and returns no value
	//Purpose: Sets the Expentiture
       public Time getCurrentTime()
       {
    	   return currentTime;
       }
       
       public void setExp(String name,Time time,double amount)
      {
         if(expenditure.setExp( name, time, amount))
         {
            System.out.println("set expenditure success!");
            printExpMonth(time);
         }
         else
         {
            System.out.println("no category "+name);
         }
      
      }
   	//Decription: recives the parameter of time, String, and double and returns no value
	//Purpose: Sets the Revenue
       public void setRev(String name,Time time,double amount)
      {
         if(revenue.setRev( name, time, amount))
         {
            System.out.println("set revenue success!");
            printRevMonth(time);
         }
         else
         {
            System.out.println("no category "+name);
         }
      
      }
   
   //method:
	//Decription: recives the parameter of time and returns no value
	//Purpose: Outputs a report for Expenditure within the month
       public void printExpMonth(Time time)
      {
         double total = expenditure.monthTotal(time);
      
         if(total == 0)
            System.out.println("The expenditure of "+time+" is $0.00");
         else
         {
            System.out.println("The expenditure of "+time+" :");
            expenditure.printMonth(time);
            System.out.println("The total expenditure : "+total);
         
         }
         System.out.println("");
      }
   //Decription: recives the parameter of time and returns no value
	//Purpose: Outputs a report for Revenue within the month
       public void printRevMonth(Time time)
      {
         double total = revenue.getMonth(time);
         if(total == 0)
            System.out.println("The revenue of "+time+" is $0.00");
         else
         {
            System.out.println("The revenue of "+time+" :");
            revenue.printMonth(time);
            System.out.println("The total revenue : "+total);
         }
         System.out.println("");
      }
   //Decription:recives the parameter of time and returns no value
	//Purpose: Outputs a report for CashFlow within the month
       public void printCashflowMonth(Time time)
      {
    	   double value = cashflow.getMonth(time);
    	   if(value != 0)
    		   System.out.println("the cash flow of "+time+" :$"+value);
      }
   //Decription:recives the parameter of time and returns no value
	//Purpose: Outputs a report for Interest within the month
       public void printInterest(Time time)
      {
    	   double value = debt.amountMonth(time);
    	   if(value != 0)
    		   System.out.println("the debt interest of "+time+" :$"+value);
      }
   //Decription:recives not parameter and returns no value
	//Purpose: Outputs a report for Balance within the month
       public void printBalance()
      {
         System.out.println("the current balance :$"+balance);
      }
   //Decription: recieves the paramenter of year as an int and returns not value
	//Purpose: Outputs a report for the Expenditure within the year
       public void printExpYear(int year)
      {
         Time t;
         System.out.println("the expenditure of "+year+" :");
         for(int i = 0;i<12;i++)
         {
            t = new Time(year,i+1);
            System.out.println ("----------------------------------------");
            printExpMonth(t);
         }
      
      }
   //Decription: recieves the paramenter of year as an int and returns not value
	//Purpose: Outputs a report for the Revenue within the year
       public void printRevYear(int year)
      {
         Time t;
         System.out.println("the revenue of "+year+" :");
         for(int i = 0;i<12;i++)
         {
            t = new Time(year,i+1);
            System.out.println ("----------------------------------------");
            printRevMonth(t);
         }
      
      }
       //Decription: recieves the paramenter of year as an int and returns no value
	//Purpose: Outputs a report for year of everything
       public void printYear(int year)
       {
          Time t;
          System.out.println("the yearly report of "+year+" :");
          for(int i = 0;i<12;i++)
          {
             t = new Time(year,i+1);
             System.out.println ("----------------------------------------");
             printExpMonth(t);
             printRevMonth(t);
             printCashflowMonth(t);
             printInterest(t);
          }
       
       }
   	//Decription: recives the parameter of name as a String and returns no value
	//Purpose: Allows user to add a new Category within Expenditure if it was successful 
	//then it will output a success message if not then an error
       public void addExpCategory(String name)
      {
         if(expenditure.addCategory(name))
            System.out.println("add category success.");
         else
            System.out.println("add category fail.");
      
      }
   //Decription: recives the parameter of name as a String and returns no value
	//Purpose: Allows user to add a new Category within Revenue if it was successful 
	//then it will output a success message if not then an error
       public void addRevCategory(String name)
      {
         if(revenue.addCategory(name))
            System.out.println("add category success.");
         else
            System.out.println("add category fail.");
      
      }
   //Decription: recives no parameters and returns no value
	//Purpose: User Pays off Debt
       public void payDebt()
      {
      
         balance = 0;
         payTime = currentTime;
      
      }
   //Decription: recieves no parameters and returns no value
	//Purpose: saves Debt as a file
       public void saveDebt()
      {
         balance = debt.getDebt(payTime,currentTime);
         try
         {
            BufferedWriter bw  = new BufferedWriter(new FileWriter(corporate));
         
            bw.write(payTime+"");
            bw.newLine();
            bw.write(balance+"");
            bw.newLine();
         
            bw.close();
         }
             catch(IOException e)
            {
               System.out.println("corporate save file error");
            }
      }
   //Decription: recives no parameter and returns no value
	//Purpose: Saves the whole data into a txt file
       public void save()
      {
      
         debt.updateDebt();
         debt.saveCategory();
         saveDebt();
         expenditure.update();
		 revenue.update();
         expenditure.sortTime();
         revenue.sortTime();
         expenditure.saveFile();
         revenue.saveFile();
         cashflow.updateCashflow(expenditure, revenue);
         cashflow.saveCashflow();
      
      }
   
   } // Corporate class
