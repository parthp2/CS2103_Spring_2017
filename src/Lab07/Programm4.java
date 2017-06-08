package Lab07;

import java.util.Scanner;

public class Programm4 {

	public static void main(String[] args) {
		

		Integer[] list=new Integer[5];
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter upto 5 elemnts");
		
		for(int i=0;i<list.length;i++)
		{
			
			list[i]=sc.nextInt();
		}
		
		selectionSort(list);
		
		System.out.println("Reslut of Selection sort");
		
		for(int i=0;i<list.length;i++)
		{
			System.out.println(list[i]);
		}
		
	}
	
	public static<E extends Comparable<E>> void selectionSort(E[] list)
	{
		 for (int i = 0; i < list.length - 1; i++)
		 {
	            int min = i;
	            
	            for (int j = i + 1; j < list.length; j++) 
	            {

	                if (list[j].compareTo(list[min]) < 0) 
	                {
	                    min = j;
	                }
	            }

	            
	            	E temp=list[min];
	            	list[min]=list[i];
	                list[i]=temp;
	            
	        }
		
		
		
	}

}
