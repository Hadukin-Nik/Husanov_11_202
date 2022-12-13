public class Entity {
	private double hp;
	private int numberTeam;
	private int myID;

	public Entity() {
		this.hp = 0;
		this.numberTeam = 0;
	}

	public Entity(double hp, int numberTeam) {
		this.hp = hp;
		this.numberTeam = numberTeam;
	}

	public double getHP() {
		return hp;
	}

	public void setHP(double hp) {
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