package edu.nyu.cs9053.midterm.hierarchy;

public class Skier extends WinterSportPlayer {
	private int skiLength;
	public Skier(String name, int age, int skiLength) {
		super(name, age);
		this.skiLength = skiLength;
	}
	
	public int getSkiLength() {
		return skiLength;
	}
	
	public boolean equals(WinterSportPlayer wsp) {
		if (wsp.getClass() == this.getClass()) {
			Skier skier = (Skier)wsp;
			return super.equals(wsp) && this.skiLength == skier.skiLength;
		}
		return false;
	}
}
