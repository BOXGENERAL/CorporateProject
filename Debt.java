   import java.util.*;
   import java.lang.*;
   import java.io.*;

    public class Debt extends Category
   {
    	
      protected double rate = 0.05;
      protected CashFlow cashflow = new CashFlow();
      protected double debt;
   
   //constructor:
       public Debt()
      {
         super("debt");
      
      }
   
   //accessor:
       public void setRate(double rate)
      {
         this.rate = rate;
      }
   
   //methods:
       public double interest(double[] cash,int n)
      {
			
         if(n == -1 || cash[n]>= 0)
            return 0;
         else
            return (cash[n]+interest(cash,n-1))*rate;
      }
   
       public void updateDebt()
      {
      
         numCategory = cashflow.numCashflow;
      
         for(int i = numCategory-1;i>=0;i--)
         {
				
            time[i] = cashflow.time[i];
            amount[i] = Math.abs(Math.round((interest(cashflow.amount,i))));
         }
      
      }
   
       public double getDebt(Time start,Time end)
      {
         Time t = start.copy();
         debt = 0;
         while((t.compare(end)<= 0))
         {
            debt += amountMonth(t);
            t.addMonth();
         }
         return debt;
      }
   
   
   
   }
