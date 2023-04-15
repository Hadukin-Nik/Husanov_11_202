package testBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBase {
    String subscribtionsAddress;
    String usersAddress;

    List<User> users;

    public DataBase(String subscribtionsAddress, String usersAddress) {
        this.subscribtionsAddress = subscribtionsAddress;
        this.usersAddress = usersAddress;

        users = null;
    }

    public List<User> getUsers() {
        if(users != null) return users;
        List<User> users = new ArrayList<>();
        Scanner sc = new Scanner(usersAddress);
        while(sc.hasNext("[A-Za-z]* [A-za-z]* [1-9]* [1-9]*")) {
            String[] buf = sc.next().split(" ");
            users.add(new User(buf[0], Integer.parseInt(buf[2]), Integer.parseInt(buf[3])));
        }

        return users;
    }

    public User getUserById(int id) {
        return getUsers().stream().filter(user -> {return user.getId() == id;}).findFirst().get();
    }

    public List<Subscribe> getSubscibtions() {
        List<Subscribe> subscriptions = new ArrayList<>();

        Scanner sc = new Scanner(subscribtionsAddress);

        List<User> users = getUsers();

        while(sc.hasNext("[1-9]* [1-9]*")) {
            String[] buf = sc.next().split(" ");
            subscriptions.add(new Subscribe(getUserById(Integer.parseInt(buf[0])), getUserById(Integer.parseInt(buf[1]))));
        }

        return subscriptions;
    }
}
