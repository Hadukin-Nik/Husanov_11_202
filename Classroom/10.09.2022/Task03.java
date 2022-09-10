import java.util.Scanner;

public class Task03{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = Scanner.nextInt();
		int b = Scanner.nextInt();
		int c = Scanner.nextInt();

		if (a >= b && a >= c) {
			System.out.println(a);
		} else if (b >= a && b >= c) {
			System.out.println(b);
		} else {
			System.out.println(c);
		}
	}
}