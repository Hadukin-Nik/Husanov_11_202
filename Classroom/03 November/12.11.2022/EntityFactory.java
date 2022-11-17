public class EntityFactory {
	private static void createEntity (GameDataBase gameDataBase, GameServices gameService, int hp, int groupNumber) throws Exception{
		Entity entity = new Entity(hp, groupNumber);

		EntityState entityState = new EntityState(entity, gameService, hp);

		gameDataBase.addEntityState(entityState);
	}


	public static void createBot (GameDataBase gameDataBase, GameServices gameService, int hp, int groupNumber, boolean isDifficult) throws Exception{
		createEntity(gameDataBase, gameService, hp, groupNumber);

		BotBehaviour turnBehaviour = new BotBehaviour();
		
		if (isDifficult) {
			turnBehaviour = new BotBehaviour(gameService, gameDataBase, gameDataBase, new HardBotBehaviour(), groupNumber);
		} else {
			turnBehaviour = new BotBehaviour(gameService, gameDataBase, gameDataBase, new EasyBotBehaviour(), groupNumber);	
		}

		gameDataBase.addEntityBehaviour(turnBehaviour);
	}

	public static void createPlayer(GameDataBase gameDataBase, GameServices gameService, int hp, int groupNumber) throws Exception{
		createEntity(gameDataBase, gameService, hp, groupNumber);

		PlayerBehaviour turnBehaviour = new PlayerBehaviour(gameService, gameDataBase, gameDataBase);
		
		gameDataBase.addEntityBehaviour(turnBehaviour);
	}
}