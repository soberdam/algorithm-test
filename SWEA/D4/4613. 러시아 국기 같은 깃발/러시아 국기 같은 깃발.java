import java.util.Scanner;

class Solution {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			char[][] arr = new char[N][M];
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < M; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			int[] countW = new int[N];
			int[] countB = new int[N];
			int[] countR = new int[N];
			for (int i = 0; i < N - 2; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] != 'W')
						countW[i]++;
				}
			}
			for (int i = 1; i < N - 1; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] != 'B')
						countB[i]++;
				}
			}
			for (int i = 2; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] != 'R')
						countR[i]++;
				}
			}

			int count = Integer.MAX_VALUE;
			int minW = 0;
			for (int i = 0; i < N - 2; i++) {
					minW += countW[i];
					int minB = 0;
				for (int j = i + 1; j < N - 1; j++) {
						minB += countB[j];
						int minR = 0;
					for (int k = j + 1; k < N; k++) {
							minR += countR[k];
					}
					count = Math.min(count, minW+minB+minR);
				}
			}

			System.out.printf("#%d %d\n", test_case, count);
		}
	}

}