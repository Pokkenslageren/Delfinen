import java.util.*;

public class Member{
	int memberPrice;

	public Member(int age){
		if(age < 18){
			memberPrice = 1000;
		}
		else if(age > 60){
			memberPrice = 1600 * 0.75;
		}
		else{
			memberPrice = 1600;
		}
	}

}