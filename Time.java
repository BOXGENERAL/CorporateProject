/*
Class name: Time
Author: Jonathan
Date: June 5, 2017
School: AYJackson
Purpose: Manages Time within the Corporate Project
*/


import java.util.*;
import java.lang.*;
import java.io.*;

public class Time
{
	java.text.SimpleDateFormat format;
	private String time;
	private int year;
	private int month;
	//Constructor 1
	public Time(String time)
	{
		
		this.time = time;
		
		year = Integer.parseInt(time.substring(0,4));
		month = Integer.parseInt(time.substring(5));
		
	}
	//Constructor 2
	public Time(int year,int month)
	{
		this.year = year;
		this.month = month;
		
		if(month<10)
			time = year+"-0"+month;
		else
			time = year+"-"+month;
	}
	//Decription: recieves not parameters and returns year
	//Purpose: Returns year
	public int getYear()
	{
		return year;
	}
	//Decription: recieves not parameters and returns year
	//Purpose: Returns month
	public int getMonth()
	{
		return month;
	}
	//Decription: recieves another object time and returns boolean
	//Purpose: returns true if the 2 time year and month are same
	public boolean equals(Time other)
	{
		if(month == other.month && year == other.year)
			return true;
		else
			return false;
	}
	//Description:Recieves time as an object and returns int
	//Purpose: compares time with other time object
	public int compare(Time other)
	{
		return year*12+month - (other.year*12+other.month);
	}
	//Decription: recieves no parameters  and and returns string
	//Purpose: returns string within time
	public String toString()
	{
		return time;
	}
		

}
