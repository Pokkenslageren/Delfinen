import java.io.*;
import java.util.Scanner;

	public class Main{
		Scanner sc = new Scanner(System.in);
		Chairman chairman1 = new Chairman("Formand");
		Trainer trainer1 = new Trainer("Træner");
		Accountant accountant1 = new Accountant("Kasserer");

		public static void main(String[] args) {
			Main main = new Main();
			main.runProgram();
		}

		/**
		 * Creates a Members file to store data, if one does not already exist in the directory
		 */
		public void createFile() {
			try {
				File file = new File("Members");

				if (file.createNewFile())
					System.out.println("File Created");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		 * Method to handle all functionality related to accountant
		 */
		public void accountant(){
			accountant1.readFromFile();
			int sentinel = 1;
			while(sentinel != 0){
				System.out.print("Tast 1 for at se alle Delfinens medlemmer, \nTast 2 for at vise information om et specfikt medlem. \nTast 3 for at printe alle betalte medlemsskaber. \nTast 4 for at printe alle ubetalte medlemsskaber. \nTast 5 for at printe alle blokerede medlemmer. \nTast 6 for at markere et medlemsskab som betalt. \nTast 7 for at blokere et medlem. \nTast 8 for at fjerne blokeret status for et medlem. \nTast 9 for at printe due dates for alle medlemmer.\nTast 0 for at returnere til hovedmenu. \n");
				int input = sc.nextInt();
				switch(input){
					case 1:
						accountant1.printMembers();
						break;
					case 2:
						System.out.println("Indtast medlems-ID: ");
						int memberId = sc.nextInt();
						accountant1.printMemberInfo(memberId);
						break;
					case 3:
						System.out.println("Printer betalte medlemsskaber.");
						accountant1.displayPaid();
						break;
					case 4:
						System.out.println("Printer ubetalte medlemsskaber.");
						accountant1.displayUnpaid();
						break;
					case 5:
						System.out.println("Printer blokerede medlemmer.");
						accountant1.displayBlocked();
						break;
					case 6:
						System.out.println("Indtast medlems-ID: ");
						int markas = sc.nextInt();
						accountant1.markAsPaid(markas);
						System.out.println("Medlem med ID: " + markas + ", er markeret som betalt.");
						accountant1.writeToFile();
						break;
					case 7:
						System.out.println("Indtast medlems-ID: ");
						int block = sc.nextInt();
						accountant1.blockMember(block);
						System.out.println("Medlem med ID: " + block + " er blevet blokeret.");
						accountant1.writeToFile();
						break;
					case 8:
						System.out.println("Indtast medlems-ID: ");
						int unblock = sc.nextInt();
						accountant1.unblockMember(unblock);
						System.out.print("Medlem med ID: " + unblock + ", har fået fjernet sin blokering.");
						accountant1.writeToFile();
						break;
					case 9:
						System.out.println("Printer due date for alle medlemmer.");
						accountant1.displayDueDate();
						break;
					default:
						sentinel = 0;
						break;
				}
			}
		}

		/**
		 * Method to handle all functionality related to trainer
		 */
		public void trainer(){
			trainer1.readFromFile();
			int sentinel = 1;
			while(sentinel != 0){
				System.out.print("Tast 1 for at printe alle Delfinens medlemmer. \nTast 2 for at printe alle juniorsvømmere. \nTast 3 for at printe alle seniorsvømmere. \nTast 4 for at tilføje træningsresultat. \nTast 5 for at tilføje konkurrenceresultat. \nTast 6 for at printe træningsresultater. \nTast 7 for at printe konkurrenceresultater. \nTast 8 for at fjerne resultat. \nTast 9 for at printe top 5 for en given disciplin. \nTast 0 for at returnere til hovedmenu.\n");
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
					case 9:
						trainer1.printTopFive();
						break;
					default:
						sentinel = 0;
						break;
				}
			}
		}

		/**
		 * Method to handle all functionality related to chairman
		 */
		public void chairman(){
			chairman1.readFromFile();
			int sentinel = 1;
			while(sentinel != 0){
				System.out.println("Tast 1 for at printe alle Delfinens medlemmer. \nTast 2 for at tilføje medlem. \nTast 3 for at fjerne medlem. \nTast 4 for at redigere medlem \nTast 5 for at se information om et specifikt medlem. \nTast 0 for at returnere til hovedmenu.\n");
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
					case 5:
						System.out.println("Indtast medlems-ID: ");
						int memberId = sc.nextInt();
						chairman1.printMemberInfo(memberId);
						break;
					default:
						sentinel = 0;
						break;
				}
			}
		}

		/**
		 * Runs the program
		 */
		public void runProgram(){
			createFile();
			System.out.println("Velkommen til Sport Club Adminstration System for Svømmeklubben Delfinen");
			int sentinel = 1;
			while(sentinel != 0){
				System.out.println("Vælg din rolle \n1: Formand. \n2: Træner. \n3: Kasserer. \n0: Afslut programmet." );
				int input = sc.nextInt();
				switch(input){
					case 1:
						System.out.println("Formand valgt.");
						chairman();
						break;
					case 2:
						System.out.println("Træner valgt.");
						trainer();
						break;
					case 3:
						System.out.println("Kasserer valgt.");
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