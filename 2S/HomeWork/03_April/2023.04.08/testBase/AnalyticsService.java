package testBase;

import java.util.List;

public class AnalyticsService {
    DataBase dataBase;

    public AnalyticsService(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public List<String> getLastNamesBeforeYear(int year) {
        List<User> users = dataBase.getUsers();

        return users.stream().filter(user -> {return user.getYear() <= year;}).map(User::getLastName).toList();
    }

    public int getNumberByYear(int year) {
        List<User> users = dataBase.getUsers();

        return users.stream().filter(user -> {return user.getYear() == year;}).toArray().length;
    }

    public List<String> getSubscriptionsNames(int userId) {
        List<Subscribe> subr = dataBase.getSubscibtions();
        return subr.stream().filter(user -> {return user.getWho().getId() == userId;})
                    .map(Subscribe::getWhom).map(User::getName).toList();
    }

    public List<String> getSubscribersNames(int userId) {
        List<Subscribe> subr = dataBase.getSubscibtions();
        return subr.stream().filter(user -> {return user.getWhom().getId() == userId;})
                .map(Subscribe::getWho).map(User::getName).toList();
    }

    public List<String> getFriends(int userId) {
        List<Subscribe> subr = dataBase.getSubscibtions();
        return subr.stream().filter(subscribe -> {return
                subscribe.getWho().getId() == userId
                &&
                subr.contains(new Subscribe(subscribe.getWhom(), subscribe.getWho()));})
                .map(Subscribe::getWhom).map(User::getName).toList();
    }
}
