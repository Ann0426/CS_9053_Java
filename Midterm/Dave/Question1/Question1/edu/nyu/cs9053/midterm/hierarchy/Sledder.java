package edu.nyu.cs9053.midterm.hierarchy;

public class Sledder extends WinterSportPlayer {
	public String sledColor;
	
	public Sledder(String name, int age, String SledColor) {
		super(name, age);
		this.sledColor = SledColor;
	}

	public String getSledColor() {
		return this.sledColor;
	}
	
	public boolean equals(WinterSportPlayer wsp) {
		if (wsp.getClass() == this.getClass()) {
			Sledder sledder =(Sledder)wsp;
			return super.equals(wsp) && this.sledColor == sledder.sledColor;
		}
		return false;
	}
}
