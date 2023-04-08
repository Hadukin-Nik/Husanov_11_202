import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnalyticsService {
    DataBase dataBase;

    private Map<Integer, Group> groupById;

    public AnalyticsService(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public List<String> getFriends(int userId) {
        List<Subscribe> subr = dataBase.getSubscibtionsUsers();
        return subr.stream().filter(subscribe -> {return
                subscribe.getWho().getId() == userId
                &&
                subr.contains(new Subscribe(subscribe.getWhom(), subscribe.getWho()));})
                .map(Subscribe::getWhom).map(User::getName).toList();
    }

    public List<User> getUsersOfSameCity(int userId) {
        String city = dataBase.getUserById(userId).getCity();
        return dataBase.getUsers().stream().filter(value -> {return value.getCity().equals(city);}).toList();
    }

    public List<User> getUsers(int group) {
        List<Subscribe> subrs = dataBase.getSubscibtionsGroups();

        List<User> users = subrs.stream().map(Subscribe::getWho).toList();

        return users;
    }

    public Integer getCountUsers(int group) {
        return getUsers(group).size();
    }

    public double procentOfUsersOfSameCityAsGroup(int groupId) {
        List<User> usersOfGroup = getUsers(groupId);

        Group group = dataBase.getGroupById(groupId);

        return usersOfGroup.stream().filter(user -> {return user.getCity().equals(group.getCity());}).count() * 1.0
                / usersOfGroup.size() * 100;
    }

    public double procentOfUsersFriendship(int groupId) {

    }
}
