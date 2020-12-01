package edu.nyu.cs9053.midterm.hierarchy;


public class Skier extends WinterSportPlayer {
	private int skiLength;

	public Skier() {
		super();
	}

	public Skier(String name, int age, int skiLength) {
		super(name, age);
		this.skiLength = skiLength;
		// TODO Auto-generated constructor stub
	}

	public int getSkiLength() {
		return this.skiLength;
	}

	public void setSkiLength(int skiLength) {
		this.skiLength = skiLength;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Skier)) {
			return false;
		}
		Skier other = (Skier) obj;
		return skiLength == other.skiLength;
	}
	
	

}
