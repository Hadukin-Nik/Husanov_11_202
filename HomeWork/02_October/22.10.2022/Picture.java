public class Picture {
	public static void main (String[] args) {
		int n = Integer.parseInt(args[0]);

		int d = 0;
		for (int i = 0; i < 2 * n + 1; i++) {
			for (int j = 0; j < 2 * n + 1; j++) {
				boolean disp = false;
				if (i == 2 * n || j == 0 || j == 2 * n) {
					disp = true;
				} 

				if (d <= n) {
					if (j == d) {
						disp = true;
					} else if (j == 2 * n - d) {
						disp = true;
					}
				}

				if (disp) {
					System.out.print(1);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
			d++;
		}
	}
}