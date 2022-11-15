import java.util.Random;

public class GameServices {
	private Random random;

	private int dice;
	private int maxDamage;

	public GameServices(int dice, int maxDamage) {
		this.dice = dice;
		this.maxDamage = maxDamage;

		random = new Random();
	}

	public int DamageCalculation(int damage) {
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

	public int getMaxDamage() {
		 return maxDamage;
	}
}