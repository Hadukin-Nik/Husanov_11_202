public class Task020{
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		double x = Double.parseDouble(args[1]);

		Long lastInUseK = 1L;
		double lastInUseX = 1.0;

		double ans = 0.0;

		for (int k = 1; k < n; k++) {
			lastInUseK *= k;
			lastInUseX *= x;

			ans += lastInUseK * lastInUseX;
		}

		System.out.println(ans);
	}
}