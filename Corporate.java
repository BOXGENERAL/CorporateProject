   import java.io.*;
   import java.util.*;

    public class Corporate
   {
   //field:
      protected String name;
   
      File corporate;	
      Expenditure expenditure;
      Revenue revenue;
      CashFlow cashflow;
      Debt debt;
      double balance;
   
   //time:
      java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM");
      Calendar cal = Calendar.getInstance();	
      Time currentTime = new Time(format.format(cal.getTime()));
      Time payTime;
   
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
   
       public void printCashflowMonth(Time time)
      {
         System.out.println("the cash flow of "+time+" :$"+cashflow.getMonth(time));
      }
   
       public void printInterest(Time time)
      {
         System.out.println("the debt interest of "+time+" :$"+debt.amountMonth(time));
      }
   
       public void printBalance()
      {
         System.out.println("the current balance :$"+balance);
      }
   
       public void printExpYear(int year)
      {
         Time t;
         System.out.println("the expenditure of "+year+" :");
         for(int i = 0;i<12;i++)
         {
            t = new Time(year,i+1);
            printExpMonth(t);
         }
      
      }
   
       public void printRevYear(int year)
      {
         Time t;
         System.out.println("the revenue of "+year+" :");
         for(int i = 0;i<12;i++)
         {
            t = new Time(year,i+1);
            printRevMonth(t);
         }
      
      }
   	
       public void addExpCategory(String name)
      {
         if(expenditure.addCategory(name))
            System.out.println("add category success.");
         else
            System.out.println("add category fail.");
      
      }
   
       public void addRevCategory(String name)
      {
         if(revenue.addCategory(name))
            System.out.println("add category success.");
         else
            System.out.println("add category fail.");
      
      }
   
       public void payDebt()
      {
      
         balance = 0;
         payTime = currentTime;
      
      }
   
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
   
       public void save()
      {
      
         debt.updateDebt();
         debt.saveCategory();
         saveDebt();
         expenditure.update();
         expenditure.sortTime();
         revenue.sortTime();
         expenditure.saveFile();
         revenue.saveFile();
         cashflow.updateCashflow(expenditure, revenue);
         cashflow.saveCashflow();
      
      }
   
   } // Corporate class

