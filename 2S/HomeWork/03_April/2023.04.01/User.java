import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private int userID;
    private int birthDate;

    private String name;

    private String surName;
    private String city;

    private List<User> friends;

    public User(int userID, String name, String surname, String city, int birthDate) {
        this.userID = userID;
        this.birthDate = birthDate;

        this.name = name;
        this.city = city;
        this.surName = surname;
    }

    public void setFriends(User[] friends) {
        this.friends = new ArrayList<>();

        Arrays.stream(friends).forEach(value -> {this.friends.add(value);});
    }

    public void addFriend(User friend) {
        friends.add(friend);
    }

    public int getId() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
