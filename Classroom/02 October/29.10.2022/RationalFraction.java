public class RationalFraction {
	private int a;
	private int b;

	RationalFraction() {
		a = 0;
		b = 1;
	}

	RationalFraction(int a, int b) {
		this.a = a;
		this.b = b;
	}

	private double sqrt(double a) {
		double l = 0;
		double r = a;

		if (l > r) {
			double b = l;
			l = r;
			r = b;
		}

		while(r - l > 0.00001) {
			double m = (l + r) / 2;

			if (m * m > a) {
				r = m;
			} else {
				l = m;
			}
		}

		return l;
	}

	private double finder(double a, double c) {
		int l = 0;
		int r = a;

		if (l > r) {
			int b = l;
			l = r;
			r = b;
		}

		while(r - l > 1) {
			int m = (l + r) / 2;

			if (a % (m * c) != 0) {
				r = m;
			} else {
				l = m;
			}
		}

		return l;
	}

	public void reduce() {
		int c = 2;
		while (c < sqrt(a) && c < sqrt(b)) {
			a /= c * finder(a, c);
			b /= c * finder(b, c);

			c++;
		}
	}

	public RationalFraction add(RationalFraction c) {
		RationalFraction m = new RationalFraction(c.a * b + c.b * b, c.b * b);
		m.reduce();

		return m;
	}	

	public void addToSelf(RationalFraction c) {
		RationalFraction m = add(c);

		this.a = m.a;
		this.b = m.b;
	}	

	public RationalFraction sub(RationalFraction c) {
		RationalFraction m = new RationalFraction(c.a * b - c.b * b, c.b * b);
		m.reduce();

		return m;
	}	

	public void subFromSelf(RationalFraction c) {
		RationalFraction m = sub(c);

		this.a = m.a;
		this.b = m.b;
	}	


	public RationalFraction mult(RationalFraction c) {
		RationalFraction m = new RationalFraction(c.a * a, c.b * b);
		m.reduce();

		return m;
	}	

	public void multToSelf(RationalFraction c) {
		RationalFraction m = mult(c);

		this.a = m.a;
		this.b = m.b;
	}

	public RationalFraction div(RationalFraction c) {
		RationalFraction m = new RationalFraction(c.a * b, c.b * a);
		m.reduce();

		return m;
	}	

	public void divFromSelf(RationalFraction c) {
		RationalFraction m = div(c);

		this.a = m.a;
		this.b = m.b;
	}

	public double value() {
		return (double)(a * 1.0 / b * 1.0)
	}

	public boolean equals(RationalFraction c) {
		return ((a * c.b) / (b * c.a) == 1);
	}

	public int numberPart() {
		return a / b;
	}

	@Override
	public String toString() {
		System.out.println(a + " / " + b);
	}
}