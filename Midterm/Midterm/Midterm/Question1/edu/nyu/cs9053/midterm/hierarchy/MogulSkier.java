package edu.nyu.cs9053.midterm.hierarchy;


public class MogulSkier extends Skier {
	private int skillLevel;

	public MogulSkier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MogulSkier(String name, int age, int skiLength,int skillLevel) {
		super(name, age, skiLength);
		this.skillLevel = skillLevel;
		// TODO Auto-generated constructor stub
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}


	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof MogulSkier)) {
			return false;
		}
		MogulSkier other = (MogulSkier) obj;
		return skillLevel == other.skillLevel;
	}

}
