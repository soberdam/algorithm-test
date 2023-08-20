
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			boolean isFive = false;
			char[][] board = new char[N][N];
			// 돌을 기준으로 가로(동), 세로(남), 왼쪽대각(남서), 오른쪽 대각(남동) 탐색
			int[] dr = { 0, 1, 1, 1 };
			int[] dc = { 1, 0, -1, 1 };

			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					board[i][j] = s.charAt(j);
				}
			}

			Loop1: for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (board[r][c] == 'o') {
						// 4방향으로 5칸씩 탐색
						for (int d = 0; d < 4; d++) {
							int count = 1;
							int nr = r;
							int nc = c;
							for (int k = 0; k < 4; k++) {
								nr += dr[d];
								nc += dc[d]; 
								if (nr >= 0 & nr < N && nc >= 0 && nc < N) {
									if (board[nr][nc] == 'o') {
										count++;
									}
									else {
										break;
									}

								}
							}
							if (count == 5) {
								isFive = true;
								break Loop1;
							}

						}
					}
				}
			}

			String answer = "NO";
			if (isFive)
				answer = "YES";
			System.out.printf("#%d %s\n", test_case, answer);

		}
	}
}