public class RationalComplexVector2D {
	private RationalComplexNumber x;
	private RationalComplexNumber y;

	RationalComplexVector2D() {
		x = new RationalComplexNumber();
		y = new RationalComplexNumber();
	}

	RationalComplexVector2D(RationalComplexNumber x, RationalComplexNumber y) {
		this.x = x;
		this.y = y;
	}

	RationalComplexVector2D add(RationalComplexVector2D other) {
		return new RationalComplexVector2D(x.add(other.x), y.add(other.y));
	}

	@Override
	String toString() {
		return "X: " + x.toString() + " Y: " + y.toString();
	}

	public RationalComplexNumber scalarProduct(RationalComplexVector2D a) {
		return x.mult(a.x).addToSelf(y.mult(a.y));
	}
}