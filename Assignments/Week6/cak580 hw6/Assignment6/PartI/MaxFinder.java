import java.util.ArrayList;

public class MaxFinder< T extends Number > {
		

		ArrayList<T> a = new ArrayList<T>();
		
		
		public MaxFinder() { 
	
		}
       

		public T max() {
        	T max = (T) this.a.get(0);
        	for (int i = 1; i < this.a.size(); i++){ 
        		double c = Double.parseDouble(a.get(i).toString());
        		double d = Double.parseDouble(max.toString());
	        	if (c -d > 0){
	        			max = (T) a.get(i); 
	        		}
        	}
        	return max;	
        }
       
		public void adding(T t) {

        	this.a.add(t);

                
        }
		public void adding(Complex t) {
        	this.a.add( (T)(Number)t.real);
                
        }

			
		
        
        public static void main (String[] args) {
                MaxFinder<Number>m = new MaxFinder<Number>();
                Complex n1 = new Complex(20.0,5.0);
                Integer a = new Integer(5);
                Double d= new Double(3.0);
                m.adding(n1);
                m.adding(a);
                m.adding(d);
                Number max = m.max();
                System.out.println("max for m is "+ max);
                MaxFinder<Integer> m1 = new MaxFinder<Integer>();
                Integer b = new Integer(10);
                Integer c = new Integer(20);
                m1.adding(b);
                m1.adding(c);
                Integer max1 = m1.max();
                System.out.println("max for m1 is "+ max1);
                
        }


		




}
