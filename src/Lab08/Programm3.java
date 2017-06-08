package Lab08;

import java.util.ArrayList;
import java.util.Scanner;

public class Programm3 {

	public static void main(String[] args) {
		
		int item;
		
		Scanner sc=new Scanner(System.in);
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		
		System.out.println("How much element you want to enter in arraylist: ");
		
		int r=sc.nextInt();
		
		System.out.println("Enter 7 integer  Elements in arraylist: ");
		
		for(int i=0;i<r;i++)
		{
			item=sc.nextInt();
			list.add(item);
		}

		sort(list);
		

	}

	public static <E extends Comparable<E>> void sort(ArrayList<E> list)
	{
		E min;
		for(int i=0;i<list.size();i++)
		{
			min=list.get(i);
			for(int j=i+1;j<list.size();j++)
			{
				if(min.compareTo(list.get(j))>0)
				{
					min=list.get(j);
					
					E temp=list.get(i);
					list.set(i, min);
					list.set(j, temp);
				}
				
				
			}
		
		}
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
		
	}
}
