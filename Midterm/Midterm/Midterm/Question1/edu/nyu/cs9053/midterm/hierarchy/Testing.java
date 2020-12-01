package edu.nyu.cs9053.midterm.hierarchy;


public class Testing {

	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug WinterSportPLayer objects
	 
	 Curler b = new Curler("Ann", 15,"red",20);
	 Curler c = new Curler("Ann", 15,"red",20);
	 Curler d = new Curler("Debpo", 15,"red",20);
	 Sledder e = new Sledder("Debpo", 15,"red");
	 Sledder f = new Sledder("Debpo", 15,"red");
	 Luger g = new Luger();
	 Luger h = new Luger();
	 IceSkater i = new IceSkater();
	 IceSkater j = new IceSkater();
	 SpeedSkater k = new SpeedSkater("Ann", 15,20, 20.3);
	 SpeedSkater l = new SpeedSkater("Ann", 15,20, 20.3);
	 SpeedSkater m = new SpeedSkater("debo", 15,20, 20.3);
	 
	 
	 
	 System.out.println(b.toString());
	 System.out.println(b.equals(c));
	 System.out.println(b.toString());
	 System.out.println(b.equals(d));
	 System.out.println(b.equals(e));
	 System.out.println(f.equals(e));
	 System.out.println(g.equals(h));
	 System.out.println(f.equals(h));
	 System.out.println(i.equals(j));
	 System.out.println(k.equals(l));
	 System.out.println(k.equals(m));
//	 System.out.println(f.equals(h));
	


	}

}
