public class Task005{
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		int[] a = new int[n];

		boolean isOk = true;
		for (int i = 0; i < n && isOK; i++) {
			a[i] = Integer.parseInt(args[i + 1]);

			if (a[i] > 0 && !isTwoIn(a[i])) {
				isOK = false;
			}
		}

		if (isOk) {
			System.out.println("It is ok!");
		} else {
			System.out.println("It is not ok!");
		}
	}

	public static boolean isTwoIn(int a) {
		boolean check = false;

		while(!check && a > 0) {
			if (a % 10 % 2 == 0) {
				check = true;
			}

			a /= 10;
		}
	}
}