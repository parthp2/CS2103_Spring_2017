package Lab07;

import java.util.ArrayList;
import java.util.Scanner;



class GenericStack<E> extends ArrayList<E>
{


public void push(E value) {

	add(value);
}


public E pop() {
	
	E ele=get(getSize()-1);
	remove(getSize()-1);
	return ele;

}


public E peek() {
	
	return get(getSize()-1);

}



public boolean isEmpty() {
	
	return super.isEmpty();

}


public int getSize()
{
 
	int size=size();
	
	return size;
}



}
