import java.util.ArrayList;
import java.util.Collection;
import javafx.util.Pair;

public class ResultPrinter implements MathOperation {

	MathOperation op;
	
	public ResultPrinter(MathOperation op) {
		this.op = op;
	}
	
	public double operation(double a, double b) {
		return a + b;
	}

	
	public void go(double a, double b) {
		double c = operation(a,b) ;
		System.out.println("the addition result is  " + c);
	}
	static MathOperation multiplication = (double a, double b) -> { return a * b; };
	public static double go(double a, double b, MathOperation op) {
		return op.operation(a, b);
	}
	static MathOperation division = (double a, double b) -> a / b;
	public static void go(Collection<Pair<Double,Double>> c, MathOperation op) {

		 c.forEach((Pair i) -> 	System.out.println("the division result is " + op.operation((double) i.getKey(), (double)i.getValue())));
		
	}
		 

	
	public static void main(String[] args) {
		MathOperation addition = (double a, double b) -> a + b;
		ResultPrinter rp = new ResultPrinter(addition);
		rp.go(3.0, 4.0);
		
		System.out.println("the multiplication result is " + ResultPrinter.go(4.0, 2.0, multiplication));
		  
		
		ArrayList<Pair<Double,Double>> al = new ArrayList<Pair<Double,Double>>();
		Pair<Double, Double> p = new Pair<Double, Double>(3.0, 4.0);
		al.add(p);
		p = new Pair<Double, Double>(5.0, 6.0);
		al.add(p);
		p = new Pair<Double, Double>(7.0, 8.0);
		al.add(p);
		
		ResultPrinter.go(al, division);
		
	}

	
	
}
