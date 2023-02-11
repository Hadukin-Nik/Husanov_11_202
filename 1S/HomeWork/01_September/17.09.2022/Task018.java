public class Task018 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		Long ans = 0L;
		Long power = 2L;

		for (int i = 1; i <= n; i++) {
			ans += power;

			power *= 2;
		}

		System.out.println(ans);
	}
}