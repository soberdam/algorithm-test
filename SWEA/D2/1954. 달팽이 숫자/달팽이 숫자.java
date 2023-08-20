
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			// 동, 남, 서, 북
			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };
			int[][] board = new int[N][N];
			int r = 0;
			int c = 0;
			int dir = 0;
			int cnt = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[r][c] = cnt++;
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[(dir + d) % 4];
						int nc = c + dc[(dir + d) % 4];
						if (nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] == 0) {
							r = nr;
							c = nc;
							dir = dir + d;
							break;
						}
					}
				}
			}

			System.out.printf("#%d\n", test_case);
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}

		}
	}
}