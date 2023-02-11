public class ComplexNumber {
	private final double eps = 0.00001;

	private double imaginable;
	private double real; 



	ComplexNumber() {
		imaginable = 0;
		real = 0;
	}

	ComplexNumber(double real, double imaginable) {
		this.imaginable = imaginable;
		this.real = real;
	}

	public ComplexNumber add(ComplexNumber a) {
		return new ComplexNumber(a.imaginable + imaginable, a.real + real);
	}

	public void addToSelf(ComplexNumber a) {
		imaginable += a.imaginable;
		real += a.real;
	}

	public ComplexNumber sub(ComplexNumber a) {
		return new ComplexNumber(a.imaginable - imaginable, a.real - real);
	}

	public void subFromSelf(ComplexNumber a) {
		imaginable -= a.imaginable;
		real -= a.real;
	}

	public ComplexNumber multNumber(double a) {
		return new ComplexNumber(a * imaginable, a * real);
	}

	public void multNumberToSelf(double a) {
		imaginable *= a;
		real *= a;
	}

	public ComplexNumber mult(ComplexNumber a) {
		return new ComplexNumber(-this.imaginable * a.imaginable + this.real * a.real, this.real * a.imaginable + a.real * this.imaginable);
	}

	public void multToSelf(ComplexNumber a) {
		ComplexNumber c = mult(a);
		this.real = c.real;
		this.imaginable = c.imaginable;
	}

	public ComplexNumber div(ComplexNumber a) {
		ComplexNumber c = new ComplexNumber();
		c.real = (real * a.real + imaginable * a.imaginable) / (real * real + a.imaginable * a.imaginable);
		c.imaginable = (imaginable * a.real - real * a.imaginable) / (real * real + a.imaginable * a.imaginable);

		return c;
	}

	public void divSelf(ComplexNumber a) {
		ComplexNumber c = div(a);
		this.real = c.real;
		this.imaginable = c.imaginable;
	}

	private double sqrt(double a) {
		double l = 0;
		double r = a;

		if (l > r) {
			double b = l;
			l = r;
			r = b;
		}

		while(r - l > eps) {
			double m = (l + r) / 2;

			if (m * m > a) {
				r = m;
			} else {
				l = m;
			}
		}

		return l;
	}

	public double length() {
		return sqrt(real * real + imaginable * imaginable);
	}

	public double arg() {
		return (real) / length();
	}

	private double sin() {
		return 1 - arg() * arg();
	}

	public ComplexNumber pow(double a) {
		double e = Math.pow(length(), a) ;
		return new ComplexNumber(e * Math.cos(Math.acos(arg()) * a), e * Math.sin(Math.acos(arg()) * a))
	}

	public boolean equals(ComplexNumber a) {
		return a.imaginable - imaginable < eps && b.real - real < eps;
	}

	@Override 
	public String toString() {
		return real + "" + (imaginable < 0 ? "" : "+") + b + "i";
	}

	public double getRe() {
		return real;
	}

	public double getIm() {
		return imaginable;
	}
}