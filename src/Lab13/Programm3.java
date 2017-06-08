package Lab13;

import java.util.Scanner;

public class Programm3 {

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
		
		mergeSort(list);
		
		for(int i=0;i<list.length;i++)
		{
			System.out.print(list[i]+" ");
		}
		

	}
	
	public static <E extends Comparable<E>> void mergeSort(E[] list)
	{
	
		if (list.length > 1) {
			
			E[] left = (E[]) new Comparable[list.length / 2];
			System.arraycopy(list, 0 , left, 0, list.length / 2);
			mergeSort(left);

			
			int rightlength = list.length - list.length / 2;
			E[] right= (E[])(new Comparable[rightlength]);
			System.arraycopy(list, list.length / 2, right, 0, rightlength);
			mergeSort(right);

			// Merge firstHalf with secondHalf into list
			merge(left,right,list);
		}
	}
	
	public static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] temp) {
		int a = 0; 
		int b= 0; 
		int c= 0;

		while (a < list1.length && b < list2.length) {
			if (list1[a].compareTo(list2[c]) < 0)
				temp[c++] = list1[a++];
			else
				temp[c++] = list2[b++];
		}

		while (a < list1.length) 
			temp[c++] = list1[a++];
		
		while (b < list2.length)
			temp[c++] = list2[b++];
	}

}
