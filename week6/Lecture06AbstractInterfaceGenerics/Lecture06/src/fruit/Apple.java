package fruit;

public class Apple extends Fruit {
	
	public String species;
	public Apple() {
		super("Apple");
		this.species = "Red Delicious";
		System.out.println("The name is " + this.name);
	}
	
	public static void main(String[] args) {
		Apple a = new Apple();
		Apple b = new Apple();
		Fruit c = new Apple();
		Fruit d = new Orange("Orange");
		//System.out.println("Apple instance: " + a.toString("foo"));
		//System.out.println("Apple instance: " + a);
		System.out.println("Fruit instance: " + c);
			System.out.println("species: " + ((Apple)d).species);
		
		
	}
	
	public String howToEat() {
		return "Apple: Make Apple Cider";
	}
	
	public String toString() {
		
		return super.toString() + " " + "This is an Apple of species " + this.species;
	}
	
	public String toString(String arg) {
		
		return toString() + " with arg " + arg; 
	}

}
