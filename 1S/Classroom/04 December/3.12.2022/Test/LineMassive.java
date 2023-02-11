public class LineMassive {
	public static double allLength (Line[] lines) {
		double ans = 0;

		for (int i = 0; i < lines.length; i++) {
			ans += lines[i].getLength();
		}

		return ans;
	}

	public static boolean isOneInMassive(Line[] lines) {
		int count = 0;

		for (int i = 0; (i < lines.length - 1) && count < 2; i++) {
			if (lines[i].isCutedWithOtherLine(lines[i + 1])) {
				count ++;
			}
		}

		return count >= 2;
	}
}