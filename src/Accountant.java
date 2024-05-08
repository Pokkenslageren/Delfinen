import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Accountant extends Chairman {

    private final String name = "Lasse";
    Scanner scanner = new Scanner(System.in);
    // ArrayList<Member> members = getMembers();

    public Accountant(String name) {
        super(name);
    }

    public String getName() {
        return super.getName();
    }

    public void printMemberInfo(int memberId){ // prints a unique member.
        super.printMemberInfo(memberId);
    }

    public void markAsPaid (int memberId) {
        for(int i = 0; i < members.size(); i++) {
            if(memberId==members.get(i).getMemberId()) {
                System.out.println("Medlem: " + members.get(i).getMemberId() + " fundet.");
                LocalDateTime now = LocalDateTime.now().plusYears(1).plusDays(30);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
                members.get(i).setDueDate(now.format(formatter));
                System.out.println("Ændring gemt.");
                System.out.println("Medlemsskab tilhørende medlem: " + members.get(i).getMemberId() + ", navn: " + members.get(i).getName() + " er markeret betalt.");
                System.out.println("Næste betalingsdato: " + members.get(i).getDueDate());
            }
        }
    }

    public void blockMember (int memberId) {
        for(int i = 0; i < members.size(); i++) {
            if(memberId==members.get(i).getMemberId()) {
                System.out.println("Medlem: " + members.get(i).getMemberId() + " fundet.");
                members.get(i).setIsBlocked(true);
                System.out.println("Ændring gemt.");
                System.out.println("Medlemsskab tilhørende medlem: " + members.get(i).getMemberId() + ", navn: " + members.get(i).getName() + " er blokeret.");
            }
        }
    }

    public void unblockMember (int memberId) {
        for(int i = 0; i < members.size(); i++) {
            if(memberId==members.get(i).getMemberId()) {
                System.out.println("Medlem: " + members.get(i).getMemberId() + " fundet.");
                members.get(i).setIsBlocked(false);
                System.out.println("Ændring gemt.");
                System.out.println("Medlemsskab tilhørende medlem: " + members.get(i).getMemberId() +", navn: " + members.get(i).getName() + " er blokeret.");
            }
        }
    }

    public void displayPaid() {
        System.out.println("Viser betalte medlemsskaber:");
        for(Member m : members) {
            if(m.getIsPaid()) {
                System.out.println("Medlem: " + m.getMemberId() + "- Navn: " + m.getName());
            }
        }
    }



    public void displayUnpaid() {
        System.out.println("Viser ubetalte medlemsskaber:");
        for(Member m : members) {
            if(!m.getIsPaid()) {
                System.out.println("Medlem: " + m.getMemberId() + "- Navn: " + m.getName());
            }
        }
    }

    public void displayBlocked() {
        System.out.println("Viser blokerede medlemsskaber:");
        for(Member m : members) {
            if(m.getIsBlocked()) {
                System.out.println("Medlem: " + m.getName() + "- Navn: " + m.getName());
            }
        }
    }
}