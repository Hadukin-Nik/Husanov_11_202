package entities.gameEntities;

import gameServices.gameDataBase.*;
import gameServices.*;

public interface IPlayerBehaviour {
	public void makePlayerChoose(IReadGameDataBase dataBaseRead, ISetGameDataBase dataBaseSet);
}