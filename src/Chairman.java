import java.util.*;
import java.io.*;

public class Chairman implements java.io.Serializable {
    private static final long serialVersionUID = 6529685098267757680L;

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

    /**
     * Prints all member information, based on the given ID
     */
    public void printMemberInfo(int memberId){ // prints a unique member.
        //int memberId = scanner.nextInt();
        for(Member m : members){
            if (m.getMemberId() == memberId){
                m.printMemberInfo();
                if(m.getIsBlocked()){
                    System.out.println("OBS! Medlemsskab blokeret!");
                }
                if (m.getIsPaid()){
                    System.out.println("Medlemsskab: Betalt.");
                } else {
                    System.out.println("Medlemsskab: Ikke betalt.");
                }
                if (m.getIsActive()){
                    System.out.println("Medlemsskab: Aktivt.");
                } else {
                    System.out.println("Medlemsskab: Passivt.");
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

    public void typeSafetyInteger(){
        while(!scanner.hasNextInt()){
            scanner.nextLine();
            System.out.println("Ugyldigt input. Indtast heltal.");
        }
    }

    /**
     * Method to ensure safety when instantiating a member
     * through the addMember() method.
     * @return The age of a member
     */
    public int giveAge(){
        System.out.println("Indtast alder: ");
        int age = scanner.nextInt();
        while(String.valueOf(age).length() > 2 || age == 0){
            System.out.println("Ugyldig alder. Alder skal være mellem 1 og 99 år");
            age = scanner.nextInt();
        }
        return age;
    }

    /**
     * Method to ensure safety when instantiating a member
     * through the addMember() method.
     * @return the phone number of the member.
     */
    public int givePhoneNumber(){
        System.out.println("Indtast telefonnummer: ");
        int phoneNumber = scanner.nextInt();
        while(String.valueOf(phoneNumber).length() != 8){
            System.out.println("Telefonnummeret er ikke af længde 8");
            phoneNumber = scanner.nextInt();
        }
        return phoneNumber;
    }

    /**
     * Method to ensure safety when instantiating a member
     * through the addMember() method.
     * @return the gender of the member.
     */
    public int giveGender(){
        System.out.println("Indtast køn: 1: for mand, 2: for kvinde, 3: for andet.");
        int gender = scanner.nextInt();
        while(gender != 1 && gender != 2 && gender != 3){
            System.out.println("Ugyldigt input");
            gender = scanner.nextInt();
        }
        return gender;
    }

    /**
     * Method to ensure safety when instantiating a member
     * through the addMember() method.
     * @return the name of the member.
     */
    public String giveName(){
        System.out.println("Indtast fornavn: ");
        String firstName = scanner.next();
        System.out.println("Indtast efternavn: ");
        String lastName = scanner.next();
        return firstName + " " + lastName;
    }

    /**
     * Method to ensure safety when instantiating a member
     * through the addMember() method.
     * @return the address of the member
     */
    public String giveAddress(){
        System.out.println("Indtast vejnavn: ");
        String vejnavn = scanner.next();
        System.out.println("Indtast bolignummer: ");
        String husnummer = scanner.next();
        return (vejnavn + " " + husnummer);
    }

    /**
     * Method to ensure safety when instantiating a member
     * through the addMember() method.
     * @return a given discipline of the member
     */
    public int giveDiscipline(){
        int discipline = scanner.nextInt();
        while(discipline <= 0 || discipline > 2) {
            System.out.println("Ugyldigt input.");
            discipline = scanner.nextInt();
        }
        return discipline;
    }
    /**
     * Adds a new member to the members list
     */
    public void addMember() {
        Random rdm = new Random();
        System.out.println();
        System.out.println("Tryk 1 for motionist. \nTryk 2 for konkurrencesvømmer.");
        typeSafetyInteger();
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                String name = giveName();
                int age = giveAge();
                int gender = giveGender();
                int phoneNr = givePhoneNumber();
                String address = giveAddress();
                Member m = new Member(name, age, gender, phoneNr, address);
                m.setMemberId(rdm.nextInt(1000, 10000));
                members.add(m);
                break;
            case 2:
                String compName = giveName();
                int compAge = giveAge();
                int compGender = giveGender();
                int compPhoneNr = givePhoneNumber();
                String compAddress = giveAddress();
                System.out.println("Skal medlemmet udøve freestyle? 1: Ja, 2: Nej.");
                int freestyle = giveDiscipline();
                System.out.println("Skal medlemmet udøve brystsvømning? 1: Ja, 2: Nej.");
                int breaststroke = giveDiscipline();
                System.out.println("Skal medlemmet udøve butterfly? 1: Ja, 2: Nej.");
                int butterfly = giveDiscipline();
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
     */
    public void removeMember(){
        System.out.println("Indtast Member-ID");
        int memberId = scanner.nextInt();
        for (int i = 0; i <= members.size()-1; i++){
            if (memberId == members.get(i).getMemberId()){
                members.remove(members.get(i));
            }
        }
    }

    /**
     * Edits information on a member, given member ID
     * Distinguishes between regular member (1) and competitive swimmer (2)
     */
    public void editMember(){
        System.out.println("Indtast medlems-ID: ");
        int memberId = scanner.nextInt();
        int counter = 0;
        for (int i = 0; i <= members.size()-1; i++){

            if (memberId == members.get(i).getMemberId()){
                System.out.println("Medlem med ID: " + members.get(i).getMemberId() + ", fundet.");
                if (!members.get(i).isCompetitive()){
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
                                String name = giveName();
                                members.get(i).setName(name);
                                System.out.println("Ændring gemt: " + members.get(i).getName() + ".");
                                System.out.println();
                                break;

                            case 2:
                                System.out.println("Nuværende alder: " + members.get(i).getAge());
                                int age = giveAge();
                                members.get(i).setAge(age);
                                System.out.println("Ændring gemt: " + members.get(i).getAge() + ".");
                                System.out.println();
                                break;

                            case 3:
                                System.out.println("Nuværende køn: " + members.get(i).getGender());
                                int gender = giveGender();
                                members.get(i).setGender(gender);
                                System.out.println("Ændring gemt: " + members.get(i).getGender() + ".");
                                System.out.println();
                                break;

                            case 4:
                                System.out.println("Nuværende telefonnummer: " + members.get(i).getPhoneNr());
                                int phoneNr = givePhoneNumber();
                                members.get(i).setPhoneNr(phoneNr);
                                System.out.println("Ændring gemt: " + members.get(i).getPhoneNr() + ".");
                                System.out.println();
                                break;

                            case 5:
                                System.out.println("Nuværende adresse: " + members.get(i).getAddress());
                                String address = giveAddress();
                                members.get(i).setAddress(address);
                                System.out.println("Ændring gemt: " + members.get(i).getAddress() + ".");
                                System.out.println();
                                break;

                            case 6:
                                System.out.println("Nuværende medlemsskab: " + members.get(i).getIsActive());
                                System.out.println("Indtast det nye valg: " );
                                boolean isActive = scanner.nextBoolean();
                                members.get(i).setIsActive(isActive);
                                System.out.println("Ændring gemt: " + members.get(i).getIsActive() + ".");
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
                                String name = giveName();
                                members.get(i).setName(name);
                                System.out.println("Ændring gemt: " + members.get(i).getName() + ".");
                                System.out.println();
                                break;

                            case 2:
                                System.out.println("Nuværende alder: " + members.get(i).getAge());
                                int age = giveAge();
                                members.get(i).setAge(age);
                                System.out.println("Ændring gemt: " + members.get(i).getAge() + ".");
                                System.out.println();
                                break;

                            case 3:
                                System.out.println("Nuværende køn: " + members.get(i).getGender());
                                int gender = giveGender();
                                members.get(i).setGender(gender);
                                System.out.println("Ændring gemt: " + members.get(i).getGender() + ".");
                                System.out.println();
                                break;

                            case 4:
                                System.out.println("Nuværende telefonnummer: " + members.get(i).getPhoneNr());
                                int phoneNr = givePhoneNumber();
                                members.get(i).setPhoneNr(phoneNr);
                                System.out.println("Ændring gemt: " + members.get(i).getPhoneNr() + ".");
                                System.out.println();
                                break;

                            case 5:
                                System.out.println("Nuværende adresse: " + members.get(i).getAddress());
                                String address = giveAddress();
                                members.get(i).setAddress(address);
                                System.out.println("Ændring gemt: " + members.get(i).getAddress() + ".");
                                System.out.println();
                                break;

                            case 6:
                                System.out.println("Nuværende medlemsskab: " + members.get(i).getIsActive());
                                System.out.println("Indtast det nye valg: " );
                                boolean isActive = scanner.nextBoolean();
                                members.get(i).setIsActive(isActive);
                                System.out.println("Ændring gemt: " + members.get(i).getIsActive() + ".");
                                System.out.println();
                                break;

                            case 7:
                                if(members.get(i) instanceof CompetitiveSwimmer) {
                                    System.out.print("Nuværende freestyle aktivitet: ");
                                    if((((CompetitiveSwimmer) members.get(i)).getIsFreestyle())){
                                        System.out.println("Deltager.");
                                    }
                                    else{
                                        System.out.println("Deltager ikke.");
                                    }
                                    System.out.println("Indtast det nye valg. Tast 1 for Deltager. Tast 0 for Deltager ikke. ");
                                    int freestyle = scanner.nextInt(); // OBS DATATYPE
                                    if(freestyle == 1){
                                        ((CompetitiveSwimmer) members.get(i)).setIsFreestyle(true);
                                        System.out.println("Medlemmet deltager nu i freestyle.");
                                    }
                                    else if(freestyle == 0){
                                        ((CompetitiveSwimmer) members.get(i)).setIsFreestyle(false);
                                        System.out.println("Medlemmet deltager nu ikke i freestyle");
                                    }
                                    else{
                                        System.out.println("Ugyldigt input");
                                    }

                                    System.out.println("Ændring gemt: ");
                                    System.out.println();
                                }
                                break;
                            case 8:
                                if(members.get(i) instanceof CompetitiveSwimmer) {
                                    System.out.print("Nuværende brystsvømning aktivitet: ");
                                    if((((CompetitiveSwimmer) members.get(i)).getIsBreaststroke())){
                                        System.out.println("Deltager.");
                                    }
                                    else{
                                        System.out.println("Deltager ikke.");
                                    }
                                    System.out.println("Indtast det nye valg. Tast 1 for Deltager. Tast 0 for Deltager ikke. ");
                                    int breaststroke = scanner.nextInt(); // OBS DATATYPE
                                    if(breaststroke == 1){
                                        ((CompetitiveSwimmer) members.get(i)).setIsBreaststroke(true);
                                        System.out.println("Medlemmet deltager nu i brystsvømning.");
                                    }
                                    else if(breaststroke == 0){
                                        ((CompetitiveSwimmer) members.get(i)).setIsBreaststroke(false);
                                        System.out.println("Medlemmet deltager nu ikke i brystsvømning");
                                    }
                                    else{
                                        System.out.println("Ugyldigt input");
                                    }

                                    System.out.println("Ændring gemt: ");
                                    System.out.println();
                                }
                                break;
                            case 9:
                                if(members.get(i) instanceof CompetitiveSwimmer) {
                                    System.out.print("Nuværende butterfly aktivitet: ");
                                    if((((CompetitiveSwimmer) members.get(i)).getIsButterfly())){
                                        System.out.println("Deltager.");
                                    }
                                    else{
                                        System.out.println("Deltager ikke.");
                                    }
                                    System.out.println("Indtast det nye valg. Tast 1 for Deltager. Tast 0 for Deltager ikke. ");
                                    int butterfly = scanner.nextInt(); // OBS DATATYPE
                                    if(butterfly == 1){
                                        ((CompetitiveSwimmer) members.get(i)).setIsButterfly(true);
                                        System.out.println("Medlemmet deltager nu i butterfly.");
                                    }
                                    else if(butterfly == 0){
                                        ((CompetitiveSwimmer) members.get(i)).setIsButterfly(false);
                                        System.out.println("Medlemmet deltager nu ikke i butterfly");
                                    }
                                    else{
                                        System.out.println("Ugyldigt input");
                                    }

                                    System.out.println("Ændring gemt: ");
                                    System.out.println();
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
                 counter++;
                 if (counter == members.size()) {
                     System.out.println("ID ikke fundet. Returnér med 0 + Enter");
                 }
            }
        }
    }

    /**
     * Serializes all objects in the members ArrayList to file "Members"
     */
    public void writeToFile(){
        try (FileOutputStream fos = new FileOutputStream("Members");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(members);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserializes all members objects from the "Members" file and puts the objects in ArrayList members
     */
    @SuppressWarnings("unchecked")
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
}