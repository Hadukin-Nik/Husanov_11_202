import java.util.Random;

public class BotBehaviour implements ITurnOfEnityBehaviour {
	private GameService gameService;
	private IReadGameDataBase dataBaseRead;
	private ISetGameDataBase dataBaseSet;
	private IBotBehaviour botBehaviour;

	private int maxDamage;
	private int numberTeam;

	public EntityBehaviour (GameService gameService, IReadGameDataBase dataBaseRead, ISetGameDataBase dataBaseSet, IBotBehaviour botBehaviour , int numberTeam) {
		this.gameService = gameService;
		this.dataBaseRead = dataBaseRead;
		this.dataBaseSet = dataBaseSet;

		this.botBehaviour = botBehaviour;

		this.numberTeam = numberTeam;
	}

	public void makeTurn() {
		botBehaviour.makeKick(gameService, dataBaseRead, dataBaseSet, numberTeam);
	}
}