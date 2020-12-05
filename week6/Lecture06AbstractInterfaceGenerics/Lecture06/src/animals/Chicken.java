package animals;
import edibles.*;

public class Chicken extends Animal implements Edible {

	@Override
	public String sound() {
		return "Chicken: cock-a-dodle-doo";
	}

	@Override
	public String howToEat() {
		return "Chicken: Fry it";
	}

}
