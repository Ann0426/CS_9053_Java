package exceptions;
import java.io.*;

public class ReadIntoArray {
	public static void main(String[] args) { 
		int n=10; 
		int[] v = new int[n]; 
		FileReader f = null;
		f = new FileReader("data.txt");
		BufferedReader in = new BufferedReader(f); 
		int i=0; 
		String linea = in.readLine(); 
		while (linea!=null) { 
			v[i] = Integer.parseInt(linea); 
			linea = in.readLine(); 
			i++; 
		}
		f.close(); 
	}

}
