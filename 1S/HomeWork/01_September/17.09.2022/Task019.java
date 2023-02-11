public class Task019 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		Long ans = 0L;
		Long lastInUse = 1L;

		for (int i = 1; i <= n; i++) {
			lastInUse *= i;

			ans += lastInUse;
		}

		System.out.println(ans);
	}
}