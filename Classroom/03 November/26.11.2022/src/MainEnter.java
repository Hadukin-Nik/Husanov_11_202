import ru.kpfu.longArithmetics.Number;
import ru.kpfu.services.StringHelper;

import java.util.Scanner;

public class MainEnter {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] c = StringHelper.stringToIntReverse(sc.nextLine());
		int[] e = StringHelper.stringToIntReverse(sc.nextLine());

		Number a = new Number(c, 1);
		Number b = new Number(e, 1);

		System.out.println(a + " * " + b + " = " + a.mult(b));
	}

}