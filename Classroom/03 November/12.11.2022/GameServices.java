import java.util.Random;

public class GameServices {
	private Random random;

	private double maxDamage;

	private int dice;

	public GameServices(double maxDamage, int dice) {
		this.dice = dice;
		this.maxDamage = maxDamage;

		random = new Random();
	}

	public double DamageCalculation(double damage) {
		int cubeNumber = random.nextInt(dice + 1);
		double returnDamage = 0;

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

	public double getMaxDamage() {
		return maxDamage;
	}

	public double setMaxDamage(double newMaxDamage) {
		if (newMaxDamage < 0) {
			maxDamage = 0;
		} else {
			maxDamage = newMaxDamage;
		}
	}
}