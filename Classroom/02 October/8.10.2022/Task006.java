public class Task006 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args [0]);
		int m = Integer.parseInt(args [1]);

		int[][] mas = new int[n][m];


		boolean find = false;
		for (int i = 0; i < n && !find; i++) {
			boolean ok = true;

			for (int j = 0; j < m && ok; j++) {
				mas[i][j] = Integer.parseInt(args[3 + i * m + j]);

				if (mas[i][j] % 3 != 0) {
					ok = false;
				}
			}

			find = ok;
		}

		if (find) {
			System.out.println("Is all right");
		} else {
			System.out.println("WTF?!");
		}
	}
}