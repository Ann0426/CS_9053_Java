package fruit;

public class Orange extends Fruit {
	
	public Orange(String name) {
		super(name);
		System.out.println("Orange's constructor is invoked");
	}

	@Override
	public String howToEat() {
		return "Orange: Make orange juice";
	}
}
