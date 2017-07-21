/*
 * @author Sonakshi Grover 2014106 and divam gupta 2014038
 * */


package data_manager;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;



public class DataManager {
	
	 static String datFileFolder = "src/dbData/registration_dat_files/";
	
	  public static Integer getNoOfEntries()
	  {
		  try{
			  BufferedReader r = null;
			  r =new BufferedReader(new InputStreamReader(new FileInputStream(datFileFolder + "nEntries")));
			  String line = r.readLine();
			  r.close();
			  return Integer.parseInt(line);
		  }catch(Exception ex){
			  ex.printStackTrace();
		  }
		  
		  return -1;
	  }
	  
	  
	  public static void  setNoOfEntries(Integer a)
	  {
		  try{
			  FileWriter out = null;
			  out = new FileWriter(   datFileFolder + "nEntries"  );
			  out.write(a.toString());
			  out.close();
			 
			  
		  }catch(Exception ex){
			  ex.printStackTrace();
		  }
		  
		  
	  }
	
	   public static void writeToFile(Registration r){
		   		   
		   try{
			   
			FileOutputStream fout = new FileOutputStream(datFileFolder  + getNoOfEntries().toString() +".dat");
			ObjectOutputStream oos = new ObjectOutputStream(fout);   
			oos.writeObject(r);
			oos.close();
			
			setNoOfEntries( getNoOfEntries() + 1);
			
			System.out.println("Done");
			   
		   }catch(Exception ex){
			   ex.printStackTrace();
		   }
	   }
	   
	   public static Registration readFromFile(Integer i)
	   {
		   Registration r;
		   try{
			    
			   FileInputStream fin = new FileInputStream(datFileFolder + i.toString() +".dat");
			   ObjectInputStream ois = new ObjectInputStream(fin);
			   r = (Registration) ois.readObject();
			   ois.close();
			  
			   return r;
			   
		   }catch(Exception ex){
			   ex.printStackTrace();
			   return null;
		   } 
		   
	   }
	   
	   public static  ArrayList<Registration> getAllRegistrations()
		{
		
		     Integer num= getNoOfEntries();
			 int i=0;
			 ArrayList<Registration> arr=new ArrayList<Registration>();
			 while(i<num)
			 {
				 arr.add(readFromFile(i));
				 i++;
			 }
			return arr;
		}
}
