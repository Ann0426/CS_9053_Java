package edu.nyu.cs9053.midterm.hierarchy;

public class SpeedSkater extends IceSkater {
	public int skateSize;
	private double fastSpeed;
	
	SpeedSkater(String name, int age, int SkateSize, double FastSpeed) {
		super(name, age, SkateSize);
		this.fastSpeed = FastSpeed;
	}

	public int getSkateSize() {
		return this.skateSize;
	}

	public double getFastSpeed() {
		return fastSpeed;
	}

	public boolean equals(IceSkater iceSkater) {
		if (iceSkater.getClass() == this.getClass()) {
			SpeedSkater speedSkater = (SpeedSkater)iceSkater;
			 return super.equals(iceSkater) && this.fastSpeed == speedSkater.fastSpeed;
		}
		return false;
	}
}
