package edu.nyu.cs9053.midterm.hierarchy;


public class Luger extends Sledder {
	private int lugeWeight;
	private int lugeLength;
	

	public Luger() {
		// TODO Auto-generated constructor stub
		super();
	}
	

	public Luger(String name, int age, String sledColor, int lugeWeight, int lugeLength ) {
		super(name, age, sledColor);
		this.lugeWeight = lugeWeight;
		this.lugeLength = lugeLength;
		// TODO Auto-generated constructor stub
	}


	public int getLugeWeight() {
		return this.lugeWeight;
	}


	public void setLugeWeight(int lugeWeight) {
		this.lugeWeight = lugeWeight;
	}


	public int getLugeLength() {
		return this.lugeLength;
	}


	public void setLugeLength(int lugeLength) {
		this.lugeLength = lugeLength;
	}





	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Luger)) {
			return false;
		}
		Luger other = (Luger) obj;
		return lugeLength == other.lugeLength && lugeWeight == other.lugeWeight;
	}
	

}
