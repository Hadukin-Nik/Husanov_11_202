public class EntityTurn {
	private Entity entity;
	private IEntityBahaviour entityBehaviour;

	public EntityTurn(Entity entity, IEntityBahaviour entityBehaviour) {
		this.entity = entity;
		this.entityBehaviour = entityBehaviour;
	}

	public makeTurn() {
		if (entity.isAlive()) {
			entityBehaviour.makeTurn();
		}
	}
}