public class RationMatrix2x2 {
	private RationalFraction[][] matrix;

	public RationMatrix2x2() {
		matrix = new RationalFraction[2][2] matrix;
	}

	public RationMatrix2x2(RationalFraction a) {
		this();

		for (int i =0; i < 2; i++) {
			matrix[i][0] = a;
			matrix[i][1] = a;
		}
	}
}