package testBase;

public class Subscribe {
    private User who;
    private User whom;

    public Subscribe(User who, User whom) {
        this.who = who;
        this.whom = whom;
    }

    public User getWho() {
        return who;
    }

    public User getWhom() {
        return whom;
    }
}
