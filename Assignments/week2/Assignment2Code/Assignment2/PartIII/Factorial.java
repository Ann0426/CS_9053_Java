import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		int val = 1;
		Scanner in = new Scanner(System.in);
		System.out.print("Input num: ");
		int num = in.nextInt();
		
		for (int i = 1;i<=num; i++)
	        {   
			   val = val * i;
	        
	        } 
		System.out.println("Factorial of "+num+" is: "+ val);   
		
	}
	
}
