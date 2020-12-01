package edu.nyu.cs9053.midterm.hierarchy;



public class IceSkater extends WinterSportPlayer {
	private int skateSize;

	public IceSkater() {
		super();
	}

	public IceSkater(String name, int age, int skateSize) {
		super(name, age);
		this.skateSize = skateSize;
		// TODO Auto-generated constructor stub
	}


	public int getSkateSize() {
		return this.skateSize;
	}

	public void setSkateSize(int skateSize) {
		this.skateSize = skateSize;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof IceSkater)) {
			return false;
		}
		IceSkater other = (IceSkater) obj;
		return skateSize == other.skateSize;
	}
	

}
