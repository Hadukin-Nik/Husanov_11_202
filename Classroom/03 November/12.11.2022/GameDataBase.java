public class GameDataBase implements IReadGameDataBase, ISetGameDataBase {
	private EntityState[] entitiesStatets;
	private IEntityBehaviour[] entitiesTurn;

	private int maxCountOfEntities;

	private int currentCountOfEntitiesStates;
	private int currentCountOfEntitiesBehaviours;

	public GameDataBase() {
		currentCountOfEntitiesStates = 0;
		currentCountOfEntitiesBehaviours = 0;
	}

	public GameDataBase(int maxCountOfEntities) {
		super();

		this.maxCountOfEntities = maxCountOfEntities;

		entitiesStatets = new EntityState[maxCountOfEntities];
		entitiesTurn = new IEntityBehaviour[maxCountOfEntities];

	}

	public void damage(int idOfEnemy, double damage) throws Exception {
		if (idOfEnemy >= currentCountOfEntitiesStates) {
			throw new Exception("id of enemy for damage is out of range");
		} else {
			entitiesStatets[idOfEnemy].decHP(damage);
		}
	}

	public int getNumberOfEntities() {
		return currentCountOfEntitiesStates;
	}
	public int getNumberOfTeam(int id) throws Exception {
		if (id >= currentCountOfEntitiesStates) {
			throw new Exception("id is out of range");
		} else {
			return entitiesStatets[id].getNumberOfTeam();
		} 
	}


	public double getHPOfEntity(int id) throws Exception {
		if (id >= currentCountOfEntitiesStates) {
			throw new Exception("id is out of range");
		} else {
			return entitiesStatets[id].getHPState();
		}
	}


	public IEntityBehaviour entityTurn(int id) throws Exception {
		if (id >= currentCountOfEntitiesStates) {
			throw new Exception("id is out of range");
		} else {
			return entitiesTurn[id];
		} 
	}
	//public IUpdate getIUpdate(int id) {
		//not realized yet
	//}

	public boolean isAlive(int id) throws Exception {
		if (id >= currentCountOfEntitiesStates) {
			throw new Exception("id is out of range");
		} else {
			return entitiesStatets[id].getHPState() > 0;
		
		} 
	}

	public void addEntityState(EntityState entityState) throws Exception {
		if (currentCountOfEntitiesStates > maxCountOfEntities) {
			throw new Exception("too many entities");
		}

		entitiesStatets[currentCountOfEntitiesStates] = entityState;
		currentCountOfEntitiesStates ++;
	}

	public void addEntityBehaviour(IEntityBehaviour entityBehaviour) throws Exception {
		if (currentCountOfEntitiesBehaviours > maxCountOfEntities) {
			throw new Exception("too many entities");
		}

		entitiesTurn[currentCountOfEntitiesBehaviours] = entityBehaviour;
		currentCountOfEntitiesBehaviours++;
	}
}