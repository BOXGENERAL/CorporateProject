import java.util.*;
import java.lang.*;
import java.io.*;

public class Category
{
	//file:
	protected File f;
	
	//fields:
	protected String name;
	protected double[] amount;
	protected int maxNum;
	protected int numCategory;
	protected Time[] time;
	
	//Constructor Method
	public Category (String name)
	{
		this.name = name;
		f = new File(name+".txt");
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(f));
			
			numCategory = Integer.parseInt(br.readLine());
			maxNum = numCategory+1000;
			time = new Time[maxNum];
			amount = new double[maxNum];
			
			for(int i = 0;i<numCategory;i++)
			{
				time[i] = new Time(br.readLine());
				amount[i] = Double.parseDouble(br.readLine());
			}
			br.close();
		}
		catch(IOException e)
		{
			System.out.println("category file error");
		}
		
		
	}
	
	//saveCategory method
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
	
	//setAmount mutator
	public boolean setAmount (Time time, double money)	//Changes the amount of money in the Category
	{
		int n = searchTime(time);
		if(n == -1)
		{
			this.time[numCategory] = time;
			this.amount[numCategory] = money;
			numCategory++;
		}
		else
		{
			this.amount[n] = money; 
			
		}
		return true;
	}
		
	//searchTime method
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
	
	//amountMonth method
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
	
	//amountYear method
	public double amountYear(int year)
	{
		double total = 0;
		for(int i = 0;i<numCategory;i++)
			if(year == time[i].getYear())
				total+= amount[i];
				
		return total;
	}
	
	//sortTime method
	public void sortTime()
	{
		
		Time temp;
		Double temp2;
		for(int i = numCategory;i>0;i--)
		{
			for(int j = 0;j<i-1;j++)
			{
				if(time[j].getYear() > time[j+1].getYear())
				{
					temp = time[j];
					temp2 = amount[j];
					time[j] = time[j+1];
					amount[j] = amount[j+1];
					time[j+1] = temp;
					amount[j+1] = temp2;
				}
				else if(time[j].getYear() == time[j+1].getYear() && (time[j].getMonth() > time[j+1].getMonth()))
				{
					temp = time[j];
					temp2 = amount[j];
					time[j] = time[j+1];
					amount[j] = amount[j+1];
					time[j+1] = temp;
					amount[j+1] = temp2;
				}
			}
		}
			
	}
	

}//Category class
