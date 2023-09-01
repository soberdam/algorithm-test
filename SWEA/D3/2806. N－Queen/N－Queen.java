
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution {
	static int N;
	static int[][] visited;
	static int ans;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			visited = new int[N][N];
			ans = 0;
			DFS(0, 0);
			System.out.printf("#%d %d\n", tc, ans);
		}
	}

	public static void DFS(int i, int count) {
		if (count == N) {
			ans++;
			return;
		}

		
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == 0) {
					count++;
					visited[i][j] = count;
					Mark(i, j);
					DFS(i + 1, count);
					count--;
					removeMark(i, j);
					visited[i][j] = 0;
				}
			}
		
	}

	public static void Mark(int r, int c) {
		for (int i = 0; i < N; i++) {
			if (r + i < N && c + i < N) {
				visited[r + i][c + i]++;
			}

			if (r + i < N) {
				visited[r + i][c]++;

			}

			if (r + i < N && c - i >= 0) {
				visited[r + i][c - i]++;
			}
		}

	}
	
	public static void removeMark(int r, int c) {
		for (int i = 0; i < N; i++) {
			if (r + i < N && c + i < N) {
				visited[r + i][c + i]--;
			}

			if (r + i < N) {
				visited[r + i][c]--;

			}

			if (r + i < N && c - i >= 0) {
				visited[r + i][c - i]--;
			}
		}

	}
}
