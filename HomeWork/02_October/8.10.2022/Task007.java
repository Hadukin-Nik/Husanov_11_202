public class Task007{
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		String[][] nom = new String[n][m];

		boolean isOk = true;

		for (int j = 0; j < m && isOk; j++) {

			boolean flag = false;
			for (int i = 0; i < n && !flag; i++) {
				if (isVowel(nom[i][j])) {
					flag = true;
				}
			}

			isOk = flag;
		}

		if(isOk) {
			System.out.println("good!");
		} else {
			System.out.println("not good!");
		}
	}

	public static boolean isVowel(String a) {
		String vowel = "aeiouyAEIOUY";

		boolean notIn = true;
		for (int j = 0; j < vowel.length() && notIn; j++) {
			if (a.charAt(0) == vowel.charAt(j)) {
				notIn = false;
			}
		}

		return !notIn;
	}
}