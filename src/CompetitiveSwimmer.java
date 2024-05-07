import java.util.*;
public class CompetitiveSwimmer extends Member{

	ArrayList<Results> compResults;
	ArrayList<Results> trainingResults;

	private boolean isFreestyle;
	private boolean isBreaststroke;
	private boolean isButterfly;

	CompetitiveSwimmer(String name, int age, int gender, int phoneNr, String address, int flag1, int flag2, int flag3){
		super(name, age, gender, phoneNr, address);
		compResults = new ArrayList<>();
		trainingResults = new ArrayList<>();
		if (flag1 == 1){
			isFreestyle = true;
		}
		else {
			isFreestyle = false;
		}
		if (flag2 == 1){
			isBreaststroke = true;
		}
		else {
			isBreaststroke = false;
		}
		if (flag3 == 1){
			isButterfly = true;
		}
		else {
			isButterfly = false;
		}
	}

	public ArrayList<Results> getCompResults(){
		return compResults;
	}

	public ArrayList<Results> getTrainingResults(){
		return trainingResults;
	}

	public void printDisciplines(){
		if (isFreestyle){
			System.out.println("Freestyle.");
		}
		if (isBreaststroke){
			System.out.println("Breaststroke.");
		}
		if (isButterfly){
			System.out.println("Butterfly.");
		}
	}

	public void printMemberInfo(){
		super.printMemberInfo();
		System.out.println("Konkurrerer i: ");
		if (isFreestyle) {
			System.out.println("Freestyle.");
		}

		if (isBreaststroke) {
			System.out.println("Breaststroke.");
		}

		if (isButterfly) {
			System.out.println("Butterfly.");
		}
	}

}