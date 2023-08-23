
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int money = 1000 - sc.nextInt();
		int count = 0;
		int[] change = {500, 100, 50, 10, 5, 1};
		int idx = 0;
		while(money!=0) {
			count += money/change[idx];
			money %= change[idx];
			idx++;
		}
		
		System.out.println(count);
	}
}

