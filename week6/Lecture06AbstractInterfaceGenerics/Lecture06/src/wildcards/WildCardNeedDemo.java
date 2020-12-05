package wildcards;

import java.util.Stack;

public class WildCardNeedDemo {
	  public static void main(String[] args ) {
		  Stack<Integer> intStack = new Stack<>();
	    intStack.push(1); // 1 is autoboxed into an Integer Object
	    intStack.push(2);
	    intStack.push(-2);

	    System.out.print("The max number is " + max(intStack)); // Error: 
	  }

	  /** Find the maximum in a stack of numbers */
	  public static double max(Stack<Number> stack) {
	    double max = stack.pop().doubleValue(); // initialize max

	    while (!stack.isEmpty()) {
	      double value = stack.pop().doubleValue();
	      if (value > max)
	        max = value;
	    }

	    return max;
	  }
	}