public interface IReadGameDataBase {
	public int getNumberOfEntities();
	public int getNumberOfTeam(int id);

	public EntityTurn entityTurn(int id);
	public IUpdate getIUpdate(int id);

	public boolean isAlive(int id);
}