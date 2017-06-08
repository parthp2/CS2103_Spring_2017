package Lab03;

import java.util.Scanner;

public class Programm3 {
	
	public static void main(String[] args) 
	{
		
        String s;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter String s:");
		
         s=sc.nextLine();
		
		System.out.println("Result of permutation string:");
		
		permutation("",s);
		
	}
	
	
	public static void permutation(String p,String s)
	{
		int n=s.length();
		
		if(s.isEmpty())
		{
			System.out.println(p+s);
		}
		else
		{
			for(int i=0;i<s.length();i++)
			{
				permutation(p+s.charAt(i),s.substring(0, i)+s.substring(i+1,n));
			}
		}
	}

}
