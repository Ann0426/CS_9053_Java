import java.text.DecimalFormat;
import java.util.Objects;


public class Complex implements Cloneable{
		protected double real;
		protected double imaginary;
		
		public Complex() {
			this.real = 0;
			this.imaginary =0;	
		};
		public Complex(double b) {
			this();
			this.real = 0;
			this.imaginary = b;	
		};
		public Complex(double a,double b) {
			this();
			this.real = a;
			this.imaginary =b;	
		};
		public double getReal() {
			return this.real;
		}
		public double getImaginary() {
			return this.imaginary;
		}
		public Complex add(Complex c1) {
			this.real = this.real + c1.real;
	        this.imaginary = this.imaginary + c1.imaginary;
	        //returning the output complex number
	        return this;
		}
		public Complex subtract(Complex c1) {
			this.real = this.real - c1.real;
	        this.imaginary = this.imaginary - c1.imaginary;
	        //returning the output complex number
	        return this;
		}
		public Complex multiply(Complex complex) {
		        // (a + bi)*(c + di) = (ac - bd) + (bc + ad)i
			 this.real = this.real * complex.real - this.imaginary * complex.imaginary;
			 this.imaginary =  this.imaginary * complex.real + this.real * complex.imaginary;

		        return this;
		    }
	    public Complex divide(Complex complex) {
	        // (a+bi)/(c+di)=(ac+bd)/(c^2 +d^2)+(bc-ad)i/(c^2 +d^2)
	    	this.real = (this.real * complex.real + this.imaginary * complex.imaginary)/((Math.pow(complex.real, 2) + Math.pow(complex.imaginary, 2)));
	    	this.imaginary = (this.imaginary * complex.real - this.real * complex.imaginary)/((Math.pow(complex.real, 2) + Math.pow(complex.imaginary, 2)));

	    	return this;
	    }

	    public double abs() {
	        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imaginary, 2));
	    }

	    public String toString() {

	        if (imaginary == 0) return this.real + "";

	        DecimalFormat decimal = new DecimalFormat("#.###");
	        return  "(" + decimal.format(this.real) + " + " + decimal.format(this.imaginary) + "i)";

	    }
	    public Complex clone()throws CloneNotSupportedException{  
	    	return (Complex)super.clone();  
	       }
	    
	
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Complex)) {
				return false;
			}
			Complex other = (Complex) obj;
			return Double.doubleToLongBits(imaginary) == Double.doubleToLongBits(other.imaginary)
					&& Double.doubleToLongBits(real) == Double.doubleToLongBits(other.real);
		}
		public static void main(String[] args) {
//                Double testNan1 = new Double(5/0);
//                Double testNan = new Double(5) / new Double(0);
//                System.out.println(testNan);
        	Complex c1 = new Complex(5,3);
        	Complex c2 = new Complex(1,2);
        	
                System.out.println(c1.add(c2));
//                return;
        }

}
