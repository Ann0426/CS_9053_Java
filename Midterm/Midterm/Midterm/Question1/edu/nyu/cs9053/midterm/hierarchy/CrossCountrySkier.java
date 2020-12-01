package edu.nyu.cs9053.midterm.hierarchy;

import java.util.Objects;

public class CrossCountrySkier extends Skier {
	private String country;

	public CrossCountrySkier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CrossCountrySkier(String name, int age, int skiLength, String country) {
		super(name, age, skiLength);
		this.country = country;
		// TODO Auto-generated constructor stub
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof CrossCountrySkier)) {
			return false;
		}
		CrossCountrySkier other = (CrossCountrySkier) obj;
		return Objects.equals(country, other.country);
	}
	
	

}
