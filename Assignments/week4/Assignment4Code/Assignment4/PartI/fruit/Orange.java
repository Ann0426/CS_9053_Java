package fruit;

public class Orange extends Citris {
	private String type;

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Orange() {
		super();
	
	}

	public Orange(String type, String taste,  boolean rotten) {
		super(taste, "orange", rotten);
		this.type = type;
		
}

	@Override
	public String toString() {
		return "Orange [type=" + type + ", color=" + getColor() + ", getTaste()=" + getTaste() + ", toString()="
				+ super.toString() + ", isRotten()=" + isRotten() + ", getId()=" + getId() + ", getClass()="
				+ getClass() + "]";
	}
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		if ( o != null && o.getClass() == getClass()) {
			if (this.getType() != ((Orange)o).getType()) return false;
			
		      return true;
		}
		return false;
	}
}