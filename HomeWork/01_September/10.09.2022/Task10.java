public class Task10 {
	public static void main(String[] args) {
		long a = Long.parseLong(args[0]);

		if (a < 0) {
			a *= -1;
		}

		long sum = 0;
		while(a > 0) {
			sum += a % 10;
			a /= 10;
		}
		System.out.println(sum);
	}
}