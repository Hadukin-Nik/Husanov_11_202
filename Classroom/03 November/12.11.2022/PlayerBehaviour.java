import java.util.Scanner;


public class PlayerBehaviour implements IEntityBehaviour {
	private GameService gameService;
	private IReadGameDataBase dataBase;
	private ISetGameDataBase dataBaseSet;


	private IPlayerBehaviour playerBehaviour;

	public PlayerBehaviour (GameService gameService, IReadGameDataBase dataBaseRead, ISetGameDataBase dataBaseSet) {
		this.gameService = gameService;
		this.dataBaseRead = dataBaseRead;
		this.dataBaseSet = dataBaseSet;

		this.playerBehaviour = playerBehaviour;
	}

	public void makeTurn() {
		int countOfEntities = dataBaseRead.getNumberOfEntities();

		System.out.println("Choose your enemy!"); 
		int enemy = scanner.nextInt();
		enemy--;

		//check
		if (enemy >= countOfEntities) {
			System.out.println("Wrong enemy input! try again");
			this.makeTurn();
		}


		System.out.println("Input your damage!");
		int damage = scanner.nextInt();

		//check
		if (damage > gameService.getMaxDamage()) {
			System.out.println("Wrong damage input! try again" + damage + " > " + gameService.getMaxDamage());
			this.makeTurn();
		}

		damage = gameService.DamageCalculation(damage);
		dataBaseSet.damage(enemy, damage);

		if(dataBaseRead.isAlive(enemy)) {
			System.out.println("Minus one!");
		}
	}
}