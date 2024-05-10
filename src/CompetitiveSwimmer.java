import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class CompetitiveSwimmer extends Member{

	/**
	 * List of competition results for the competitive swimmer
	 */
	ArrayList<Results> compResults;
	/**
	 * List of training results for the competitive swimmer
	 */
	ArrayList<Results> trainingResults;


	/**
	 * Denotes whether the competitive swimmer competes in freestyle
	 */
	private boolean isFreestyle = true;
	/**
	 * Denotes whether the competitive swimmer competes in breast stroke
	 */
	private boolean isBreaststroke = true;
	/**
	 * Denotes whether the competitive swimmer competes in butterfly
	 */
	private boolean isButterfly = true;


	Random rdm = new Random();

	/**
	 * Constructor for the CompetitiveSwimmer class
	 * @param name The name of the competitive swimmer
	 * @param age The age of the competitive swimmer
	 * @param gender The gender of the competitive swimmer
	 * @param phoneNr The phone number of the competitive swimmer
	 * @param address The address of the competitive swimmer
	 * @param flag1 Denotes whether the competitive swimmer competes in freestyle
	 * @param flag2 Denotes whether the competitive swimmer competes in breast stroke
	 * @param flag3 Denotes whether the competitive swimmer competes in butterfly
	 */
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

		super.memberId = rdm.nextInt(100,10000); // Tjek om memberId er unikt.
	}

	/**
	 * Getter for the list of competitive results
	 * @return List of competitive results for the object
	 */
	public ArrayList<Results> getCompResults(){
		return compResults;
	}

	/**
	 * Getter for the list of training results
	 * @return List of training results for the object
	 */
	public ArrayList<Results> getTrainingResults(){
		return trainingResults;
	}

	/**
	 * Getter for isFreestyle
	 * @return Whether object competes in freestyle
	 */
	public boolean getIsFreestyle(){
		return isFreestyle;
	}

	/**
	 * Setter for isFreestyle
	 * @param isFreestyle Whether the object competes in freestyle
	 */
	public void setIsFreestyle(boolean isFreestyle){ // OBS DATATYPE
		this.isFreestyle = isFreestyle;
	}

	/**
	 * Getter for isBreaststroke
	 * @return Whether object competes in breast stroke
	 */
	public boolean getIsBreaststroke(){
		return isBreaststroke;
	}

	/**
	 * Setter for isBreaststroke
	 * @param isBreaststroke Whether the object competes in breast stroke
	 */
	public void setIsBreaststroke(boolean isBreaststroke){
		this.isBreaststroke = isBreaststroke;
	}

	/**
	 * Getter for isButterFly
	 * @return Whether object competes in butterfly
	 */
	public boolean getIsButterfly(){
		return isButterfly;
	}

	/**
	 * Setter for isButterfly
	 * @param isButterfly Whether the object competes in butterfly
	 */
	public void setIsButterfly(boolean isButterfly){
		this.isButterfly = isButterfly;
	}

	/**
	 * Prints the disciplines that the object competes in
	 */
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

	/**
	 * Prints member information for the given competitive swimmer
	 */
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