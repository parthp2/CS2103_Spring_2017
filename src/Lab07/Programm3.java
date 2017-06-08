package Lab07;

public class Programm3 {

	public static void main(String[] args) {
	
        Integer[] list=new Integer[20];
		
		String[] list2={"a","b","c"};
		
		for(int i=0;i<list.length;i++)
		{
			list[i]=i;
		}
		
		System.out.println(binarySearch(list,5));
		
		System.out.println(binarySearch(list2,"a"));
		
		System.out.println(binarySearch(list2,"c"));
		
		System.out.println(binarySearch(list2,"d"));
		
		System.out.println(binarySearch(list,15));
		
		System.out.println(binarySearch(list,21));
		
		

	}

	public static <E extends Comparable<E>> int binarySearch(E[] list, E key)
	{
		int low=0;
		int high=list.length-1;
		
		while(low<=high)
		{
			int mid=(low+high)/2;
			
			if(key.compareTo(list[mid])<0)
			{
				high=mid-1;
			}
			else if(key.compareTo(list[mid])>0)
			{
				low=mid+1;
			}
			else if(key.compareTo(list[mid])==0)
			{
				return mid;
			}
		}
				
	return -1;
	}
}
