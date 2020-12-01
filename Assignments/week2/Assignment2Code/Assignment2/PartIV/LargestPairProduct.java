
public class LargestPairProduct {

	public static void main(String[] args) {
		
		int[] intArray = {17, 1, 3, 12, 39, 4, 76, 4, 31, 87};
		int product = -1;
		for (int i = 0; i<intArray.length; i++) {
			for (int j = 0; j<intArray.length - i ; j++) {
				int res = intArray[i]*intArray[j+i];
				if (product < res && i!=j+i) product = res;
					
		}}
		
		
		System.out.println("Maximum product of all pairs in the array: " +
							product);
	}
}
