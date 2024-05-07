import java.util.*;
public class Chairman{

    private final String name;
    ArrayList<Member> members;
    Scanner scanner = new Scanner(System.in);

    public Chairman(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void printMemberInfo(int memberId){ // prints a unique member.
        for (Member m : members){
            if (m.getMemberId() == memberId){
                m.printMemberInfo();
            }
        }
    }

    public void printMembers(){ // prints entire member-list.
        for (Member m : members){
            m.printMemberInfo();
        }
    }

    public void addMember(){
        System.out.println("Tryk 1 for motionist, tryk 2 for konkurrencesvømmer.");
        int input = scanner.nextInt();
        switch (input){

            case 1:
                System.out.println("Indtast navn: ");
                String name = scanner.next();
                System.out.println("Indtast alder: ");
                int age = scanner.nextInt();
                System.out.println("Indtast køn: 1: for mand, 2: for kvinde, 3: for andet.");
                int gender = scanner.nextInt();
                System.out.println("Indtast telefonnummer: ");
                int phoneNr = scanner.nextInt();
                System.out.println("Indtast addresse: ");
                String address = scanner.next();
                Member m = new Member(name, age, gender, phoneNr, address);
                members.add(m);
        }
    }

}