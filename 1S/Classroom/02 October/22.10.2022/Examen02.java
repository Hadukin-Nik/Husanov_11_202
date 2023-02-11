public class Examen02 {
	public static void main (String[] args) {
		int n = Integer.parseInt(args[0]);

		double fact = 1;
		double sum = 0;
		for (int k = 1; k <= n; k++) {
			fact *= k * 2;

			sum += (k*k + 2.0) / (fact);
		}

		System.out.println(sum);
	}
}