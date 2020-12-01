package fruit;

public class Inheritance {

	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug your Fruit objects
	 Fruit a = new Fruit();
	 Apple b = new Apple("good", "good","red",true);
	 Apple c = new Apple("good", "good","re",true);
	 Apple d = new Apple("good", "bad","red",true);
	 Lemon f = new Lemon(3,"bad",true);
	 Citris g = new Citris("bad","red",true);
	 System.out.println(g.toString());
	 System.out.println(b.equals(c));
	 System.out.println(g.equals(f));


	}

}
