package Lab13;

import java.util.Scanner;

public class Programm1 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter length of array:");
		
		int len=sc.nextInt();
		
		Integer[] list=new Integer[len];
		
		System.out.println("Enter Elements:");
		
		for(int i=0;i<len;i++)
		{
			list[i]=sc.nextInt();
		}
		
		insertionSort(list);
		
		for(int i=0;i<list.length;i++)
		{
			System.out.print(list[i]+" ");
		}

	}
	
	public static <E extends Comparable<E>> void insertionSort(E[] list){
		
		 if (list != null)
	      {
	         insertionSort(list, list.length);
	      }

	}
	
	public static <E extends Comparable<E>> void insertionSort (E[] list, int n)
	   {
	      E temp;
	      int p;

	      if (n>list.length || n<=0)
	      {
	         n=list.length;
	      }

	      for (int i = 1; i < n; i++)
	      {
	         temp = list[i];
	         p = i;

	         // shift larger values to the right
	         while (p > 0 && list[p-1].compareTo(temp) > 0)
	         {
	            list[p] = list[p-1];
	            p--;
	         }
	            
	         list[p] = temp;
	      }
	   }

}
