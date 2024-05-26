import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Trainer extends Chairman implements java.io.Serializable {
    private static final long serialVersionUID = 6529685098267757680L; //Giver et konstant ID på tværs af serialization instanser.
    Scanner scanner = new Scanner(System.in);

    /**
     * Constructor
     * @param name The name of the trainer
     */
    public Trainer(String name) {
        super(name);
    }

    /**
     * Prints all members under 18
     */
    public void printJunior() {
        //readFromFile();
        for (Member m : members) {
            if (m.getAge() < 18 && m instanceof CompetitiveSwimmer) {
                m.printMemberInfo();
            }
        }
    }

    /**
     * Prints all members, 18 and over.
     */
    public void printSenior() {
        for (Member m : members) {
            if (m.getAge() >= 18 && m instanceof CompetitiveSwimmer) {
                m.printMemberInfo();
            }
        }
    }

    /**
     * Adds a training result for a member.
     */
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
                if((discipline.equals("Freestyle") || discipline.equals("freestyle")) && ((CompetitiveSwimmer) members.get(i)).getIsFreestyle()){
                    Results r = new Results(time, competition, placement, isCompetition, discipline);
                    ((CompetitiveSwimmer) members.get(i)).addTrainingResult(r);
                    System.out.println("Freestyle resultat tilføjet til træningsresultater.");
                }
                else if((discipline.equals("bryst") || discipline.equals("Bryst")) && ((CompetitiveSwimmer) members.get(i)).getIsBreaststroke()){
                    Results r = new Results(time, competition, placement, isCompetition, discipline);
                    ((CompetitiveSwimmer) members.get(i)).addTrainingResult(r);
                    System.out.println("Brystsvømningsresultat tilføjet til træningsresultater.");
                }
                else if((discipline.equals("Butterfly") || discipline.equals("butterfly")) && ((CompetitiveSwimmer) members.get(i)).getIsButterfly()){
                    Results r = new Results(time, competition, placement, isCompetition, discipline);
                    ((CompetitiveSwimmer) members.get(i)).addTrainingResult(r);
                    System.out.println("Butterfly Resultat tilføjet til træningsresultater.");
                }
                else{
                    System.out.println("Ugyldig disciplin.");
                }
            }
        }
    }

    /**
     * Adds a competition result for a member
     */
    public void addCompResults() {
        System.out.println("Indtast medlems-ID: ");
        int memberId = scanner.nextInt();
        System.out.println("Indtast tid i sekunder, eksempelvis 12,5: ");
        double time = scanner.nextDouble();
        System.out.println("Indtast konkurrence: ");
        String competition = scanner.next();
        System.out.println("Indtast placering: ");
        int placement = scanner.nextInt();
        boolean isCompetition = true;
        System.out.println("Indtast disciplin, Freestyle, Bryst eller Butterfly: ");
        String discipline = scanner.next();
        for (int i = 0; i < members.size(); i++) {
            if (memberId == members.get(i).getMemberId() && members.get(i) instanceof CompetitiveSwimmer) {
                if((discipline.equals("Freestyle") || discipline.equals("freestyle")) && ((CompetitiveSwimmer) members.get(i)).getIsFreestyle()){
                    Results r = new Results(time, competition, placement, isCompetition, discipline);
                    ((CompetitiveSwimmer) members.get(i)).addCompResult(r);
                    System.out.println("Freestyle resultat tilføjet til konkurrenceresultater.");
                }
                else if((discipline.equals("Bryst") || discipline.equals("bryst")) && ((CompetitiveSwimmer) members.get(i)).getIsBreaststroke()){
                    Results r = new Results(time, competition, placement, isCompetition, discipline);
                    ((CompetitiveSwimmer) members.get(i)).addCompResult(r);
                    System.out.println("Brystsvømningsresultat tilføjet til konkurrenceresultater.");
                }
                else if((discipline.equals("Butterfly") || discipline.equals("butterfly")) && ((CompetitiveSwimmer) members.get(i)).getIsButterfly()){
                    Results r = new Results(time, competition, placement, isCompetition, discipline);
                    ((CompetitiveSwimmer) members.get(i)).addCompResult(r);
                    System.out.println("Butterfly resultat tilføjet til konkurrenceresultater.");
                }
                else{
                    System.out.println("Ugyldig disciplin");
                }
            }

        //writeToFile();
        }
    }

    /**
     * Removes a training or competition result, given member ID.
     */
    public void removeResults() {
        System.out.println("Indtast medlems-ID: ");
        int memberId = scanner.nextInt();
        int counter = 0;

        for(int i = 0; i < members.size(); i++) {
            if (memberId == members.get(i).getMemberId() && members.get(i) instanceof CompetitiveSwimmer) {
                CompetitiveSwimmer swimmer = (CompetitiveSwimmer) members.get(i);
                System.out.println("Tast 1 for at fjerne et konkurrenceresultat. \nTast 2 for at fjerne et træningsresultat.");
                int choice = scanner.nextInt();
                counter++;

                switch (choice) {
                    case 1:
                        printCompResults2(memberId);
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
                        printTrainingResults2(memberId);
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
        if(counter == 0){
            System.out.println("Der findes ingen medlemmer med det givne ID");
        }
    }

    /**
     * Prints the competition results for a member given member ID.
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

    /**
     * Alternate printComp method that has parameter memberID
     * @param memberID The ID of the given member
     */
    public void printCompResults2(int memberID) {
        int memberId = memberID;
        for (Member m : members) {
            if (memberId == m.getMemberId() && m instanceof CompetitiveSwimmer) {
                for (Results r : ((CompetitiveSwimmer) m).getCompResults()) {
                    System.out.println("Resultats-ID: " + r.getResultId() + ", " + "Stævne: " + r.getCompetition() + ", " + "Disciplin: " + r.getDiscipline() + ", " + "Tid: " + r.getTime() + ", " + "Placering: " + r.getPlacement());
                    System.out.println();
                }
            }
        }
    }

    /**
     * Prints the training results for a member given member ID.
     */
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

    /**
     * Alternate printComp method that has parameter memberID
     * @param memberID The ID of the given member
     */
    public void printTrainingResults2(int memberID){
        int memberId = memberID;
        for (Member m : members) {
            if (memberId == m.getMemberId() && m instanceof CompetitiveSwimmer) {
                for (Results r : ((CompetitiveSwimmer) m).getTrainingResults()) {
                    System.out.println("Resultats-ID: " + r.getResultId() + ", " + "Stævne: " + r.getCompetition() + ", " + "Disciplin: " + r.getDiscipline() + ", " + "Tid: " + r.getTime() + ", " + "Placering: " + r.getPlacement());
                    System.out.println();
                }
            }
        }

    }

    /**
     * Prints the top 5 times and corresponding memberID for a given discipline
     */
    public void printTopFive() {
        HashMap<Integer, Double> fristil = new HashMap<>();
        HashMap<Integer, Double> bryst = new HashMap<>();
        HashMap<Integer, Double> butterfly = new HashMap<>();

        for (Member m : members) {
            if (m instanceof CompetitiveSwimmer) {
                for (Results r : ((CompetitiveSwimmer) m).getCompResults()) {
                    if (r.getDiscipline().equals("freestyle") || r.getDiscipline().equals("Freestyle")) {
                        fristil.put(m.getMemberId(), r.getTime());
                    } else if (r.getDiscipline().equals("bryst") || r.getDiscipline().equals("Bryst")) {
                        bryst.put(m.getMemberId(), r.getTime());
                    } else if (r.getDiscipline().equals("butterfly") || r.getDiscipline().equals("Butterfly")) {
                        butterfly.put(m.getMemberId(), r.getTime());
                    }
                }
            }


        }
        System.out.print("Vælg disciplin. \nTast 1 for freestyle. \nTast 2 for breaststroke. \nTast 3 for butterfly. \n");
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