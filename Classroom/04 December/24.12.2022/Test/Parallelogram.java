import java.math.*;

public class Parallelogram {
	private final double EPS = 0.00000001;

	private Point[] pointsUp;
	private Point[] pointsDown;

	public Parallelogram(Point[] points) throws Exception{
		if (points.length > 4) {
			throw new Exception("Wrong data in Parallelogram");
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4 - 1; j++) {
				if (points[j].getY() > points[j + 1].getY()) {
					Point buf = points[j];
					points[j] = points[j + 1];
					points[j + 1] = buf;
				}
			}
		}
		if (points[0].getX() > points[1].getX()) {
			Point buf = points[0];
			points[0] = points[0 + 1];
			points[0 + 1] = buf;
		}
		if (points[2].getX() > points[3].getX()) {
			Point buf = points[2];
			points[2] = points[2 + 1];
			points[2 + 1] = buf;
		}
		if (points[0].getY() - points[1].getY() > EPS || points[2].getY() - points[3].getY() > EPS) {
			throw new Exception("Wrong data in Parallelogram");
		}

		pointsDown = new Point[] {points[0], points[1]};
		pointsDown = new Point[] {points[2], points[3]};
	}

	public Point[] getPointsUp() {
		return pointsUp;
	}

	public Point[] getPointsDown() {
		return pointsDown;
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

	public double length() {
		return pointsDown[0].getDistance(pointsDown[1]) + pointsDown[0].getDistance(pointsUp[0]) + pointsUp[1].getDistance(pointsDown[1]) + pointsUp[1].getDistance(pointsUp[0]);
	}

	public double square() {
		return pointsDown[0].getDistance(pointsDown[1]) * (pointsUp[0].getY() - pointsDown[0].getY());
	}

	public boolean equals(Parallelogram other) {
		Point[] pointsUpOther = other.getPointsUp();
		Point[] pointsDownOther = other.getPointsDown();

		for (int i = 0; i < 2; i ++) {
			if (pointsUpOther[i].getX() - pointsUp[i].getX() > EPS || pointsUpOther[i].getY() - pointsUp[i].getY() > EPS) {
				return false;
			}
		}

		for (int i = 0; i < 2; i ++) {
			if (pointsDownOther[i].getX() - pointsDown[i].getX() > EPS || pointsDownOther[i].getY() - pointsDown[i].getY() > EPS) {
				return false;
			}
		}

		return true;
	}

	public double[] getAngles() {
		if(pointsUp[0].getX() > pointsDown[0].getX()) {
			return new double[] {Math.asin((pointsUp[0].getY() - pointsDown[0].getY()) / pointsDown[0].getDistance(pointsUp[0])), Math.acos((pointsUp[1].getY() - pointsDown[1].getY())/ pointsDown[1].getDistance(pointsUp[1]))};
		}
		return new double[] {Math.asin((pointsUp[0].getY() - pointsDown[0].getY()) / pointsDown[1].getDistance(pointsUp[1])), Math.acos((pointsUp[1].getY() - pointsDown[1].getY())/ pointsDown[0].getDistance(pointsUp[0]))};
	}

	public String toString() {
		return "Points down: " + pointsDown[0].toString() + " " + pointsDown[1].toString() + "\n" + "Points up: " + pointsUp[0].toString() + " " + pointsUp[1].toString();
	}


}