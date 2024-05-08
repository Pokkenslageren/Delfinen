import java.io.*;
import java.util.Scanner;

public class Delfinen{

	public static void main(String[] args) {
		Delfinen delfinen = new Delfinen();
		delfinen.runProgram();
	}

	public void runProgram() {
		createFile();
		loginMenu();
	}

	public void createFile() {
		try {
			File file = new File("Members.txt");
			if (file.createNewFile())
				System.out.println("File Created");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loginMenu() {
		Scanner input = new Scanner(System.in);
	}
}

