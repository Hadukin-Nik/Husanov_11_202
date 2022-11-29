package entities.gameEntities;

import java.util.Random;
import gameServices.*;

public class EasyBotBehaviour implements IBotBehaviour {
	Random random;

	public EasyBotBehaviour () {
		random = new Random();
	}


	public void kick(GameServices gameService, IReadGameDataBase dataBaseRead, ISetGameDataBase dataBaseSet, int numberOfTeam) throws Exception{
		int countOfEntities = dataBaseRead.getNumberOfEntities();
		int choosedEnemy = 0;
		while (!dataBaseRead.isAlive(choosedEnemy) || dataBaseRead.getNumberOfTeam(choosedEnemy) == numberOfTeam) {
			choosedEnemy = random.nextInt(countOfEntities);
		}
		double maxDamage = gameService.getMaxDamage();
		double damage = 9;

		damage = gameService.damageCalculation(damage);

		dataBaseSet.damage(choosedEnemy, damage);
	}
}