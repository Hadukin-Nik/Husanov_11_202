package entities.gameEntities;

import gameServices.*;

public interface IPlayerBehaviour {
	public void makePlayerChoose(IReadGameDataBase dataBaseRead, ISetGameDataBase dataBaseSet);
}