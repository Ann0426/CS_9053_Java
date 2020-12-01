package edu.nyu.cs9053.midterm.hierarchy;

public class FigureSkater extends IceSkater {
	public int skateSize;
	private String ClothColor;
	
	FigureSkater(String name, int age, int SkateSize, String ClothColor) {
		super(name, age, SkateSize);
		this.ClothColor = ClothColor;
	}

	public int getSkateSize() {
		return this.skateSize;
	}
	
	public String getClothColor() {
		return ClothColor;
	}
	
	public boolean equals(IceSkater iceSkater) {
		if (iceSkater.getClass() == this.getClass()) {
			FigureSkater figureSkater = (FigureSkater)iceSkater;
			return super.equals(iceSkater) && this.ClothColor == figureSkater.ClothColor;
		}
		return false;
		
	}


}
