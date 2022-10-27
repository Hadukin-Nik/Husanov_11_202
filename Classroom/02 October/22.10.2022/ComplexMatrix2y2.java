public class ComplexMatrix2by2 {
	private ComplexNumber arithmImpl;
	private Matrix2by2 matrixImpl;

	public int definition () {
		return matrixImpl.defenition();
	}

	
	
	public Matrix2by2 add(ComplexMatrix2by2 b) {
		Matrix2by2 c = matrixImpl.add(b.getMatrix());
		
		return c;
	}

	public Matrix2by2 multiply(ComplexMatrix2by2 b) {
		Matrix2by2 c = 
	}

	public Matrix2by2 getMatrix() {
		return matrixImpl;
	}

}