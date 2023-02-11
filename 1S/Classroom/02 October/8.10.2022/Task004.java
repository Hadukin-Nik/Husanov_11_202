public class Task004{
	public static void main (String[] args) {
		String vowel = new String();
		vowel = "aeiouyAEIOUY";
		String a = args[0];


		int counter = 0;

		for (int i = 0; i < a.length() && counter < 4; i++) {
			boolean notIn = true;
			for (int j = 0; j < vowel.length() && notIn; j++) {
				if (a.charAt(i) == vowel.charAt(j)) {
					notIn = false;
				}
			}

			counter += (!notIn ? 1 : 0);
		}

		if (counter == 3) {
			System.out.println("It is OK");
		} else {
			System.out.println("It is not OK!");
		}
	}
}