import java.util.*;
import java.lang.*;
import java.io.*;

public class Category
{
	//file:
	File f;
	
	//fields:
	protected String name;
	protected double[] amount;
	int maxNum;
	int numCategory;
	Time[] time;
	
	//Constructor Method
	public Category (String name)
	{
		this.name = name;
		f = new File(name+".txt");
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			numCategory = Integer.parseInt(br.readLine());
			maxNum = numCategory+100;
			time = new Time[maxNum];
			amount = new double[maxNum];
			
			for(int i = 0;i<numCategory;i++)
			{
				time[0] = new Time(br.readLine());
				amount[0] = Double.parseDouble(br.readLine());
			}
			br.close();
		}
		catch(IOException e)
		{
			System.out.println("category file error");
		}
		
		
	}
	
	public void saveCategory()
	{
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter((f)));
			
			bw.write(numCategory+"");
			bw.newLine();
			for(int i = 0;i<numCategory;i++)
			{
				bw.write(time[i]+"");
				bw.newLine();
				bw.write(amount[i]+"");
				bw.newLine();
			}
			
			bw.close();
		}
		catch(IOException e)
		{
			System.out.println("Category save file error");
		}
		
	}
	
	//accessor:
	public String getName()
	{
		return name;
	}
	
	public boolean setAmount (Time time, double money)	//Changes the amount of money in the Category
	{
		int n = searchTime(time);
		if(n == -1)
			return false;
		else
		{
			this.amount[n] = money; 
			return true;
		}
		
	}
		
	//searcher:
	public int searchTime(Time time)
	{
		
		for(int i = 0;i<numCategory;i++)
		{
			if(this.time[i].equals(time))
				return i;
		}
		
		return -1;
	}
	
	//methods:
	
	
	public double amountMonth(Time time)
	{
		int n = searchTime(time);
		
		if(n == -1)
			return 0;
		else
		{
			return amount[n];
		}
 
	}
	
	public double amountYear(int year)
	{
		double total = 0;
		for(int i = 0;i<numCategory;i++)
			if(year == time[i].getYear())
				total+= amount[i];
				
		return total;
	}
	
	

}//Category.class