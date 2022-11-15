public class EntityState implements IHealthChange, IDamageChange, IHealthState, IDamageState {
	Entity entity;
	GameService gameService;

	double maxHP;

	public EntityState (Entity entity, GameService gameService, double maxHP) {
		this.entity = entity;
		this.gameService = gameService;

		this.maxHP = maxHP;
	}


	public double getCurrentHP() {
		return entity.getHP();
	}

	public double getMaxDamage() {
		return gameService.getMaxDamage();
	}


	public void addMaxHP(double addable) {
		maxHP += addable;
	}

	public void decMaxHP(double decreasable) {
		if (maxHP - decreasable < 0) {
			maxHP = 0;
		} else {
			maxHP -= decreasable;
		}
	}

	public void addHP(double addable) {
		double newHP = entity.getHP() + addable;

		if (newHP > maxHP) {
			entity.setHP(maxHP);
		} else {
			entity.setHP(newHP);
		}
	}
	
	public void decHP(double decreasable) {
		double newHP = entity.getHP() - decreasable;

		if (newHP < 0) {
			entity.setHP(0);
		} else {
			entity.setHP(newHP);
		}
	}

	public double getMaxHP() {
		return maxHP;
	}

	public void setMaxDamage(double maxDamage) {
		if (maxDamage < 0) {
			gameService.setMaxDamage(0)
		} else {
			gameService.setMaxDamage(maxDamage);
		}
	}

	public void addMaxDamage(double addable) {
		gameService.setMaxDamage(addable + gameService.getMaxDamage());
	}

	public void decMaxDamage(double decreasable) {
		double newMaxDamage = gameService.getMaxDamage() - decreasable;

		if (newMaxDamage < 0) {
			gameService.setMaxDamage(0);
		} else {
			gameService.setMaxDamage(newMaxDamage);
		}
	}
}