package entities.gameEntities;

import gameServices.*;

public interface IBotBehaviour {
	public void kick(GameServices gameService, IReadGameDataBase dataBaseRead, ISetGameDataBase dataBaseSet, int numberOfTeam) throws Exception;
}