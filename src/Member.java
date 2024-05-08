import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Member implements java.io.Serializable { // default motionist
	private double memberPrice;
	protected int memberId;
	private final String dateCreated;
	private String dueDate;
	private String name;
	private int age;
	private int gender;
	private String address;
	private int phoneNr;
	private boolean isActive;
	private boolean isPaid;
	private boolean isBlocked;

	Random rdm = new Random();

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

		memberId = rdm.nextInt(100,10000); // Tjek om memberId er unikt.
	}

	public double getMemberPrice(){
		return memberPrice;
	}

	public void setMemberPrice(double memberPrice){
		this.memberPrice = memberPrice;
	}

	public int getMemberId(){
		return memberId;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getGender(){
		return gender;
	}

	public void setGender(int gender){
		this.gender = gender;
	}

	public int getPhoneNr(){
		return phoneNr;
	}

	public void setPhoneNr(int phoneNr){
		this.phoneNr = phoneNr;
	}

	public String getAddress(){
		return address;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public boolean getIsActive(){
		return isActive;
	}

	public void setIsActive(boolean isActive){
		this.isActive = isActive;
	}

	public boolean getIsPaid(){
		return isPaid;
	}

	public void setIsPaid(boolean isPaid){
		this.isPaid = isPaid;
	}

	public boolean getIsBlocked(){
		return isBlocked;
	}

	public void setIsBlocked(boolean isBlocked){
		this.isBlocked = isBlocked;
	}

	public boolean isCompetitive(){
		return false;
	}

	public boolean isUniqueId(int memberId) {
		return true;
		// todo: Lav metode der tjekker om member id er unikt ved oprettelse af nye members. evt. do//while i constructor?
	}

	public void printMemberInfo(){
		System.out.println();
		System.out.println("Member ID: " + memberId);
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

}