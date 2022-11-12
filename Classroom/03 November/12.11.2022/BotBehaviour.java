import java.util.Random;

public class BotBehaviour implements IEntityBehaviour {
	private GameService gameService;
	private IReadGameDataBase dataBase;
	private ISetGameDataBase dataBaseSet;

	private Random random;

	private int idOfEnemy;

	private int maxDamage;
	private int countOfPlayers;

	public BotBehaviour (GameService gameService, IReadGameDataBase dataBaseRead, ISetGameDataBase dataBaseSet, IBotBehaviour botBehaviour , int numberTeam) {
		this.gameService = gameService;
		this.dataBaseRead = dataBaseRead;
		this.dataBaseSet = dataBaseSet;
		this.numberTeam = numberTeam;

		this.countOfEntities = dataBase.getNumberOfEntities();
	}

	public void makeTurn() {
		botBehaviour.makeKick(gameService, dataBaseRead, dataBaseSet, numberTeam, countOfEntities);
	}
}