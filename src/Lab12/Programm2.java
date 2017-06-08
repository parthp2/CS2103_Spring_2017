package Lab12;

import java.util.LinkedList;
import java.util.Scanner;

public class Programm2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String s = sc.nextLine(); 

		LinkedList<Character> l1= new LinkedList<>();

		for (int i = 0; i < s.length(); i++) 
		{ 
			LinkedList<Character> l2= new LinkedList<>();
			l2.add(s.charAt(i));
			for (int j = i + 1; j < s.length(); j++) 
			{
				if (s.charAt(j) > l2.getLast()) 
				{
					l2.add(s.charAt(j)); 
				}
			}

			if (l2.size() > l1.size()) 
			{
				l1.clear();
				l1.addAll(l2);
			}
			l2.clear();
		}

		System.out.print("Result:");
		for (Character ch: l1)
		{
			System.out.print(ch); 
		}
		System.out.println();
	}

}
