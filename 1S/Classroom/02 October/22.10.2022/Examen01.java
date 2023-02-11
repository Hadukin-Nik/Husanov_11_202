public class Examen01 {
	public static void main (String[] args) {
		int n = Integer.parseInt(args[0]);

		boolean left = true;
		int d = 0;

		for (int i = 0; i < 2 * n + 1; i++) {
			for (int j = 0; j < 2 * n + 1; j++) {
				if (i == 0 || i == 2 * n || j == 2 * n - d || j == 0) {
					System.out.print("1");
				} else {
					System.out.print(" ");
				}

			}
			System.out.println();

			if (i == n) {
				left = false;
			}

			if (left) {
				d++;
			} else {
				d--;
			}
		}
	}
}