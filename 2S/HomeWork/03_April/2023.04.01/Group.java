import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Group {
    private int groupID;

    private String name;

    public String city;
    private List<User> members;

    public Group(int groupID, String name, String city) {
        this.groupID = groupID;

        this.name = name;
        this.city = city;

    }

    public void setMembers(User[] members) {
        this.members = new ArrayList<>();

        Arrays.stream(members).forEach(value -> {this.members.add(value);});
    }

    public void addMember(User member) {
        members.add(member);
    }

    public String getName() {
        return name;
    }

    public int getGroupID() {
        return groupID;
    }

    public String getCity() {return city;};

    public List<User> getMembers() {
        return members;
    }
}
