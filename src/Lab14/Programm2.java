package Lab14;

import java.util.Comparator;
import java.util.Scanner;

public class Programm2 {

	public static <E extends Comparable<E>> void quickSort(E[] list) {
		quickSort(list, 0, list.length - 1);
	}

	public static <E extends Comparable<E>> 
			void quickSort(E[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}

	/** Partition the array list[first..last] */
	public static <E extends Comparable<E>> 
			int partition(E[] list, int first, int last) {
		E pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; // Index for backward search

		while (high > low) {
			// Search forward from left
			while (low <= high && list[low].compareTo(pivot) <= 0)
				low++;

			// Search backward from right
			while (low <= high && list[high].compareTo(pivot) > 0)
				high--;

			// Swap two elements in the list
			if (high > low) {
				E temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}

		while (high > first && list[high].compareTo(pivot) >= 0)
			high--;

		// Swap pivot with list[high]
		if (pivot.compareTo(list[high]) > 0) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else {
			return first;
		}
	}

	
	
	public static void main(String[] args) {
		

         Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter length of array:");
		
		Integer len=sc.nextInt();
		
		Integer[] list=new Integer[len];
		
		System.out.println("Enter Elements:");
		
		for(int i=0;i<len;i++)
		{
			list[i]=sc.nextInt();
		}
		
		quickSort(list);
		
		for(int i=0;i<list.length;i++)
		{
			System.out.print(list[i]+" ");
		}
	
		
	}
	

}
