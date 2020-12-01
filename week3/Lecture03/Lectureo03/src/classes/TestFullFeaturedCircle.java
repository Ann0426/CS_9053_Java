package classes;

public class TestFullFeaturedCircle {

	public static void main(String[] args) {
		
		FullFeaturedCircle circle1 = new FullFeaturedCircle();
		System.out.println("circle1 has radius " + circle1.getRadius()
							+ " and area " + circle1.getArea() + 
							" and ID " + circle1.getID());
		
		FullFeaturedCircle circle2 = new FullFeaturedCircle(4.5);
		System.out.println("circle2 has radius " + circle2.getRadius()
							+ " and area " + circle2.getArea() + 
							" and ID " + circle2.getID());
		
		changeRadius(circle1, 5);
		System.out.println("new radius for circle1 is " + circle1.getRadius()
							+ " which gives a new area of  "+ circle1.getArea() +
							" even though the radius is still " + circle1.getID());
		
	}
	
	public static void changeRadius(FullFeaturedCircle c, 
									double newRadius) {
		
		c.setRadius(newRadius);
		
	}
}
