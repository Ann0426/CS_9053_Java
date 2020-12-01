package Question3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Matrix {
	double[][] mtx = null;
	
	public Matrix(int m, int n) {
		this.mtx = new double[m][n];
		
	}
	
	public int numRows() {
		return mtx.length;
	}
	
	public double[] getRow(int i) {
		return mtx[i];
	}
	
	public double getElement(int i, int j) {
		return mtx[i][j];
	}
	
	public void setElement(int i, int j, double val) {
		mtx[i][j] = val;
	}
	
	public int numColumns() {
		return mtx[0].length;
	}
	
	public void save(String filename) {
		
		FileWriter f = null;
		try {
			f = new FileWriter(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		BufferedWriter out = new BufferedWriter(f);
		try {
			out.write(this.numRows() + " " + this.numColumns() + "\n");
		} catch (IOException e) {
			System.err.println("IOException : " + e);
		}
		for (int i=0;i<mtx.length; i++) {
			String outString = "";
			for (int j=0; j < mtx[i].length ; j++) {
				outString += mtx[i][j] + " "; 
			}
			outString = outString.trim() + "\n";
			try {
				out.write(outString); 
			} catch (IOException e) {
				System.err.println("IOException : " + e +  " while writing out string " + outString);
			}
		}
		try {
			out.close();
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Matrix read(String filename) throws ExceptionWrongMatrixValues, ExceptionWrongMatrixDimension {
		Matrix result = null;
		FileReader f = null;
		try {
			f = new FileReader(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedReader in = new BufferedReader(f);
		String inLine = null;
		try {
			inLine = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (inLine != null) {
			String[] dims = inLine.split(" ");
			if (dims.length == 2) {
				try {
					int m = Integer.parseInt(dims[0]);
					int n = Integer.parseInt(dims[1]);
					result = new Matrix(m,n);
				} catch (NumberFormatException e) {
					System.err.println("problem with dimensions: " + e);
					throw new ExceptionWrongMatrixValues();
				}
				
			}
		} else {
			throw new ExceptionWrongMatrixValues("no matrix dimensions");
		}
		
		try {
			inLine = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int rownum = 0;
		while ((inLine != null) && (inLine.length() > 0)) {
			if (rownum >= result.numRows()) { 
				throw new ExceptionWrongMatrixDimension("Wrong Matrix Dimension. File " + filename + " says " + result.numRows() + 
						" rows. Additional line " + rownum + ": " + inLine);
			}
			String[] stringValues = inLine.split(" ");
			if (stringValues.length != result.numColumns()) {
				throw new ExceptionWrongMatrixDimension("Wrong Matrix Dimension. File " + filename + " says " + result.numColumns() + 
											" columns. File line " + rownum + ": " + inLine);
			}
			double[] doubleVals = new double[stringValues.length];
			
			for (int j=0;j < doubleVals.length ; j++) {
				result.setElement(rownum, j, doubleVals[j]);
			}
			try {
				inLine = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rownum++;
		}
		
		
		return result;
	}
	
	public Matrix sum(Matrix m) {
		Matrix result = null;
		if ((this.numRows() == m.numRows() ) && (this.numColumns() == m.numColumns())) {
			result = new Matrix(numRows(), numColumns());
			for (int i=0;i<mtx.length; i++) {
				for (int j=0; j < mtx[i].length ; j++) {
					result.setElement(i, j, (this.getElement(i, j) + m.getElement(i, j)));
				}
			}
			
		}
		return result;
	}
	
	// this will come in handy for the multiplication part
	public double[] getColumn(int j) {
		if (j >= this.numColumns()) {
			return null;
		}
		double[] col = new double[this.numRows()];
		for (int i=0; i<mtx.length; i++) {
			col[i] = mtx[i][j];
		}
		return col;
	}
	
	public Double dotproduct(double[] v1, double[] v2) {
		Double result = null;
		if (v1.length == v2.length) {
			result = 0.0;
			for (int i=0; i<v1.length ; i++) {
				result += v1[i] * v2[i];
			}
		}
		return result;
	}
	
	public Matrix product(Matrix m) {
		
		// this * m
		Matrix result = null;
		if ( (this.numColumns() == m.numRows()) && (this.numRows() == m.numColumns()) ) {
			result = new Matrix(this.numRows(), m.numColumns());
			for (int i=0 ;i< this.numRows(); i++) {
				double[] row = this.getRow(i);
				for (int j=0; j < m.numColumns(); j++) {
					double[] col = m.getColumn(j);
					Double dp = this.dotproduct(row,  col);
					if (dp == null) {
						return null;
					} else {
						result.setElement(i, j, dp.doubleValue());
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Matrix m1 = new Matrix(2,3);
		m1.setElement(0, 0, 1.0);
		m1.setElement(0, 1, 1.0);
		m1.setElement(0, 2, 1.0);
		m1.setElement(1, 0, 1.0);
		m1.setElement(1, 1, 1.0);
		m1.setElement(1, 2, 1.0);
		
		Matrix m2 = new Matrix(3,2);
		m2.setElement(0, 0, 2.0);
		m2.setElement(0, 1, 2.0);
		m2.setElement(1, 0, 2.0);
		m2.setElement(1, 1, 3.0);
		m2.setElement(2, 0, 3.0);
		m2.setElement(2, 1, 3.0);
		
		Matrix result = m1.product(m2);
		m1.save("m1");
		m2.save("m2");
		result.save("result");
		
		try {
			m1 = Matrix.read("m1");
			m2 = Matrix.read("m2");
			Matrix m3 = Matrix.read("result");
		} catch (Exception e) {
			System.err.println("error: " + e);
		}
		
		try {
			Matrix badMatrix = Matrix.read("wrongcolumns");
		} catch (ExceptionWrongMatrixDimension e1) {
			System.err.println("wrong dimensions: " + e1);
		} catch (ExceptionWrongMatrixValues e2) {

			System.err.println("wrong matrix values: " + e2);
		}
		

		try {
			Matrix badMatrix2 = Matrix.read("wrongrows");
		} catch (ExceptionWrongMatrixValues e) {

			System.err.println("wrong dimensions: " + e);
		} catch (ExceptionWrongMatrixDimension e) {
			System.err.println("wrong matrix values: " + e);
		}
		
		return;
		
		
	}
	
}
