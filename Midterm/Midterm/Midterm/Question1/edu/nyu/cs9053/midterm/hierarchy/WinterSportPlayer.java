package edu.nyu.cs9053.midterm.hierarchy;

import java.util.Objects;

public abstract class WinterSportPlayer {
	private String name;
	private int age;
	public WinterSportPlayer() {
		this.age = 15;
		this.name = "Ann";
		
	}

	public WinterSportPlayer(String name, int age) {
		this();
		this.name = name;
		this.age = age;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		
		return this.name;
	}
	
	public int getAge() {
		
		return this.age;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WinterSportPlayer other = (WinterSportPlayer) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
}
