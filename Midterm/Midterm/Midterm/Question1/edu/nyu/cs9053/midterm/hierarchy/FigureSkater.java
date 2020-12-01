package edu.nyu.cs9053.midterm.hierarchy;



public class FigureSkater extends IceSkater {
	private char gender;

	public FigureSkater() {
		super();
		this.gender = 'F';
		// TODO Auto-generated constructor stub
	}

	public FigureSkater(String name, int age, int skateSize, char gender) {
		super(name, age, skateSize);
		this.gender = gender;
		// TODO Auto-generated constructor stub
	}

	public char getGender() {
		return this.gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}


	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof FigureSkater)) {
			return false;
		}
		FigureSkater other = (FigureSkater) obj;
		return gender == other.gender;
	}
	

}
