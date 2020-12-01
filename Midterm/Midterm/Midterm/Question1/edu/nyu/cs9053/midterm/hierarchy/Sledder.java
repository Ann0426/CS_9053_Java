package edu.nyu.cs9053.midterm.hierarchy;

import java.util.Objects;

public class Sledder extends WinterSportPlayer {
		
	public String sledColor;
	
	public Sledder() {
		super();
		this.sledColor = "red";
		}
		
	public Sledder(String name, int age, String sledColor) {
		super(name, age);
		this.sledColor = sledColor;
		}

	public String getSledColor() {
		return this.sledColor;
	}

	public void setSledColor(String sledColor) {
		this.sledColor = sledColor;
	}

	

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Sledder)) {
			return false;
		}
		Sledder other = (Sledder) obj;
		return Objects.equals(sledColor, other.sledColor);
	}
	
	
	
}
