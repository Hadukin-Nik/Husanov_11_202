public class ComplexVector2D {
	private ComplexNumber x;
	private ComplexNumber y;

	public ComplexVector2D() {
		x = new ComplexNumber();
		y = new ComplexNumber();
	}


	public ComplexVector2D(ComplexNumber x, ComplexNumber y) {
		this.x = x;
		this.y = y;
	}

	public ComplexVector2D add(ComplexVector2D other) {
		return new ComplexVector2D(x.add(other.x), y.add(other.y));
	}

	@Override
	public String toString() {
		return "x: " + x.toString() + " y: " + y.toString();
	}

	public double scalarProduct(ComplexVector2D a) {
		return x.mult(a.x).add(y.mult(a.y));
	}

	public boolean equals(ComplexVector2D a) {
		return (x.equals(a.x) && y.equals(a.y));
	}
}