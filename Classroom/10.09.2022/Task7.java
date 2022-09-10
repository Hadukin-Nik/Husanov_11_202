import java.util.Scanner;

public class Task7{
	public static void main(String[] args) {
		float x = Float.parseFloat(args[0]);
		float y = Float.parseFloat(args[1]);

		float dest = x*x + y*y;

		int n = 1;
		
		while (dest > n * n) {
			n = n + 1;
		}

		if (n <= 9) {
			System.out.println(n);
		} else {
			System.out.println("Out");
		}
	}
}