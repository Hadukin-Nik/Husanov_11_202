//example of singletone

public class GodSingleTone {
	public static God god;

	public static God get() {
		if (god == null) {
			god = new God();
		}

		return god;
	}
}