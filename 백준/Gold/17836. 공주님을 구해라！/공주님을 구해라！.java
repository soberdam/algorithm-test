import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Hero {
		int x;
		int y;
		int cnt;
		boolean gram;

		public Hero(int x, int y, int cnt, boolean gram) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.gram = gram;
		}
	}

	static int N, M, T;
	static int[][] map;
	static boolean[][][] check;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		check = new boolean[N][M][2];
		bfs(0, 0);

	}

	public static void bfs(int x, int y) {
		Queue<Hero> q = new LinkedList<>();
		q.add(new Hero(x, y, 0, false));
		check[x][y][0] = true;

		while (!q.isEmpty()) {
			Hero now = q.poll();

			if (now.cnt > T)
				break;
			if (now.x == N - 1 && now.y == M - 1) {
				System.out.println(now.cnt);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nx = now.x + dr[d];
				int ny = now.y + dc[d];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				if (!now.gram) {
					if (!check[nx][ny][0] && map[nx][ny] == 0) {
						q.add(new Hero(nx, ny, now.cnt + 1, now.gram));
						check[nx][ny][0] = true;
					} else if (!check[nx][ny][0] && map[nx][ny] == 2) {
						q.add(new Hero(nx, ny, now.cnt + 1, true));
						check[nx][ny][0] = true;
					}

				} else {
					if (!check[nx][ny][1]) {
						q.add(new Hero(nx, ny, now.cnt + 1, now.gram));
						check[nx][ny][1] = true;

					}
				}
			}
		}
		System.out.println("Fail");

	}

}