import java.util.*;
public class CompetitiveSwimmer extends Member{

	ArrayList<Results> compResults;
	ArrayList<Results> trainingResults;

	private boolean isFreestyle;
	private boolean isBreaststroke;
	private boolean isButterfly;

	CompetitiveSwimmer(String name, int age, int gender, int phoneNr, String address, boolean isFreestyle, boolean isBreaststroke, boolean isButterfly){
		super(name, age, gender, phoneNr, address);
		compResults = new ArrayList<>();
		trainingResults = new ArrayList<>();
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
}