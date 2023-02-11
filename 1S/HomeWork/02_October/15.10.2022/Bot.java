import java.util.Random;

public class Bot implements Entity{
	private GameServices gameService;
	private Random random;

	private int hp;
	private int maxDamage;
	private int countOfPlayers;
	private int choosedEnemy; 
	private int state;

	private boolean isDifficult;

	public Bot(GameServices gameService, int hp, int countOfPlayers, int maxDamage, boolean isBotDifficult) {
		this.gameService = gameService;

		this.hp = hp;
		this.maxDamage = maxDamage;
		this.countOfPlayers = countOfPlayers;
		this.isDifficult = isBotDifficult;

		random = new Random();

		choosedEnemy = random.nextInt(countOfPlayers);
		state = 1;
	}

	public void Damage(int damage) {
		hp -= damage;
	}

	public int GetHP() {
		return hp;
	}

	public boolean IsKilled() {
		return hp <= 0;
	}


	public void TurnOfEntity(Entity[] warriors) {
		if (isDifficult) {
			hardTurn(warriors);
		} else {
			easyTurn(warriors);
		}
	}

	private void easyTurn(Entity[] warriors) {
		int enemy = random.nextInt(countOfPlayers);

		int damage = random.nextInt(maxDamage + 1);

		damage = gameService.DamageCalculation(damage);

		warriors[enemy].Damage(damage);
	}

	private void hardTurn(Entity[] warriors) {
		if (warriors[choosedEnemy].IsKilled()) {
			choosedEnemy = random.nextInt(countOfPlayers);
		}

		int damage = random.nextInt(maxDamage / 3 + 1) + maxDamage / 3 * state;

		damage = gameService.DamageCalculation(damage);

		if (damage == 0 && state > 0) {
			state --;
		} else if (damage > 0 && state < 2) {
			state ++;
		}

		warriors[choosedEnemy].Damage(damage);
	}
}