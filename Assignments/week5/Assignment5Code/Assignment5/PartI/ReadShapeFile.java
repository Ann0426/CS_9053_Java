import java.io.*;
import java.util.ArrayList;

import shapes.*;
class ShapeException extends Exception 
{
   
   public ShapeException(String msg) 
   {
      super(msg);
   }
}

/* your tasks:
 * create a class called ShapeException
 * createShape should throw a ShapeException
 * in main(), you should catch the ShapeException
 * 
 */
public class ReadShapeFile {

	public static GeometricObject createShape(String shapeName) throws ShapeException {
		
			 if (shapeName.equals("Circle")) return new Circle();
			 if (shapeName.equals("Square")) return new Square();
			 if (shapeName.equals("Rectangle")) return new Rectangle();
			 else {
				 throw new ShapeException("Cannot create shape");
					  
			 }}

		 
		
		/* if shapeName is "Circle" return Circle();
		 * if shapeName is "Square" return Square();
		 * if shapeName is "Rectangle" return Rectangle();
		 * if it is not any one of these, it should throw
		 * a ShapeException
		 */
		

	
	public static void main(String[] args) throws FileNotFoundException,IOException  {
		ArrayList<GeometricObject> shapeList = new ArrayList<GeometricObject>();
		File f = new File("shapes.txt");
		FileReader fr = null;
		BufferedReader in = null;
		fr = new FileReader(f);
		in = new BufferedReader(fr); 
		 
		
		String linea = in.readLine(); 
		
		/* create a loop to read the file line-by-line */
		
		int numLines = 0;
			
        while (linea  != null) {
        	try {
        	GeometricObject shape = createShape(linea);
           
            shapeList.add(shape);
            System.out.println(shapeList.get(numLines));
            
            numLines++;
           
        	}catch ( ShapeException  se) {
    		System.err.println("Cannot create shape: " + linea);
    		}
    		finally{
    			
    			linea = in.readLine(); 
    			}
        	 //return;
        }
        System.out.println("size of the shapeList: " + shapeList.size());
        in.close();
   	 	fr.close();
			
		} 
 
	}

