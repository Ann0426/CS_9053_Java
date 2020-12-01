package classes;

public class FullFeaturedCircle {

	private static int numObjects = 0;
	private int circleID;
	private double radius = 1.0;
	
	public FullFeaturedCircle() {
		this.circleID = FullFeaturedCircle.numObjects;
		FullFeaturedCircle.numObjects++;
	}
	
	public FullFeaturedCircle(double radius) {
		this();
		this.radius = radius;
		
	}
	
	public double getArea() {
		return radius * radius * Math.PI;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public int getID() {
		return this.circleID;
	}
}
