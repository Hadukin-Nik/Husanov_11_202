package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FilmsData {
    private String[] films;

    public void getDataFromFile(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));

        int count = 0;

        while(sc.hasNextLine()) {
            count ++;

            sc.nextLine();
        }

        films = new String[count];

        sc = new Scanner(new File(fileName));

        for (int i = 0; i < count; i++) {
            films[i] = sc.nextLine();
        }
    }

    public String[] getFilms() {
        return films;
    }
}
