public class RationalVector2D {
	private RationalFraction x;
	private RationalFraction y;

	public RationalVector2D() {
		x = new RationalFraction();
		y = new RationalFraction();
	}

	public RationalVector2D(RationalFraction x, RationalFraction y) {
		this.x = x;
		this.y = y;
	}

	public RationalVector2D add(RationalVector2D other) {
		return new RationalVector2D(other.x.add(x), other.y.add(y));
	}

	@Override
	public String toString() {
		String a = "x: " + x.toString() + " y: " + y.toString();

		return a;
	}

	private double sqrt(double a) {
		double l = 0;
		double r = a;

		if (l > r) {
			double b = l;
			l = r;
			r = b;
		}

		while(l - r > 0.00001) {
			double m = (l + r) / 2;

			if (m * m > a) {
				r = m;
			} else {
				l = m;
			}
		}

		return l;
	}

	double length() {
		return sqrt(x.value() * x.value() + y.value() * y.value());
	}

	public double scalarProduct(RationalVector2D a) {
		return x.mult(a.x) + y.mult(a.y);
	}

	public boolean equals(RationalVector2D other) {
		return (x.equals(other.x) && y.equals(other.y));
	}

}