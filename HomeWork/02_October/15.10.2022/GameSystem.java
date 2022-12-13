//import java.Random;


public class GameSystem {
	private GameServices gameService;

	private Entity[] warriors;	

	private int dice;
	private int countOfPlayers;
	private int countOfDifficults;
	private int maxDamage;

	public GameSystem(int countOfPlayers, int countOfBots, int countOfDifficults, int commonHealth, int dice, int maxDamage) {
		this.countOfPlayers = countOfPlayers;
		this.maxDamage = maxDamage;
		this.countOfDifficults = countOfDifficults;
		gameService = new GameServices(dice, maxDamage);


		warriors = new Entity[countOfPlayers + countOfBots];

		for (int i = 0; i < countOfPlayers; i++) {
			warriors[i] = new Warrior(gameService, commonHealth, maxDamage);
		}


		for (int i = countOfPlayers; i < countOfBots + countOfPlayers; i++){
			boolean botSet = false;

			if (countOfDifficults > 0) {
				botSet = true;

				countOfDifficults --;
			}

			warriors[i] = new Bot(gameService, commonHealth, countOfPlayers, maxDamage, botSet);
		}

		this.dice = dice;
	}

	public boolean NextTurn() {
		for (int i = 0; i < warriors.length; i++) {
			if (warriors[i].IsKilled()) {
				continue;
			}

			
			System.out.println(i + 1 + ": ");

			warriors[i].TurnOfEntity(warriors);
			if (!isGamePossible()) {
				return false;
			}

			if (i >= countOfPlayers) {
				System.out.println("Turn of the BOT");
			}
		}
		for (int i = 0; i < warriors.length; i++) {
			System.out.println(i + 1 + ": " + warriors[i].GetHP());
		}

		for (int i = 0; i < warriors.length; i++) {
			System.out.print(i + 1 + ": ");
			if (i < countOfPlayers) {
				System.out.println("Player");
			} else {
				System.out.print("Bot ");
				System.out.println((i < countOfPlayers + countOfDifficults? "Hard" : "Easy"));
			}
		}


		return isGamePossible();
	}

	public boolean isGamePossible() {
		int countAlive = 0;

		for (int i = 0; i < countOfPlayers; i++) {
			if (!warriors[i].IsKilled()) {
				countAlive ++;
			}
		}

		return (countAlive < 2);
	}

	
}