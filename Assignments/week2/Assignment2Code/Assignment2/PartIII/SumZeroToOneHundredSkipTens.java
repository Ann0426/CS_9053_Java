
/* You're going to sum up the numbers 0 to 100 but you are
 * going to skip any number divisible by 10. 
 */
public class SumZeroToOneHundredSkipTens {

	public static void main(String[] args) {
		
		// you can use any kind of loop you want
		// have a counter that counts from 0 to 100
		
		int sum = 0;
		
		for (int count = 0; count<=100; count++) {
			if( count % 10 != 0) {
				sum += count;
				
			}	
		}
		System.out.println("sum:"+ sum);
		
		
		
		// the first loop has the structure of 
		// if (counter is not divisible by 10)
		// then
		//    sum += counter;
		
		int sum2 = 0;
		for (int count = 0; count<=100; count++) {
			if( count % 10 == 0) {
				continue;
			}
			sum2 += count;
		
		}
		System.out.println("sum2:" + sum2);
		// the second loop has the structure of:
		// if (counter is divisible by 10)
		// then
		//  continue
		// and then it adds the counter to the sum if that condition does not execute
		
	}
}

