import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBase {
    String subscribtionsUserAddress;
    String subscribtionsGroupAddress;
    String usersAddress;

    String groupsAddress;

    List<User> users;
    List<Group> groups;

    public DataBase(String subscribtionsAddress, String subscribtionsGroupAddress, String usersAddress, String groupsAddress) {
        this.subscribtionsUserAddress = subscribtionsAddress;
        this.usersAddress = usersAddress;
        this.groupsAddress = groupsAddress;

        users = null;
    }

    public List<User> getUsers() {
        if(users != null) return users;
        users = new ArrayList<>();
        Scanner sc = new Scanner(usersAddress);
        while(sc.hasNext()) {
            String[] buf = sc.next().split(" ");
            users.add(new User(Integer.parseInt(buf[0]), buf[1], buf[2], buf[3], Integer.parseInt(buf[4])));
        }

        return users;
    }

    public List<Group> getGroups() {
        if(groups != null) return groups;
        groups = new ArrayList<>();
        Scanner sc = new Scanner(groupsAddress);
        while(sc.hasNext()) {
            String[] buf = sc.next().split(" ");
            groups.add(new Group(Integer.parseInt(buf[0]), (buf[1])));
        }

        return groups;
    }

    public User getUserById(int id) {
        return getUsers().stream().filter(user -> {return user.getId() == id;}).findFirst().get();
    }

    public Group getGroupById(int id) {
        return getGroups().stream().filter(value -> {return value.getGroupID() == id;}).findFirst().get();
    }

    public List<Subscribe> getSubscibtionsUsers() {
        List<Subscribe> subscriptions = new ArrayList<>();

        Scanner sc = new Scanner(subscribtionsUserAddress);

        while(sc.hasNext()) {
            String[] buf = sc.next().split(" ");
            subscriptions.add(new Subscribe(getUserById(Integer.parseInt(buf[0])), getUserById(Integer.parseInt(buf[1]))));
        }

        return subscriptions;
    }

    public List<Subscribe> getSubscibtionsGroups() {
        List<Subscribe> subscriptions = new ArrayList<>();

        Scanner sc = new Scanner(subscribtionsGroupAddress);

        while(sc.hasNext()) {
            String[] buf = sc.next().split(" ");
            subscriptions.add(new Subscribe(getUserById(Integer.parseInt(buf[0])), getUserById(Integer.parseInt(buf[1]))));
        }

        return subscriptions;
    }
}
