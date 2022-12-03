public class Line {
	private Point point1;
	private Point point2;

	public Line() {
		point1 = new Point();
		point2 = new Point();
	}

	public Line(Point point1, Point point2) {
		this.point1 = point1;
		this.point2 = point2;
	}

	public Point getPoint1() {
		return point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public String toString() {
		return "Line: " + "Point1: " + point1 + " Point2: " + point2;
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

	public double getLength() {
		return sqrt((point1.getX() - point2.getX()) * (point1.getX() - point2.getX()) + (point1.getY() - point2.getY()) * (point1.getY() - point2.getY()));
	}

	public double getSquare() {
		return (point1.getX() - point2.getX()) * (point1.getY() - point2.getY());
	}

	public boolean isCutedWithOtherLine(Line other) {
		Line a = this;

		if (point1.getX() > point2.getX()) {
			a = new Line (point2, point1);
		}

		Line b = other;

		if (other.getPoint1().getX() > other.getPoint2().getX()) {
			b = new Line (other.getPoint2(), other.getPoint1());
		}

		if (a.getPoint1().getY() > b.getPoint1().getY()) {
			Line buf = a;
			a = b;
			b = buf;
		}

		return false;
	}

	public boolean equals(Line other) {
		if (this.getPoint1().equals(other.getPoint1()) && this.getPoint2().equals(other.getPoint2())) {
			return true;
		}

		return false;
	}
}