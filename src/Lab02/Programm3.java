package Lab02;

import java.util.Scanner;

public class Programm3 {
	
	public static void main(String[] args)
	{
	
		int m,n;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter m:");
		
		m=sc.nextInt();
		
		System.out.print("Enter n:");
		
		n=sc.nextInt();
		
		System.out.println("Result of GCD("+m+","+n+")  of is "+gcd(m,n));
		
		
	}
	
	public static int gcd(int m, int n)
	{
		if(m%n==0)
		{
			return n;
		}
		else
		{
			return gcd(n,m%n);
		}
	}

}
