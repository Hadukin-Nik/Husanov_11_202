package src;

import src.user.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UsersData {

    User[] users;

    public void getDataFromFile (String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));

        int count = 0;

        while(sc.hasNextLine()) {
            count ++;

            sc.nextLine();
        }

        users = new User[count];

        sc = new Scanner(new File(fileName));

        for (int i = 0; i < count; i++) {
            String[] raw = sc.nextLine().split(":");
            users[i] = new User(raw[0]);

            users[i].setTest(raw[1]);
        }
    }

    public User findUserByName(String name) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getName().equals(name)) {
                return users[i];
            }
        }

        return null;
    }

    public User[] getUsers() {
        return users;
    }
}
