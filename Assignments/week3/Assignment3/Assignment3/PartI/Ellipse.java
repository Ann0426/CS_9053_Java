
public class Ellipse {
	private static int numObjects = 0;
	private int ellipseID;
	private double semiMajorAxis = 2.0;
	private double semiMinorAxis = 1.0;
	
	public Ellipse() {
		this.ellipseID = Ellipse.numObjects;
		Ellipse.numObjects++;
	}
	public Ellipse(double a, double b) {
		this();
		this.semiMajorAxis = a;
		this.semiMinorAxis = b;
		
	}
	public int getID() {
		return this.ellipseID;
	}
	public double getSemiMajorAxis() {
		return this.semiMajorAxis;
	}
	public double getSemiMinorAxi() {
		return this.semiMinorAxis;
	}
	public double getArea() {
		return semiMajorAxis * semiMinorAxis * Math.PI;
	}
}
