import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Trainer extends Chairman implements java.io.Serializable {
    private static final long serialVersionUID = 6529685098267757680L; //Giver et konstant ID på tværs af serialization instanser.
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
        System.out.println("Indtast medlems-ID: ");
        int memberId = scanner.nextInt();
        System.out.println("Indtast tid: ");
        double time = scanner.nextDouble();
        String competition = "Træning";
        System.out.println("Indtast placering: ");
        int placement = scanner.nextInt();
        boolean isCompetition = false;
        System.out.println("Indtast disciplin: ");
        String discipline = scanner.next();
        for (int i = 0; i < members.size(); i++) {
            if (memberId == members.get(i).getMemberId() && members.get(i) instanceof CompetitiveSwimmer) {
                Results r = new Results(time, competition, placement, isCompetition, discipline);
                ((CompetitiveSwimmer) members.get(i)).addTrainingResult(r);
                System.out.println("Resultat tilføjet til træningsresultater.");
            }
        }
    }

    public void addCompResults() {
        System.out.println("Indtast medlems-ID: ");
        int memberId = scanner.nextInt();
        System.out.println("Indtast tid: ");
        double time = scanner.nextDouble();
        System.out.println("Indtast konkurrence: ");
        String competition = scanner.next();
        System.out.println("Indtast placering: ");
        int placement = scanner.nextInt();
        boolean isCompetition = true;
        System.out.println("Indtast disciplin: ");
        String discipline = scanner.next();
        for (int i = 0; i < members.size(); i++) {
            if (memberId == members.get(i).getMemberId() && members.get(i) instanceof CompetitiveSwimmer) {
                Results r = new Results(time, competition, placement, isCompetition, discipline);
                ((CompetitiveSwimmer) members.get(i)).addCompResult(r);
                System.out.println("Resultat tilføjet til konkurrenceresultater.");
            }
        }
        //writeToFile();
    }

    public void removeResults() {
        System.out.println("Indtast medlems-ID: ");
        int memberId = scanner.nextInt();

        for(int i = 0; i < members.size(); i++) {
            if (memberId == members.get(i).getMemberId() && members.get(i) instanceof CompetitiveSwimmer) {
                CompetitiveSwimmer swimmer = (CompetitiveSwimmer) members.get(i);
                System.out.println("Tast 1 for at fjerne et konkurrenceresultat. \nTast 2 for at fjerne et træningsresultat.");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        printCompResults();
                        System.out.println("Indtast resultat-id");
                        int compResultId = scanner.nextInt();
                        List<Results> compResults = swimmer.getCompResults();
                        boolean compResultFound = false;

                        for(int k = 0; k < compResults.size(); k++) {
                            if(compResultId == compResults.get(k).getResultId()) {
                                compResults.remove(k);
                                System.out.println("Resultat med resultat-id: " + compResultId + " er nu fjernet.");
                                compResultFound = true;
                                break;
                            }
                        }

                        if(!compResultFound) {
                            System.out.println("Resultat kunne ikke findes. ");
                        }
                        break;

                    case 2:
                        printTrainingResults();
                        System.out.println("Indtast resultat-id");
                        int trainResultId = scanner.nextInt();
                        List<Results> trainingResults = swimmer.getTrainingResults();
                        boolean trainResultFound = false;

                        for(int k = 0; k < trainingResults.size(); k++) {
                            if(trainResultId == trainingResults.get(k).getResultId()) {
                                trainingResults.remove(k);
                                System.out.println("Resultat med resultat-id: " + trainResultId + " er nu fjernet.");
                                trainResultFound = true;
                                break;
                            }
                        }

                        if(!trainResultFound) {
                            System.out.println("Resultat kunne ikke findes. ");
                        }
                        break;



                }
            }
        }
    }


    /*    public void removeResults() {
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
*/
    public void printCompResults() {
        System.out.print("Indtast medlems-ID: ");
        int memberId = scanner.nextInt();
        for (Member m : members) {
            if (memberId == m.getMemberId() && m instanceof CompetitiveSwimmer) {
                for (Results r : ((CompetitiveSwimmer) m).getCompResults()) {
                    System.out.println("Resultats-ID: " + r.getResultId() + ", " + "Stævne: " + r.getCompetition() + ", " + "Disciplin: " + r.getDiscipline() + ", " + "Tid: " + r.getTime() + ", " + "Placering: " + r.getPlacement());
                    System.out.println();
                }
            }
        }
    }

    public void printTrainingResults() {
        System.out.print("Indtast medlems-ID: ");
        int memberId = scanner.nextInt();
        for (Member m : members) {
            if (memberId == m.getMemberId() && m instanceof CompetitiveSwimmer) {
                for (Results r : ((CompetitiveSwimmer) m).getTrainingResults()) {
                    System.out.println("Resultats-ID: " + r.getResultId() + ", " + "Stævne: " + r.getCompetition() + ", " + "Disciplin: " + r.getDiscipline() + ", " + "Tid: " + r.getTime() + ", " + "Placering: " + r.getPlacement());
                    System.out.println();
                }
            }
        }
    }

    public void printTopFive() {
        HashMap<Integer, Double> fristil = new HashMap<>();
        HashMap<Integer, Double> bryst = new HashMap<>();
        HashMap<Integer, Double> butterfly = new HashMap<>();

        for (Member m : members) {
            for (Results r : ((CompetitiveSwimmer) m).getCompResults()) {
                if (r.getDiscipline().equals("freestyle")) {
                    fristil.put(m.getMemberId(), r.getTime());
                } else if (r.getDiscipline().equals("breaststroke")) {
                    bryst.put(m.getMemberId(), r.getTime());
                } else if (r.getDiscipline().equals("butterfly")) {
                    butterfly.put(m.getMemberId(), r.getTime());
                } else {
                    System.out.println("Ugyldigt input");
                }
            }
        }
        System.out.print("Vælg disciplin. Tast 1 for freestyle. \nTast 2 for breaststroke. \nTast 3 for butterfly.");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                //sorter mappet ud for value
                System.out.println("Printer top 5 tider i freestyle og tilhørende medlems-ID.");
                List<Map.Entry<Integer, Double>> list = new ArrayList<>(fristil.entrySet());
                list.sort(Map.Entry.comparingByValue());
                list.stream().limit(5).forEach((fri) -> System.out.println(fri.getKey() + " = " + fri.getValue()));
                break;
            case 2:
                System.out.println("Printer top 5 tider i bryst og tilhørende medlems-ID.");
                List<Map.Entry<Integer, Double>> list2 = new ArrayList<>(bryst.entrySet());
                list2.sort(Map.Entry.comparingByValue());
                list2.stream().limit(5).forEach((breast) -> System.out.println(breast.getKey() + " = " + breast.getValue()));
                break;
            case 3:
                System.out.println("Printer top 5 tider i butterfly og tilhørende medlems-ID.");
                List<Map.Entry<Integer, Double>> list3 = new ArrayList<>(butterfly.entrySet());
                list3.sort(Map.Entry.comparingByValue());
                list3.stream().limit(5).forEach((butter) -> System.out.println(butter.getKey() + " = " + butter.getValue()));
                break;
            default:
                System.out.println("Ugyldigt input. Returnerer til menu");
                break;
        }
    }
}