import java.util.Random;
import java.util.Scanner;

public class GetThree{
	public static void main(String[] args) {
		boolean gameOn = true;
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);


		int[] gemsCounts = new int[5];
		char[] gems = {' ', '$', '#', '?', '@'};
		
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);

		int countOfGems = Integer.parseInt(args[2]);

		int[][] field  = new int[m][n];

		for(int i = 0; i < m && countOfGems > 0; i++) {
			for(int j = 0; j < n && countOfGems > 0; j++) {
				int r = rand.nextInt(gems.length - 1) + 1;

				while(i > 0 && gems[r] == gems[field[i - 1][j]]) {
					r = rand.nextInt(gems.length - 1);
					r ++;
				}
				field[i][j] = r;
				gemsCounts[r]++;
				countOfGems--;
			}
		}
		//printing

		printOut(gems, field);

		//checking
		if (countOfGems >= m * n) {
			System.out.println("Wrong input");
		}

		//game loop
		int points = 0;
		while(gameOn) {
			//please, create an announcement
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();


			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			//Checking the input
			if (x1 >= n || y1 >= m || x2 >= n || y2 >= m) {
				System.out.println("Wrong input");
				continue;
			}
			if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0) {
				System.out.println("Wrong input");
				continue;
			}
			System.out.println(gems[field[y1][x1]] + " " + gems[field[y2][x2]]);
			int buf = field[y2][x2];
			field[y2][x2] = field[y1][x1];
			field[y1][x1] = buf;
			//swap field[y1][x1] and field[y2][x2]
			//the bonusCalculation
			int bonuses = calculateBonuses(field, x1, y1);

			if (bonuses >= 3) {
				calculateField(field, gemsCounts, x1, y1);
				points += bonuses;
			} 

			bonuses = calculateBonuses(field, x2, y2);

			if (bonuses >= 3) {
				calculateField(field, gemsCounts, x2, y2);
				points += bonuses;
			}

			//Checking if the game possible
			boolean isGameOn = false;
			for (int i = 0; i < gems.length; i++) {
				if (gemsCounts[i] >= 3) {
					isGameOn = true;
				}
			}

			gameOn = isGameOn;

			System.out.println("Score:" + points);
			printOut(gems, field);
		}
		

	}


	public static void printOut(char[] gems, int[][] field) {
		int n = field[0].length;
		int m = field.length;

		for (int i = m - 1; i >= 0; i--) {
			System.out.print(i);
			for (int j = 0; j < n; j++) {
				System.out.print(gems[field[i][j]] + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < n; i++) {
			System.out.print(" " + i);
		}
	}

	public static int calculateBonuses(int[][] field, int x, int y) {
		int n = field[0].length;
		int m = field.length;

		int bonuses = 1;

		for (int j = x + 1; j < n && field[y][j] == field[y][x]; j++) {
			//Calculate bonuses

			bonuses += 1;
		}

		for (int j = x - 1; j >= 0 && field[y][j] == field[y][x]; j--) {
			//Calculate bonuses

			bonuses += 1;
		}

		return bonuses;
	}

	public static void calculateField(int[][] field, int[] countOfGems, int x, int y) {
		int key = field[y][x];

		int n = field[0].length;
		int m = field.length;

		countOfGems[key]--;
		field[y][x] = 0;
		gemDownToEarth(field, x, y + 1);
		for (int j = x + 1; j < n && field[y][j] == key; j++) {
			field[y][j] = 0;
			gemDownToEarth(field, j, y + 1);
			countOfGems[key]--;
		}

		for (int j = x - 1; j >= 0 && field[y][j] == key; j--) {
			field[y][j] = 0;
			gemDownToEarth(field, j, y + 1);
			countOfGems[key]--;
		}
	}

	public static void gemDownToEarth(int[][] field, int x, int y) {
		int n = field[0].length;
		int m = field.length;

		if (x >= n || y >= m || field[y][x] == 0) {
			return;
		} else {
			field[y - 1][x] = field[y][x];
			field[y][x] = 0;

			gemDownToEarth(field, x, y + 1);
		}
	}
}