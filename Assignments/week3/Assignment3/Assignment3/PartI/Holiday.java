
public class Holiday {
	private String name;
	private int day;
	private String month;
	
	
	public Holiday(String name, int day, String month) {
		this.name = name;
		this.day = day;
		this.month = month;
		
	}
	
	public static boolean inSameMonth(Holiday h1, Holiday h2) {
		if(h1.month == h2.month) return true;
		return false;
	}
	
	public static double avgDate(Holiday[] holidays) {
		double avgDate = 0.0;
		for(int i =0; i < holidays.length; i++) {
			avgDate += holidays[i].day;
		}
		return avgDate/holidays.length;
		
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDay() {
		return this.day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getMonth() {
		return this.month;
	}
	public void getMonth(String month) {
		this.month = month;
	}
//	public Holiday addUp (Holiday h ) {
//		int addDay = h.day + this.day;
//		String addName = h.name + this.name;
//		String addMonth = h.month + this.month;
//		Holiday addHoli = new Holiday(addName, addDay, addMonth);
//		return  new Holiday(h.name + this.name, 
//				h.day + this.day, 
//				h.month + this.month);
//	}
	public String toString() {
		return "\"" + this.name + ": " + this.month + " " + Integer.toString(this.day) + "\"" ; 
	}
	public static void main(String[] args) {
		
		Holiday[] holidays = new Holiday[5];
		Holiday independence = new Holiday("Independence Day", 4 , "July");
		holidays[0] = new Holiday("May Day", 1, "May");
		holidays[1] = new Holiday("Fri Day", 2, "May");
		holidays[2] = new Holiday("Ju Day", 1, "July");
		holidays[3] = new Holiday("Mon Day", 1, "Mon");		
		holidays[4] = new Holiday("Call it a Day", 1, "call");
		System.out.println(independence);
		
	}
}

