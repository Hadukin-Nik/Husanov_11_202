public class GameDataBase implements IReadGameDataBase, ISetGameDataBase {
	private EntityState[] entitiesStatets;

	private int currentCountOfEntities;

	public GameDataBase() {
		currentCountOfEntities = 0;
	}

	public GameDataBase(int maxCountOfEntities) {
		super();

		entitiesStatets = new EntityState[maxCountOfEntities];
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

	public EntityTurn enityTurn(int id) {
		
	}
	public IUpdate getIUpdate(int id);

	public boolean isAlive(int id);
}