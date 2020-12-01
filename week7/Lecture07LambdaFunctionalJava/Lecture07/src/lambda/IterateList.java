package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class IterateList {
	
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1,2,3);
		
		for (int i = 0; i< intList.size() ; i++) {
			System.out.println(intList.get(i));
		}

		System.out.println("-----------");
		

		for (Integer i : intList) {
			System.out.println("The square of " + i + " is:");
			System.out.println(i*i);
		}
		
		System.out.println("-----------");
		// or we can write it like this in Java8
		intList.forEach(new Consumer<Integer>() {
			public void accept(Integer i) {
				System.out.println(i);
			}
		});
		System.out.println("-----------");
	
		// Lambdas mean we don’t have to write out
		// the function
		intList.forEach((Integer i) -> 	System.out.println(i));
		System.out.println("-----------"); 
		
		intList.forEach((i) -> 	System.out.println(i*i));
	}
}
