  /*
Class name: Revenue
Author: Donggi, Jonathan
Date: June 5, 2017
School: AYJackson
Purpose: Manages the Revenue
*/


   import java.util.*;
   import java.lang.*;
   import java.io.*;

    public class Revenue
   {
   //file 
    	protected File revenueFile = new File("revenue.txt");
    	protected File categoryFile = new File("category-R.txt");
      protected Time[] time;
      protected double[] amount;
   
      protected int maxCategory = 100;
      protected int maxNum;
      protected int numRevenue,numCategory;
      protected Category[] categoryList = new Category[maxCategory];
   
   	//Constructor
       public Revenue()
      {
         try
         {
            BufferedReader br = new BufferedReader(new FileReader(revenueFile));
            BufferedReader br2 = new BufferedReader(new FileReader(categoryFile));
         
            numRevenue = Integer.parseInt(br.readLine());
            maxNum = numRevenue+1000;
            time = new Time[maxNum];
            amount = new double[maxNum];
         		
            for(int i = 0;i < numRevenue; i++)
            {
               time[i] = new Time(br.readLine());
               amount[i] = Double.parseDouble(br.readLine());
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
               System.out.println("revenue load file error");
            
            }			
      				
      
      }
   //Decription: recieves no parameters and returns no value
	//Purpose: Saves the Revenue file
       public void saveFile()
      {
         try
         {
            BufferedWriter bw = new BufferedWriter(new FileWriter(revenueFile));
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(categoryFile));
         
            bw.write(numRevenue+"");
            bw.newLine();
            for(int i = 0;i<numRevenue;i++)
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
               System.out.println("revenue save file error");
            }
      
         for(int i = 0;i < numCategory; i++)
         {
            categoryList[i].saveCategory();
         }
      }
   
   //accessor:
	//Decription: recieves string, Time object, and amount and returns boolean
	//Purpose: Sets up the Revenue
       public boolean setRev(String name,Time time,double amount)
      {
         int n = searchCategory(name);
         if(n == -1)
            return false;
      
         categoryList[n].setAmount(time,amount);
      
         n = searchRev(time);
         if(n == -1)
         {
            this.time[numRevenue] = time;
            this.amount[numRevenue] = monthTotal(time);
            numRevenue++;
         
         }
         else
         {
            this.amount[n] = monthTotal(time);
         }
      
         return true;
      }
   //Decription: recieves Time Object and returns double
	//Purpose: gets the Month from Expenditure
       public double getMonth(Time time)
      {
         int n = searchRev(time);
         if(n == -1)
            return 0;
      
         return amount[n];
      }
   
   //search:
	//Decription: recieves Time Object and returns int
	//Purpose: Searches for the specific expenditure within time object
       public int searchRev(Time time)
      {		
         for(int i = 0;i<numRevenue;i++)
            if(time.equals(this.time[i]))
               return i;
      	
         return -1;
      }
    //Decription: recieves not parameters and returns year
	//Purpose: searches for a specific Category
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
   //Decription: recieves time object and returns double
	//Purpose: calculate the toal months in Category
       public double monthTotal(Time time)
      {
         double total = 0;
      
         for(int i = 0;i<numCategory;i++)
            total+= categoryList[i].amountMonth(time);
      	
         return total;
      }
   //Decription: recieves time object and returns no value
	//Purpose:Outputs the Revenue within the Month
       public void printMonth(Time time)
      {
         for(int i = 0;i<numCategory;i++)
            System.out.println(categoryList[i].getName()+": $"+categoryList[i].amountMonth(time));
      
      }
   
   	//Decription: recieves String and returns boolean
	//Purpose: adds a new Category to the Class		
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
   	//Decription: recieves no parameter and returns no value
	//Purpose: Updates Revenue
		 public void update()
      {
         for(int i = 0;i<numRevenue;i++)
         {
            amount[i] = monthTotal(time[i]);
         }
      }
		 //Decription: recieves no parameter and returns no value
	//Purpose: Sorts time within the Category and Revenue
       public void sortTime()
      {
         for(int i = 0;i<numCategory;i++)
            categoryList[i].sortTime();
      
         Time temp;
         Double temp2;
         for(int i = numRevenue;i>0;i--)
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
   
   
   }
