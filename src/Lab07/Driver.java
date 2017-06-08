package Lab07;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		int value;
		
		GenericStack<Integer> item=new GenericStack<Integer>();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the size of element you want use:");

		int s=sc.nextInt();
		
		for(int i=0;i<=s;i++)
		{
			System.out.println("Enter the Element you want to push in stack:");
			value=sc.nextInt();
			item.push(value);
		}
		
		System.out.println("Pop Action perfromed in stack");
	
		System.out.println("Pop Element from stack:"+item.pop());
		
		System.out.println("Peek Action perfromed in stack");
		
		System.out.println("Peek Element from stack:"+item.pop());
		
		System.out.println("Check stack is empty or not");
		
		System.out.println("Peek Element from stack:"+item.isEmpty());
		
		
	}

}
