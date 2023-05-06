package org.example.third.gameServices;

import org.example.third.entities.gameEntities.*;
import org.example.third.entities.inventoryEntities.IInventory;
import org.example.third.gameServices.gameDataBase.GameDataBase;

public class EntityFactory {
	private static void createEntity (GameDataBase gameDataBase, GameServices gameService, IInventory inventory, int hp, int groupNumber) throws Exception{
		Entity entity = new Entity(hp, groupNumber);

		EntityState entityState = new EntityState(entity, gameService, hp);

		gameDataBase.addEntityState(entityState);
		gameDataBase.addEntityInventory(inventory);
	}


	public static void createBot (GameDataBase gameDataBase, GameServices gameService, String nameOfClassBehaviour, IInventory inventory, int hp, int groupNumber) throws Exception{
		createEntity(gameDataBase, gameService, inventory, hp, groupNumber);

		Class<IBotBehaviour> b = (Class<IBotBehaviour>) Class.forName(nameOfClassBehaviour);
		BotBehaviour turnBehaviour = new BotBehaviour(gameService, gameDataBase, gameDataBase, ((Class<IBotBehaviour>) Class.forName(nameOfClassBehaviour)).newInstance(), groupNumber);


		gameDataBase.addEntityBehaviour(turnBehaviour);
	}

	public static void createPlayer(GameDataBase gameDataBase, GameServices gameService, IInventory inventory, int hp, int groupNumber) throws Exception{
		createEntity(gameDataBase, gameService, inventory, hp, groupNumber);

		PlayerBehaviour turnBehaviour = new PlayerBehaviour(gameService, gameDataBase, gameDataBase, inventory);
		
		gameDataBase.addEntityBehaviour(turnBehaviour);
	}
}