
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			int M1 = sc.nextInt();
			int D1 = sc.nextInt();
			int M2 = sc.nextInt();
			int D2 = sc.nextInt();
			int[] month_days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			int d1 = 0;
			int d2 = 0;
			for(int i=0; i<M1-1; i++) {
				d1 += month_days[i];
			}
			d1 += D1;
			
			for(int i=0; i<M2-1; i++) {
				d2 += month_days[i];
			}
			d2 += D2;
			
			answer = d2 - d1 + 1;
			
			
			System.out.printf("#%d %d\n", test_case, answer);

		}
	}
}