import java.util.Random;

public class HardBotBehaviour implements IBotBehaviour  { 
	private Random random;

	private int choosedEnemy; 
	private int state;

	public HardBotBehaviour() {
		random = new Random();

		state = 1;
		choosedEnemy = 0;
	}
	

	public void kick(GameServices gameService, IReadGameDataBase dataBaseRead, ISetGameDataBase dataBaseSet, int numberOfTeam) throws Exception{
		int countOfEntities = dataBaseRead.getNumberOfEntities();

		while (!dataBaseRead.isAlive(choosedEnemy) || dataBaseRead.getNumberOfTeam(choosedEnemy) == numberOfTeam) {
			choosedEnemy = random.nextInt(countOfEntities);
		}

		double maxDamage = gameService.getMaxDamage();
		double damage = (double)random.nextInt((int)maxDamage / 3 + 1) + maxDamage / 3 * state;

		damage = gameService.damageCalculation(damage);

		if (damage == 0 && state > 0) {
			state --;
		} else if (damage > 0 && state < 2) {
			state ++;
		}

		dataBaseSet.damage(choosedEnemy, damage);
	}
}