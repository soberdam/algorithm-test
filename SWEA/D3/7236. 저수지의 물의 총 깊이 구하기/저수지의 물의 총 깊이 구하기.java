
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int answer = Integer.MIN_VALUE;
			int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
			int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
			String[][] arr = new String[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.next();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j].equals("W")) {
						int count = 0;
						for(int d=0; d<8; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];
							if(nr>=0 && nr < N && nc>=0 && nc<N) {
								if(arr[nr][nc].equals("W")) count++;
							}
						}
						if(count == 0) count = 1;
						answer = Math.max(answer, count);
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, answer);

		}
	}
}