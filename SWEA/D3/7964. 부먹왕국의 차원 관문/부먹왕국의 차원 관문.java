
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int D = sc.nextInt();
			int answer = 0;
			int[] citys = new int[N];
			for (int i = 0; i < N; i++) {
				citys[i] = sc.nextInt();
				
			}
			for(int i=0; i<N; i++) {
				boolean isNear = false;
				int idx = 1;
				while (i - idx >= 0 && idx <= D) {
					if (citys[i - idx] == 1) {
						isNear = true;
						break;
					}
					idx++;
				}
				if (!isNear && --idx !=0) {
					citys[i-idx] = 1;
					answer++;
				}
				
				isNear = false;
				idx = 1;
				while (i + idx < N && idx <= D) {
					if (citys[i + idx] == 1) {
						isNear = true;
						break;
					}
					idx++;
				}
				if (!isNear && --idx !=0) {
					citys[i+idx] = 1;
					answer++;
				}
			}
			System.out.printf("#%d %d\n", test_case, answer);

		}
	}
}