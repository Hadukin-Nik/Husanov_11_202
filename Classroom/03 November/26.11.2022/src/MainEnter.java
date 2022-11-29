import ru.kpfu.longArithmetics.Number;

public class MainEnter {
	public static void main (String[] args) {

		int[] c = {4321};
		int[] e = {544421};

		Number a = new Number(c, 1);
		Number b = new Number(e, 1);

		System.out.println(a.sub(b));
	}

}