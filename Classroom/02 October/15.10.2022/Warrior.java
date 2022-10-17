public class Warrior implements Entity{
	private int hp = 100;

	public Warrior (int hp) {
		this.hp = hp;
	}

	public boolean IsKilled() {
		return (hp <= 0);
	}

	public int GetHP() {
		return hp;
	}

	public void Damage(int damage) {
		hp -= damage;
	}

	public void TurnOfEntity(Entity[] warriors) {
		System.out.println("Choose your enemy!"); 
		int enemy = scanner.nextInt();
		enemy--;

		//check
		if (enemy >= warriors.length) {
			System.out.println("Wrong enemy input! try again");
			TurnOfEntity();
		}


		System.out.println("Input your damage!");
		int damage = scanner.nextInt();

		//check
		if (enemy >= maxDamage) {
			System.out.println("Wrong damage input! try again");
			TurnOfEntity();
		}

		damage = damageCalculation(damage);
		warriors[enemy].Damage(damage);

		if(warriors[enemy].IsKilled()) {
			System.out.println("Minus one!");
		}
	}
}