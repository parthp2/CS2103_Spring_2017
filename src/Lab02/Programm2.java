package Lab02;

import java.util.Scanner;

public class Programm2 {

	public static void main(String[] args)
	{
		
		int n;
		
		double result;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter number n:");
		
		n=sc.nextInt();
		
		result= harmonicSum(n);
		
		System.out.println("Result of HarmonicSum is:"+result);
		
		

	}
	
	public static double harmonicSum(int n)
	{
		
		if(n==1)
		{
			return 1;
		}
		else
		{
			return (1.0/n)+(harmonicSum(n-1));
		}
		
	}

}


