public class Task13 {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);

		int buf = 1;
		while (a > 0) {
			buf *= 10;
			buf += a % 2;
			a /= 2;
		}

		while (buf > 1) {
			System.out.print(buf % 10);
			buf /= 10;
		}
	}
}