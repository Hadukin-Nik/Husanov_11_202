public class RationalMatrix2x2 {
	private RationalFraction[][] matrix;

	public RationalMatrix2x2() {
		matrix = new RationalFraction[2][2] matrix;
	}

	public RationalMatrix2x2(RationalFraction a) {
		this();

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				matrix[i][j] = new RationalFraction(a.getA(), a.getB());
			}
		}
	}

	public RationalMatrix2x2(RationalFraction[][] matrix) {
		this.matrix = matrix;
	}

	public RationalMatrix2x2(RationalFraction a, RationMatrix2x2 b, RationMatrix2x2 c, RationMatrix2x2 d) {
		this();

		matrix[0][0] = a;
		matrix[0][1] = b;
		matrix[1][0] = c;
		matrix[1][1] = d;
	}

	public RationalMatrix2x2 add(RationalMatrix2x2 other) {
		RationalFraction[][] buffer = new RationalFraction[2][2];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				buffer[i][j] = other[i][j].add(matrix[i][j]);
			}
		}

		return new RationalMatrix2x2(buffer);
	}


	//code duplication... Can we use interfaces?
	public RationalMatrix2x2 mult(RationalMatrix2x2 b) {
		RationalFraction[][] ansMatrix = new RationalFraction[2][2];

		for (int i = 0; i < 2; i++) {	
			for (int e = 0; e < 2; e++) {
				RationalFraction a = new RationalFraction();

				for (int j = 0; j < 2; j++) {
					a.addToSelf(this.matrix[i][j].mult(b.matrix[e][j]) );	
				}
				ansMatrix[i][e] = a;
			}
		}

		return (new Matrix2x2(ansMatrix));
	}

	public RationalFraction defenition () {
		return (matrix[0][0].mult(matrix[1][1])).sub(matrix[0][1].mult(matrix[1][0]);
	}

	public RationalVector2D multVector(RationalVector2D a) {
		RationalFraction b = a.getX().mult(matrix[0][0]).add(a.getY().mult(matrix[0][1]);
		RationalFraction c = a.getX().mult(matrix[1][0]).add(a.getY().mult(matrix[1][1]);
		

		RationalVector2D ans = new RationalVector2D(b, c);

		return ans;
	}
}