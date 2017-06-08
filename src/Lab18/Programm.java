package Lab18;

import java.util.NoSuchElementException;

import Lab17.MyLinkedList.Node;

	
	public class Programm<E> {
		 
	    private Node H;
	    private Node T;
	    private int size;
	     
	    public Programm () 
	    {
	        size = 0;
	    }
	   
	    
	    private class Node<E>
	    {
	        E element;
	        Node<E> next;
	        Node<E> prev;
	 
	        public Node(E e, Node next, Node prev)
	        {
	            this.element = e;
	            this.next = next;
	            this.prev = prev;
	        }
	    }
	   
	    public int size()
	    { 
	    	return size;
	    }
	    
	    
	    public boolean isEmpty() 
	    { 
	    	return size == 0; 
	    }
	     
	    
	    public void addFirst(E element) 
	    {
	        Node tmp = new Node(element, H, null);
	        if(H != null )
	        {
	        	H.prev = tmp;
	        }
	        
	        H = tmp;
	        
	        if(T == null) 
	        { 
	        	T = tmp;
	        }
	        size++;
	        System.out.println("adding: "+element);
	    }
	     
	   
	    public void addLast(E element) {
	         
	        Node tmp = new Node(element, null, T);
	        if(T != null)
	        {
	        	T.next = tmp;
	        }
	        
	        T = tmp;
	        if(H == null) 
	        { 
	        	H = tmp;
	        }
	        size++;
	        System.out.println("adding: "+element);
	    }
	     
	   
	    public void traverseForward(){
	         
	        System.out.println("traversing  forward..");
	        Node tmp = H;
	        while(tmp != null)
	        {
	            System.out.println(tmp.element);
	            tmp = tmp.next;
	        }
	    }
	     
	    
	    public void traverseBackward(){
	         
	        System.out.println("traversing backword..");
	        Node tmp = T;
	        while(tmp != null)
	        {
	            System.out.println(tmp.element);
	            tmp = tmp.prev;
	        }
	    }
	     
	   
	    public E removeFirst() {
	        if (size == 0) throw new NoSuchElementException();
	        Node tmp = H;
	        H = H.next;
	        H.prev = null;
	        size--;
	        System.out.println("deleted: "+tmp.element);
	        return (E) tmp.element;
	    }
	     
	   
	    public E removeLast() {
	        if (size == 0) throw new NoSuchElementException();
	        Node tmp = T;
	        T = T.prev;
	        T.next = null;
	        size--;
	        System.out.println("deleted: "+tmp.element);
	        return (E) tmp.element;
	    }
	    
	    private void checkIndex(int I)
		  {
		    if (I < 0 || I >= size)
		    {
		      throw new IndexOutOfBoundsException("Index: " + I + ", Size: " + size);
		    }
		  }
	    
	    public void set(int I, E e)
		  {
		    checkIndex(I);

		    Node<E> crnt = H;
		    E oValue = null;
		    for (int i = 0; i < size; i++) 
		    {
		      if (i == I)
		      {
		        oValue = crnt.element;
		        crnt.element = e;
		        break;
		      }
		      crnt = crnt.next;
		    }
		    
		  }

	    
	  

	    public static void main(String[] args) 
		{
			Programm<Integer> dll = new Programm<Integer>();
	        dll.addFirst(10);
	        dll.addFirst(34);
	        dll.addLast(56);
	        dll.addLast(364);
	        dll.traverseForward();
	        dll.set(2, 91);
	        dll.traverseForward();
	        dll.removeFirst();
	        dll.removeLast();
	        dll.traverseBackward();
			

		}

	
  }
	
	


