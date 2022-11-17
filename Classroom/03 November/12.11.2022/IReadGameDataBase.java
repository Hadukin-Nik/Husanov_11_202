public interface IReadGameDataBase {
	public int getNumberOfEntities();
	public int getNumberOfTeam(int id) throws Exception;

	public double getHPOfEntity(int id) throws Exception;

	public IEntityBehaviour entityTurn(int id) throws Exception ;
	//public IUpdate getIUpdate(int id);

	public boolean isAlive(int id) throws Exception ;
}