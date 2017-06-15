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
   
   //Corporate constructor:
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
      
      } 
   
   //getCurrentTime accessor:
       public Time getCurrentTime()
       {
    	   return currentTime;
       }
   
   //setExp mutator		    
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
   //setRev mutator
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
   
   //printExpMonth method:
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
   
   //printRevMonth method		    
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
  
   //printCashflowMonth method	    
       public void printCashflowMonth(Time time)
      {
    	   double value = cashflow.getMonth(time);
    	   if(value != 0)
    		   System.out.println("the cash flow of "+time+" :$"+value);
      }
   
   //printInterest method
       public void printInterest(Time time)
      {
    	   double value = debt.amountMonth(time);
    	   if(value != 0)
    		   System.out.println("the debt interest of "+time+" :$"+value);
      }
  
   //printBalance method	    
       public void printBalance()
      {
         System.out.println("the current balance :$"+balance);
      }
   
   //printExpYear method	    
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
   
   //printRevYear method
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
   
   //printYear method		    
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
  
   //addExpCategory method
       public void addExpCategory(String name)
      {
         if(expenditure.addCategory(name))
            System.out.println("add category success.");
         else
            System.out.println("add category fail.");
      
      }
  
   //addRevCategory method	    
       public void addRevCategory(String name)
      {
         if(revenue.addCategory(name))
            System.out.println("add category success.");
         else
            System.out.println("add category fail.");
      
      }
   
   //payDebt method	    
       public void payDebt()
      {
      
         balance = 0;
         payTime = currentTime;
      
      }
   
   //saveDebt method	    
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
   
   //save method	    
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
