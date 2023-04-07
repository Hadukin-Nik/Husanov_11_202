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

    @Override
    public boolean equals(Object value) {
        if(!(value instanceof Subscribe)) return false;


        return who.equals(((Subscribe) value).who) && whom.equals(((Subscribe)value).whom);
    }
}
