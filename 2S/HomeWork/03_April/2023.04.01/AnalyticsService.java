import java.util.ArrayList;
import java.util.List;

public class AnalyticsService {
    DataBase dataBase;

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
        if(dataBase.g)
    }
}
