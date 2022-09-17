public class Draft {
	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);

		Long lastInUseK = 1L;
		double lastInUseX = 1.0;
		double eps = 0.000001;

		double ans = 0.0;

		for (int k = 1; lastInUseX / lastInUseK >= eps; k++) {
			lastInUseK *= k;
			lastInUseX *= x;

			ans += lastInUseX / lastInUseK;
		}

		System.out.println(ans - eps);
	}
}