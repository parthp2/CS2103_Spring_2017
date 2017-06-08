package Lab14;

import java.util.Scanner;

public class Programm1 {
	
	public static <E extends Comparable<E>> void heapSort(E[] list){

		Heap<E> heap = new Heap<>();

	    for (int i = 0; i < list.length; i++)

	    heap.add(list[i]);

	     for (int i = list.length - 1; i >= 0; i--)

	    list[i] = heap.remove();

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
			
			 heapSort(list);		
			
			for(int i=0;i<list.length;i++)
			{
				System.out.print(list[i]+" ");
			}
		
			

		 }

}
