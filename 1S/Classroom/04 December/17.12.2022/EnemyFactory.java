//A factory pattern example


public class EnemyFactory {
	public static Enemy[] createAStandartCatArmy(int count, int hp, int damage) {
		Enemy[] answer = new Enemy[count];

		for (int i = 0; i < count; i++) {
			answer[i] = new FluffyCat();
		}

		return answer;
	}

	public static Enemy[] createAStandartOrcArmy(int count, int hp, int damage) {
		Enemy[] answer = new Enemy[count];

		for (int i = 0; i < count; i++) {
			answer[i] = new FluffyOrc(); 
		}
		
		return answer;
	}
}