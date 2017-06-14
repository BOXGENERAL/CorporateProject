import java.util.*;
import java.lang.*;
import java.io.*;

public class Time
{
	java.text.SimpleDateFormat format;
	private String time;
	private int year;
	private int month;
	
	public Time(String time)
	{
		
		this.time = time;
		
		year = Integer.parseInt(time.substring(0,4));
		month = Integer.parseInt(time.substring(5));
		
	}
	
	public Time(int year,int month)
	{
		this.year = year;
		this.month = month;
		
		if(month<10)
			time = year+"-0"+month;
		else
			time = year+"-"+month;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public void addMonth()
	{
		month++;
		if(month>12)
		{
			month = 1;
			year++;
		}
		if(month<10)
			time = year+"-0"+month;
		else
			time = year+"-"+month;
		
	}
	
	public Time copy()
	{
		Time t = new Time(year,month);
		return t;
	}
	
	public boolean equals(Time other)
	{
		if(month == other.month && year == other.year)
			return true;
		else
			return false;
	}
	
	public int compare(Time other)
	{
		return year*12+month - (other.year*12+other.month);
	}
	public String toString()
	{
		return time;
	}
		

}
