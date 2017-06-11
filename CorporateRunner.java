import java.util.*;
import java.lang.*;
import java.io.*;

public class CorporateRunner 
{
	public static void main(String[] args)
	{
		Time currentTime;

		//set current time:
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM");
		Calendar cal = Calendar.getInstance();	
		currentTime = new Time(format.format(cal.getTime()));
		
		Corporate ay = new Corporate();
		Time time = new Time("2017-06");
		
		ay.addExpCategory("office");
		
	}
} // CorporateRunner class