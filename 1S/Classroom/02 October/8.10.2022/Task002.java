public class Task002 {
	public static void main(String[] args) {
		String vowel = "aeiouyAEIOUY";

		String a = args[0];


		boolean isIn = false;

		for (int i = 0; i < a.length() && !isIn; i++) {
			boolean notIn = true;
			for (int j = 0; j < vowel.length() && notIn; j++) {
				if (a.charAt(i) == vowel.charAt(j)) {
					notIn = false;
				}
			}

			isIn = notIn;
		}

		if (isIn) {
			System.out.println("Is is not vowel in the string");
		}
	}
}