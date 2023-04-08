import java.util.*;

public class AnalyticsService {
    DataBase dataBase;

    private Map<Integer, Group> groupById;

    public AnalyticsService(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public List<User> getFriends(int userId) {
        List<Subscribe> subr = dataBase.getSubscibtionsUsers();
        return subr.stream().filter(subscribe -> {return
                subscribe.getWho().getId() == userId
                &&
                subr.contains(new Subscribe(subscribe.getWhom(), subscribe.getWho()));})
                .map(Subscribe::getWhom).toList();
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
        Set<User> usersOfGroup = new TreeSet<>();

        usersOfGroup.addAll(getUsers(groupId));

        List<List<User>> friendsInGroup = new ArrayList<>();
        Map<Integer, Integer> idToVert = new HashMap<>();

        for (var i : usersOfGroup) {
            idToVert.put(i.getId(), friendsInGroup.size());

            friendsInGroup.add(new ArrayList<>());

            List<User> buf = getFriends(i.getId()).stream().filter(value -> {
                return usersOfGroup.contains(value);
            }).toList();


            friendsInGroup.get(friendsInGroup.size() - 1).addAll(buf);
        }

        List<List<Integer>> friendsGraf = new ArrayList<>();
        for(int i = 0; i < usersOfGroup.size(); i++){
            friendsGraf.add(new ArrayList<>());
            for(var j : friendsInGroup.get(i)) {
                friendsGraf.get(i).add(idToVert.get(j.getId()));
            }
        }

        int maxCluster = maxCluster(friendsGraf);

        return maxCluster * 1.0 / usersOfGroup.size() * 100;

    }

    private int maxCluster(List<List<Integer>> users) {
        boolean[] isPointed = new boolean[users.size()];
        int count = 0;
        for(int i = 0; i < users.size(); i++) {
            if(!isPointed[i]) {
                isPointed[i] = true;
                count = Math.max(count, countCluster(users, isPointed, i, 1));
            }
        }

        return count;
    }

    private int countCluster(List<List<Integer>> users, boolean[] isPointed, int vert, int count) {
        List<Integer> friends = users.get(vert);
        for(int i = 0; i < friends.size(); i++) {
            if(!isPointed[friends.get(i)]) {
                isPointed[friends.get(i)] = true;

                count += countCluster(users, isPointed, friends.get(i), 1);
            }
        }

        return count;
    }
}
