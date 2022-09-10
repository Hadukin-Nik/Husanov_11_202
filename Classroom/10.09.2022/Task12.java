public class Task12 {
	public static void main(String[] args) {
		int toParse = Integer.parseInt(args[0]);
		int sum = 0; 

		int buf = 1;

		while(toParse > 0) {
			sum += buf * (toParse % 10);

			toParse /= 10;
			buf *= 2;
		}

		System.out.println(sum);
	}
}