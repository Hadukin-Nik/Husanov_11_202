public class BotFabric {
	public static void createBot (GameDataBase gameDataBase, GameService gameService, int hp, int groupNumber, boolean isDifficult) {
		Entity bot = new Entity(hp, groupNumber);

		BotBehaviour turnBehaviour;
		
		if (isDifficult) {
			turnBehaviour = new BotBehaviour(gameService, gameDataBase, gameDataBase, new HardBotBehaviour(), groupNumber);
		} else {
			turnBehaviour = new BotBehaviour(gameService, gameDataBase, gameDataBase, new EasyBotBehaviour(), groupNumber);	
		}

		gameDataBase.add(bot, turnBehaviour);
	}

	public static void createPlayer(GameDataBase gameDataBase, GameService gameService, int hp, int groupNumber) {
		Entity player = new Entity(hp, groupNumber);

		PlayerBehaviour turnBehaviour = new PlayerBehaviour(gameService, gameDataBase, gameDataBase);
		
		gameDataBase.add(player, turnBehaviour);
	}
}