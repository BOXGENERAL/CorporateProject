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
	
	public int getYear()
	{
		return year;
	}
	
	public int getMonth()
	{
		return month;
	}
	
		

}