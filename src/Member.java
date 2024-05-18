import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Member implements java.io.Serializable { // default motionist
	private static final long serialVersionUID = 6529685098267757680L;
	/**
	 * The yearly subscription price for a member.
	 */
	private double memberPrice;

	/**
	 * A unique ID number for a member.
	 */
	protected int memberId;

	/**
	 * The date at which a member object is created.
	 */
	private String dateCreated;

	/**
	 * The date at which the annual subscription payment is due.
	 */
	private String dueDate;

	/**
	 * The name of the member.
	 */
	private String name;

	/**
	 * The age of the member.
	 */
	private int age;

	/**
	 * The gender of the member.
	 */
	private int gender;

	/**
	 * The address of the member.
	 */
	private String address;

	/**
	 * The phone number of the member.
	 */
	private int phoneNr;

	/**
	 * Indicates if membership is active or passive.
	 */
	private boolean isActive;

	/**
	 * Indicates whether the membership has been paid.
	 */
	private boolean isPaid;

	/**
	 * Indicates whether the member is blocked.
	 */
	private boolean isBlocked;

	private boolean isUnique = false;

	Random rdm = new Random();

	/**
	 * Constructor for the Member class.
	 * @param name Name of the member.
	 * @param age Age of the member.
	 * @param gender Gender of the member.
	 * @param phoneNr Phone number of the member.
	 * @param address Address of the member.
	 */
	public Member(String name, int age, int gender, int phoneNr, String address){

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss");
		dateCreated = now.format(formatter);
		dueDate = now.plusDays(30).format(formatter);

		if(age < 18){
			memberPrice = 1000.0;
		}
		else if(age > 60){
			memberPrice = (1600 * 0.75);
		}
		else{
			memberPrice = 1600.0;
		}

		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phoneNr = phoneNr;
		this.address = address;

		memberId = rdm.nextInt(1000,10000);
	}

	/**
	 * Getter for memberPrice
	 * @return The annual member subscription price
	 */
	public double getMemberPrice(){
		return memberPrice;
	}

	/**
	 * Setter for memberPrice
	 * @param memberPrice Annual member subscription price
	 */
	public void setMemberPrice(double memberPrice){
		this.memberPrice = memberPrice;
	}

	/**
	 * Getter for memberId
	 * @return unique member ID
	 */
	public int getMemberId(){
		return memberId;
	}

	public void setMemberId(int memberId){
		this.memberId = memberId;
	}
	/**
	 * Getter for dateCreated
	 * @return The date where the member is instantiated
	 */
	public String getDateCreated() {
		return dateCreated;
	}

	/**
	 * Getter for dueDate
	 * @return The date where a membership payment is due
	 */
	public String getDueDate() {
		return dueDate;
	}

	/**
	 * Setter for dueDate
	 * @param dueDate The date where a membership is due
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * Getter for name
	 * @return The name of the member
	 */
	public String getName(){
		return name;
	}

	/**
	 * Setter for name
	 * @param name The name of the member
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * Getter for age
	 * @return The age of the member
	 */
	public int getAge(){
		return age;
	}

	/**
	 * Setter for age
	 * @param age The age of the member
	 */
	public void setAge(int age){
		this.age = age;
	}

	/**
	 * Getter for gender
	 * @return The gender of the member
	 */
	public int getGender(){
		return gender;
	}

	/**
	 * Setter for gender
	 * @param gender The gender of the member
	 */
	public void setGender(int gender){
		this.gender = gender;
	}

	/**
	 * Getter for phoneNr
	 * @return The phone number of the member
	 */
	public int getPhoneNr(){
		return phoneNr;
	}

	/**
	 * Setter for phoneNr
	 * @param phoneNr The phone number of the member
	 */
	public void setPhoneNr(int phoneNr){
		this.phoneNr = phoneNr;
	}

	/**
	 * Getter for address
	 * @return The address of the member
	 */
	public String getAddress(){
		return address;
	}

	/**
	 * Setter for address
	 * @param address The address of the member
	 */
	public void setAddress(String address){
		this.address = address;
	}

	/**
	 * Getter for isActive
	 * @return Whether the member is active
	 */
	public boolean getIsActive(){
		return isActive;
	}

	/**
	 * Setter for isActive
	 * @param isActive Whether the member is active
	 */
	public void setIsActive(boolean isActive){
		this.isActive = isActive;
	}

	/**
	 * Getter for isPaid
	 * @return Whether the member has paid their subscription fee
	 */
	public boolean getIsPaid(){
		return isPaid;
	}

	/**
	 * Setter for isPaid
	 * @param isPaid Whether the member has paid their subscription fee
	 */
	public void setIsPaid(boolean isPaid){
		this.isPaid = isPaid;
	}

	/**
	 * Getter for isBlocked
	 * @return Whether the member is blocked
	 */
	public boolean getIsBlocked(){
		return isBlocked;
	}

	/**
	 * Setter for isBlocked
	 * @param isBlocked Whether member is blocked
	 */
	public void setIsBlocked(boolean isBlocked){
		this.isBlocked = isBlocked;
	}

	public void setIsUnique(boolean isUnique) {
		this.isUnique = isUnique;
	}

	public boolean getIsUnique(){
		return isUnique;
	}
	/**
	 * Prints all available info on the member.
	 */

	public void printMemberInfo(){
		System.out.println();
		System.out.println("Member-ID: " + memberId);
		System.out.println("Navn: " + name);
		System.out.println("Alder: " + age);
		if (gender == 1){
			System.out.println("Køn: mand");
		}
		else if (gender == 2){
			System.out.println("Køn: kvinde");
		}
		else {
			System.out.println("Køn: andet");
		}
		System.out.println("Telefonnummer: " + phoneNr);
		System.out.println("Adresse: " + address);
	}

	/**
	 * Flag to show whether member is a competitive swimmer or regular member
	 * @return Member is regular
	 */
	public boolean isCompetitive(){
		return false;
	}
}