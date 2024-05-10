import java.util.*;
import java.io.*;

public class Chairman implements java.io.Serializable {

    /**
     * The name of the chairman
     */
    private final String name;

    /**
     * List containing all members in the club
     */
    ArrayList<Member> members = new ArrayList<>();

    /**
     * Scanner object used to handle input
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * Constructor for the Chairman class
     * @param name The name of the chairman
     */
    public Chairman(String name){
        this.name = name;
    }

    /**
     * Getter for name
     * @return name of the chairman
     */
    public String getName(){
        return name;
    }

    /**
     * Getter for the list of members
     * @return ArrayList of member objects
     */
    public ArrayList<Member> getMembers() {
        return members;
    }

    public void retrieveContentOfFile (String fileName){  // todo: Deserialization of files

    }

    /**
     * Prints all member information, based on the given ID
     * @param memberId The member ID given
     */
    public void printMemberInfo(int memberId){ // prints a unique member.
        for(Member m : members){
            if (m.getMemberId() == memberId){
                m.printMemberInfo();
                    if(m.getIsBlocked()){
                        System.out.println("OBS! Medlemsskab blokeret!");
                    }
                    if (m.getIsPaid()){
                        System.out.println("Medlemsskab: Betalt");
                    } else {
                        System.out.println("Medlemsskab: Ikke betalt");
                    }
                    if (m.getIsActive()){
                        System.out.println("Medlemsskab: Aktivt");
                    } else {
                        System.out.println("Medlemsskab: Passivt");
                    }
            }
        }
    }

    /**
     * Prints information for all members of the club
     */
    public void printMembers(){ // prints entire member-list.
        for (Member m : members){
            m.printMemberInfo();
        }
    }

    /**
     * Adds a new member to the members list
     */
    public void addMember() {
        System.out.println();
        System.out.println("Tryk 1 for motionist, tryk 2 for konkurrencesvømmer.");
        int input = scanner.nextInt();
        switch (input) {

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
                break;

            case 2:
                System.out.println("Indtast navn: ");
                String compName = scanner.next();
                System.out.println("Indtast alder: ");
                int compAge = scanner.nextInt();
                System.out.println("Indtast køn: 1: for mand, 2: for kvinde, 3: for andet.");
                int compGender = scanner.nextInt();
                System.out.println("Indtast telefonnummer: ");
                int compPhoneNr = scanner.nextInt();
                System.out.println("Indtast addresse: ");
                String compAddress = scanner.next();
                System.out.println("Skal medlemmet udøve freestyle? 1: Ja, 2: Nej. ");
                int freestyle = scanner.nextInt();
                System.out.println("Skal medlemmet udøve brystsvømning? 1: Ja, 2: Nej.  ");
                int breaststroke = scanner.nextInt();
                System.out.println("Skal medlemmet udøve butterfly? 1: Ja, 2: Nej.  ");
                int butterfly = scanner.nextInt();
                Member c = new CompetitiveSwimmer(compName, compAge, compGender, compPhoneNr, compAddress, freestyle, breaststroke, butterfly);
                members.add(c);
                break;

            default:
                System.out.println("Ugyldigt input.");
                break;
        }

    }

    /**
     * Removes a member from the members list, given a member ID
     * @param memberId The ID for the member you want to remove
     */
    public void removeMember(int memberId){
            for (int i = 0; i <= members.size()-1; i++){
                if (memberId == members.get(i).getMemberId()){
                    members.remove(members.get(i)); // OBS
                }
            }
        }

    /**
     * Edits information on a member, given member ID
     * Distinguishes between regular member (1) and competitive swimmer (2)
     * @param memberId The member ID of the member you want to edit
     */
    public void editMember(int memberId){
            for (int i = 0; i <= members.size()-1; i++){
                if (memberId == members.get(i).getMemberId()){
                    System.out.println("Medlem " + members.get(i).getMemberId() + " fundet.");
                    if (members.get(i).isCompetitive() == false){
                        int sentinel = 1;
                        while (sentinel == 1){
                            members.get(i).printMemberInfo();
                            System.out.println("Vælg hvad du vil redigere:");
                            System.out.println("1: Navn.");
                            System.out.println("2: Alder.");
                            System.out.println("3: Køn.");
                            System.out.println("4: Telefonnummer.");
                            System.out.println("5: Adresse.");
                            System.out.println("6: Medlemsskab.");
                            System.out.println("0: Afslut.");

                            int input = scanner.nextInt();
                            switch (input){

                                case 1:
                                    System.out.println("Nuværende navn: " + members.get(i).getName());
                                    System.out.println("Indtast det nye navn: ");
                                    String name = scanner.next();
                                    members.get(i).setName(name);
                                    System.out.println("Ændring gemt: " + members.get(i).getName());
                                    System.out.println();
                                    break;

                                case 2:
                                    System.out.println("Nuværende alder: " + members.get(i).getAge());
                                    System.out.println("Indtast den nye alder: ");
                                    int age = scanner.nextInt();
                                    members.get(i).setAge(age);
                                    System.out.println("Ændring gemt: " + members.get(i).getAge());
                                    System.out.println();
                                    break;

                                case 3:
                                    System.out.println("Nuværende køn: " + members.get(i).getGender());
                                    System.out.println("Indtast det nye køn: ");
                                    int gender = scanner.nextInt();
                                    members.get(i).setGender(gender);
                                    System.out.println("Ændring gemt: " + members.get(i).getGender());
                                    System.out.println();
                                    break;

                                case 4:
                                    System.out.println("Nuværende telefonnummer: " + members.get(i).getPhoneNr());
                                    System.out.println("Indtast det nye telefonnummer: ");
                                    int phoneNr = scanner.nextInt();
                                    members.get(i).setPhoneNr(phoneNr);
                                    System.out.println("Ændring gemt: " + members.get(i).getPhoneNr());
                                    System.out.println();
                                    break;

                                case 5:
                                    System.out.println("Nuværende adresse: " + members.get(i).getAddress());
                                    System.out.println("Indtast den nye adresse: ");
                                    String address = scanner.next();
                                    members.get(i).setAddress(address);
                                    System.out.println("Ændring gemt: " + members.get(i).getAddress());
                                    System.out.println();
                                    break;

                                case 6:
                                    System.out.println("Nuværende medlemsskab: " + members.get(i).getIsActive());
                                    System.out.println("Indtast det nye valg: " );
                                    boolean isActive = scanner.nextBoolean();
                                    members.get(i).setIsActive(isActive);
                                    System.out.println("Ændring gemt: " + members.get(i).getIsActive());
                                    System.out.println();
                                    break;

                                default:
                                    sentinel = 0;
                                    break;
                            }
                        }
                    }
                    else {
                        int sentinel = 1;
                        while (sentinel == 1){
                            members.get(i).printMemberInfo();
                            System.out.println("Vælg hvad du vil redigere:");
                            System.out.println("1: Navn.");
                            System.out.println("2: Alder.");
                            System.out.println("3: Køn.");
                            System.out.println("4: Telefonnummer.");
                            System.out.println("5: Adresse.");
                            System.out.println("6: Medlemsskab.");
                            System.out.println("7: Freestyle aktivitet.");
                            System.out.println("8: Brystsvømning aktivitet.");
                            System.out.println("9: Butterfly aktivitet.");
                            System.out.println("0: Afslut");

                            int input = scanner.nextInt();
                            switch (input){

                                case 1:
                                    System.out.println("Nuværende navn: " + members.get(i).getName());
                                    System.out.println("Indtast det nye navn: ");
                                    String name = scanner.next();
                                    members.get(i).setName(name);
                                    System.out.println("Ændring gemt: " + members.get(i).getName());
                                    System.out.println();
                                    break;

                                case 2:
                                    System.out.println("Nuværende alder: " + members.get(i).getAge());
                                    System.out.println("Indtast den nye alder: ");
                                    int age = scanner.nextInt();
                                    members.get(i).setAge(age);
                                    System.out.println("Ændring gemt: " + members.get(i).getAge());
                                    System.out.println();
                                    break;

                                case 3:
                                    System.out.println("Nuværende køn: " + members.get(i).getGender());
                                    System.out.println("Indtast det nye køn: ");
                                    int gender = scanner.nextInt();
                                    members.get(i).setGender(gender);
                                    System.out.println("Ændring gemt: " + members.get(i).getGender());
                                    System.out.println();
                                    break;

                                case 4:
                                    System.out.println("Nuværende telefonnummer: " + members.get(i).getPhoneNr());
                                    System.out.println("Indtast det nye telefonnummer: ");
                                    int phoneNr = scanner.nextInt();
                                    members.get(i).setPhoneNr(phoneNr);
                                    System.out.println("Ændring gemt: " + members.get(i).getPhoneNr());
                                    System.out.println();
                                    break;

                                case 5:
                                    System.out.println("Nuværende adresse: " + members.get(i).getAddress());
                                    System.out.println("Indtast den nye adresse: ");
                                    String address = scanner.next();
                                    members.get(i).setAddress(address);
                                    System.out.println("Ændring gemt: " + members.get(i).getAddress());
                                    System.out.println();
                                    break;

                                case 6:
                                    System.out.println("Nuværende medlemsskab: " + members.get(i).getIsActive());
                                    System.out.println("Indtast det nye valg: " );
                                    boolean isActive = scanner.nextBoolean();
                                    members.get(i).setIsActive(isActive);
                                    System.out.println("Ændring gemt: " + members.get(i).getIsActive());
                                    System.out.println();
                                    break;

                                case 7:
                                    if(members.get(i) instanceof CompetitiveSwimmer) {
                                        System.out.println("Nuværende freestyle aktivitet: " + (((CompetitiveSwimmer) members.get(i)).getIsFreestyle()));
                                        System.out.println("Indtast det nye valg: ");
                                        boolean freestyle = scanner.nextBoolean(); // OBS DATATYPE
                                        ((CompetitiveSwimmer) members.get(i)).setIsFreestyle(freestyle);
                                        System.out.println("Ændring gemt: " + ((CompetitiveSwimmer) members.get(i)).getIsFreestyle());
                                        System.out.println();
                                    }
                                    break;

                                case 8:
                                    if(members.get(i) instanceof CompetitiveSwimmer) {
                                        System.out.println("Nuværende brystsvømning aktivitet: " + (((CompetitiveSwimmer) members.get(i)).getIsBreaststroke()));
                                        System.out.println("Indtast det nye valg: ");
                                        boolean breaststroke = scanner.nextBoolean(); // OBS DATATYPE
                                        ((CompetitiveSwimmer) members.get(i)).setIsBreaststroke(breaststroke);
                                        System.out.println("Ændring gemt: " + ((CompetitiveSwimmer) members.get(i)).getIsBreaststroke());
                                        System.out.println();
                                    }
                                    break;

                                case 9:
                                    if(members.get(i) instanceof CompetitiveSwimmer) {
                                        System.out.println("Nuværende butterfly aktivitet: " + (((CompetitiveSwimmer) members.get(i)).getIsButterfly()));
                                        System.out.println("Indtast det nye valg: ");
                                        boolean butterfly = scanner.nextBoolean(); // OBS DATATYPE
                                        ((CompetitiveSwimmer) members.get(i)).setIsButterfly(butterfly);
                                        System.out.println("Ændring gemt: " + ((CompetitiveSwimmer) members.get(i)).getIsButterfly());
                                    }
                                    break;

                                default:
                                    sentinel = 0;
                                    break;
                            }
                        }
                    }
                }
                else {
                    System.out.println("ID ikke fundet.");
                }
            }
        }

    /**
     * Serializes all objects in the members list to file "Members"
     */
    public void writeToFile(){
                try (FileOutputStream fos = new FileOutputStream("Members");
                     ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                    oos.writeObject(members);

                    System.out.println("Data gemt i Members");
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    /**
     * Deserializes all members objects from the "Members" file and puts the objects in list members
     */
    public void readFromFile(){
            try (FileInputStream fis = new FileInputStream("Members");
                 ObjectInputStream ois = new ObjectInputStream(fis);) {

                members = (ArrayList<Member>) ois.readObject();


            }

            catch(IOException e){
                 e.printStackTrace();
           }catch (ClassNotFoundException c){
                 c.printStackTrace();
          }
        }

        public static void main(String[] args){
            Chairman chairman = new Chairman("Julius");
            chairman.readFromFile();
            chairman.printMembers();
/*            chairman.addMember();
            chairman.writeToFile();*/
        }
}