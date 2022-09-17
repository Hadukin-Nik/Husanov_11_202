public class Sqrt {
	public static void main (String[] args) {
		double n = Double.parseDouble(args[0]);

		final double EPS = 1e-4; //0.0001;
		double finder = n;
		while ((finder * finder) - n >= EPS) {
			finder -= EPS;
		}

		System.out.println(finder);
	}
}