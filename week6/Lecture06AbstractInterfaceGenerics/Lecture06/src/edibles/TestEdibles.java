package edibles;

import java.util.ArrayList;

import animals.Chicken;
import animals.Tiger;
import fruit.Orange;

public class TestEdibles {

	public static void main(String[] args) {
		Tiger t = new Tiger();
		Chicken c = new Chicken();
		Orange o = new Orange("Orange");
		/*
		System.out.println(t.sound());
		System.out.println(c.sound());
		System.out.println(c.howToEat());
		System.out.println(o.howToEat());
		*/
		
		ArrayList<Edible> edibleList = new ArrayList<Edible>();
		edibleList.add(c);
		edibleList.add(o);
		
		for (int i = 0; i<edibleList.size();i++) {
			Edible myEdible = edibleList.get(i);
			System.out.println(myEdible.howToEat());
		}
		
	}
}
