package classes;

public class Circle {

	/** the radius of this cricle */
	double radius = 1.0;
	
	/** construct a circle object */
	public Circle() {
		
	}
	
	/** Construct a circle object */
	public Circle(double newRadius) {
		radius = newRadius;
	}
	
	/** Return the area of this circle */
	public double getArea() {
		return radius * radius * 3.14159;
	}
}
