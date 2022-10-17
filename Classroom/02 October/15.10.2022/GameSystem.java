//import java.Random;
import java.util.Scanner;
import java.util.Random;

public class GameSystem {
	private Random random;
	private Scanner scanner;

	private Entity[] warriors;	

	private int dice;
	private double maxDamage;

	public GameSystem(int countOfPlayers, int countOfBots, int countOfDifficults, int commonHealth, int dice, double maxDamage) {
		random = new Random();
		scanner = new Scanner(System.in);

		warriors = new Entity[countOfPlayers + countOfBots];

		for (int i = 0; i < countOfPlayers; i++) {
			warriors[i] = new Warrior(commonHealth);
		}


		for (int i = countOfPlayers; i < countOfBots + countOfPlayers; i++){
			boolean botSet = false;

			if (countOfDifficults > 0) {
				botSet = true;

				countOfDifficults --;
			}

			warriors[i] = new Bot(new Warrior(commonHealth), botSet);
		}

		this.dice = dice;
		this.maxDamage = maxDamage;
	}

	public boolean NextTurn() {
		for (int i = 0; i < warriors.length(); i++) {
			if (warriors[i].IsKilled()) {
				continue;
			}

			
			System.out.println(i + 1 + ": ");

			warriors[i].TurnOfEntity();
			if (!isGamePossible) {
				return false;
			}
		}
		for (int i = 0; i < warriors.length; i++) {
			System.out.println(i + 1 + ": " + warriors[i].HP());
		}
		return isGamePossible();
	}

	public boolean isGamePossible() {
		int countDead = 0;

		for (int i = 0; i < warriors.length; i++) {
			if (warriors[i].IsKilled()) {
				countDead ++;
			}
		}

		return (countDead < warriors.length - 1);
	}

	private int damageCalculation(int damage) {
		int cubeNumber = random.nextInt(dice + 1);
		int returnDamage = 0;

		if (damage < maxDamage / 3) {
			if (cubeNumber < dice * 1.0 / 100 * 90) {
				returnDamage = damage;
			}
		} else if (damage < maxDamage / 3 * 2) {
			if (cubeNumber < dice * 1.0 / 100 * 70) {
				returnDamage = damage;
			}
		} else {
			if (cubeNumber < dice * 1.0 / 100 * 35) {
				returnDamage = damage;
			}
		}

		if (cubeNumber < dice * 1.0 / 100 * 5) {
			returnDamage += maxDamage / 10 + damage * 2;
		}

		return returnDamage;
	}
}