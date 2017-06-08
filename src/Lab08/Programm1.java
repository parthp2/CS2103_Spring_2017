package Lab08;

import java.util.ArrayList;
import java.util.Scanner;

public class Programm1 {

	public static void main(String[] args) {
		
		int item;
		String item2;
		
		Scanner sc=new Scanner(System.in);

		ArrayList<Integer> list=new ArrayList<Integer>();
		
		ArrayList<String> list2=new ArrayList<String>();
		
		System.out.println("Enter 7 integer  Elements in arraylist: ");
		
		for(int i=0;i<=7;i++)
		{
			item=sc.nextInt();
			list.add(item);
		}
		
		removeDuplicates(list);
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i));
		}
		
        System.out.println("Enter 7 String  Elements in arraylist: ");
		
		for(int i=0;i<=7;i++)
		{
			item2=sc.nextLine();
			list2.add(item2);
		}
		
       removeDuplicates(list2);
		
		for(int i=0;i<list2.size();i++)
		{
			System.out.println(list2.get(i));
		}
 		
	}

	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
	{
		
		for(int i=0;i<list.size();i++)
		{
			for(int j=i+1;j<list.size();j++)
			{
				if(list.get(i)==list.get(j) || list.get(i).equals(list.get(j))==true)
				{
					list.remove(j);
				}
			}
		}
		
		return list;
	}
}
