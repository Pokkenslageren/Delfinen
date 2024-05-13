import java.io.*;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Main main = new Main();
		main.runProgram();
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


}

