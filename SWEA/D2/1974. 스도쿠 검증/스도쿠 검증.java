
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int[][] board = new int[9][9];
			boolean[] isVisited;
			int answer = 1;

			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					board[i][j] = sc.nextInt();
				}
			}

			Loop1: for (int i = 0; i < 9; i++) {
				isVisited = new boolean[9];
				// 가로탐색
				for (int j = 0; j < 9; j++) {
					if (!isVisited[board[i][j] - 1]) {
						isVisited[board[i][j] - 1] = true;
					} else {
						answer = 0;
						break Loop1;
					}
				}
				isVisited = new boolean[9];
				// 세로탐색
				for (int j = 0; j < 9; j++) {
					if (!isVisited[board[j][i] - 1]) {
						isVisited[board[j][i] - 1] = true;
					} else {
						answer = 0;
						break Loop1;
					}
				}

			}

			// 격자 탐색
			Loop2: for (int r = 0; r < 9; r += 3) {
				for (int c = 0; c < 9; c += 3) {
					isVisited = new boolean[9];
					for (int j = 0; j < 3; j++) {
						for (int k = 0; k < 3; k++) {
							if (!isVisited[board[r + j][c + k] - 1]) {
								isVisited[board[r + j][c + k] - 1] = true;
							} else {
								answer = 0;
								break Loop2;
							}
						}
					}
				}

			}
			System.out.printf("#%d %d\n", test_case, answer);
		}
	}
}