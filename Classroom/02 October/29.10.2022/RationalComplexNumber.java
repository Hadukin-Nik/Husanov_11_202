public class RationalComplexNumber {
	private RationalFraction real;
	private RationalFraction imaginable;

	public RationalComplexNumber () {
		real = new RationalFraction();
		imaginable = new RationalFraction();
	}

	public RationalComplexNumber(RationalFraction real, RationalFraction imaginable) {
		this.real = new RationalFraction(real.getA(), real.getB());
		this.imaginable = new RationalFraction(imaginable.getA(), imaginable.getB());
	}

	public RationalComplexNumber add (RationalComplexNumber other) {
		return new RationalComplexNumber(a.imaginable.add(imaginable), a.real.add(real));
	}

	public RationalComplexNumber addToSelf (RationalComplexNumber other) {
		RationalComplexNumber buffer = add(other);

		real = buffer.real;
		imaginable = buffer.imaginable;
	}

	RationalComplexNumber sub(RationalComplexNumber other) {
		return new RationalComplexNumber(a.imaginable.sub(imaginable), a.real.sub(real));
	}

	RationalComplexNumber mult(RationalComplexNumber other) {
		return new ComplexNumber(this.real.mult(other.real).sub(this.imaginable.mult(other.imaginable)), this.real.mult(other.imaginable).add(other.real.mult(this.imaginable));
	}

	@Override
	public String toString() {
		return "Real: "  + real.toString() + " Imaginable: " + (imaginable.toString()) + "i";
	}

	public RationalFraction getRe() {
		return real;
	}

	public RationalFraction getIm() {
		return imaginable;
	}
}