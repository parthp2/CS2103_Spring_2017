package Lab05;

import java.util.Scanner;

public class Programm1 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the length of array:");
		
		int n=sc.nextInt();
		
		System.out.println("Enter element of array");
		
		int[] a=new int[n];
		
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		System.out.println("Result of Selection sort:");
	
		int[] b= Non_RecursiveSort(a);
		
		for(int i=0;i<b.length;i++)
		{
			System.out.println(b[i]);
		}
		
	}
	
	public static int[] Non_RecursiveSort( int[] a)
	{
		
		int n=a.length;
		for(int i=0;i<n-1;i++)
		{
			int min= i;
			
			for(int j=i+1;j<n;j++)
			{
				if(a[j]<a[min])
				{
					min=j;
				}
			}
			
			int temp=a[min];
			a[min]=a[i];
			a[i]=temp;
			
		}
	
		
		return a;
		
	}
	
	

}
