package org.example.third.entities.gameEntities;

import org.example.third.gameServices.gameDataBase.IReadGameDataBase;
import org.example.third.gameServices.gameDataBase.ISetGameDataBase;

public interface IPlayerBehaviour {
	public void makePlayerChoose(IReadGameDataBase dataBaseRead, ISetGameDataBase dataBaseSet);
}