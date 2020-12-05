package fruit;
import edibles.Edible;

public abstract class Fruit {

	String name = null;
	
	public Fruit(String name) {
		this.name = name;
	    System.out.println("Fruit's constructor is invoked");
	  }
	
	public String toString() {
		return "This is a fruit with name " + this.name;
	}

}

// implements Edible