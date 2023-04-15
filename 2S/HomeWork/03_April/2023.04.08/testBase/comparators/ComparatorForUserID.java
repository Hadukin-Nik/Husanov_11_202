package testBase.comparators;

import java.util.Comparator;
import testBase.User;

public class ComparatorForUserID implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getId() - o2.getId();
    }
}
