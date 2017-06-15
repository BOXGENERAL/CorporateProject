import java.util.*;
import java.lang.*;
import java.io.*;

public class CorporateRunner 
{
	static Scanner sc = new Scanner(System.in);
	static Corporate ay = new Corporate("ayjackson");
	
	public static void mainMenu()
	{
		System.out.println ("--------------Menu-------------");
        System.out.println ("Option 1: Overview Report  Input 1");
        System.out.println ("Option 2: Manage Expenditure Input 2");
        System.out.println ("Option 3: Manage Revenue Input 3");
        System.out.println ("Option 4: Manage Cashflow and Debt Input 4");
        System.out.println ("Option 5: save all changed Input 5");
        System.out.println ("Option 6: Exit the program Input 6");
	}
	
	public static void option1()
	{
		int option;
		int year;
		Time time;
		
		do
		{
			System.out.println ("--Select data to Report--");
            System.out.println ("Option 1: monthly report");
            System.out.println ("Option 2: yearly report");
            System.out.println ("Option 0: back menu");
	        
	        option = getInt();
	        
	        if(option == 1)
	        {	
	        	System.out.println ("Enter a time in format \"yyyy-mm\" (example  \"2017-06\") :");
	        	time = getTime();
	        	ay.printExpMonth(time);
	        	ay.printRevMonth(time);
	        	ay.printCashflowMonth(time);
	        	ay.printInterest(time);
	        	
	        }
	        else if(option == 2)
	        {
	        	System.out.println ("Enter a year(int) :");
	        	year = getInt();
	        	ay.printYear(year);
	        }
	        else if(option == 0)
	        	break;
	        else
	        	System.out.println("Please enter a valid Option");
	        
		}while(option != 0);
	}
	
	public static void option2()
	{
		String name;
		int option;
		int year;
		Time time;
		double amount;
		
		do
		{
			System.out.println ("--Select properties to Manage--");
            System.out.println ("Option 1: print monthly Expenditure");
            System.out.println ("Option 2: print yearly Expenditure");
            System.out.println ("Option 3: Add Category to the Expenditure");
            System.out.println ("Option 4: set expenditure value for a month");
            System.out.println ("Option 0: back menu");
            
	        option = getInt();
	        
	        if(option == 1)
	        {	
	        	System.out.println ("Enter a time in format \"yyyy-mm\" (example  \"2017-06\") :");
	        	time = getTime();
	        	ay.printExpMonth(time);
	        		        	
	        }
	        else if(option == 2)
	        {
	        	System.out.println ("Enter a year(int) :");
	        	year = getInt();
	        	ay.printExpYear(year);
	        }
	        else if(option == 3)
	        {
	        	System.out.println ("Input the Category name to add :");
	        	ay.addExpCategory(sc.next());
	        }
	        else if(option == 4)
	        {
	        	System.out.println ("Input the Category name to change:");
	        	name = sc.next();
	        	System.out.println ("Enter the time in format \"yyyy-mm\" (example  \"2017-06\") :");
	        	time = getTime();
	        	System.out.println ("Input the amount :");
	        	amount = getDouble();
	        	ay.setExp(name,time,amount);
	        		        	
	        }
	        else if(option == 0)
	        	break;
	        else
	        	System.out.println("Please enter a valid Option");
	        
		}while(option != 0);
	}
	
	public static void option3()
	{
		String name;
		int option;
		int year;
		Time time;
		double amount;
		
		do
		{
			System.out.println ("--Select properties to Manage--");
            System.out.println ("Option 1: print monthly Revenue");
            System.out.println ("Option 2: print yearly Revenue");
            System.out.println ("Option 3: Add Category to the Revenue");
            System.out.println ("Option 4: set Revenue value for a month");
            System.out.println ("Option 0: back menu");
            
	        option = getInt();
	        
	        if(option == 1)
	        {	
	        	System.out.println ("Enter a time in format \"yyyy-mm\" (example  \"2017-06\") :");
	        	time = getTime();
	        	ay.printRevMonth(time);
	        		        	
	        }
	        else if(option == 2)
	        {
	        	System.out.println ("Enter a year(int) :");
	        	year = getInt();
	        	ay.printRevYear(year);
	        }
	        else if(option == 3)
	        {
	        	System.out.println ("Input the Category name to add :");
	        	ay.addRevCategory(sc.next());
	        }
	        else if(option == 4)
	        {
	        	System.out.println ("Input the Category name to change:");
	        	name = sc.next();
	        	System.out.println ("Enter the time in format \"yyyy-mm\" (example  \"2017-06\") :");
	        	time = getTime();
	        	System.out.println ("Input the amount :");
	        	amount = getDouble();
	        	ay.setRev(name,time,amount);
	        		        	
	        }
	        else if(option == 0)
	        	break;
	        else
	        	System.out.println("Please enter a valid Option");
	        
		}while(option != 0);
	}
	
	public static void option4()
	{
		String name;
		int option;
		int year;
		Time time;
		double amount;
		
		do
		{
			System.out.println ("--Debt and CashFlow--");
			System.out.println ("--Select properties to Manage--");
            System.out.println ("Option 1: print a monthly cash flow");
            System.out.println ("Option 2: print a monthly Interest");
            System.out.println ("Option 3: print current balance");
            System.out.println ("Option 4: pay off balance");
            System.out.println ("Option 0: back menu");
            
	        option = getInt();
	        
	        if(option == 1)
	        {	
	        	System.out.println ("Enter a time in format \"yyyy-mm\" (example  \"2017-06\") :");
	        	time = getTime();
	        	ay.printCashflowMonth(time);
	        		        	
	        }
	        else if(option == 2)
	        {
	        	System.out.println ("Enter a time in format \"yyyy-mm\" (example  \"2017-06\") :");
	        	time = getTime();
	        	ay.printInterest(time);
	        }
	        else if(option == 3)
	        {
	        	System.out.println ("current time :"+ay.getCurrentTime());
	        	ay.printBalance();
	        }
	        else if(option == 4)
	        {
	        	ay.payDebt();	        	
	        }
	        else if(option == 0)
	        	break;
	        else
	        	System.out.println("Please enter a valid Option");
	        
		}while(option != 0);
	}
	
	//get user input:
	public static Time getTime()
	{
		Time time;
		do
        {
           try
           {
              
              time = new Time(sc.next());
              return time;
           }
           catch (InputMismatchException ex)
           {
        	   System.out.println ("Invalid Input: format: \"yyyy-mm\" (example  \"2017-06\"), try again");
               String flush = sc.next();
               
           }
        }while (true);
	}
	
	
	public static int getInt()
	{
		int num;
		
		do
        {
           try
           {
              
        	  num = sc.nextInt ();
              return num;
           }
           catch (InputMismatchException ex)
           {
        	   System.out.println ("Invalid Input: int only, try again");
               String flush = sc.next();
               
           }
        }while (true);
	}
	
	public static double getDouble()
	{
		Double num;
		
		do
        {
           try
           {
              
        	  num = sc.nextDouble ();
              return num;
           }
           catch (InputMismatchException ex)
           {
        	   System.out.println ("Invalid input: double only, try again");
               String flush = sc.next();
               
           }
        }while (true);
	}

	public static void main(String[] args)
	{
		
		
		int option;
		
		do
		{
			mainMenu();
	        
	        option = getInt();
	        
	        if(option == 1)
	        	option1();
	        else if(option == 2)
	        	option2();
	        else if(option == 3)
	        	option3();
	        else if(option == 4)
	        	option4();
	        else if(option == 5)
	        	ay.save();
	        else if(option == 6)
	        	break;
	        else
	        	System.out.println ("Please enter a valid Option");
	        
		}while(option != 6);
		System.out.println ("Thank you for using the Corporate Program");	
        
		
	}
} // CorporateRunner class