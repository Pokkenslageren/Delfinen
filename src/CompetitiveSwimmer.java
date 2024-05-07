import java.util.*;
public class CompetitiveSwimmer extends Member{

	ArrayList<Results> compResults;
	ArrayList<Results> trainingResults;

	private boolean isFreestyle = true;
	private boolean isBreaststroke = true;
	private boolean isButterfly = true;

	Random rdm = new Random();

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

		int memberId = rdm.nextInt(100,10000); // Tjek om memberId er unikt.
	}

	public ArrayList<Results> getCompResults(){
		return compResults;
	}

	public ArrayList<Results> getTrainingResults(){
		return trainingResults;
	}

	public boolean getIsFreestyle(){
		return isFreestyle;
	}

	public void setIsFreestyle(boolean isFreestyle){
		this.isFreestyle = isFreestyle;
	}

	public boolean getIsBreaststroke(){
		return isBreaststroke;
	}

	public void setIsBreaststroke(boolean isBreaststroke){
		this.isBreaststroke = isBreaststroke;
	}

	public boolean getIsButterfly(){
		return isButterfly;
	}

	public void setIsButterfly(boolean isButterfly){
		this.isButterfly = isButterfly;
	}

	public void printDisciplines(){
		if (isFreestyle){
			System.out.println("Freestyle.");
		}
		if (isBreaststroke){
			System.out.println("Brystsvømning.");
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
			System.out.println("Brystsvømning.");
		}

		if (isButterfly) {
			System.out.println("Butterfly.");
		}
	}

	public boolean isCompetitive(){
		return true;
	}
}