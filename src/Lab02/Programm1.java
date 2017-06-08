package Lab02;

import java.util.Scanner;

public class Programm1 {

	public static void main(String[] args)
	{

		double x;
		int n;
		
		System.out.print("Enter base X:");
		
		Scanner sc=new Scanner(System.in);
		
		x=sc.nextDouble();
		
		System.out.print("Enter Power Y:");
		
		n=sc.nextInt();
		
		
		
		System.out.println("The result of "+x+"^"+n+" is "+powerN(x,n));
		
		
		
		
	}
	
	public static double powerN(double x, int n)
	{
		if(n==0)
		{
			return 1;
		}
		else 
			return powerN(x,n-1)*x;
	}

}


