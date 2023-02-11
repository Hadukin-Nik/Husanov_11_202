package gameServices.gameDataBase;

public interface ISetGameDataBase {
	public void damage(int idOfEnemy, double damage) throws Exception;
	public void heal(int id, double countOfHeal) throws Exception;

}