public class Task017 {
	public static void main (String[] args) {
		int n = Integer.parseInt(args[0]);

		Long ans = 0L;
		Long power = 1L;


		for (int i = 1; i <= n; i++) {
			ans += power;

			power *= n;
		}

		System.out.println(ans);
	}
}