import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	int broken;

	Point(int x, int y, int broken) {
		this.x = x;
		this.y = y;
		this.broken = broken;
	}
}

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M, K;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		System.out.println(bfs());
	}

	public static int bfs() {
		Queue<Point> queue = new LinkedList<>();
		int[][][] dist = new int[N][M][K + 1];
		queue.add(new Point(0, 0, 0));
		dist[0][0][0] = 1;
		while (!queue.isEmpty()) {
			Point now = queue.poll();
			if (now.x == N - 1 && now.y == M - 1)
				return dist[now.x][now.y][now.broken];
			for (int d = 0; d < 4; d++) {
				int nr = now.x + dr[d];
				int nc = now.y + dc[d];
				if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
					// 다음 칸이 벽이 아닐 때
					if (map[nr][nc] == 0) {
						if (now.broken <= K & dist[nr][nc][now.broken] == 0) {
							dist[nr][nc][now.broken] = dist[now.x][now.y][now.broken] + 1;
							queue.add(new Point(nr, nc, now.broken));
							if (nr == N - 1 && nc == M - 1)
								return dist[nr][nc][now.broken];
						}
					}

					// 다음 칸이 벽일 때
					if (map[nr][nc] == 1) {
						// 벽을 부수고 왔으면
						if (now.broken >= K) {
							continue;
						}
						// 벽을 안부수고 왔으면 벽을 부순다.
						else if (dist[nr][nc][now.broken + 1] == 0) {
							dist[nr][nc][now.broken + 1] = dist[now.x][now.y][now.broken] + 1;
							queue.add(new Point(nr, nc, now.broken + 1));
							if (nr == N - 1 && nc == M - 1)
								return dist[nr][nc][now.broken + 1];
						}
					}

				}
			}
		}
		return -1;
	}

}