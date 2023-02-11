public class ComplexNumber {
	private double a, b;

	ComplexNumber(double a, double b) {
		this.a = a;
		this.b = b;
	}

	ComplexNumber() {
		this.a = 0;
		this.b = 0;
	}

	public ComplexNumber add(ComplexNumber another) {
		ComplexNumber ans = new ComplexNumber(this.a + another.getA(), this.b + another.getB());

		return ans;
	}

	public ComplexNumber subtract(ComplexNumber another) {
		ComplexNumber ans = new ComplexNumber(this.a - another.getA(), this.b - another.getB());

		return ans;
	}

	public ComplexNumber multiply(ComplexNumber another) {
		ComplexNumber ans = new ComplexNumber(-this.b * another.getB() + this.a * another.getA, this.a * another.getB() + another.getA() * this.b);

		return ans;
	}



	public double getA() {
		return a;
	}

	public double getB() {
		return b;
	}
}