public class Task001 {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int max = 0;

		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(args[i + 1]);

			if (a[i] > max) {
				max = a[i];
			}
		}

		System.out.println(max);


	}
}