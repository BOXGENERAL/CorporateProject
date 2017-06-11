import java.util.*;
import java.lang.*;
import java.io.*;

public class Expenditure
{
	//file 
	File expenditureFile = new File("expenditure.txt");
	File categoryFile = new File("category-E.txt");
	protected Time[] time;
	protected double[] amount;
	
	int maxCategory = 100;
	int maxNum;
	int numExpenditure,numCategory;
	Category[] categoryList = new Category[maxCategory];
	
	
	public Expenditure()
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(expenditureFile));
			BufferedReader br2 = new BufferedReader(new FileReader(categoryFile));
			
			numExpenditure = Integer.parseInt(br.readLine());
			maxNum = numExpenditure+100;
			time = new Time[maxNum];
			amount = new double[maxNum];
					
			for(int i = 0;i < numExpenditure; i++)
			{
				time[0] = new Time(br.readLine());
				amount[0] = Double.parseDouble(br.readLine());
			}
			
			numCategory = Integer.parseInt(br2.readLine());
			 
			for(int i = 0;i < numCategory; i++)
			{
				categoryList[i] = new Category(br2.readLine());

			}
			br.close();
			br2.close();
		}
		catch(IOException e)
		{
			System.out.println("expenditure load file error");
			
		}			
						
		
	}
	
	public void saveFile()
	{
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(expenditureFile));
			BufferedWriter bw2 = new BufferedWriter(new FileWriter(categoryFile));
			
			bw.write(numExpenditure+"");
			bw.newLine();
			for(int i = 0;i<numExpenditure;i++)
			{
				bw.write(time[i]+"");
				bw.newLine();
				bw.write(amount[i]+"");
				bw.newLine();
			}
			
			bw2.write(numCategory+"");
			bw2.newLine();
			for(int i = 0;i < numCategory; i++)
			{
				bw2.write(categoryList[i].getName());
				bw2.newLine();

			}
			
			bw.close();
			bw2.close();
		}
		catch(IOException e)
		{
			System.out.println("expenditure save file error");
		}
		
	}
	
	//accessor:
	public boolean setExp(String name,Time time,double amount)
	{
		int n = searchCategory(name);
		if(n == -1)
			return false;
		
		categoryList[n].setAmount(time,amount);
		
		n = searchExp(time);
		if(n == -1)
		{
			this.time[numExpenditure] = time;
			this.amount[numExpenditure] = monthTotal(time);
			numExpenditure++;
			
		}
		else
		{
			this.amount[n] = monthTotal(time);
		}
		
		return true;
	}
	
	public double getMonth(Time time)
	{
		int n = searchExp(time);
		if(n == -1)
			return -1;
		
		return amount[n];
	}
	
	//search:
	public int searchExp(Time time)
	{		
		for(int i = 0;i<numExpenditure;i++)
			if(time == this.time[i])
				return i;
		
		return -1;
	}
	
	public int searchCategory(String name)
	{
		for(int i = 0;i<numCategory;i++)
			if(name.equals(categoryList[i].getName()))
			{
				return i;
			}
		
		return -1;
	}
	//methods:
	public double monthTotal(Time time)
	{
		double total = 0;
		
		for(int i = 0;i<numCategory;i++)
			total+= categoryList[i].amountMonth(time);
			
		return total;
	}
	
	public void printMonth(Time time)
	{
		for(int i = 0;i<numCategory;i++)
			System.out.println(categoryList[i].getName()+": $"+categoryList[i].amountMonth(time));
		
	}
				
	public boolean addCategory(String name)
	{
		if(searchCategory(name) != -1)
		{
			System.out.println("repeat name");
			return false;
		}
		
		if(numCategory++ < maxCategory)
		{
			try
			{
				File f = new File(name+".txt");
				f.createNewFile();
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));				
				bw.write(0+"");
				
				bw.close();
												
			}
			catch(IOException e)
			{
				return false;
			}
			
			categoryList[numCategory-1] = new Category(name);
			return true;
		}
		else
		{
			System.out.println("limited maxCategory:"+maxCategory);
			return false;
		}
		
	}




		
	
	
}