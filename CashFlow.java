import java.util.*;
import java.lang.*;
import java.io.*;

public class CashFlow
{
	//file:
	File cashflowFile;
	
	//fields:
	int maxNum;
	int numCashflow;
	Time[] time;
	protected double[] amount;
	Expenditure expenditure;
	Revenue revenue;
	
	
	//Constructor Method
	public CashFlow ()
	{
		
		cashflowFile = new File("cashflow.txt");
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(cashflowFile));
			
			numCashflow = Integer.parseInt(br.readLine());
			maxNum = numCashflow+100;
			time = new Time[maxNum];
			amount = new double[maxNum];
			
			for(int i = 0;i<numCashflow;i++)
			{
				time[i] = new Time(br.readLine());
				amount[i] = Double.parseDouble(br.readLine());
			}
			br.close();
		}
		catch(IOException e)
		{
			System.out.println("Cashflow file error");
		}
		
		
	}
	
	public void saveCashflow()
	{
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter((cashflowFile)));
			
			bw.write(numCashflow+"");
			bw.newLine();
			for(int i = 0;i<numCashflow;i++)
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
			System.out.println("Cashflow save file error");
		}
		
	}
	
	//accessor:
	public double getMonth(Time time)
	{
		int n = searchTime(time);
		
		if(n == -1)
			return 0;
		else
		{
			return amount[n];
		}
	}

		
	//searcher:
	public int searchTime(Time time)
	{
		
		for(int i = 0;i<numCashflow;i++)
		{
			if(this.time[i].equals(time))
				return i;
		}
		
		return -1;
	}
	
	//methods:
	public void updateCashflow(Expenditure exp,Revenue rev)
	{
		int i;
		for(i = 0;i < exp.numExpenditure;i++)
			time[i] = exp.time[i];
		for(int j = 0;i < rev.numRevenue;i++)
			time[i+j] = rev.time[j];
		numCashflow = i;
		
		sortTime();
		
		amount[0] = rev.getMonth(time[0])-exp.getMonth(time[0]);
		for(i = 1;i<numCashflow;i++)
		{
			amount[i] = amount[i-1] + rev.getMonth(time[i])-exp.getMonth(time[i]);
		}
	}
	
	public void sortTime()
	{
		
		Time temp;
		for(int i = numCashflow;i>0;i--)
		{
			for(int j = 0;j<i-1;j++)
			{
				if(time[j].getYear() > time[j+1].getYear())
				{
					temp = time[j];
					time[j] = time[j+1];
					time[j+1] = temp;
				}
				else if(time[j].getYear() == time[j+1].getYear() && (time[j].getMonth() > time[j+1].getMonth()))
				{
					temp = time[j];
					time[j] = time[j+1];
					time[j+1] = temp;
				}
			}
		}
		
			
	}

	
	

}