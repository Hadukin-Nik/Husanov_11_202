public class Matrix2by2 {
	private double[][] matrix;

	Matrix2by2 (double[][] matrix) {
		this.matrix = matrix;
	}

	Matrix2by2 (double a, double b, double c, double d) {
		matrix = new double[2][2];

		matrix[0][0] = a;
		matrix[0][1] = b;
		matrix[1][0] = c;
		matrix[1][1] = d;
	}

	Matrix2by2 () {
	}



	double det () {
		return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
	}

	Matrix2by2 add (Matrix2by2 another) {
		Matrix2by2 ans;
		double[][] ansMatrix = new double[2][2];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				ansMatrix[i][j] = this.matrix[i][j] + another.matrix[i][j];	
			}
		}

		return new Matrix2by2(ansMatrix);
	}

	public double[][] getMatrix() {
		return matrix;
	}
}