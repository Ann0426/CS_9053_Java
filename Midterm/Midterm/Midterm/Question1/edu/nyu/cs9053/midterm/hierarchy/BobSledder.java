package edu.nyu.cs9053.midterm.hierarchy;

import java.util.Objects;

public class BobSledder extends Sledder {
	private String partner;

	public BobSledder() {
		super();
		
	}

	public BobSledder(String name, int age, String sledColor, String partner) {
		super(name, age, sledColor);
		// TODO Auto-generated constructor stub
		this.partner = partner;
	}

	public String getPartner() {
		return this.partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}



	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof BobSledder)) {
			return false;
		}
		BobSledder other = (BobSledder) obj;
		return Objects.equals(partner, other.partner);
	}
	

}
