import java.io.*;
import java.util.Scanner;

public class Main{

	Scanner sc = new Scanner(System.in);
	Chairman chairman1 = new Chairman("James");
	Trainer trainer1 = new Trainer("JamesIgen");
	Accountant accountant1 = new Accountant("OgsåJames");

	public static void main(String[] args) {
		Main main = new Main();
		//main.runProgram();
		main.testing();
	}

	public void runProgram() {
		createFile();
		loginMenu();
	}

	public void createFile() {
		try {
			File file = new File("Members");
			File file2 = new File("TrainingResults");
			File file3 = new File("CompResults");
			if (file.createNewFile())
				System.out.println("File Created");
			if (file2.createNewFile())
				System.out.println("File Created");
			if(file3.createNewFile())
				System.out.println("File Created");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loginMenu() { // todo: Lav loginMenu - writeToFile on close.
		Scanner input = new Scanner(System.in);
		System.out.println("Velkommen til Club adminstration system for Svømmeklubben Delfinen");

	}

	public void accountant(){
		accountant1.readFromFile();
		int sentinel = 1;
		while(sentinel != 0){
			System.out.print("Tast 1 for at se alle Delfinens medlemmer, \nTast 2 for at vise information om et specfikt medlem. \nTast 3 for at printe alle betalte medlemsskaber. \nTast 4 for at printe alle ubetalte medlemsskaber. \nTast 5 for at printe alle blokerede medlemmer. \nTast 6 for at markere et medlemsskab som betalt. \nTast 7 for at blokere et medlem. \nTast 8 for at fjerne blokeret status for et medlem.");
			int input = sc.nextInt();
			switch(input){
				case 1:
					accountant1.printMembers();
					break;
				case 2:
					System.out.println("Indtast medlemsID");
					int memberId = sc.nextInt();
					accountant1.printMemberInfo(memberId);
					break;
				case 3:
					System.out.println("Printer betalte medlemsskaber");
					accountant1.displayPaid();
					break;
				case 4:
					System.out.println("Printer ubetalte medlemsskaber");
					accountant1.displayUnpaid();
					break;
				case 5:
					System.out.println("Printer blokerede medlemmer");
					accountant1.displayBlocked();
					break;
				case 6:
					System.out.println("Indtast medlemsID:");
					int markas = sc.nextInt();
					accountant1.markAsPaid(markas);
					System.out.println("Medlem med ID: " + markas + " er markeret som betalt.");
					accountant1.writeToFile();
					break;
				case 7:
					System.out.println("Indtast medlemsID:");
					int block = sc.nextInt();
					accountant1.blockMember(block);
					System.out.println("Medlem med ID: " + block + " er blevet blokeret.");
					accountant1.writeToFile();
					break;
				case 8:
					System.out.println("Indtast medlemsID:");
					int unblock = sc.nextInt();
					accountant1.unblockMember(unblock);
					System.out.print("Medlem med ID: " + unblock + " har fået fjernet sin blokering.");
					accountant1.writeToFile();
					break;
				default:
					sentinel = 0;
					break;
			}
		}
	}

	public void trainer(){
		trainer1.readFromFile();
		int sentinel = 1;
		while(sentinel != 0){
			System.out.print("Tast 1 for at printe alle Delfinens medlemmer. \nTast 2 for at printe alle juniorsvømmere. \nTast 3 for at printe alle seniorsvømmere. \nTast 4 for at tilføje træningsresultat. \nTast 5 for at tilføje konkurrenceresultat. \nTast 6 for at printe træningsresultater. \nTast 7 for at printe konkurrenceresultater. \nTast 8 for at fjerne resultat.");
			int input = sc.nextInt();
			switch(input){
				case 1:
					trainer1.printMembers();
					break;
				case 2:
					trainer1.printJunior();
					break;
				case 3:
					trainer1.printSenior();
					break;
				case 4:
					trainer1.addTrainingResults();
					trainer1.writeToFile();
					break;
				case 5:
					trainer1.addCompResults();
					trainer1.writeToFile();
					break;
				case 6:
					trainer1.printTrainingResults();
					break;
				case 7:
					trainer1.printCompResults();
					break;
				case 8:
					trainer1.removeResults();
					trainer1.writeToFile();
					break;
				default:
					sentinel = 0;
					break;
			}
		}
	}

	public void chairman(){
		chairman1.readFromFile();
		int sentinel = 1;
		while(sentinel != 0){
			System.out.println("Tast 1 for at printe alle Delfinens medlemmer. Tast 2 for at tilføje medlem. \nTast 3 for at fjerne medlem. Tast 4 for at redigere medlem");
			int input = sc.nextInt();
			switch(input){
				case 1:
					chairman1.printMembers();
					break;
				case 2:
					chairman1.addMember();
					chairman1.writeToFile();
					break;
				case 3:
					chairman1.removeMember();
					chairman1.writeToFile();
					break;
				case 4:
					chairman1.editMember();
					chairman1.writeToFile();
				default:
					sentinel = 0;
					break;
			}
		}
	}

	public void testing(){

		int sentinel = 1;
		while(sentinel != 0){
			System.out.println("Vælg din rolle. 1: Chairman. 2: Træner. 3: Accountant.");
			int input = sc.nextInt();
			switch(input){
				case 1:
					System.out.println("Chairman valgt.");
					chairman();
					break;
				case 2:
					System.out.println("Trainer valgt.");
					trainer();
					break;
				case 3:
					System.out.println("Accountant valgt.");
					accountant();
					break;
				default:
					System.out.println("Afslutter program.");
					sentinel = 0;
					break;
			}

		}
	}


}

