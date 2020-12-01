package edu.nyu.cs9053.midterm.hierarchy;

public class MogulSkier extends Skier {
	public int skiLength;
	private int avgScore;

	public MogulSkier(String name, int age, int SkiLength, int AvgScore) {
		super(name, age, SkiLength);
		this.avgScore = AvgScore;
	}

	public int getSkiLength() {
		return this.skiLength;
	}

	public int getAvgScore() {
		return avgScore;
	}

	public boolean equals(Skier skier) {
		if (skier.getClass() == this.getClass()) {
			MogulSkier mogulSkier = (MogulSkier)skier;
			return super.equals(skier) && this.avgScore == mogulSkier.avgScore;
		}
		return false;
	}
}
