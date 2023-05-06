package org.example.third.entities.gameEntities;
import org.example.third.gameServices.GameServices;
import org.example.third.gameServices.gameDataBase.IReadGameDataBase;
import org.example.third.gameServices.gameDataBase.ISetGameDataBase;

public interface IBotBehaviour {
	public void kick(GameServices gameService, IReadGameDataBase dataBaseRead, ISetGameDataBase dataBaseSet, int numberOfTeam) throws Exception;
}