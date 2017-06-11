import java.io.*;
import java.util.*;

public class Corporate
{
	
	protected String name = "ayjackson";
	File corporate = new File(name+".txt");	
	Expenditure expenditure;
	Revenue revenue;
	
	//constructor:
	public Corporate()
	{
		expenditure = new Expenditure();
		
				
	} // Constructor I
	
	//accessor:
	
	
	//method:
	public void printExpMonth(Time time)
	{
		System.out.println("The expenditure of "+time+" :");
		expenditure.printMonth(time);
		System.out.println("The total expenditure : "+expenditure.monthTotal(time));
		
	}
	
	public void printExpYear(int year)
	{
		System.out.println("the expenditure of "+year+" :");
		for(int i = 0;i<12;i++)
			System.out.println("the expenditure of "+year+" :");
		
	}
		
	public void addExpCategory(String name)
	{
		if(expenditure.addCategory(name))
			System.out.println("add category success.");
		else
			System.out.println("add category fail.");
		
	}
	
	
	
	public void save()
	{
		expenditure.saveFile();
		
	}

} // Corporate class
