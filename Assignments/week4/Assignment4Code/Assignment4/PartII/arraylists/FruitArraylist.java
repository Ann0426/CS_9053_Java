package arraylists;
import java.util.Random;
import java.util.ArrayList;

import fruit.*;

public class FruitArraylist {

	public static void main(String[] args) {
		
		// this ArrayList MUST be parameterized
		

		ArrayList<Fruit> fruitArrayList = new ArrayList<Fruit>(); 
		fruitArrayList.add(new Apple("sweet","crisp","red",false));
		fruitArrayList.add(new Apple("tart","soft","green",true));
		fruitArrayList.add(new Apple("tart","soft","green",true));
		fruitArrayList.add(new Lemon(new Random().nextInt(101),"sour" , true ));
		fruitArrayList.add(new Lemon(new Random().nextInt(101),"sour" , true ));
		fruitArrayList.add(new Lemon(new Random().nextInt(101),"sour" , true ));
		fruitArrayList.add(new Orange("mandarin", "sweet" , true ));
		fruitArrayList.add(new Orange("mandarin", "sweet" , true ));
		printAvgSour(fruitArrayList);
		removeObj(fruitArrayList);
		
	}
	
	public static double printAvgSour(ArrayList<Fruit> fruitArrayList) {
		int sour = 0;
		for (int i = 0; i <fruitArrayList.size() ; i++) {
			if ( fruitArrayList.get(i) instanceof Lemon) {
				sour += ((Lemon)fruitArrayList.get(i)).getSourness() ; 
			}
			
		}
		 double avg = 1.0 * sour / fruitArrayList.size();
		 System.out.println( "The avg sourness is : " + avg);
		 return avg;
	}
	
	public static void removeObj(ArrayList<Fruit> fruitArrayList) {
		Fruit var = new Apple();
		for (int i = 0; i <fruitArrayList.size() ; i++)  {
			if(fruitArrayList.get(i) instanceof Apple && fruitArrayList.get(i).getColor() == "green" && fruitArrayList.get(i).isRotten() == true) {
				var = fruitArrayList.get(i);
				break;
				
			}
		}
		for (int i = fruitArrayList.size() - 1 ; i >= 0 ; i--) {
			if (fruitArrayList.get(i) == var){
				System.out.println("the same object :" + fruitArrayList.get(i));
			}
		}
		
		for (int i = fruitArrayList.size() - 1 ; i >= 0 ; i--) {
			if (fruitArrayList.get(i).equals(var)) {
				System.out.println("object with same values:" + fruitArrayList.get(i));
				fruitArrayList.remove(i);
			}
		}
		
		for (int i = 0; i <fruitArrayList.size() ; i++)  {
			System.out.println("remain objects:" + fruitArrayList.get(i));
			
		}
		
		 
	}
		
	
}
