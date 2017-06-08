package Lab10;

import java.util.Scanner;

public class Programm1 {

	public static void main(String[] args)
	
	{
		
		Queuemain que=new Queuemain();
		
		int ch;
		Scanner sc=new Scanner(System.in);
		Scanner so=new Scanner(System.in);


		System.out.println("##MENU##");
        System.out.println("1.Insert element in queue");
        System.out.println("2.Display queue");
        System.out.println("3.Exit");
		
		do
        {
            
            System.out.print("Enter your choice:");
            
            ch=sc.nextInt();
           
            switch(ch)
            {
                case 1:System.out.print("Enter element to be inserted:");
                	  String el=so.nextLine();
                      que.add(el);
                      break;
                case 2:System.out.println("Queue elements:");
                     que.display();
                       break;

                case 3:
                    break;
            }
        }while(ch!=3);
		

	}
	
	

}

class node
{
    String data;
    node next;
    public node(String x)
    {
        data=x;
        next=null;
    }
}

class Queuemain
{
    node f=null;
    node l=null;
    
    public boolean isEmpty()
    {
        if (f==null || l==null)
            return true;
        else
            return false;
    }
    public void add(String x)
    {
        if (isEmpty()==true)
        {
            node p=new node (x);
            f=l=p;
        }
        else
        {
            node p=new node (x);
            l.next=p;
            l=p;
        }
    }
   
    public void display()
    {
        if(isEmpty()==true)
        {
            System.out.println("Queue is Empty");
        }
        else
        {
            node temp=f;
            while (temp!=null)
            {
                System.out.print(temp.data+" ");
                System.out.println();
                temp=temp.next;
            }
        }
    }
}
