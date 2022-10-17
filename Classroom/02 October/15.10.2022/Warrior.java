import java.util.Scanner;

public class Warrior implements Entity{
	private GameServices gameService;
	private Scanner scanner;

	private int hp = 100;
	private int maxDamage;

	public Warrior (GameServices gameService, int hp, int maxDamage) {
		this.gameService = gameService;

		this.hp = hp;
		this.maxDamage = maxDamage;

		scanner = new Scanner(System.in);
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
			this.TurnOfEntity(warriors);
		}


		System.out.println("Input your damage!");
		int damage = scanner.nextInt();

		//check
		if (damage > maxDamage) {
			System.out.println("Wrong damage input! try again" + damage + " " + maxDamage);
			this.TurnOfEntity(warriors);
		}

		damage = gameService.DamageCalculation(damage);
		warriors[enemy].Damage(damage);

		if(warriors[enemy].IsKilled()) {
			System.out.println("Minus one!");
		}
	}
}