package PartII;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.*;
public class MathSet<E> extends HashSet<E> {
	
	
	public MathSet() {
	super();
	}
	public MathSet(java.util.Collection<? extends E> c) {
	      super(c);
	   }
	  public MathSet(int initialCapacity) {
	      super(initialCapacity);
	   }
	public void intersect(Set<E> s2) {
		this.addAll(s2);
		
	
	}

	public void union(Set<E> s2) {
		this.retainAll(s2);;

	}

	public static <S, T> Set<Pair<S, T>> cartesianProduct(Set<S> a, Set<T> b) {
	    Set<Pair<S, T>> product = new HashSet<Pair<S, T>>();

	    for(S s : a) {
	        for(T t : b) {
	            product.add(new Pair<S, T>(s,t));
	        }
	    }

	    return product;
	}
	
	public static void main(String[] args) {
		MathSet<Integer> set1 = new MathSet<Integer>(); 
		set1.addAll(Arrays.asList(new Integer[] {1, 3, 2, 4, 8, 9, 0}));  
		MathSet<Integer> set2 = new MathSet<Integer>(); 
		set2.addAll(Arrays.asList(new Integer[] {1, 3, 7, 5, 4, 0, 7, 5}));
		MathSet<Double> set3 = new MathSet<Double>(); 
		set3.addAll(Arrays.asList(new Double[] {1.5, 3.2, 7.0, 5.5, 4.8, 0.3, 7.6, 5.4}));
		System.out.println("set1 is " + set1);
		System.out.println("set2 is " +set2);
		System.out.println("set3 is " +set3);
		set1.intersect(set2);
		System.out.println("set1 after intersect set2 : set5 = " + set1);
		set1.union(set2);
		System.out.println("set5 after union set2  " + set1);
		System.out.println(cartesianProduct(set1, set3));
		
		// create two MathSet objects of the same type.
		// See if union and intersection works.
		
		// create another MathSet object of a different type
		// calculate the cartesian product of this set with one of the
		// above sets
	}
}
