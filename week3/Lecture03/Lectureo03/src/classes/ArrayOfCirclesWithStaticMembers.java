package classes;
import java.util.Random;

public class ArrayOfCirclesWithStaticMembers {

	public static void main(String[] args) {
		Random randGenerator = new Random();
		CircleWithStaticMembers[] circles = new CircleWithStaticMembers[50];
		for (int i=0;i < 50;i++) {
			double radius = randGenerator.nextInt(100);
			System.out.println("radius is  " + radius);
			CircleWithStaticMembers circle = new CircleWithStaticMembers(radius);
			circles[i] = circle;
		}
		
		System.out.println("number of circles created: " + 
				CircleWithStaticMembers.numberOfObjects);
		
		for (int i=0;i < 50;i++) {
			
			System.out.printf("circle in index "+ i + 
								" has area %.2f\n", circles[i].getArea());
		}
		
	}
}
