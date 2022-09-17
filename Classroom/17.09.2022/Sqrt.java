public class Sqrt {
	public static void main (String[] args) {
		double n = Double.parse(args[0]);

		double eps = 0.0000001;
		double finder = n;
		while ((finder * finder) - n >= eps) {
			finder -= eps;
		}

		System.out.println(finder);
	}
}