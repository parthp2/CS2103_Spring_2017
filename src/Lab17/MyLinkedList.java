package Lab17;

public class MyLinkedList<E> extends MyAbstractList<E> {
	
	private Node<E> H, T;
	
	public static class Node<E>
	  {
	    E element;
	    Node<E> next;

	    public Node(E element)
	    {
	      this.element = element;
	    }
	  }

	
	  public MyLinkedList() 
	  {
		  
	  }

	 
	  public MyLinkedList(E[] e) 
	  {
	    super(e);
	  }


	  
	  @Override public java.util.Iterator<E> iterator()
	  {
	    return new LinkedListIterator();
	  }

	  private void checkIndex(int I)
	  {
	    if (I < 0 || I >= size)
	    {
	      throw new IndexOutOfBoundsException("Index: " + I + ", Size: " + size);
	    }
	  }
	  
	  private class LinkedListIterator implements java.util.Iterator<E> 
	  {
	    private Node<E> crnt = H; 
	    
	    @Override public boolean hasNext() 
	    {
	      return (crnt != null);
	    }

	    @Override
	    public E next()
	    {
	      E e = crnt.element;
	      crnt = crnt.next;
	      return e;
	    }

	    @Override
	    public void remove()
	    {

	      System.out.println("Implementation left as an exercise");
	    }
	  }
	  
	  
	  public void addFirst(E e)
	  {
	    Node<E> temp = new Node<E>(e); 
	    temp.next = H; 
	    H = temp; 
	    size++; 

	    if (T == null) 
	      T = H;
	  }

	 
	  public void addLast(E e) 
	  {
	    Node<E> temp = new Node<E>(e); 

	    if (T == null) 
	    {
	      H = T = temp; 
	    }
	    else
	    {
	      T.next = temp; 
	      T = T.next;
	    }

	    size++; 
	  }


	  @Override 
	  public void add(int I, E e) 
	  {
	    if (I == 0) 
	    {
	      addFirst(e);
	    }
	    else if (I >= size)
	    {
	      addLast(e);
	    }
	    else
	    {
	      Node<E> crnt = H;
	      for (int i = 1; i < I; i++)
	      {
	        crnt = crnt.next;
	      }
	      Node<E> temp = crnt.next;
	      crnt.next = new Node<E>(e);
	      (crnt.next).next = temp;
	      size++;
	    }
	  }
	  
	  @Override 
	  public void clear()
	  {
	    size = 0;
	    H = T = null;
	  }

	  
	  @Override 
	  public boolean contains(E e) 
	  {
	    Node<E> crnt = H;
	    for (int i = 0; i < size; i++) 
	    {
	      if (crnt.element.equals(e))
	        return true;
	      crnt = crnt.next;
	    }

	    return false;
	  }
	  
	  @Override 
	  public E get(int I) 
	  {
	    checkIndex(I);
	    Node<E> crnt = H;

	    for (int i = 0; i < size; i++) 
	    {
	      if (i == I)
	        return crnt.element;
	      crnt = crnt.next;
	    }

	    return null;
	  }
	  
	  
	  @Override 
	  public int indexOf(E e) 
	  {
	    Node<E> crnt = H;
	    for (int i = 0; i < size; i++) 
	    {
	      if (crnt.element.equals(e))
	      {
	        return i;
	      }
	      crnt = crnt.next;
	    }
	    return -1;
	  }
	  

	  
	  public E removeFirst() {
	    if (size == 0)
	    {
	      return null;
	    }
	    else 
	    {
	      Node<E> temp = H;
	      H = H.next;
	      size--;
	      
	      if (H == null)
	      {
	        T = null;
	      }
	      return temp.element;
	    }
	  }

	  
	  public E removeLast()
	  {
	    if (size == 0) 
	    {
	      return null;
	    }
	    else if (size == 1)
	    {
	      Node<E> temp = H;
	      H = T = null;
	      size = 0;
	      return temp.element;
	    }
	    else 
	    {
	      Node<E> crnt = H;

	      for (int i = 0; i < size - 2; i++) 
	      {
	        crnt = crnt.next;
	      }

	      Node<E> temp = T;
	      T = crnt;
	      T.next = null;
	      size--;
	      return temp.element;
	    }
	  }

	  @Override 
	  public E remove(int I) 
	  {   
	    if (I < 0 || I >= size)
	    {
	      return null;
	    }
	    else if (I == 0) 
	    {
	      return removeFirst();
	    }
	    else if (I == size - 1)
	    {
	      return removeLast();
	    }
	    else 
	    {
	      Node<E> prv = H;

	      for (int i = 1; i < I; i++)
	      {
	        prv = prv.next;
	      }

	      Node<E> crnt = prv.next;
	      prv.next = crnt.next;
	      size--;
	      return crnt.element;
	    }
	  }

	 

	  @Override 
	  public E set(int I, E e)
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
	    return oValue;
	  }

	  
	  
	  
}
