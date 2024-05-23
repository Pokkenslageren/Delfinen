import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Accountant extends Chairman implements java.io.Serializable{
    private static final long serialVersionUID = 6529685098267757680L;

    /**
     * The name of the accountant
     */
    private final String name = "Lasse";

    /**
     * List of all members in the club
     */
    // ArrayList<Member> members = getMembers();

    Scanner scanner = new Scanner(System.in);

    /**
     * Constructor for Accountant class
     * @param name The name of the accountant
     */
    public Accountant(String name) {
        super(name);
    }

    /**
     * Getter for name
     * @return THe name of the accountant
     */
    public String getName() {
        return super.getName();
    }

    /**
     * Prints the information on a member given member ID
     */
    public void printMemberInfo(int memberId) { // prints a unique member.
        //int memberId = scanner.nextInt();
        super.printMemberInfo(memberId);
        for (Member m : members) {
            if (m.getMemberId() == memberId) {
                m.printMemberInfo();
                System.out.println(m.getDueDate());
            }
        }
    }

    /**
     * Changes the isPaid and dueDate variables of the given member.
     * @param memberId The id of the member
     */
    public void markAsPaid (int memberId) {
        for(int i = 0; i < members.size(); i++) {

            if(memberId==members.get(i).getMemberId()) {
                System.out.println("Medlem: " + members.get(i).getMemberId() + ", fundet.");
                LocalDateTime now = LocalDateTime.now().plusYears(1).plusDays(30);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
                members.get(i).setDueDate(now.format(formatter));
                members.get(i).setIsPaid(true);
                System.out.println("Ændring gemt.");
                System.out.println("Medlemsskab tilhørende medlem: " + members.get(i).getMemberId() + ", navn: " + members.get(i).getName() + " er markeret betalt.");
                System.out.println("Næste betalingsdato: " + members.get(i).getDueDate() + ".");
            }
        }
    }

    public void markAsUnpaid (int memberId) {
        for(int i = 0; i < members.size(); i++) {

            if(memberId==members.get(i).getMemberId()) {
                System.out.println("Medlem: " + members.get(i).getMemberId() + ", fundet.");
                LocalDateTime now = LocalDateTime.now().plusYears(1).plusDays(30);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
                members.get(i).setDueDate(now.format(formatter));
                members.get(i).setIsPaid(false);
                System.out.println("Ændring gemt.");
                System.out.println("Medlemsskab tilhørende medlem: " + members.get(i).getMemberId() + ", navn: " + members.get(i).getName() + " er markeret ubetalt.");
            }
        }
    }

    /**
     * Blocks a member from using the club, given the member ID
     * @param memberId The ID of the given member
     */
    public void blockMember (int memberId) {
        for(int i = 0; i < members.size(); i++) {
            if(memberId==members.get(i).getMemberId()) {
                System.out.println("Medlem: " + members.get(i).getMemberId() + ", fundet.");
                members.get(i).setIsBlocked(true);
                System.out.println("Ændring gemt.");
                System.out.println("Medlemsskab tilhørende medlem: " + members.get(i).getMemberId() + ", navn: " + members.get(i).getName() + " er blokeret.");
            }
        }
    }

    /**
     * Unblocks a member from the club
     * @param memberId ID of the given member
     */
    public void unblockMember (int memberId) {
        for(int i = 0; i < members.size(); i++) {
            if(memberId==members.get(i).getMemberId()) {
                System.out.println("Medlem: " + members.get(i).getMemberId() + ", fundet.");
                members.get(i).setIsBlocked(false);
                System.out.println("Ændring gemt.");
                System.out.println("Medlemsskab tilhørende medlem: " + members.get(i).getMemberId() +", navn: " + members.get(i).getName() + " er ikke længere blokeret.");
            }
        }
    }

    /**
     * Prints all members with paid memberships
     */
    public void displayPaid() {
        int counter = 0;
        System.out.println("Viser betalte medlemsskaber:");
        for(Member m : members) {
            if(m.getIsPaid()) { //skal være instanceof Competitve swimmer.
                System.out.println("Medlem: " + m.getMemberId() + " - Navn: " + m.getName() + ".");
                counter++;
            }
        }
        if(counter == 0){
            System.out.println("Der er ingen betalte medlemsskaber.");
        }
    }


    /**
     * Prints all members with unpaid memberships
     */
    public void displayUnpaid() {
        int counter = 0;
        System.out.println("Viser ubetalte medlemsskaber:");
        for(Member m : members) {
            if(!m.getIsPaid()) {
                System.out.println("Medlem: " + m.getMemberId() + " - Navn: " + m.getName() + ".");
                counter++;
            }
        }
        if(counter == 0){
            System.out.println("Der er ingen ubetalte medlemsskaber.");
        }
    }

    /**
     * Prints all blocked members
     */
    public void displayBlocked() {
        int counter = 0;
        System.out.println("Viser blokerede medlemsskaber:");
        for(Member m : members) {
            if(m.getIsBlocked()) {
                System.out.println("Medlem: " + m.getMemberId() + " - Navn: " + m.getName() + ".");
                counter++;
            }
        }
        if(counter == 0 ){
            System.out.println("Der er ingen blokerede medlemmer.");
        }
    }

    public void displayDueDate(){
        System.out.println("Viser betalingsdatoer.");
        for (Member m : members){
            System.out.println("Medlem: " + m.getMemberId() + " - Navn: " + m.getName() + ", har betalingsdato: " + m.getDueDate() + ".");
        }
    }
}