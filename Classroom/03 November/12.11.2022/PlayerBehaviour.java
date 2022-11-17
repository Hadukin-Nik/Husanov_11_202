import java.util.Scanner;


public class PlayerBehaviour implements IEntityBehaviour {
	private GameServices gameService;
	private IReadGameDataBase dataBaseRead;
	private ISetGameDataBase dataBaseSet;


	private IPlayerBehaviour playerBehaviour;

	private Scanner scanner;

	public PlayerBehaviour (GameServices gameService, IReadGameDataBase dataBaseRead, ISetGameDataBase dataBaseSet) {
		this.gameService = gameService;
		this.dataBaseRead = dataBaseRead;
		this.dataBaseSet = dataBaseSet;

		this.playerBehaviour = playerBehaviour;

		scanner = new Scanner(System.in);
	}

	public void makeTurn() throws Exception{
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
		double damage = scanner.nextDouble();

		//check
		if (damage > gameService.getMaxDamage()) {
			System.out.println("Wrong damage input! try again" + damage + " > " + gameService.getMaxDamage());
			this.makeTurn();
		}

		damage = gameService.damageCalculation(damage);
		dataBaseSet.damage(enemy, damage);

		if(!dataBaseRead.isAlive(enemy)) {
			System.out.println("Minus one!");
		}
	}
}