public class ComplexMatrix2x2 {
	private ComplexNumber[][] matrix;

	public ComplexMatrix2x2() {
		matrix = new ComplexMatrix2x2[2][2];
	}

	public ComplexMatrix2x2(ComplexNumber number) {
		this();

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				matrix[i][j] = new ComplexNumber(number.getRe(), number.getIm());
			}
		}
	}

	public Matrix2x2(ComplexNumber a, ComplexNumber b, ComplexNumber c, ComplexNumber d) {
		this(); 
		
		matrix[0][0] = a;
		matrix[0][1] = b;
		matrix[1][0] = c;
		matrix[1][1] = d;
	}

	public ComplexMatrix2x2 add(ComplexMatrix2x2 other) {
		ComplexNumber[][] ansMatrix = new ComplexNumber[2][2];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				ansMatrix[i][j] = this.matrix[i][j].add(other.matrix[i][j]);	
			}
		}

		return new ComplexMatrix2x2(ansMatrix);
	}

	public ComplexMatrix2x2 mult(ComplexMatrix2x2 b) {
		ComplexNumber[][] ansMatrix = new ComplexNumber[2][2];

		for (int i = 0; i < 2; i++) {	
			for (int e = 0; e < 2; e++) {
				ComplexNumber a = new ComplexNumber();

				for (int j = 0; j < 2; j++) {
					a.addToSelf(this.matrix[i][j].add(b.matrix[e][j]));	
				}
				ansMatrix[i][e] = a;
			}
		}

		return (new ComplexMatrix2x2(ansMatrix));
	}

	public ComplexNumber defenition() {
		return (matrix[0][0].mult(matrix[1][1])).sub(matrix[0][1].mult(matrix[1][0]);
	}

	public ComplexVector2D multVector(ComplexVector2D a) {
		ComplexNumber b = a.getX().mult(matrix[0][0]).addToSelf(a.getY().mult(matrix[0][1]);
		ComplexNumber c = a.getX().mult(matrix[1][0]).addToSelf(a.getY().mult(matrix[1][1]);
		

		ComplexVector2D ans = new ComplexVector2D(b, c);

		return ans;
	}
}