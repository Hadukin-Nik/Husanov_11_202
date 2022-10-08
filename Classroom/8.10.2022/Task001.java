public class Task001 {
	public static void main (String[] args) {
		int n = Integer.parseInt(args[0]);


		int[] mas = new int[n];

		boolean isIn = false;

		for (int i = 0; i < n && !isIn; i++) {
			mas[i] = Integer.parseInt(args[i + 1]);

			if (mas[i] < 0) {
				isIn = true;
			}
		}

		if (isIn) {
			System.out.println("Minus is in!");
		}
	}
}