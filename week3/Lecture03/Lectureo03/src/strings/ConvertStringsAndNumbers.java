package strings;

import java.util.Scanner;

public class ConvertStringsAndNumbers {

	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    System.out.print("Enter an integer: ");
	    String inString = input.nextLine();
	    int intValue = Integer.parseInt(inString);
	    
	    System.out.println("You entered the number " + intValue);
	    double doubleValue = Double.parseDouble(inString);
	    System.out.println("You as a floating point value it would be "
	    						+ doubleValue);

	}
}
