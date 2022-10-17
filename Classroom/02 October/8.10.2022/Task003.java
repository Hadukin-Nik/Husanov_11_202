public class Task003{
	public static void main (String[] args) {
		int n = Integer.parseInt(args[0]);

		int[] mas = new int[n];

		int counter = 0;

		for (int i = 0; i < n && counter < 2; i++) {
			mas[i] = Integer.parseInt(args[i + 1]);

			if (mas[i] < 0) {
				counter ++;
			}
		}

		if (counter >= 2) {
			System.out.println("It is OK!");
		} else {
			System.out.println("It is not OK!");
		}

	}
}