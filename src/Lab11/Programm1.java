package Lab11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Programm1 {
	
	public static void main(String args[]) throws FileNotFoundException
	{
	
		TreeSet<String> nwords=new TreeSet<String>();
		List<String> n=new ArrayList<String>();
		File  file=new File("E:/EclipseNew/CS2013/src/Lab11/demo.text");
		Scanner sc=new Scanner(file);
		
		while(sc.hasNextLine())
		{
			String words=sc.nextLine();
			String[] nw=words.split(" ");
			for(int i=0;i<nw.length;i++)
			{
				n.add(nw[i]);
			}
			
		}
		
		for(int i=0;i<n.size();i++)
		{
			nwords.add(n.get(i));
			
		}
		
		for(String e:nwords)
		{
			System.out.println(e);
		}
		
		
	}

}
