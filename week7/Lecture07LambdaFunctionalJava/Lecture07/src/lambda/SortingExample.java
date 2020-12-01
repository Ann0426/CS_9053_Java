package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SortingExample implements Comparator<String> {
	
	public int compare(String first, String second) {
		return first.length() - second.length();
	}
	
	public static void main(String[] args) {
		
		/* results of a.compareTo(T t):
		 *  -1 if a < t
		 *  0 if a == t
		 *  1 if a > t
		 */
		String[] stringArray = {"Dean", "Maria", "Bob", "Constantine", "Ivan", "Boris"};
		

		System.out.println("original array: " + Arrays.toString(stringArray));

		Arrays.sort(stringArray, null);
		System.out.println("sorted array1: " + Arrays.toString(stringArray));
		
		Arrays.sort(stringArray, new SortingExample());
		System.out.println("sorted array2: " + Arrays.toString(stringArray));
		
		/* what we're doing is passing in a function. So we can just do that */

		
		// ask how we would reverse this
		
		System.out.println("sorted array3 (ascending length): " + Arrays.toString(stringArray));
		
		ArrayList<String> al = new ArrayList<String>();
		for (String s : stringArray) {
			al.add(s);
		}
		
		al.sort( (String s1, String s2) -> s1.compareTo(s2));

		System.out.println("Arraylist is " + al);

		al.sort( (String s1, String s2) -> -s1.compareTo(s2));

		System.out.println("Arraylist is " + al);
		
		// pass a lambda to test for removal:
		al.removeIf((String s) -> s == "Dean");
		System.out.println("Arraylist is " + al);
		
	}
}
