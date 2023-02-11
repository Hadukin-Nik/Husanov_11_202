package src.user;

import src.FilmsData;

import java.util.Scanner;

public class User {
    private String name;
    private boolean[] filmsAreeable;
    public User(String name) {
        this.name = name;
    }

    public void goThroughTest(String[] films) {
        Scanner sc = new Scanner(System.in);
        filmsAreeable = new boolean[films.length];
        for (int i = 0; i < films.length; i++) {
            System.out.println(" Are you setisfied with: " + films[i] + " y/n?");

            String ans = sc.nextLine();
            if (ans.equals("y") || ans.equals("yes") || ans.equals("1")) {
                filmsAreeable[i] = true;
            }
        }
    }
    public void setTest(String films) {
        filmsAreeable = new boolean[films.length()];

        for (int i = 0; i < filmsAreeable.length; i++) {
            if (films.charAt(i) == '+') {
                filmsAreeable[i] = true;
            }
        }
    }
    public boolean[] getFilmsAreeable() {
        return filmsAreeable;
    }

    public String getDataTest() {
        String ans;

        ans = name + "";
        for (int i = 0; i < filmsAreeable.length; i++) {
            ans += (filmsAreeable[i] ? "+" : "-");
        }

        return ans;
    }

    public int getCountOfPos() {
        int count = 0;
        for (int i = 0; i < filmsAreeable.length; i++) {
            if (filmsAreeable[i]) {
                count ++;
            }
        }

        return count;
    }

    public String getName() {
        return name;
    }
}
