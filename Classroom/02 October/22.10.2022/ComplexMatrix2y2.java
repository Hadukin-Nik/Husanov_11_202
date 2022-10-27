public class ComplexMatrix2by2 {
	private ComplexNumber arithmImpl;
	private Matrix2by2 matrixImpl;

	
	ComplexMatrix2by2(ComplexNumber arithmImpl, Matrix2by2 matrixImpl) {
		this.arithmImpl = arithmImpl;
		this.matrixImpl = matrixImpl;
	}

	ComplexMatrix2by2(ComplexNumber arithmImpl) {
		this.arithmImpl = arithmImpl;

		Matrix2by2 a = new Matrix2by2(arithmImpl.getA(), 0, arithmImpl.getA(), 0);
		Matrix2by2 b = new Matrix2by2(arithmImpl.getB(), 0, arithmImpl.getB(), 0);
		Matrix2by2 i = new Matrix2by2(0, 1, -1, 0);

		this.matrixImpl = (a.add(b.multiply(i)))
	}

	public int definition () {
		return matrixImpl.defenition();
	}
	
	public ComplexMatrix2by2 add(ComplexMatrix2by2 b) {
		Matrix2by2 c = matrixImpl.add(b.getMatrix());
		ComplexNumber e = arithmImpl.add(b.getAritm());

		return new ComplexMatrix2by2(e, c);
	}

	public ComplexMatrix2by2 multiply(ComplexMatrix2by2 b) {
		Matrix2by2 c = matrixImpl.multiply(b.getMatrix());
		ComplexNumber e = arithmImpl.multiply(b.getAritm());

		return new ComplexMatrix2by2(e, c)
	}

	public Matrix2by2 getMatrix() {
		return matrixImpl;
	}

	public ComplexNumber getAritm() {
		return arithmImpl;
	} 
}