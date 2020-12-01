package shapes;

public abstract class GeometricObject implements Comparable<GeometricObject> {
	
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;
	
	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}
	
	protected GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean isFilled() {
		return filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	
	/*
	@Override
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color + 
				" and filled: " + filled;
	}
	*/
	
	public abstract String toString();
	
	public abstract Double getArea();
	
	public abstract Double getPerimiter();
	
	public int compareTo(GeometricObject o) {
		//return this.getDateCreated().compareTo(o.getDateCreated());
		return this.getArea().compareTo(o.getArea());
		//return Double.compare(this.getArea(), o.getArea());
	}

		
}




/* implements Comparable<GeometricObject> 
 * 	
	public int compareTo(GeometricObject o) {
		return Double.compare(this.getArea(), o.getArea());
	}
 */
 
