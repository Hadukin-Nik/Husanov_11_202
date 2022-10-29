public class Matrix2x2 {
	private double[][] matrix;

	public Matrix2x2() {
		matrix = new double[2][2];
	}

	public Matrix2x2(double a) {
		this();

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				matrix[i][j] = a;
			}
		}
	}

	public Matrix2x2(double[][] matrix) {
		if (matrix.length != 2 || matrix[0].length != 2) {
			System.out.print("ERROR!");
		}

		this.matrix = matrix;
	}

	public Matrix2x2(double a, double b, double c, double d) {
		super();

		matrix[0][0] = a;
		matrix[0][1] = b;
		matrix[1][0] = c;
		matrix[1][1] = d;
	}

	public double defenition () {
		return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
	}

	public Matrix2x2 add (Matrix2x2 another) {
		Matrix2x2 ans;
		double[][] ansMatrix = new double[2][2];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				ansMatrix[i][j] = this.matrix[i][j] + another.matrix[i][j];	
			}
		}

		return new Matrix2x2(ansMatrix);
	}

	public void addToSelf(Matrix2x2 other) {
		matrix = add(other).matrix;
	}

	public Matrix2x2 sub (Matrix2x2 another) {
		Matrix2x2 ans;
		double[][] ansMatrix = new double[2][2];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				ansMatrix[i][j] = this.matrix[i][j] - another.matrix[i][j];	
			}
		}

		return new Matrix2x2(ansMatrix);
	}

	public void subFromSelf(Matrix2x2 other) {
		matrix = add(other).matrix;
	}

	public Matrix2x2 multiply(Matrix2x2 b) {
		Matrix2x2 ans;
		double[][] ansMatrix = new double[2][2];

		for (int i = 0; i < 2; i++) {	
			for (int e = 0; e < 2; e++) {
				double a = 0;
				for (int j = 0; j < 2; j++) {
					a += this.matrix[i][j] * another.matrix[e][j];	
				}
				ansMatrix[i][e] = a;
			}
			
		}

		return new Matrix2x2(ansMatrix);
	}

	public void multiplySelf(Matrix2x2 b) {
		matrix = multiply(b).matrix;
	}

	public Matrix2x2 multiplyOnNumber(double b) {
		Matrix2x2 ans;
		double[][] ansMatrix = new double[2][2];

		for (int i = 0; i < 2; i++) {	
			for (int e = 0; e < 2; e++) {
				ansMatrix[i][e] = matrix[i][e] * b;
			}
		}

		return new Matrix2x2(ansMatrix);
	}

	public void multiplyOnNumberSelf(double b) {
		matrix = multiplyOnNumber(b).matrix;
	}

	public void transpon() {
		double[][] b = new double[2][2];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				b[j][i] = matrix[i][j]
			}
		}

		matrix = b;
	}

	public Matrix2x2 inverseMatrix() {
		double[][] b = new double[2][2];
		double d = defenition();

		if (d == 0) {
			return new Matrix2x2(b);
		}

		b = transpon();

		for (int i =0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				b[i][j] /= d;
			}
		}
		
		return new Matrix2x2(b);
	}

	public Matrix2x2 equivalentDiagonal() {
		double[][] b = new double[2][2];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				b[i][j] = matrix[i][j];
			}
		}

		b[1][1] -= b[1][0] / b[0][0] * b[0][1];
		b[0][1] = 0;

		b[1][0] = 0;

		return new Matrix2x2(b);
	}

	public Vector2D multVector(Vector2D a) {
		int b = a.getX() * matrix[0][0] + a.getY() * matrix[0][1];
		int c = a.getX() * matrix[1][0] + a.getY() * matrix[1][1];
		

		Vector2D ans = new Vector2D(b, c);

		return ans;
	}
}