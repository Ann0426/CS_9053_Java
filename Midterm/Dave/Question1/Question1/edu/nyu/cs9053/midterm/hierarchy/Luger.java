package edu.nyu.cs9053.midterm.hierarchy;

public class Luger extends Sledder {
	private int LugeWeight;
	public Luger(String name, int age, String SledColor,  int LugeWeight ) {
		super(name, age, SledColor);
		this.LugeWeight =  LugeWeight;
	}
	
	public int getLugeWeight() {
		return LugeWeight;
	}

	public boolean equals(Sledder sledder) {
		if(sledder.getClass() == this.getClass()) {
			Luger luger = (Luger)sledder;
			return super.equals(sledder) && this.LugeWeight == luger.LugeWeight;
		}
		return false;
	}
}
