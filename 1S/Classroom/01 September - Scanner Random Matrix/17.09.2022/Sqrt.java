public class Sqrt {
	public static void main (String[] args) {
		double n = Double.parseDouble(args[0]);

		final double EPS = 1e-4; //0.0001;
		
		double l = 0;
		double r = n;

		while (r - l >= EPS) {
			double m = (l + r) / 2;

			if (m * m > n) {
				r = m;
			} else {
				l = m;
			}
		}

		System.out.println(l);

	}
}