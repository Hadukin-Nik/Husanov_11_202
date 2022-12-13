import java.util.Scanner;


public class PlayerBehaviour implements IEntityBehaviour {
	private GameServices gameService;
	private IReadGameDataBase dataBaseRead;
	private ISetGameDataBase dataBaseSet;


	private IPlayerBehaviour playerBehaviour;

	private IInventory inventory;

	private Scanner scanner;

	public PlayerBehaviour (GameServices gameService, IReadGameDataBase dataBaseRead, ISetGameDataBase dataBaseSet, IInventory inventory) {
		this.gameService = gameService;
		this.dataBaseRead = dataBaseRead;
		this.dataBaseSet = dataBaseSet;
		this.inventory = inventory;

		this.playerBehaviour = playerBehaviour;

		scanner = new Scanner(System.in);
	}

	public void makeTurn() throws Exception {
		System.out.println("press 1 - to attack, press 2 - to get acess to inventory");
		int numberOfAction = scanner.nextInt();

		if (numberOfAction != 1 && numberOfAction != 2) {
			System.out.println("incorrect input");

			makeTurn();
		}

		if (numberOfAction == 1) {
			attack();
		} else {
			inventoryInterface();
		}
	}

	private void attack() throws Exception {
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

	private void inventoryInterface() throws Exception {
		System.out.println("This is your inventory:");

		int n = inventory.getCountOfItems();

		for (int i = 0; i < n; i++) {
			System.out.println((i + 1) + ": " + inventory.getNameOfItem(i) + ": " + inventory.getCountOfItem(i));
		}	

		System.out.println();
		System.out.println("Please Choose Your Item!");

		int chosenItem = scanner.nextInt();
		chosenItem --;

		if (chosenItem < 0 || chosenItem >= n || inventory.getCountOfItem(chosenItem) < 1) {
			System.out.println("Wrong Number Of Item");

			inventoryInterface();
		}


		System.out.println("Chose who to heal!");

		int chosenEntity = scanner.nextInt();
		chosenEntity--;

		if (chosenItem < 0 || chosenEntity >= dataBaseRead.getNumberOfEntities()) {
			System.out.println("Wrong Number Of Entity");

			inventoryInterface();
		}

		inventory.setCountOfItems(chosenItem, inventory.getCountOfItem(chosenItem) - 1);

		dataBaseSet.heal(chosenEntity, inventory.getPowerOfItem(chosenItem));
	}
}