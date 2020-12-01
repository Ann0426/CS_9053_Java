public class ExceptionWrongMatrixDimension extends Exception {

	public ExceptionWrongMatrixDimension() {

		super("Wrong Matrix Dimension Error");
	}
	
	public ExceptionWrongMatrixDimension(String msg) {

		super(msg);
	}
}
