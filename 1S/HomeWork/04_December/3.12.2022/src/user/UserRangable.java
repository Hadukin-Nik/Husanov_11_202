package src.user;

public class UserRangable {
    private User me;
    private User compareWith;

    private double equality;

    public UserRangable(User user, User compareWith, double equality) {
        this.me = user;
        this.compareWith = compareWith;

        this.equality = equality;
    }

    public User getMe() {
        return me;
    }

    public User getCompareWith() {
        return compareWith;
    }

    public double getEquality() {
        return equality;
    }
}
