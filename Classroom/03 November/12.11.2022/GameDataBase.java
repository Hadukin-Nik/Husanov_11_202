public class GameDataBase implements IReadGameDataBase, ISetGameDataBase {
	private EntityState[] entitiesStatets;
	private IEntityBehaviour[] entitiesTurn;

	private int currentCountOfEntities;

	public GameDataBase() {
		currentCountOfEntities = 0;

	}

	public GameDataBase(int maxCountOfEntities) {
		super();

		entitiesStatets = new EntityState[maxCountOfEntities];
		entitiesTurn = new IEntityBehaviour[maxCountOfEntities];
	}

	public void damage(int idOfEnemy, int damage) {
		if (idOfEnemy >= currentCountOfEntities) {
			throw new Exception("id of enemy for damage is out of range");
		} else {
			entitiesStatets[idOfEnemy].decHP(damage);
		}
	}

	public int getNumberOfEntities() {
		return currentCountOfEntities;
	}
	public int getNumberOfTeam(int id) {
		if (id >= currentCountOfEntities) {
			throw new Exception("id is out of range");
		} else {
			entitiesStatets[id].getNumberOfTeam(damage);
		} 
	}

	public EntityTurn entityTurn(int id) {
		if (id >= currentCountOfEntities) {
			throw new Exception("id is out of range");
		} else {
			entitiesTurn[id].makeTurn(damage);
		} 
	}
	public IUpdate getIUpdate(int id) {
		//not realized yet
	}

	public boolean isAlive(int id) {
		if (id >= currentCountOfEntities) {
			throw new Exception("id is out of range");
		} else {
			return entitiesStatets[id].getHP(damage) <= 0;
		} 
	}
}