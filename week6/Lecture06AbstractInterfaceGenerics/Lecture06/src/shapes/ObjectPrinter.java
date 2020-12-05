package shapes;

import java.util.HashSet;

public class ObjectPrinter<T extends GeometricObject> {

	private HashSet<T> objSet = new HashSet<T>();
	
	public void add(T t) {
		objSet.add(t);
	}
	
	public void printObjects() {
		for (T t : objSet) {
			System.out.println(t);
		}
	}
	
	public static void main(String[] args) {

		Circle circle = new Circle(5);
		Rectangle rect = new Rectangle(4,5);
		Integer newInt = new Integer(5);
		
		ObjectPrinter<GeometricObject> objectPrinter = new ObjectPrinter<GeometricObject>();
		objectPrinter.add(circle);
		objectPrinter.add(rect);
		objectPrinter.printObjects();
		//objectPrinter.add(newInt);
	}
	
}
