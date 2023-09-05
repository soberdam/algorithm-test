import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1. 재귀함수의 시작에서 열별로 순회하며 합격기준에 맞는지 확인하고, 맞다면 count를 최솟값으로 업데이트
 * 2. 각 행을 바꿨을 때를 기준으로 재귀를 시작한다.
 * 3. 순열 아닌 조합
 */
public class Solution {
	static int N;
	static int[] dr = { -1, -1, 1, 1 };
	static int[] dc = { -1, 1,  1, -1 };
	static boolean[] number;
	static boolean[][] visited;
	static int[][] arr;
	static int max;
	static int startR;
	static int startC;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			number = new boolean[101];
			max = -1;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 2; i < N; i++) {
				for (int j = 1; j < N - 1; j++) {
					startR = i;
					startC = j;
					DFS(i, j, 0, 0);
				}
			}

			System.out.printf("#%d %d\n", tc, max);

		}

	}

	public static void DFS(int row, int col, int eat, int dir) {
		if (dir == 3 && eat>=3) {
			if (row == startR && col == startC) {
				max = Math.max(max, eat);
			}
		}
		
		for(int d=dir; d<4; d++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			
			if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && !number[arr[nr][nc]]) {
				visited[nr][nc] = true;
				number[arr[nr][nc]] = true;
				DFS(nr, nc, eat + 1, d);
				number[arr[nr][nc]] = false;
				visited[nr][nc] = false;
			} 
		}

	}

}
