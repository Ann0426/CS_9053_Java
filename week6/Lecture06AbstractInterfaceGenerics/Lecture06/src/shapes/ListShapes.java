package shapes;
import java.util.ArrayList;

public class ListShapes {

	public static void main(String[] args) {
		ArrayList<GeometricObject> shapeList = new ArrayList<GeometricObject>();
		
		Circle circle = new Circle(5);
		Rectangle rect = new Rectangle(4,5);
		Circle circle2 = new Circle(2);
		shapeList.add(circle);
		shapeList.add(rect);
		shapeList.add(circle2);
		
		//shapeList.sort(null);
		
		for (int i = 0; i < shapeList.size();i++) {
			GeometricObject shape = shapeList.get(i);
			System.out.println(shape);
		}
	}
}
