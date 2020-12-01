package edu.nyu.cs9053.midterm.hierarchy;

import java.util.Objects;

public class Curler extends WinterSportPlayer {
	private String trouserPattern;
	private int brushLength;
	
	public Curler() {
		super();  
	} 
	public Curler(String name, int age, String trouserPattern, int brushLength) {
		super(name, age);
        this.trouserPattern = trouserPattern;
        this.brushLength = brushLength;
	}
	public String getTrouserPattern() {
		return this.trouserPattern;
	}
	public void setTrouserPattern(String trouserPattern) {
		this.trouserPattern = trouserPattern;
	}
	public int getBrushLength() {
		return this.brushLength;
	}
	public void setBrushLength(int brushLength) {
		this.brushLength = brushLength;
	}
	
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Curler)) {
			return false;
		}
		Curler other = (Curler) obj;
		return brushLength == other.brushLength && Objects.equals(trouserPattern, other.trouserPattern);
	}
	
	

}
