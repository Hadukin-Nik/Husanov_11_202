public class FightSimulator {
	public static void main (String[] args) {
		GameSystem a = new GameSystem(1, 2, 1, 100, 10, 10);

		boolean isGameOn = true;
		while(isGameOn) {
			isGameOn = a.NextTurn();
		}
	}
}

