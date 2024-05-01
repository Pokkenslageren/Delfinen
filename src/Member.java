import java.util.*;

public class Member{
	double memberPrice;

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