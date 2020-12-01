package edu.nyu.cs9053.midterm.hierarchy;

public class Curler extends WinterSportPlayer {
	private String trouserPattern;
	private int brushLength;

	public Curler(String name, int age, String trouserPattern, int brushLength) {
		super(name, age);
        this.trouserPattern = trouserPattern;
        this.brushLength = brushLength;
	}

	public String getTrouserPattern() {
		return this.trouserPattern;
	}

	public int getBrushLength() {
		return brushLength;
	}

	public boolean equals(WinterSportPlayer wsp) {
		if (wsp.getClass() == this.getClass()) {
			Curler curler = (Curler)wsp;
			return super.equals(wsp) && this.brushLength == curler.brushLength && this.trouserPattern == curler.trouserPattern;
		}
		return false;
	}
}
