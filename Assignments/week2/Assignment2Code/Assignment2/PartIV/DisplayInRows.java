
public class DisplayInRows {

	static final int ROW_LENGTH = 10;
	
	public static void main(String[] args) {
		
		int[] intArray = new int[100];
		
		for (int i=0;i< intArray.length;i++) {
			intArray[i] = (int)(Math.random()*100);
			if ( (i+1) %10 == 0)
				System.out.print( intArray[i] + "," + "\n");
			else
				System.out.print( intArray[i] + ",");
				
		}
		
	}
}
