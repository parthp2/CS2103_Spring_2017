package Lab11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Programm3 {
	
	public static void main(String args[]) throws FileNotFoundException
	{
		String[] nr=null;
		List<String> nav=new ArrayList<String>();
		HashMap<String,Integer> res=new HashMap<String,Integer>();
		
		File  file=new File("E:/EclipseNew/CS2013/src/Lab11/demo.text");
		Scanner sc=new Scanner(file);
		
		while(sc.hasNextLine())
		{
			String n=sc.nextLine();
			nr=n.split(" ");
			for(int i=0;i<nr.length;i++)
			{
				nav.add(nr[i]);
			}
			
		}
	
		
		for(int i=0;i<nav.size();i++)
		{
			
				if(res.containsKey(nav.get(i)))
				{
					res.put(nav.get(i),res.get(nav.get(i))+1);
				}
				else
				{
					res.put(nav.get(i),1);
				}
			
			
		}
		
		for(String key:res.keySet())
	       {
	           System.out.println("number of "+key+"'s is "+res.get(key));
	       }
	}
}


