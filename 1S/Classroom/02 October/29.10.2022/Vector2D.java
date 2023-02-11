public class Vector2D {
	private double x;
	private double y;

	Vector2D() {
		x = 0;
		y = 0;
	}

	Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector2D add (Vector2D another) {
		return new Vector2D(another.x + this.x, another.y + this.y);
	}

	public void addToThis(Vector2D another) {
		this.x += another.x;
		this.y += another.y;
	}

	public Vector2D sub (Vector2D another) {
		return new Vector2D(another.x + this.x, another.y + this.y);
	}

	public void subFromThis(Vector2D another) {
		this.x -= another.x;
		this.y -= another.y;
	}

	public Vector2D mult (double number) {
		return new Vector2D(this.x * number, this.y * number);
	}

	public void multThis (double number) {
		this.x *= number;
		this.y *= number;
	}

	public double lengthSquare() {
		return (x*x + y*y);
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

	public double lengthSqrt() {
		return sqrt(x*x + y*y);
	}

	public double scalarProduct(Vector2D a) {
		return x * a.x + y * a.y;
	}

	public double cos(Vector2D a) {
		return (scalarProduct(a) / (a.lengthSqrt() * this.lengthSqrt()));
	}

	public boolean equals(Vector2D a) {
		return a.x == x && a.y == y;
	}

	@Override
	public String toString() {
		return ("X: " + x + " Y: " + y);
	}



	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}