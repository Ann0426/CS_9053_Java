package tests;
import static org.junit.Assert.assertTrue;
import org.junit.*;

import shapes.Circle;

public class CircleTest {

	@Test
	public void test1() {
		Circle circle = new Circle();
		assertTrue(circle.getRadius() == 1.0);
	}
}
