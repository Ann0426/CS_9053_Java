package edu.nyu.cs9053.midterm.hierarchy;

public abstract class WinterSportPlayer {
	private String name;
	private int age;

	public WinterSportPlayer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean equals(WinterSportPlayer wsp) {
		return (this.name == wsp.name) && (this.age == wsp.age);
	}
}
