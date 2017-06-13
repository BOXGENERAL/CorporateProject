import java.io.*;
import java.util.*;

public class Corporate
{
	
	protected String name = "ayjackson";
	File corporate = new File(name+".txt");	
	Expenditure expenditure;
	Revenue revenue;
	CashFlow cashflow;
	//constructor:
	public Corporate()
	{
		expenditure = new Expenditure();
		revenue = new Revenue();
		cashflow = new CashFlow();
				
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
		if(revenue.setExp( name, time, amount))
		{
			System.out.println("set revenue success!");
			printExpMonth(time);
		}
		else
		{
			System.out.println("no category "+name);
		}
	
	}
	
	//method:
	public void printExpMonth(Time time)
	{
		double total = expenditure.getMonth(time);
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
	
	
	public void save()
	{
		expenditure.saveFile();
		revenue.saveFile();
		cashflow.updateCashflow(expenditure, revenue);
		cashflow.saveCashflow();
	}

} // Corporate class
