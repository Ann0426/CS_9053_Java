package edu.nyu.cs9053.midterm.hierarchy;

public class Bobsledder extends Sledder {
	public String sledColor;
	private int groupSize;
	
	public Bobsledder(String name, int age, String sledColor, int groupSize) {
		super(name, age, sledColor);
		this.groupSize = groupSize;
	}

	public String getSledColor() {
		return this.sledColor;
	}

	public int getGroupSize() {
		return groupSize;
	}

	public boolean equals(Sledder sledder) {
		if (sledder.getClass() == this.getClass()) {
			Bobsledder bobsledder = (Bobsledder)sledder;
			return super.equals(sledder) && this.groupSize == bobsledder.groupSize;
		}
		return false;
	}

}
