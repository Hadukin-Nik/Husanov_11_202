public class Task002 {
	public static void main(String[] args) {
		int n1 = Integer.parseInt(args[0]);

		int[] a = new int[n1];
		for (int i = 0; i < n1; i++) {
			a[i] = Integer.parseInt(args[i + 1]);
		}

		int n2 = Integer.parseInt(args[n1 + 1]);

		int[] b = new int[n2];
		for (int i = 0; i < n2; i++) {
			b[i] = Integer.parseInt(args[i + n1 + 2]);
		}

		boolean ans = true;

		if(n1 != n2) {
			ans = false;
		}

		for (int i = 0; i < n1 && i < n2; i++) {
			if (a[i] != b[i]) {
				ans = false;
			}
		}

		System.out.println((ans ? "A equals B" : "A not equals B"));
	}
}