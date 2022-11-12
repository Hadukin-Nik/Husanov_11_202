public class Entity {
	private int hp;
	private int numberTeam;

	public Entity(int hp, int numberTeam) {
		this.hp = hp;
		this.numberTeam = numberTeam;
	}



	public int getHP() {
		return hp;
	}

	public boolean isAlive() {
		return hp > 0;
	}

	public void damage(int damage) {
		hp -= numberTeam;
	}

	public int getNumberTeam() {
		return numberTeam;
	}
}