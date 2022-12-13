public class Task009 {
	public static void main (String[] args) {
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);

		int[][] array = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				array[i][j] = Integer.parseInt(args[2 + i * n + j]);
			}
		}

		boolean isOk = true;
		for (int i = 0; i < n && isOk; i++) {
			int counter = 0;

			int j = 0;
			while (counter < 3 && j < m) {
				if (check(array[i][j])) {
					counter ++;
				}

				j++;
			}

			if (counter < 3) {
				isOk = false;
			}
		}

		if (isOk) {
			System.out.println("It is OK!");
		} else {
			System.out.println("It is not OK!");
		}
	}

	public static boolean check(int a) {
		boolean isOk = true;

		while(a > 0 && isOk) {
			if (a % 10 % 2 != 0) {
				isOk = false;
			}

			a /= 10;
		}
		return isOk;
	}
}