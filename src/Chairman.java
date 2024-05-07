import java.util.*;
public class Chairman{

    private final String name;
    ArrayList<Member> members = new ArrayList<>();
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

    public void addMember() {
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
        public void removeMember(int memberId){
            for (int i = 0; i <= members.size()-1; i++){
                if (memberId == members.get(i).getMemberId()){
                    members.remove(members.get(i)); // OBS
                }
            }
        }

        public void editMember(int memberId){
            for (int i = 0; i <= members.size()-1; i++){
                if (memberId == members.get(i).getMemberId()){
                    if (members.get(i).isCompetitive()){
                        int sentinel = 1;
                        while (sentinel == 1){
                            members.get(i).printMemberInfo();
                            System.out.println("Vælg hvad du vil redigere:");
                            System.out.println("1: Navn.");
                            System.out.println("2: Alder.");
                            System.out.println("3: Køn.");
                            System.out.println("4: Telefonnummer.");
                            System.out.println("5: Adresse.");

                            int input = scanner.nextInt();
                            switch (input){

                                case 1:
                                    System.out.println("Nuværende navn: " + members.get(i).getName());
                                    System.out.println("Indtast det nye navn: ");
                                    String name = scanner.next();
                                    members.get(i).setName(name);
                                    System.out.println("Ændring gemt: " + members.get(i).getName());
                                    break;

                                case 2:
                                    System.out.println("Nuværende alder: " + members.get(i).getAge());
                                    System.out.println("Indtast den nye alder: ");
                                    int age = scanner.nextInt();
                                    members.get(i).setAge(age);
                                    System.out.println("Ændring gemt: " + members.get(i).getAge());
                                    break;

                                case 3:
                                    System.out.println("Nuværende køn: " + members.get(i).getGender());
                                    System.out.println("Indtast det nye køn: ");
                                    int gender = scanner.nextInt();
                                    members.get(i).setGender(gender);
                                    System.out.println("Ændring gemt: " + members.get(i).getGender());
                                    break;

                                case 4:
                                    System.out.println("Nuværende telefonnummer: " + members.get(i).getPhoneNr());
                                    System.out.println("Indtast det nye telefonnummer: ");
                                    int phoneNr = scanner.nextInt();
                                    members.get(i).setPhoneNr(phoneNr);
                                    System.out.println("Ændring gemt: " + members.get(i).getPhoneNr());
                                    break;

                                case 5:
                                    System.out.println("Nuværende adresse: " + members.get(i).getAddress());
                                    System.out.println("Indtast den nye adresse: ");
                                    String address = scanner.next();
                                    members.get(i).setAddress(address);
                                    System.out.println("Ændring gemt: " + members.get(i).getAddress());
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
                            System.out.println("6: Freestyle aktivitet.");
                            System.out.println("7: Brystsvømning aktivitet.");
                            System.out.println("8: Butterfly aktivitet.");

                            int input = scanner.nextInt();
                            switch (input){

                                case 1:
                                    System.out.println("Nuværende navn: " + members.get(i).getName());
                                    System.out.println("Indtast det nye navn: ");
                                    String name = scanner.next();
                                    members.get(i).setName(name);
                                    System.out.println("Ændring gemt: " + members.get(i).getName());
                                    break;

                                case 2:
                                    System.out.println("Nuværende alder: " + members.get(i).getAge());
                                    System.out.println("Indtast den nye alder: ");
                                    int age = scanner.nextInt();
                                    members.get(i).setAge(age);
                                    System.out.println("Ændring gemt: " + members.get(i).getAge());
                                    break;

                                case 3:
                                    System.out.println("Nuværende køn: " + members.get(i).getGender());
                                    System.out.println("Indtast det nye køn: ");
                                    int gender = scanner.nextInt();
                                    members.get(i).setGender(gender);
                                    System.out.println("Ændring gemt: " + members.get(i).getGender());
                                    break;

                                case 4:
                                    System.out.println("Nuværende telefonnummer: " + members.get(i).getPhoneNr());
                                    System.out.println("Indtast det nye telefonnummer: ");
                                    int phoneNr = scanner.nextInt();
                                    members.get(i).setPhoneNr(phoneNr);
                                    System.out.println("Ændring gemt: " + members.get(i).getPhoneNr());
                                    break;

                                case 5:
                                    System.out.println("Nuværende adresse: " + members.get(i).getAddress());
                                    System.out.println("Indtast den nye adresse: ");
                                    String address = scanner.next();
                                    members.get(i).setAddress(address);
                                    System.out.println("Ændring gemt: " + members.get(i).getAddress());
                                    break;

                                case 6:
                                    System.out.println("Nuværende freestyle aktivitet: " + members.get(i).getIsFreestyle());
                                    System.out.println("Indtast det nye valg: ");
                                    int freestyle = scanner.nextInt();
                                    members.get(i).setIsFreestyle(freestyle);
                                    System.out.println("Ændring gemt: " + members.get(i).getIsFreestyle());
                                    break;

                                case 7:

                                case 8:

                                default:
                                    sentinel = 0;
                                    break;
                            }
                        }
                    }
                }
            }
        }

}