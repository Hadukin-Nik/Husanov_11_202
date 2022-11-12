import java.util.Random;

public class EasyBotBehaviour implements IBotBehaviour {
	Random random;

	public EasyBotBehaviour () {
		random = new Random();
	}


	public void kick(GameService gameService, IReadGameDataBase dataBaseRead, ISetGameDataBase dataBaseSet, int numberOfTeam, int countOfEntities) {
		int choosedEnemy = 0;
		while (!dataBaseRead.isAlive(choosedEnemy) || dataBaseRead.getNumberOfTeam(choosedEnemy) == numberOfTeam) {
			choosedEnemy = random.nextInt(countOfEntities);
		}
		int maxDamage = gameService.getMaxDamage();
		int damage = random.nextInt(maxDamage + 1);

		damage = gameService.DamageCalculation(damage);

		dataBaseSet.damage(choosedEnemy, damage);
	}
}