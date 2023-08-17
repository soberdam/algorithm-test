
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int[][] arr = new int[300][300];
			int num = 0;
			int x1 = 0;
			int x2 = 0;
			int y1 = 0;
			int y2 = 0;
			for (int i = 1; i < 300; i++) {
				for (int j = 1, k=i; j <= i && k>=1; j++, k--) {
					arr[k][j] = ++num;
					if (arr[k][j] == p) {
						y1 = k;
						x1 = j;
					}
					if (arr[k][j] == q) {
						y2 = k;
						x2 = j;
					}
				}
			}
			int x3 = x1 + x2;
			int y3 = y1 + y2;
			int answer = arr[y3][x3];
			System.out.printf("#%d %d\n", test_case, answer);

		}
	}
}