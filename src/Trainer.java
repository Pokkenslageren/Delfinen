import java.util.*;
import java.io.*;
public class Trainer extends Chairman {
    private final String name = "Jon";
    ArrayList<Member> members = new ArrayList<>();

    public Trainer(String name) {
        super(name);

    }

    public void printJunior() {
        for (Member m : members) {
            if (m.getAge() < 18 && m instanceof CompetitiveSwimmer) {
                m.printMemberInfo();
            }
        }
    }

    public void printSenior() {
        for (Member m : members) {
            if (m.getAge() >= 18 && m instanceof CompetitiveSwimmer) {
                m.printMemberInfo();
            }
        }
    }

    public void addResults(int memberId) {
        Scanner scanner = new Scanner(System.in);
        double time = scanner.nextDouble();
        String competition = scanner.next();
        int placement = scanner.nextInt();
        boolean isCompetition = scanner.nextBoolean();
        String discipline = scanner.next();
        for (int i = 0; i < members.size(); i++) {
            if (memberId == members.get(i).getMemberId() && members.get(i) instanceof CompetitiveSwimmer) {
                Results r = new Results(time, competition, placement, isCompetition, discipline);
                if(r.getIsCompetition()){
                    ((CompetitiveSwimmer) members.get(i)).addCompResult(r);
                        System.out.println("Resultat tilføjet til konkurrenceresultater ");
                }
                else {
                    ((CompetitiveSwimmer) members.get(i)).addTrainingResult(r);
                    System.out.println("Resultat tilføjet til træningsresultater ");
                }
            }
        }
    }
    public void removeResults(int memberId, int choice) {
        for (int i = 0; i < members.size(); i++) {
            if (memberId == members.get(i).getMemberId()) {
                switch (choice) {
                    case 1: members.get(i).removeResult();
                }
            }
        }
    }
}

