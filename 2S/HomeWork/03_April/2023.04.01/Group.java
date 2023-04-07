import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Group {
    private int groupID;

    private String name;
    private List<User> members;

    public Group(int groupID, String name) {
        this.groupID = groupID;

        this.name = name;
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

    public List<User> getMembers() {
        return members;
    }
}
