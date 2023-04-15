package testBase.comparators;

import testBase.User;

import java.util.Comparator;

public class ComparatorForUserName implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
