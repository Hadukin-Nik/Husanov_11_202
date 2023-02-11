import java.util.Scanner;

public class Task04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		final float EPS = 0.000000001;

		float a = sc.nextFloat();
		float b = sc.nextFloat();


		float dif = a - b;
		if (dif < 0) {
			dif *= -1;
		}

		if(dif < EPS) {
			System.out.println("equals");
		} else {
			System.out.println("different");
		}
	}
}