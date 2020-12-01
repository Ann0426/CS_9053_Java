package shapes;

import java.util.Comparator;

public class GeometricObjectComparator<T extends GeometricObject> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		if (o1.getArea() > o2.getArea()) {
			return 1;
		} else if (o1.getArea() == o1.getArea()) {
			return 0;
		} else {
			return -1;
		}
	}

}
