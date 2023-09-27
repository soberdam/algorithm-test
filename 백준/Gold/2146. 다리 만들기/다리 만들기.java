import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
 * 1.
 * 1-1. bfs로 섬을 탐색한 후 섬별 번호를 다르게 저장한다.
 * 1-2. 다시 전체 맵에서 모든 점에서 자기 제신을 제외한 다른 섬으로 가는 bfs를 시행한 후 도착한다면 최소거리 업데이트
 * 1-3. 만약 지금 가는 거리가 최소거리보다 크다면 return 
 */

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N;
	static int[][] map;
	static int minDist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		minDist = Integer.MAX_VALUE;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		initMap();
		findMinDist();
		System.out.println(minDist);
	}

	public static void initMap() {
		int idx = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					boolean[][] visited = new boolean[N][N];
					Queue<Point> queue = new LinkedList<>();
					queue.add(new Point(i, j));
					visited[i][j] = true;
					map[i][j] = idx;
					while (!queue.isEmpty()) {
						Point p = queue.poll();
						for (int d = 0; d < 4; d++) {
							int nr = p.x + dr[d];
							int nc = p.y + dc[d];

							if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && map[nr][nc] == 1) {
								queue.add(new Point(nr, nc));
								visited[nr][nc] = true;
								map[nr][nc] = idx;
							}
						}
					}
					idx++;
				}
			}
		}
	}

	public static void findMinDist() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					int now = map[i][j];
					boolean[][] visited = new boolean[N][N];
					Queue<Point> queue = new LinkedList<>();
					queue.add(new Point(i, j));
					visited[i][j] = true;
					int dist = -1;
					boolean isArrived = false;
					Loop1: while (!queue.isEmpty()) {
						dist++;
						if(dist>minDist) break;
						int level = queue.size();
						for (int k = 0; k < level; k++) {
							Point p = queue.poll();
							for (int d = 0; d < 4; d++) {
								int nr = p.x + dr[d];
								int nc = p.y + dc[d];
								if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && map[nr][nc] == 0) {
									queue.add(new Point(nr, nc));
									visited[nr][nc] = true;
								}
								if(nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && map[nr][nc]!=now && map[nr][nc]!=0) {
									isArrived = true;
									break Loop1;
								}
							}
						}
					}
					if(isArrived)
					minDist = dist;
				}
			}
		}
	}
}
