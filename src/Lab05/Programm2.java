package Lab05;

import java.util.Scanner;

public class Programm2 {

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
		
		System.out.println("Enter key element:");
		
		int k=sc.nextInt();
		
		System.out.println("Result of Binary Search tree:");
		
		boolean result= Non_RecursiveBinary(a,k);
		
		System.out.println(result);
	
		
	}
	
	public static boolean Non_RecursiveBinary(int[] a,int k)
	{
		
		for(int i=0;i<a.length-1;i++)
		{
			int min=i;
			for(int j=i+1;j<a.length;j++)
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
		
		
		int low=0;
		int high=a.length-1;
		
		while(high >= low)
		{
			int mid= (low+high)/2;
			
			if(a[mid]==k)
			{
				return true;
			}
			
			else if(a[mid]<k)
			{
				low=mid+1;
			}
			
			else if(a[mid]>k)
			{
				high=mid-1;
			}
		}
		
		return false;
	}

}
