import java.util.Scanner;

public class Task5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		float x = sc.nextFloat();
		float y = sc.nextFloat();

		int n = sc.nextInt();

		float halfOfLine = n * 1.0 / 2;

		if (x >= halfOfLine * (-1) && x <= halfOfLine 
			&& y >= halfOfLine * (-1) && y <= halfOfLine) {
			System.out.println("In");
		} else {
			System.out.println("Out");
		}
	}
}