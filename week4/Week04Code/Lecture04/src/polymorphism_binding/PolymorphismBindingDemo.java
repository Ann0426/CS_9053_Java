package polymorphism_binding;
import People.GraduateStudent;
import People.Student;
import People.Person;

public class PolymorphismBindingDemo {
	
	public static void main(String[] args) {
		PolymorphismBindingDemo d = new PolymorphismBindingDemo();
		m(new GraduateStudent());
		m(new Student());
		m(new Person());
		m(new Object());
  }

  public static void m(Object x) {
    System.out.println(x.toString());
  }
}


