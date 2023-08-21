
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int[][] board = new int[19][19];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 동, 남, 남동, 남서
		int[] dr = { 0, 1, 1, 1 };
		int[] dc = { 1, 0, 1, -1 };

		for (int r = 0; r < 19; r++) {
			for (int c = 0; c < 19; c++) {
				// 0 혹은 1이라면 오목 탐색
				if (board[r][c] != 0) {
					// 4방향 탐색 시작
					for (int d = 0; d < 4; d++) {
						int nr = r;
						int nc = c;
						int count = 1;
						int[][] stones = new int [5][2];
						stones[0][0] = r;
						stones[0][1] = c;
						int idx = 1;
						// 정방향 탐색 (동, 남, 남동, 남서)
						while (true) {
							nr += dr[d];
							nc += dc[d];
							if (nr >= 0 && nr < 19 && nc >= 0 && nc < 19 && board[nr][nc] == board[r][c]) {
								count++;
								if(count>5) break;
								stones[idx][0] = nr;
								stones[idx][1] = nc;
								idx++;
							} else {
								break;
							}
						}
						
						nr = r;
						nc = c;
						
						// 역방향 탐색 (서, 북, 북서, 북동)
						while (true) {
							nr -= dr[d];
							nc -= dc[d];
							if (nr >= 0 && nr < 19 && nc >= 0 && nc < 19 && board[nr][nc] == board[r][c]) {
								count++;
								if(count>5) break;
								stones[idx][0] = nr;
								stones[idx][1] = nc;
								idx++;
							} else {
								break;
							}
						}
						
						if (count == 5) {
							System.out.println(board[r][c]);
							Arrays.sort(stones, ((a,b)-> {
								return a[1] - b[1];
							}));
							
							System.out.println((stones[0][0]+1) + " " + (stones[0][1]+1));
							return;

						}

					}
				}

			}

		}

		System.out.println(0);
		return;

	}

}