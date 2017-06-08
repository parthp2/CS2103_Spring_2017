package Lab17;

public class Driver {
	 
	  public static void main(String[] args) {
	    
	    MyLinkedList<String> list = new MyLinkedList<String>();

	    
	    list.add("Parth"); 
	    
	    System.out.println("(1)After Adding Parth in to the list:");
	    
	    for(int i=0;i<list.size();i++)
	    {
	    	System.out.println("   "+list.get(i));
	    }

	    list.add(0, "Chintan"); 
	   
        System.out.println("(2)After Adding chintan to the beginning of the list:");
	    
	    for(int i=0;i<list.size();i++)
	    {
	    	System.out.println("   "+list.get(i));
	    }

	    list.add("Acharya"); 
	    
        System.out.println("(3)After Adding Acharya to the end of the list:");
	    
	    for(int i=0;i<list.size();i++)
	    {
	    	System.out.println("   "+list.get(i));
	    }

	    list.addLast("Delhi"); 
	    
        System.out.println("(4)After Adding Delhi to the end of the list:");
	    
	    for(int i=0;i<list.size();i++)
	    {
	    	System.out.println("   "+list.get(i));
	    }

	    list.add(2, "Kishan"); 
	    
        System.out.println("(5)After Adding Kishan to the list at index 2:");
	    
	    for(int i=0;i<list.size();i++)
	    {
	    	System.out.println("   "+list.get(i));
	    }

	    list.add(5, "Shantanu");

        System.out.println("(6)After Adding Shantanu to the list at index 5:");
	    
	    for(int i=0;i<list.size();i++)
	    {
	    	System.out.println("   "+list.get(i));
	    }

	    list.add(0, "Poland"); 
	    
        System.out.println("(7)After Adding Shivam to the beginning of the list:");
	    
	    for(int i=0;i<list.size();i++)
	    {
	    	System.out.println("   "+list.get(i));
	    }

	   
	    list.remove(0); 
	    
        System.out.println("(8)Remove elements from the list:");
	    
	    for(int i=0;i<list.size();i++)
	    {
	    	System.out.println("   "+list.get(i));
	    }

	    list.remove(2); 
	   
        System.out.println("(9)Remove the element at index 2:");
	    
	    for(int i=0;i<list.size();i++)
	    {
	    	System.out.println("   "+list.get(i));
	    }

	    list.remove(list.size() - 1); 
	    
	    System.out.println("(10)Remove the last element:");
	    
	    for(int i=0;i<list.size();i++)
	    {
	    	System.out.println("   "+list.get(i));
	    }
	    
	    System.out.println("(11)check list contain name Chinatn or not:");
	    
	    System.out.println("   "+list.contains("Chintan"));
	    
	    System.out.println("(---Printing the list--------------");

	    for(int i=0;i<list.size();i++)
	    {
	    	System.out.print(list.get(i)+"  ");
	    }

	    list.clear();
	    
	    System.out.println("\nAfter clearing the list, the list size is " + list.size());
	  }
	}