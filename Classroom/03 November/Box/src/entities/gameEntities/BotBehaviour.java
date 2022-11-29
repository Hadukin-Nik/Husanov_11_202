package entities.gameEntities;

import java.util.Random;
import gameServices.gameDataBase.*;

public class BotBehaviour implements IEntityBehaviour {
	private GameServices gameService;
	private IReadGameDataBase dataBaseRead;
	private ISetGameDataBase dataBaseSet;
	private IBotBehaviour botBehaviour;

	private int numberOfTeam;

	public BotBehaviour() {
	}

	public BotBehaviour (GameServices gameService, IReadGameDataBase dataBaseRead, ISetGameDataBase dataBaseSet, IBotBehaviour botBehaviour , int numberTeam) {
		this.gameService = gameService;
		this.dataBaseRead = dataBaseRead;
		this.dataBaseSet = dataBaseSet;

		this.botBehaviour = botBehaviour;

		this.numberOfTeam = numberOfTeam;
	}

	public void makeTurn() throws Exception{
		botBehaviour.kick(gameService, dataBaseRead, dataBaseSet, numberOfTeam);
	}
}