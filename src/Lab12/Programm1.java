package Lab12;

import java.util.Scanner;

public class Programm1 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter the Integer string end with 0: ");
		
		int longSequenceCount=0;
		
		int longSequenceValue=0;
		
		int longSequenceIndex=0;
		
		int CurrentSequenceCount=1;
		
		int CurrentSequenceValue=0;
		
		int value;
		
		int previous=0;
		
		int index=0;
		
		do
		{
			value=sc.nextInt();
			
			if(value==previous)
			{
				CurrentSequenceCount++;
			}
			else if(CurrentSequenceCount >= longSequenceCount)
			{
				longSequenceCount=CurrentSequenceCount;
				
				longSequenceValue=CurrentSequenceValue;
				
				longSequenceIndex=index-CurrentSequenceCount;
				
				
				
				CurrentSequenceCount=1;
				
				CurrentSequenceValue=value;
				
			}
			
			index++;
			
			previous=value;
			
		}while(value!=0);
		
		System.out.println("The longest same number sequence starts at index " + longSequenceIndex + " with " + longSequenceCount + " values of " + longSequenceValue);

	}

}
