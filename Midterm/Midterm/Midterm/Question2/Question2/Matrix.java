package Question2;
import java.io.*;

class ExceptionWrongMatrixDimension extends Exception {
	public ExceptionWrongMatrixDimension(String msg) {

		super(msg);
	}
}
class ExceptionWrongMatrixValues extends Exception {

	public ExceptionWrongMatrixValues(String msg) {

		super(msg);
	}
}



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
		FileWriter fout = null;
		
		try {
			
			fout = new FileWriter(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter out = new BufferedWriter(fout);
		
		try {
			out.write(this.numRows() + " " + this.numColumns() + "\n");
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
		} catch (IOException e) {
			System.err.println("Error writing to file: "+ e.getMessage());
			e.printStackTrace();
		}finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                try {
        			out.close();
        			fout.close();
        		} catch (IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
            } else {
                System.out.println("PrintWriter not open");
            }
        }
		
		
		
		
	}
	
	public static Matrix read(String fileName) throws FileNotFoundException, IOException, ExceptionWrongMatrixValues, ExceptionWrongMatrixDimension {
		Matrix result = null;
		
		FileReader fr = null;
		BufferedReader in = null;
		String linea = null;
		try {
			File f = new File(fileName);
			fr = new FileReader(f);
			in = new BufferedReader(fr); 
			
		} catch(FileNotFoundException fnfe) {
            System.err.println("File: " + fileName + " not found.");
      } 
            catch (IOException ioe) {
            System.err.println(ioe.toString());
        }
		int count = 0;
		linea = in.readLine(); 
        while(linea != null) {
			try {
				if(count == 0) {
					String[] dims = linea.split(" ");
					int m = Integer.parseInt(dims[0]);
					int n = Integer.parseInt(dims[1]);
					result = new Matrix(m,n);
				} else {
					throw new ExceptionWrongMatrixValues("no matrix dimensions");
				}
				
			}catch (NumberFormatException e) {
				System.err.println("problem with dimensions: " + e.getMessage());
				throw new ExceptionWrongMatrixValues("Wrong Matrix Values");
			}
			int rownum = 0;
		while ((linea != null) && (linea.length() > 0)) {
			if (rownum >= result.numRows()) { 
				throw new ExceptionWrongMatrixDimension("Wrong Matrix Dimension. File " + fileName + " says " + result.numRows() + 
						" rows. Additional line " + rownum + ": " + linea);
			}
			String[] stringValues = linea.split(" ");
			if (stringValues.length != result.numColumns()) {
				throw new ExceptionWrongMatrixDimension("Wrong Matrix Dimension. File " + fileName + " says " + result.numColumns() + 
											" columns. File line " + rownum + ": " + linea);
			}
			double[] doubleVals = new double[stringValues.length];
			
			for (int j=0;j < doubleVals.length ; j++) {
				result.setElement(rownum, j, doubleVals[j]);
			}
			try {
			linea = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.toString());}
			rownum++;
		}
   
        in.close();
		
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
		Matrix result = null;
		if ( (this.numColumns() == m.numRows()) && (this.numRows() == m.numColumns()) ) {
			result = new Matrix(this.numRows(), m.numColumns());
			for (int i=0 ;i< this.numRows(); i++) {
				double[] row = this.getRow(i);
				for (int j=0; j < m.numColumns(); j++) {
					double[] col = m.getColumn(j);
					Double dp = this.dotproduct(row,  col);
					result.setElement(i, j, dp.doubleValue());
			}
		}
}
	
	return result;}

	
	public static void main(String[] args) throws FileNotFoundException, IOException {
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
