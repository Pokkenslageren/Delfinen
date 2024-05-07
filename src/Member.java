import java.util.*;

public class Member{ // default motionist
	private double memberPrice;
	private int memberId;
	private double dateCreated;
	private String name;
	private int age;
	private int gender;
	private String address;
	private int phoneNr;
	private boolean isActive;
	private boolean isPaid;
	private boolean isBlocked;

	Random rdm = new Random();

	public Member(String name, int age, int gender, int phoneNr, String address){ // Constructor m. stamoplysninger
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

	public int getMemberId(){
		return memberId;
	}

	public double getDateCreated() {
		return dateCreated;
	}

	public String getName(){
		return name;
	}

	public int getAge(){
		return age;
	}

	public int getGender(){
		return gender;
	}

	public int getPhoneNr(){
		return phoneNr;
	}

	public String getAddress(){
		return address;
	}

	public boolean getIsActive(){
		return isActive;
	}

	public boolean getIsPaid(){
		return isPaid;
	}

	public boolean getIsBlocked(){
		return isBlocked;
	}

	public void printMemberInfo(){
		System.out.println("Navn: " + name);
		System.out.println("Alder: " + age);
		System.out.println("Køn: " + gender);
		System.out.println("Telefonnummer: " + phoneNr);
		System.out.println("Adresse: " + address);
	}

}