package JavaPracticeMain;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int[] numbers = {1,2,3,4,5};
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.forEach( (n) -> { System.out.println(n); } );;
	}

}
