public class Bot implements Entity{
	private int hp;
	private boolean isDifficult;

	public Bot(int hp, boolean isBotDifficult) {
		this.hp = hp;
		this.isDifficult = isBotDifficult;
	}

	public void TurnOfEntity() {

	}

	public void Damage(int damage) {
		hp -= damage;
	}

	public int GetHP() {
		return hp;
	}

	public void TurnOfEntity(Entity[] warriors) {
		if (isDifficult) {

		} else {

		}
	}

	public boolean isKilled() {
		return hp <= 0;
	}

	private void easyTurn(Entity[] warriors, int countOfPlayers) {

	}

	private void hardTurn(Entity[] warriors, int countOfPlayers) {

	}
}