package fruit;

public class Apple extends Fruit {
	private String taste;
	private String texture;

	public Apple() {
		super();
	}

	public Apple(String taste, String texture, String color, boolean rotten) {
		super(color, rotten);
		this.taste = taste;
		this.texture = texture;
		
	}
	public String getTaste() {
		return this.taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public void setTexture(String texture) {
		this.texture = texture;
	}
	public String getTexture() {
		return this.texture;	}
	public String toString() {
		return "Apple[" + super.toString() + 
				",taste=" + this.taste + ",texture=" + this.texture + "]";
		
	}
	public boolean equals(Object o) {
		if (!super.equals(o)) return false;
		if ( o != null && o.getClass() == getClass()) {
			if (this.getTaste() != ((Apple)o).getTaste()) return false;
			if (this.getTexture() != ((Apple)o).getTexture()) return false;
		      return true;
		}
		return false;
	}
	
	
}
