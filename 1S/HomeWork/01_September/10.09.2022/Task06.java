public class Task06 {
	public static void main(String[] args) {
		float x = Float.parseFloat(args[0]);
		float y = Float.parseFloat(args[1]);
		int n = Integer.parseInt(args[2]);

		if (x*x + y*y <= n * n) {
			System.out.println("In");
		} else {
			System.out.println("Out");
		}
	}
}