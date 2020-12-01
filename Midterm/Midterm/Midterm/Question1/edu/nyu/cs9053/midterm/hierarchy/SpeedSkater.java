package edu.nyu.cs9053.midterm.hierarchy;



public class SpeedSkater extends IceSkater {
	private double speed;

	public SpeedSkater() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SpeedSkater(String name, int age, int skateSize, double speed) {
		super(name, age, skateSize);
		this.speed = speed;
		// TODO Auto-generated constructor stub
	}

	public double getSpeed() {
		return this.speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}


	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof SpeedSkater)) {
			return false;
		}
		SpeedSkater other = (SpeedSkater) obj;
		return Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed);
	}
	
	

}
