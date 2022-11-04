public class RationalComplexMatrix2x2 {
	private RationalComplexNumber[][] matrix;

	public RationalComplexMatrix2x2() {
		matrix = new RationalComplexNumber[2][2];
	}

	public RationalComplexMatrix2x2(RationalComplexNumber number) {
		this();

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				matrix[i][j] = number.copy();
			}
		}
	}

	public RationalComplexMatrix2x2(RationalComplexNumber a, RationalComplexNumber b, RationalComplexNumber c, RationalComplexNumber d) {
		this();

		matrix[0][0] = a;
		matrix[0][1] = b;
		matrix[1][0] = c;
		matrix[1][1] = d;
	}

	public RationalComplexMatrix2x2 add (RationalComplexMatrix2x2 other) {
		RationalComplexMatrix2x2 m = new RationalComplexMatrix2x2();

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				m[i][j] = matrix[i][j].add(other[i][j]);
			}
		}

		return m;
	}


	//code duplication... Can we use interfaces?
	RationalComplexMatrix2x2 mult(RationalComplexMatrix2x2 other) {
		RationalComplexNumber[][] ansMatrix = new RationalComplexNumber[2][2];

		for (int i = 0; i < 2; i++) {	
			for (int e = 0; e < 2; e++) {
				RationalComplexNumber a = new RationalComplexNumber();

				for (int j = 0; j < 2; j++) {
					a.addToSelf(this.matrix[i][j].mult(b.matrix[e][j]) );	
				}
				ansMatrix[i][e] = a;
			}
		}

		return (new RationalComplexMatrix2x2(ansMatrix));
	}

	public RationalComplexNumber defenition () {
		return (matrix[0][0].mult(matrix[1][1])).sub(matrix[0][1].mult(matrix[1][0]);
	}

	public RationalComplexVector2D multVector(RationalComplexVector2D a) {
		RationalComplexNumber b = a.getX().mult(matrix[0][0]).add(a.getY().mult(matrix[0][1]);
		RationalComplexNumber c = a.getX().mult(matrix[1][0]).add(a.getY().mult(matrix[1][1]);
		
		RationalComplexVector2D ans = new RationalComplexVector2D(b, c);

		return ans;
	}
}