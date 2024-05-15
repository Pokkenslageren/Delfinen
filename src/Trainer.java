import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Trainer extends Chairman implements java.io.Serializable {
    private static final long serialVersionUID = 6529685098267757680L; //Giver et konstant ID på tværs af serialization instanser.
    //private final String name = "Jon"; // skal fjernes
    //ArrayList<Member> members = readFromFile2();//new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Trainer(String name) {
        super(name);

    }

    public void printJunior() {
        //readFromFile();
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

    public void addTrainingResults() {
        System.out.println("Indtast medlemsID");
        int memberId = scanner.nextInt();
        System.out.println("Indtast tid");
        double time = scanner.nextDouble();
        String competition = "Træning";
        System.out.println("Indtast placering");
        int placement = scanner.nextInt();
        boolean isCompetition = false;
        System.out.println("Indtast disciplin");
        String discipline = scanner.next();
        for (int i = 0; i < members.size(); i++) {
            if (memberId == members.get(i).getMemberId() && members.get(i) instanceof CompetitiveSwimmer) {
                Results r = new Results(time, competition, placement, isCompetition, discipline);
                ((CompetitiveSwimmer) members.get(i)).addTrainingResult(r);
                System.out.println("Resultat tilføjet til træningsresultater ");
            }
        }
    }

    public void addCompResults(){
        System.out.println("Indtast medlemsID");
        int memberId = scanner.nextInt();
        System.out.println("Tid?");
        double time = scanner.nextDouble();
        System.out.println("Konkurrence?");
        String competition = scanner.next();
        System.out.println("Placering?");
        int placement = scanner.nextInt();
        boolean isCompetition = true;
        System.out.println("Disciplin?");
        String discipline = scanner.next();
        for (int i = 0; i < members.size(); i++) {
            if (memberId == members.get(i).getMemberId() && members.get(i) instanceof CompetitiveSwimmer) {
                Results r = new Results(time, competition, placement, isCompetition, discipline);
                ((CompetitiveSwimmer) members.get(i)).addCompResult(r);
                System.out.println("Resultat tilføjet til konkurrenceresultater ");
            }
        }
        //writeToFile();
    }

    public void removeResults() {
        System.out.println("Indtast medlems-ID: ");
        int memberId = scanner.nextInt();
        for (int k = 0; k < members.size(); k++) {
            if (memberId == members.get(k).getMemberId() && members.get(k) instanceof CompetitiveSwimmer) {
                System.out.print("Tast 1 for at fjerne et konkurrenceresultat. \nTast 2 for at fjerne et træningsresultat.");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        printCompResults();
                        System.out.println("Indtast resultats-ID: ");
                        int resultId = scanner.nextInt();
                        for (int i = 0; i < ((CompetitiveSwimmer) members.get(i)).getCompResults().size(); i++){
                            if (resultId == ((CompetitiveSwimmer) members.get(i)).getCompResults().get(i).getResultId()){
                                //((CompetitiveSwimmer) members.get(i)).getCompResults().removeIf(((CompetitiveSwimmer) members.get(i)).getCompResults().get(i) -> ((CompetitiveSwimmer) members.get(i)).getCompResults().get(i).getResultId() == resultId);
                                //((CompetitiveSwimmer) members.get(i)).getCompResults().removeIf(result -> result.getResultId() == resultId);
                                ((CompetitiveSwimmer) members.get(i)).getCompResults().remove(((CompetitiveSwimmer) members.get(i)).getCompResults().get(i));
                                System.out.println("Resultat med ID: " + resultId + ", er nu fjernet.");
                            }
                            else {
                                System.out.println("Resultat kunne ikke findes.");
                            }
                        }
                        break;

                    case 2:
                        printTrainingResults();
                        System.out.println("Indtast resultats-ID: ");
                        int resultId2 = scanner.nextInt();
                        for (int j = 0; j < ((CompetitiveSwimmer) members.get(j)).getTrainingResults().size(); j++){
                            if (resultId2 == ((CompetitiveSwimmer) members.get(j)).getTrainingResults().get(j).getResultId()){
                                //((CompetitiveSwimmer) members.get(j)).getTrainingResults().removeIf(result -> result.getResultId() == resultId2);
                                ((CompetitiveSwimmer) members.get(j)).getTrainingResults().remove(((CompetitiveSwimmer) members.get(j)).getTrainingResults().get(j));
                                System.out.println("Resultat med ID: " + resultId2 + ", er nu fjernet.");
                            }
                            else {
                                System.out.println("Resultat kunne ikke findes.");
                            }
                        }
                        break;

                    default:
                        throw new IllegalStateException ("Unexpected value: " + choice);
                }
            }
        }
        scanner.close();
    }

    public void printCompResults(){
        System.out.print("Indtast medlemsID");
        int memberId = scanner.nextInt();
        for (Member m : members){
            if (memberId == m.getMemberId() && m instanceof CompetitiveSwimmer){
                for (Results r : ((CompetitiveSwimmer) m).getCompResults()){
                    System.out.println( "ResultatsID: " + r.getResultId() + ", " + "Stævne: " + r.getCompetition() + ", " + "Disciplin: " + r.getDiscipline() +", " + "Tid: " + r.getTime() + ", " + "Placering: " + r.getPlacement());
                    System.out.println();
                }
            }
        }
    }

    public void printTrainingResults(){
        System.out.print("Indtast medlemsID");
        int memberId = scanner.nextInt();
        for (Member m : members){
            if (memberId == m.getMemberId() && m instanceof CompetitiveSwimmer){
                for (Results r : ((CompetitiveSwimmer) m).getTrainingResults()){
                    System.out.println( "ResultatsID: " + r.getResultId() + ", " + "Stævne: " + r.getCompetition() + ", " + "Disciplin: " + r.getDiscipline() +", " + "Tid: " + r.getTime() + ", " + "Placering: " + r.getPlacement());
                    System.out.println();
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

    public static void main(String[] args) {
        Trainer trainer1 = new Trainer("Julle");
        // trainer1.readFromFile();
        // trainer1.addCompResults(1509);
        // trainer1.writeToFile();
        // trainer1.printCompResults(9677);
        // trainer1.readFromFile();
        //trainer1.printMembers();
        //trainer1.printJunior();



    }


}

