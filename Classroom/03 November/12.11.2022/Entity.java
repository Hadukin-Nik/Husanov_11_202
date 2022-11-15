public class Entity {
	private double hp;
	private int numberTeam;

	public Entity(double hp, int numberTeam) {
		this.hp = hp;
		this.numberTeam = numberTeam;
	}



	public double getHP() {
		return hp;
	}

	public double setHP(double hp) {
		if (hp < 0) {
			this.hp = 0;
		} else {
			this.hp = hp;
		}
	}

	public boolean isAlive() {
		return hp > 0;
	}

	public void damage(int damage) {
		hp -= damage;
	}

	public int getNumberTeam() {
		return numberTeam;
	}
}