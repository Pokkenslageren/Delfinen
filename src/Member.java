import java.util.*;

public class Member{
	double memberPrice;
	int memberId;
	double dateCreated;
	String name;
	int age;
	String gender;
	String address;
	int phoneNr;
	boolean isActive;
	boolean isPaid;
	boolean blocked;


	public Member(int age){
		if(age < 18){
			memberPrice = 1000.0;
		}
		else if(age > 60){
			memberPrice = (1600 * 0.75);
		}
		else{
			memberPrice = 1600.0;
		}
	}

}