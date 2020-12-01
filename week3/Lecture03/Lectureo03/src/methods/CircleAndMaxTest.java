package methods;
import classes.Circle;

public class CircleAndMaxTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle myCircle = new Circle(5.0); // Circle with radius 5.0
		Circle myOtherCircle = new Circle(10.0);
		
		int maxArea = TestMax.max((int)myCircle.getArea(),
								(int)myOtherCircle.getArea());
		
		System.out.println("maxArea between the two circles is " 
							+ maxArea);
	}

}
