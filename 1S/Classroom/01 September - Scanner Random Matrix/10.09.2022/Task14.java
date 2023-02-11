import java.util.Scanner;

public class Task14{
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		while(b >= a) {
			a = b;
			b = sc.nextInt();
		}
	}
}