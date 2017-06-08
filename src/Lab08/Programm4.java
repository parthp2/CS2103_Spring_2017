package Lab08;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Programm4 {

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

	
		suffle(list);

	}
	
	public static <E > void suffle(ArrayList<E> list)
	{
		Random num=new Random();
		
		for(int i=0;i<list.size();i++)
		{
			int n=num.nextInt(list.size()-i)+i;
			
			E temp=list.get(i);
			list.set(i, list.get(n));
			list.set(n, temp);
		}
		
		
		System.out.println("Result after suffle:");
		
		for(int j=0;j<list.size();j++)
		{
			System.out.println(list.get(j));
		}
		
		
	}

}
