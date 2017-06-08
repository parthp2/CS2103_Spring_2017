package Lab08;

import java.util.Scanner;

public class Programm2 {

	public static void main(String[] args) {
		
		int item;
		int r,c;
		
		Scanner sc=new Scanner(System.in);
	
		System.out.println("Enter the row value of 2D array:");
		
		r=sc.nextInt();
		
		System.out.println("Enter the row value of 2D array:");
		
		c=sc.nextInt();
		
		Integer[][] a1=new Integer[r][c];
		
		
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				
				a1[i][j]=sc.nextInt();
				
			}
		}
		
		
		
		int result=max(a1);
		
		System.out.println("The maximum number of 2D array is:"+result);
		
		
		

	}
	
	public static <E extends Comparable<E>> E max(E[][] list)
	{
		E result=list[0][0];
		
		for(int i=0;i<list.length;i++)
		{
			for(int j=0;j<list[0].length;j++)
			{
				
				if(list[i][j].compareTo(result)>0)
				{
					result=list[i][j];
				}
			}
		}
		
		return result;
	}

}
