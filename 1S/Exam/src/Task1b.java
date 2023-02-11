import java.util.Scanner;

public class Task1b {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);

        int n = a.nextInt();
        int m = a.nextInt();

        String[][] matrix = new String[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = a.next();
            }
        }

        boolean onTurn = true;


        int countOfLines = 0;
        int allNotGlasnaya = 0;

        for (int i = 0; i < n; i++) {
            int counter = 0;

            for (int j = 0; j < m; j++) {
                int glasnaya = 0;
                int notGlasnaya = 0;

                for (int b = 0; b < matrix[i][j].length(); b++) {
                    if (isGlasnaya(matrix[i][j].charAt(b))) {
                        glasnaya ++;
                    } else {
                        notGlasnaya ++;
                    }
                }

                if (glasnaya > notGlasnaya) {
                    counter ++;
                }

                if (isGlasnaya(matrix[i][j].charAt(0))) {
                    countOfLines ++;
                }

                allNotGlasnaya += notGlasnaya;
            }

            if (onTurn && counter != 2) {
                onTurn = false;
            }
        }

        System.out.println("if common statment is true: " + (onTurn ? "Yes" : "No") +
                ('\n' + "Statistics: all lines: " + countOfLines + " count of letters: " + allNotGlasnaya));


    }

    public static boolean isGlasnaya(char a) {
        switch (a) {
            case 'a', 'e', 'y', 'u', 'i', 'o':
                return true;
            default:
                return false;
        }
    }
}