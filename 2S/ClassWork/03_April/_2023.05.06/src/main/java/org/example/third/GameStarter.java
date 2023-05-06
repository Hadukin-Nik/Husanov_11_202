package org.example.third;

import org.example.third.entities.inventoryEntities.IInventory;
import org.example.third.entities.inventoryEntities.IItem;
import org.example.third.entities.inventoryEntities.Inventory;
import org.example.third.entities.inventoryEntities.Item;
import org.example.third.gameServices.EntityFactory;
import org.example.third.gameServices.GameServices;
import org.example.third.gameServices.gameDataBase.GameDataBase;

import java.io.File;
import java.util.Scanner;

public class GameStarter {
	public static void main (String[] args) throws Exception  {
		GameServices gameServices = new GameServices(5, 20);
		GameDataBase gameDataBase = new GameDataBase(10);

		Scanner sc = new Scanner(new File("src/main/BattleField.txt"));

		int fCommand = 1;
		int sCommand = 4;

		int count = sc.nextInt();
		String fullPath = sc.next();

		IItem[] items = {new Item("MedKit", 50, 10)};
		IInventory newInventory = new Inventory(items);


		EntityFactory.createPlayer(gameDataBase, gameServices, newInventory, 100, 5);

		for (int i = 0; i < count; i++) {
			EntityFactory.createBot(gameDataBase, gameServices, fullPath + "." + sc.next(), new Inventory(), 100, 1);
		}

		int turn = 0;
		System.out.println(gameDataBase.isAlive(0));

		while(gameDataBase.isAlive(0) && gameDataBase.isAlive(1)) {
			if (turn == fCommand + sCommand) {
				turn = 0;
			}

			if(turn == 0) {
				System.out.println("");
				System.out.println("");

				System.out.println("This is your turn!!!");
				System.out.println("Player: " + gameDataBase.getHPOfEntity(0));

				for (int i = 0; i < sCommand; i++)  {
					System.out.println("Bot " + i + " : "+ gameDataBase.getHPOfEntity(i + 1));
				}
			}

			gameDataBase.entityTurn(turn).makeTurn();

			
			turn ++;

		}
	}
}