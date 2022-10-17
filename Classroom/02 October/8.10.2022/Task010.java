public class Task010 {
	public static void main (String[] args) {
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);

		String[][] array = new String[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				array[i][j] = args[2 + i * n + j];
			}
		}


		boolean isOk = true;
		for (int col = 0; col < m && isOk; col ++) {
			int counter = 0;

			int line = 0;
			while(counter < 2 && line < n) {
				if (check(array[line][col])) {
					counter ++;
				}


				line++;
			}

			if (counter >= 2) {
				isOk = false;
			}
		}

		if (isOk) {
			System.out.println("It is OK!");
		} else {
			System.out.println("It is not OK!");
		}
	}

	public static boolean check(String a) {
		String vowel = "aeiouyAEIOUY";

		boolean notIn = true;
		for (int j = 0; j < vowel.length() && notIn; j++) {
			if (a.charAt(0) == vowel.charAt(j)) {
				notIn = false;
			}
		}

		return !notIn;
	}
}