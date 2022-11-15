import java.util.Random;

public class HardBotBehaviour implements IBotBehaviour { 
	private Random random;

	private int choosedEnemy; 
	private int state;

	public HardBotBehaviour() {
		random = new Random();

		state = 1;
		choosedEnemy = 0;
	}
	
	public void kick(GameService gameService, IReadGameDataBase dataBaseRead, ISetGameDataBase dataBaseSet, int numberOfTeam) {
		int countOfEntities = dataBaseRead.getNumberOfEntities();

		while (!dataBaseRead.isAlive(choosedEnemy) || dataBaseRead.getNumberOfTeam(choosedEnemy) == numberOfTeam) {
			choosedEnemy = random.nextInt(countOfEntities);
		}
		int maxDamage = gameService.getMaxDamage();
		int damage = random.nextInt(maxDamage / 3 + 1) + maxDamage / 3 * state;

		damage = gameService.DamageCalculation(damage);

		if (damage == 0 && state > 0) {
			state --;
		} else if (damage > 0 && state < 2) {
			state ++;
		}

		dataBaseSet.Damage(choosedEnemy, damage);
	}
}