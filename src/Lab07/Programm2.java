package Lab07;

public class Programm2 {

	public static void main(String[] args) {
	
		Integer[] list=new Integer[20];
		
		String[] list2={"a","b","c"};
		
		for(int i=0;i<list.length;i++)
		{
			list[i]=i;
		}
		
		System.out.println(linearSearch(list,5));
		
		System.out.println(linearSearch(list2,"a"));
		
		System.out.println(linearSearch(list2,"c"));
		
		System.out.println(linearSearch(list2,"d"));
		
		System.out.println(linearSearch(list,15));
		
		System.out.println(linearSearch(list,21));
		
		
	}

	public static <E extends Comparable<E>> int linearSearch(E[] list, E key)
	{
		
		for(int i=0;i<list.length;i++)
		{
			if(list[i].compareTo(key)==0)
			{
				return i;
			}
		}
		
		return -1;
		
	}
}


