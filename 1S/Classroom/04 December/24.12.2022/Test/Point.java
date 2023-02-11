public class Point {
	private double x;
	private double y;


	public Point() {
		x = 0;
		y = 0;
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double sqrt(double a) {
		if (a < 0) {
			a *= -1;
		}

		double l = 0;
		double r = a;

		while (r - l > 0.00001) {
			double m = (r + l) / 2;

			if (m * m > a) {
				r = m;
			} else {
				l = m;
			}
		}

		return l;
	}

	public double getDistance (Point other) {
		return sqrt((other.getX() - other.getX())*(other.getX() - other.getX()) + (other.getY() - other.getY())*(other.getY() - other.getY()));
	}	

	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}

	public String toString() {
		return " X: " + x + " Y: " + y;
	}
}