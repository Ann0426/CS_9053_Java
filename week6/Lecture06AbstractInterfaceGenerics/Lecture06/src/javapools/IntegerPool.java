package javapools;
import java.util.ArrayList;

public class IntegerPool {

	public static void main(String[] args) {
		Number n;
		n = new Integer(10);
		n = new Float(12.5);
		
		int k = 5;
		Integer myInt = new Integer(k);
		int l = myInt.intValue();
		// Double, Float, Long, Boolean, etc...
		Integer a = 5;
		Integer b = 5;
		System.out.println(a==b); // true
		Integer c = 127;
		Integer d = 127;
		System.out.println(c==d); // true
		Integer e = 128;
		Integer f = 128;
		System.out.println(e==f); // false
		

		Integer g = -128;
		Integer h = -128;
		System.out.println(g==h); // true
		
		Integer i = -129;
		Integer j = -129;
		System.out.println(i==j); // false
		
		ArrayList<Integer> intArrayList = new ArrayList<Integer>();
		intArrayList.add(a);
		intArrayList.add(k); // implicitly creates new Integer(i) since JDK 1.5;
		
		
	}
}
