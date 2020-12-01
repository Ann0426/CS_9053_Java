package fruit;

public class Lemon extends Citris {
	private int sourness;


	public Lemon() {
		super();
	}

	public Lemon(int sourness,String taste, boolean rotten) {
		super(taste, "yellow", rotten);
		this.sourness = sourness;
		
	}

	public int getSourness() {
		return this.sourness;
	}

	public void setSourness(int sourness) {
		this.sourness = sourness;
	}

	@Override
	public String toString() {
		return "Lemon [sourness=" + sourness + ", color=" + getColor() + ", rotten=" + isRotten() + ", getTaste()=" + getTaste()
				+ ", toString()=" + super.toString() + ", getId()=" + getId() + ", getClass()=" + getClass() + "]";
	}
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		if ( o != null && o.getClass() == getClass()) {
			if (this.getSourness() != ((Lemon)o).getSourness()) return false;
			
		      return true;
		}
		return false;
	}
	

}
