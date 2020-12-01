package exceptions;
import java.io.*;
import java.util.Scanner;

public class WriteOutput {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		FileWriter fout;
		try {
			fout = new FileWriter("outputfile.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter out = new BufferedWriter(fout);
		System.out.print("Input data: ");
		String ln = in.next();
		while (ln != null) {
			try {
				out.write(ln);
				out.newLine();
			} catch (IOException e) {
				System.err.println("Error writing to file: "+ e.getMessage());
				e.printStackTrace();
			}
			System.out.print("Input data: ");
			ln = in.next();
		}

	}
}
