public class Point {
	private double x;
	private double y;

	public Point() {
		x = 0.0;
		y = 0.0;
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public boolean equals(Point other) {
		if ((x - other.getX()) * (x - other.getX()) < 0.000001 && (y - other.getY()) * (y - other.getY()) < 0.000001 ) {
			return true;
		}
		return false;
	}

	public String toString() {
		return " X: " + x + " Y: " + y; 
	}
}