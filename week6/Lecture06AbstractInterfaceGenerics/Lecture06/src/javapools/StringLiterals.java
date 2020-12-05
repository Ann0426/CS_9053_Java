package javapools;
import shapes.*;

public class StringLiterals {

	public static void main(String[] args) {
		String a = "Circle";
		String b = "Circle";
		String c= new String("Circle");
		String d = new String("Circle");
		String e = c; // set the reference of e to the reference of c
		System.out.println(a == b);
		System.out.println(b == c);
		System.out.println(c == d);
		System.out.println(c == e);
		c = new String("Circle");
		System.out.println(c == e);
		a = "Square";
		b = "Square";
		System.out.println(a == b);
	}
}
