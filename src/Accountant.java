import java.util.*;
public class Accountant extends Chairman {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Member> members = getMembers();

    public Accountant(String name) {
        super(name);
    }

    public String getName() {
        return super.getName();
    }

    public void printMemberInfo(int memberId) {
        super.printMemberInfo(memberId);

    }

    public void editMember (int memberId) {

    }
}