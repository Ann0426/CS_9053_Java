package edu.nyu.cs9053.midterm.hierarchy;

public class CrossCountrySkier extends Skier {
	public int skiLength;
    private int shoeSize;

	public CrossCountrySkier(String name, int age, int SkiLength, int ShoeSize)	{
		super(name, age, SkiLength);
		this.shoeSize = ShoeSize;
	}

	public int getSkiLength() {
		return this.skiLength;
	}
	
	public int getShoeSize() {
		return shoeSize;
	}

	public boolean equals(Skier skier) {
		if(skier.getClass() == this.getClass()) {
			CrossCountrySkier crossCountrySkier =(CrossCountrySkier)skier;
			return super.equals(skier) && this.shoeSize == crossCountrySkier.shoeSize;
		}
		return false;
	}
	
}
