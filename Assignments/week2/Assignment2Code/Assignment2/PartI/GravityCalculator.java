
public class GravityCalculator {

	public static double calculatePosition( double t, double vi, double xi) {
		double a = -9.81;
		double initialPosition = xi;
		double initialVelocity = vi;
		double time = t;
		double position = initialPosition + (initialVelocity * time) + (0.5 * a * time * time); 
		System.out.println("Time: " +  time);
		System.out.println("Position: " +  position);
		System.out.println("vi: " +  initialVelocity);
		System.out.println("initialPosition: " +  initialPosition);
		
		return position;
	}
	
	public static void main(String[] args) {
		calculatePosition(1000, 10, 25);
		
	}
}
