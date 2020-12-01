package exceptions;
import java.io.*;

public class ExceptionExample {
	
	public static void main(String[] args) { 
		int n=10; 
		int[] v = new int[n]; 
		File f = new File("data.txt");
		FileReader fr = null;
		BufferedReader in = null;
		fr = new FileReader(f);
		in = new BufferedReader(fr); 

		int numLines=0; 
		double numFives = 0;
		String linea = in.readLine(); 
		while (linea!=null) {
			if (linea.trim() != "") {
				System.out.println(linea);
				numLines++;
				if (linea.contains("5")) {
					numFives++;
				}
			}
			linea = in.readLine();
		}
		System.out.println("done");
		System.out.println("fraction of lines with 5 in them = " + numFives/numLines);

		fr.close(); 

	
	}
}
