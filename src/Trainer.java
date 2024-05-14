import java.lang.reflect.Array;
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

    public void addTrainingResults(int memberId) {
        Scanner scanner = new Scanner(System.in);
        double time = scanner.nextDouble();
        String competition = scanner.next();
        int placement = scanner.nextInt();
        boolean isCompetition = false;
        String discipline = scanner.next();
        for (int i = 0; i < members.size(); i++) {
            if (memberId == members.get(i).getMemberId() && members.get(i) instanceof CompetitiveSwimmer) {
                Results r = new Results(time, competition, placement, isCompetition, discipline);
                ((CompetitiveSwimmer) members.get(i)).addTrainingResult(r);
                System.out.println("Resultat tilføjet til træningsresultater ");
            }
        }
    }

    public void addCompResults(int memberId){
        Scanner scanner = new Scanner(System.in);
        double time = scanner.nextDouble();
        String competition = scanner.next();
        int placement = scanner.nextInt();
        boolean isCompetition = true;
        String discipline = scanner.next();
        for (int i = 0; i < members.size(); i++) {
            if (memberId == members.get(i).getMemberId() && members.get(i) instanceof CompetitiveSwimmer) {
                Results r = new Results(time, competition, placement, isCompetition, discipline);
                ((CompetitiveSwimmer) members.get(i)).addCompResult(r);
                System.out.println("Resultat tilføjet til konkurrenceresultater ");
            }
        }
    }

    public void removeResults(int memberId) {
        for (int i = 0; i < members.size(); i++) {
            if (memberId == members.get(i).getMemberId() && members.get(i) instanceof CompetitiveSwimmer) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        printCompResults(memberId);
                        int input = scanner.nextInt();
                        ((CompetitiveSwimmer) members.get(i)).getCompResults().remove(input);
                        break;

                    case 2:
                        printTrainingResults(memberId);
                        int input2 = scanner.nextInt();
                        ((CompetitiveSwimmer) members.get(i)).getTrainingResults().remove(input2);
                        break;

                    default:
                        throw new IllegalStateException ("Unexpected value: " + choice);
                }
            }
        }
        scanner.close();
    }

    public void printCompResults(int memberId){
        for (Member m : members){
            if (memberId == m.getMemberId() && m instanceof CompetitiveSwimmer){
                for (Results r : ((CompetitiveSwimmer) m).getCompResults()){
                    System.out.println(r.getResultId() + r.getCompetition() + r.getDiscipline() + r.getTime() + r.getPlacement());
                }
            }
        }
    }

    public void printTrainingResults(int memberId){
        for (Member m : members){
            if (memberId == m.getMemberId() && m instanceof CompetitiveSwimmer){
                for (Results r : ((CompetitiveSwimmer) m).getTrainingResults()){
                    System.out.println(r.getResultId() + r.getCompetition() + r.getDiscipline() + r.getTime() + r.getPlacement());
                }
            }
        }
    }

    public void printTopFiveFreestyle(){
        HashMap<Double, String> topFreestyle = new HashMap<>();
        for (Member m : members){
            for (Results r : ((CompetitiveSwimmer) m).getCompResults()){
                topFreestyle.put(r.getTime(), m.getMemberId() + m.getName() + r.getTime());
            }
        }
        ArrayList<Double> sort = new ArrayList<>(topFreestyle.keySet());
        Collections.sort(sort);
        System.out.println(sort.subList(0, 4));

        /*
        double avgTime = 200.0;
        ArrayList<Member> topFive = new ArrayList<>();
        topFive.add(new Member("Dummy", 20, 1, 10203040, "Palaegade"));
        for (int i = 0; i < 5; i++) {
            for (Member m : members) {
                for (Results r : ((CompetitiveSwimmer) m).getCompResults()) {
                    if (((CompetitiveSwimmer) m).getIsFreestyle()) {
                        if (r.getTime() < avgTime) {
                            System.out.println(r.getTime());
                            topFive.add(i, m);
                            avgTime = r.getTime();
                        }
                    }
                }
            }
        }*/
    }


}

