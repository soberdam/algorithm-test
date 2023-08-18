
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			int total = 0; // 현재 박수를 치는 사람의 수
			String str = sc.next();
			total += str.charAt(0) - '0'; // 조건없이 박수치는 사람의 수
			for (int i = 1; i < str.length(); i++) {
				int condition = i; // i번째 있는 사람들이 박수를 치는 조건의 수
				int num = str.charAt(i) - '0'; // total이 i-1이상일때 박수를 치는 사람의 수
				while (total < condition) { // 현재 박수를 치는 사람이 부족하다면 늘려주기
					total++; 
					answer++;
				}
				// 박수를 치는 사람이 충분하다면 박수를 치는 사람의 수 늘려주기
				total += num;
			}
			System.out.printf("#%d %d \n", test_case, answer);
		}
	}
}
