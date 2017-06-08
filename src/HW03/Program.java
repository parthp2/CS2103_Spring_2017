package HW03;

import java.util.Arrays;

public class Program {
	
	

	public static void main(String[] args) {
		
		String s="          ";
		System.out.println("Arraysize | selection sort    Bubble Sort  Merge Sort   Quick Sort   Heap Sort  Radix sort");
		
		long startTime ;
		long endTime;
		long executionTime = 0;
		
		int c=0;
		for(int i=0;i<6;i++)
		{
			c=c+50000;
			System.out.println();
			System.out.print(c);
			
			int list[]=new int[c];
			
			for(int j=1;j<c;j++)
			{
				list[j]=(int) (Math.random() * 1000);
			}
				
			startTime = System.currentTimeMillis();
			selectionSort(list);
			endTime = System.currentTimeMillis();
			executionTime = endTime - startTime;
			System.out.print(s+" "+executionTime );
			
			
			startTime = System.currentTimeMillis();
			bubbleSort(list);
			endTime = System.currentTimeMillis();
			executionTime = endTime - startTime;
			System.out.print(s+executionTime );
			
			
			startTime = System.currentTimeMillis();
			mergeSort(list);
			endTime = System.currentTimeMillis();
			executionTime = endTime - startTime;
			System.out.print(s+executionTime );
			
			
			startTime = System.currentTimeMillis();
			sort(list);
			endTime = System.currentTimeMillis();
			executionTime = endTime - startTime;
			System.out.print(s+executionTime );
			
			
			startTime = System.currentTimeMillis();
			heapSort(list);
			endTime = System.currentTimeMillis();
			executionTime = endTime - startTime;
			System.out.print(s+executionTime );
			
			
			startTime = System.currentTimeMillis();
			radixSort(list);
			endTime = System.currentTimeMillis();
			executionTime = endTime - startTime;
			System.out.print(s+executionTime );
			
			
		}
		
		

	}
	
	
	 public static void selectionSort(int[] arr){
         
	        for (int i = 0; i < arr.length - 1; i++)
	        {
	            int index = i;
	            for (int j = i + 1; j < arr.length; j++)
	                if (arr[j] < arr[index])
	                    index = j;
	      
	            int smallerNumber = arr[index]; 
	            arr[index] = arr[i];
	            arr[i] = smallerNumber;
	        }
	       
	    }
	
	
	 
	 public static void bubbleSort(int[] list){

		 for(int i=1; i< list.length;i++)
		 {
	            for(int j= 0; j< (list.length-1); j++)
	            {
	                if( (list[j])>(list[j+1]))
					{
	                    int tmp = list[j];
	                    list[j] = list[j + 1];
	                    list[j + 1] = tmp;
	                }                
	            }
	        }
	    }
	 
	 public static void mergeSort(int[] array) {
	        if (array.length > 1) {
	           
	            int[] left = leftHalf(array);
	            int[] right = rightHalf(array);
	            
	          
	            mergeSort(left);
	            mergeSort(right);
	            
	          
	            merge(array, left, right);
	        }
	    }
	    
	    // Returns the first half of the given array.
	    public static int[] leftHalf(int[] array) {
	        int size1 = array.length / 2;
	        int[] left = new int[size1];
	        for (int i = 0; i < size1; i++) {
	            left[i] = array[i];
	        }
	        return left;
	    }
	    
	    // Returns the second half of the given array.
	    public static int[] rightHalf(int[] array) {
	        int size1 = array.length / 2;
	        int size2 = array.length - size1;
	        int[] right = new int[size2];
	        for (int i = 0; i < size2; i++) {
	            right[i] = array[i + size1];
	        }
	        return right;
	    }
	    
	    
	    public static void merge(int[] result, 
	                             int[] left, int[] right) {
	        int i1 = 0;   
	        int i2 = 0;  
	        
	        for (int i = 0; i < result.length; i++) {
	            if (i2 >= right.length || (i1 < left.length && 
	                    left[i1] <= right[i2])) {
	                result[i] = left[i1];  
	                i1++;
	            } else {
	                result[i] = right[i2];  
	                i2++;
	            }
	        }
	    }


	   

	    public static void sort(int[] numbers) 
	    { 
	    	if (numbers == null || numbers.length == 0)
	    	{ 
	    		return; 
	    	}
	    	
	    	
	    	quickSort(numbers,0, numbers.length - 1); 
	    	
	    }  
	    
	    
	    private static void quickSort(int[] input,int low, int high)
	    { 
	    	int i = low; 
	    	int j = high; 
	    	int pivot = input[low + (high - low) / 2]; 
	    	while (i <= j)
	    	{ 
	    		while (input[i] < pivot) 
	    		{ 
	    			i++; 
	    		} 
	    		while (input[j] > pivot)
	    		{ 
	    			j--; 
	    		} 
	    		if (i <= j)
	    		{ 
	    			swap(input,i, j); 
	    			i++; 
	    			j--; 
	    		} 
	    	} 
	    	
	    	if (low < j) 
	    	{ 
	    		quickSort(input,low, j); 
	    	} 
	    	if (i < high) 
	    	{ 
	    		quickSort(input,i, high); 
	    	} 
	    	
	    } 
	    
	    private static void swap(int[] input,int i, int j) 
	    { 
	    	int temp = input[i]; 
	    	input[i] = input[j]; 
	    	input[j] = temp; 
	    } 
	    
	    
	    
	    public static void heapSort(int arr[])
	    {
	        int n = arr.length;
	 
	       
	        for (int i = n / 2 - 1; i >= 0; i--)
	            heapify(arr, n, i);
	 
	       
	        for (int i=n-1; i>=0; i--)
	        {
	           
	            int temp = arr[0];
	            arr[0] = arr[i];
	            arr[i] = temp;
	 
	           
	            heapify(arr, i, 0);
	        }
	    }
	 
	   
	    static void heapify(int arr[], int n, int i)
	    {
	        int largest = i; 
	        int l = 2*i + 1;  
	        int r = 2*i + 2;  
	 
	      
	        if (l < n && arr[l] > arr[largest])
	            largest = l;
	 
	       
	        if (r < n && arr[r] > arr[largest])
	            largest = r;
	 
	        
	        if (largest != i)
	        {
	            int swap = arr[i];
	            arr[i] = arr[largest];
	            arr[largest] = swap;
	 
	          
	            heapify(arr, n, largest);
	        }
	    }
	    
	    
	    static int getMax(int arr[], int n)
	    {
	        int mx = arr[0];
	        for (int i = 1; i < n; i++)
	            if (arr[i] > mx)
	                mx = arr[i];
	        return mx;
	    }
	 
	   
	    static void countSort(int arr[], int n, int exp)
	    {
	        int output[] = new int[n]; 
	        int i;
	        int count[] = new int[10];
	        Arrays.fill(count,0);
	 
	       
	        for (i = 0; i < n; i++)
	            count[ (arr[i]/exp)%10 ]++;
	 
	        
	        for (i = 1; i < 10; i++)
	            count[i] += count[i - 1];
	 
	       
	        for (i = n - 1; i >= 0; i--)
	        {
	            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
	            count[ (arr[i]/exp)%10 ]--;
	        }
	 
	        
	        for (i = 0; i < n; i++)
	            arr[i] = output[i];
	    }
	 
	   
	    static void radixSort(int arr[])
	    {
	    	int n=arr.length;
	      
	        int m = getMax(arr, n);
	 
	       
	        for (int exp = 1; m/exp > 0; exp *= 10)
	            countSort(arr, n, exp);
	    }
	    	
}
