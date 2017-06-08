package Lab03;

import java.util.Scanner;

public class Programm1 {

	public static void main(String[] args)
	{
        
		int m;
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter m:");
		
		m=sc.nextInt();
		
		reverseDisplay(m);
		
		

	}
	
	public static void reverseDisplay(int n)
	{

		if(n<10)
		{
			System.out.print(n);
		}
		else
		{
			System.out.print(n%10);
			reverseDisplay(n/10);
		}
			
	
	}

}
