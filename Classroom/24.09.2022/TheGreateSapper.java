import java.util.Random;
import java.util.Scanner;
public class TheGreateSapper{
	
	public static char toChar(int e) {
		return ((char)(e +'0'));
	}
	public static void main(String[] args) {
		int width = Integer.parseInt(args[0]);
		int height = Integer.parseInt(args[1]);
		int nMines = Integer.parseInt(args[2]);

		boolean gameIsRunning = true;

		if (nMines >= width * height - 1) {
			gameIsRunning = false;

			System.out.println("Data is incorrect");
		}

		//generation
		int[][] gameField = new int[height][width];
		char[][] playerView = new char[height][width];

		Random r = new Random();

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				gameField[i][j] = 0;
				playerView[i][j] = '~';
			}
		}

		while (gameIsRunning && nMines > 0) {
			int x = r.nextInt(width);
			int y = r.nextInt(height);
			
			if (gameField[y][x] != 9) {
				gameField[y][x] = 9;

				if (x > 0 && gameField[y][x - 1] != 9) {
					gameField[y][x - 1]++;
				}
				if (x < width - 1 && gameField[y][x + 1] != 9) {
					gameField[y][x + 1]++;
				}
				
				if (y > 0) {
					if (gameField[y - 1][x] != 9) {
						gameField[y - 1][x]++;
					}

					if (x > 0 && gameField[y - 1][x - 1] != 9) {
						gameField[y - 1][x - 1]++;
					}

					if (x < width - 1 && gameField[y - 1][x + 1] != 9) {
						gameField[y - 1][x + 1]++;
					}
				}

				if (y < height - 1) {
					if (gameField[y + 1][x] != 9) {
						gameField[y + 1][x]++;
					}
					if (x > 0 && gameField[y + 1][x - 1] != 9) {
						gameField[y + 1][x - 1]++;
					}
					if (x < width - 1 && gameField[y + 1][x + 1] != 9) {
						gameField[y + 1][x + 1]++;
					}
				}
				nMines --;
			}
		}

		Scanner sc = new Scanner(System.in);

		//GameEngine

		while (gameIsRunning) {
			char c = sc.next().charAt(0);
			int x = sc.nextInt();
			int y = sc.nextInt();

			if (x >= width || y >= height || x < 0 || y < 0)  {
				System.out.println("Error! Please enter new dot");
				continue;
			}
			if (c == 'f') {
				playerView[y][x] = '$';
			}
			if (c == 'd') {
				playerView[y][x] = '~';
			}
			if (gameField[y][x] == 9 && c == 'c') {
				System.out.println("BUM!");
				gameIsRunning = false;
			} else if (c == 'c'){
				playerView[y][x] = toChar(gameField[y][x]);
				if (playerView[y][x] =='0') {


					if (x > 0) {
						playerView[y][x - 1] = toChar(gameField[y][x - 1]);
					}
					if (x < width - 1) {
						playerView[y][x + 1] = toChar(gameField[y][x + 1]);
					}
				
					if (y > 0) {
						playerView[y - 1][x] = toChar(gameField[y - 1][x]);

						if (x > 0) {
							playerView[y - 1][x - 1] = toChar(gameField[y - 1][x - 1]);
						}	

						if (x < width - 1) {
							playerView[y - 1][x + 1] = toChar(gameField[y - 1][x + 1]);
						}
					}

					if (y < height - 1) {
						playerView[y + 1][x] = toChar(gameField[y + 1][x]);
					
						if (x > 0) {
							playerView[y + 1][x - 1] = toChar(gameField[y + 1][x - 1]);
						}
						if (x < width - 1) {
							playerView[y + 1][x + 1] = toChar(gameField[y + 1][x + 1]);
						}
					}
				}

				
			}

			for (int i =0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					System.out.print(playerView[i][j] + " ");
				}
				System.out.println();
			}		
		}
	}
}