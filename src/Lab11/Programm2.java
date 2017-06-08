package Lab11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Programm2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		String n="";
		HashMap<Character,Integer> res=new HashMap<Character,Integer>();
		
		File  file=new File("E:/EclipseNew/CS2013/src/Lab11/demo.text");
		Scanner sc=new Scanner(file);
		
		while(sc.hasNextLine())
		{
			n+=sc.nextLine();
		}
		
		
		String s=n.toUpperCase();
		
		char[] carray=s.toCharArray();
		
		for(int i=0;i<carray.length;i++)
		{
			if(carray[i]=='A' || carray[i]=='E' || carray[i]=='I' || carray[i]=='O' || carray[i]=='U' )
			{
				if(res.containsKey(carray[i]))
				{
					res.put(carray[i],res.get(carray[i])+1);
				}
				else
				{
					res.put(carray[i],1);
				}
			}
			
		}
		
		for(Character key:res.keySet())
	       {
	           System.out.println("number of "+key+"'s is "+res.get(key));
	       }
	}

}

/*if(carray[i]=='a' || carray[i]=='e' || carray[i]=='i' || carray[i]=='o' || carray[i]=='u' )
{
		res.put(carray[i],res.get(carray[i])+1);
}
*/
