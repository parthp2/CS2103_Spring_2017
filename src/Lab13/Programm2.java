package Lab13;

import java.util.Scanner;

public class Programm2 {

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
		
		    
	        display(list);
	        bubbleSort(list);
	        display(list);

	}
	
	public static <E extends Comparable<E>> void bubbleSort(E[] list){

		 for(int i=1; i< list.length;i++)
		 {
	            for(int j= 0; j< (list.length-1); j++)
	            {
	                if((((Comparable) (list[j])).compareTo(list[j+1])) > 0){
	                    E tmp = list[j];
	                    list[j] = list[j + 1];
	                    list[j + 1] = tmp;
	                }                
	            }
	        }
	    }

	    public static <E> void display(E[] list) 
	    {
	        for(E i : list)
	        {
	            System.out.print(i + " ");
	        }
	        System.out.println();
	    }
	   

}
