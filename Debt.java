/*
Class name: Debt
Author: Jonathan, Ron, Henry
Date: June 5, 2017
School: AYJackson
Purpose: Manages Debt as an inheritence
*/
 
 
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
	//Decription: recieves double as an array and int and returns double
  //Purpose: Calculates the Compound Interest using recursion Form
       public double interest(double[] cash,int n)
      {
			
         if(n == -1 || cash[n]>= 0)
            return 0;
         else
            return (cash[n]+interest(cash,n-1))*rate;
      }
   //Decription: recieves no parameters and returns no value
  //Purpose: Updates the Debt
       public void updateDebt()
      {
      
         numCategory = cashflow.numCashflow;
      
         for(int i = numCategory-1;i>=0;i--)
         {
				
            time[i] = cashflow.time[i];
            amount[i] = Math.abs(Math.round((interest(cashflow.amount,i))));
         }
      
      }
   //Decription: recieves time object and another time object and returns double
  //Purpose: returns the debt
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
