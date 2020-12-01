
public class ArrayStats {

	public static void main(String[] args) {
		int[] intArray = new int[50];
		
		
		
		
		/* initialize the source Array */
		for (int i = 0;i < intArray.length; i++) {
			intArray[i] = (int)(Math.random()*100);
		}

		int smallestValue = getMin(intArray);
		int largestValue = getMax(intArray);
		double meanAverage = getMean(intArray);
		System.out.println("Mean average value of array elements is " + 
				meanAverage); 
	    System.out.println("Largest value in the array is " + 
	    		largestValue);
	    System.out.println("Smallest value in the array is " + 
	    		smallestValue);
		
	}
	
	
	public static int getMin(int[] inputArray){ 
	    int minValue = inputArray[0]; 
	    for(int i=1;i<inputArray.length;i++){ 
	      if(inputArray[i] < minValue){ 
	        minValue = inputArray[i]; 
	      } 
	    } 
	    return minValue; 
	  
	  }
	
	public static int getMax(int[] inputArray){ 
	    int maxValue = inputArray[0]; 
	    for(int i=1;i < inputArray.length;i++){ 
	      if(inputArray[i] > maxValue){ 
	         maxValue = inputArray[i]; 
	      }  
	    } 
	    return maxValue;
	  
	  }
	public static double getMean(int[] inputArray){ 
	    
	    int sum = 0;
	    for(int i=0;i < inputArray.length;i++){ 
	      sum += inputArray[i];
	      } 
	    double average = sum / inputArray.length;
	    return average;
	    
	    
	  }
	
}
