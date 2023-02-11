public class GameStarter {
	public static void main (String[] args) throws Exception  {
		GameServices gameServices = new GameServices(5, 20);
		GameDataBase gameDataBase = new GameDataBase(10);


		int fCommand = 1;
		int sCommand = 4;


		IItem[] items = {new Item("MedKit", 50, 10)};
		IInventory newInventory = new Inventory(items);


		EntityFactory.createPlayer(gameDataBase, gameServices, newInventory, 100, 5);

		for (int i = 0; i < sCommand; i++) {
			EntityFactory.createBot(gameDataBase, gameServices, new Inventory(), 100, 1, true);
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