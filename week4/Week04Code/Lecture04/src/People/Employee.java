package People;
class Employee extends Person {

	public Employee() {
	    this("(2) Invoke Employee’s overloaded constructor");
	    System.out.println("(3) Employee's no-arg constructor is invoked");
	 }
	
	 public Employee(String s) {
	    System.out.println(s);
	 }
}