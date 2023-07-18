import java.util.Scanner;
import java.util.Stack;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int k = sc.nextInt();
		Stack<Integer> nums = new Stack<>();
		for(int i=0; i<k; i++) {
			int input = sc.nextInt();
			if(input == 0) {
				nums.pop();
			} else {
				nums.push(input);
			}
		}
		
		for(int num : nums) {
			sum+=num;
		}
		
		System.out.println(sum);
	}

}