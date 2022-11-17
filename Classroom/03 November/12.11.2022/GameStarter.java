public class GameStarter {
	public static void main (String[] args) throws Exception  {
		GameServices gameServices = new GameServices(10, 20);
		GameDataBase gameDataBase = new GameDataBase(4);

		EntityFactory.createBot(gameDataBase, gameServices, 100, 1, true);
		EntityFactory.createPlayer(gameDataBase, gameServices, 100, 5);

		int fCommand = 1;
		int sCommand = 1;


		int turn = 0;
		System.out.println(gameDataBase.isAlive(0));

		while(gameDataBase.isAlive(0) && gameDataBase.isAlive(1)) {
			System.out.println("while!");
			if (turn == 2) {
				turn = 0;
			}

			if(turn == 0) {
				System.out.println("This is your turn!!!");

				System.out.println("Player: " + gameDataBase.getHPOfEntity(0));
				System.out.println("Bot: " + gameDataBase.getHPOfEntity(1));
			}

			gameDataBase.entityTurn(turn).makeTurn();

			
			turn ++;
		}
	}
}