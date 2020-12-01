package fruit;

public class Citris extends Fruit {
	private String taste;
	
	public Citris() {
		super();
	}


	public Citris(String taste, String color, boolean rotten) {
		super(color, rotten);
		this.taste = taste;
		
	}
	public String getTaste() {
		return this.taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	@Override
	public String toString() {
		return "Citris [taste=" + taste + ", getColor()=" + getColor() + ", isRotten()=" + isRotten() + ", getId()="
				+ getId() + ", toString()=" + super.toString() + "]";
	}
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		if ( o != null && o.getClass() == getClass()) {
			if (this.getTaste() != ((Citris)o).getTaste()) return false;
			
		      return true;
		}
		return false;
	}

	
	

	


	

}
