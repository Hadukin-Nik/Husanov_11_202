public class Task11{
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);

		while(a > 0) {
			System.out.print(a%10 + " ");
			a /= 10;
		}
	}
}