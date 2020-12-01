package edu.nyu.cs9053.midterm.hierarchy;

public class IceSkater extends WinterSportPlayer {
	public int skateSize;
	
	IceSkater(String name, int age, int SkateSize) {
		super(name, age);
		this.skateSize = SkateSize;
	}

	public int getSkateSize() {
		return this.skateSize;
	}
	
	public boolean equals(WinterSportPlayer wsp) {
		if (wsp.getClass() == this.getClass()) {
			IceSkater iceSkater = (IceSkater)wsp;
			return super.equals(wsp) && this.skateSize == iceSkater.skateSize;
		}
		return false;
	}
}
