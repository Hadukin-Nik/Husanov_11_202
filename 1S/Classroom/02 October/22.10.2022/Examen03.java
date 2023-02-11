public class Examen03 {
	public static void main (String[] args) {
		int n = Integer.parseInt(args[0]);

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(args[i + 1]);
		}

		boolean isIn = false;
		for (int i = 0; i < n && !isIn; i++) {
			if (f(a[i], 3)) {
				isIn = true;
			}
		}

		if (isIn) {
			System.out.println("It is in!");
		} else {
			System.out.println("It is not in!");
		}
	}

	public static boolean f (int a, int countOfNums) {
		while(countOfNums > 0 && a > 0) {
			if (a % 10 % 2 == 0) {
				countOfNums --;
			}

			a /= 10;
		}

		return countOfNums <= 0;
	}
}