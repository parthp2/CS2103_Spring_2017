package Lab03;

import java.util.Scanner;

public class Programm2 {

	public static void main(String[] args) 
	{
		String s;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter String s:");
		
		s=sc.nextLine();
		
		System.out.println("Result of reverse string:");
		reverseDisplay(s);
	}
	
	public static void reverseDisplay(String s)
	{
		if(s.length()<=1)
		{
			System.out.println(s);
		}
		else
		{
			System.out.print(s.charAt(s.length()-1));
			reverseDisplay(s.substring(0, s.length()-1));
		}
		

	}

}
