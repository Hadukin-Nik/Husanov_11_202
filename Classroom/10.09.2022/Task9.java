public class Task9 {
	public static void main(String[] args) {
		int k = Integer.parseInt(args[0]);

		int n = 1;
		while(n < 10) {
			int res = k * n;
			System.out.println(n + " * " + k + " = " + res);
			n++;
		}
	}
}