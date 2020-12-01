package fruit;

public class Fruit {
	private String color;
	private boolean rotten;
	private int id;
	private static int next_id;
	
	public Fruit() {
		this.id = Fruit.next_id;
		Fruit.next_id++;
	}
	public Fruit(String color, boolean rotten) {
		this();
		this.color = color;
		this.rotten = rotten;
	}
	public String getColor() {
		return this.color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isRotten() {
		return this.rotten;
	}
	public void setRotten( boolean rotten) {
		this.rotten = rotten;
		
	}
	public int getId() {
		return this.id;
	}
	public String toString() {
		
		return "Class: Fruit, Id:" + this.id + ", Rotten: " + this.rotten + ", Color:" + this.color;
		
	}
	public boolean equals(Object o) {
		if (o != null && o.getClass() == getClass())
		   {
			if (this.isRotten() != ((Fruit)o).isRotten()) return false;
			if (this.getColor() != ((Fruit)o).getColor()) return false;
		      return true;
		   } 
		return false;
	}
		
		
		   
	

}
