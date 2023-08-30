import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *  불이 붙은 위치에서 BFS를 하여 불이 도착하는 분(최단거리)을 새 배열(fire)에 저장
 *  지훈이의 위치에서 BFS를 하며, 지훈이가 도착하는 시간(최단거리)에 불이 없다면(fire의 값보다 작다면) 이동.
 *  이 이동한 최단거리를 새 배열(escape)에 저장
 */
public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] maze = new char[R][C];
		int[][] fire = new int[R][C]; // 불의 전파 시간
		int[][] escape = new int[R][C]; // 지훈이의 이동 시간
		Queue<int[]> queue1 = new LinkedList<>(); // 불 BFS 할 큐
		Queue<int[]> queue2 = new LinkedList<>(); // 지훈이 BFS 할 큐
		// 미로 입력 받기
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				fire[i][j] = -1;
				escape[i][j] = -1;
				maze[i][j] = s.charAt(j);
				if (s.charAt(j) == 'F') {
					queue1.offer(new int[] { i, j });
					fire[i][j] = 0;
				}
				if (s.charAt(j) == 'J') {
					queue2.offer(new int[] { i, j });
					escape[i][j] = 0;
				}
			}
		}
		// 불이 붙은 위치에서 BFS를 하여 불이 도착하는 분(최단거리)을 새 배열(fire)에 저장
		while (!queue1.isEmpty()) {
			int[] cur = queue1.poll();
			int curR = cur[0];
			int curC = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && fire[nr][nc] == -1 && maze[nr][nc] != '#') {
					fire[nr][nc] = fire[curR][curC] + 1;
					queue1.offer(new int[] { nr, nc });
				}
			}
		}

		// 지훈이의 위치에서 BFS를 하며, 지훈이가 도착하는 시간(최단거리)에 불이 없다면(fire의 값보다 작다면) 이동
		// 이 이동한 최단거리를 새 배열(escape)에 저장
		Loop1: while (!queue2.isEmpty()) {
			int[] cur = queue2.poll();
			// 만약 탈출구(모서리의 끝)라면 break; 
			int curR = cur[0];
			int curC = cur[1];
			if (curR == 0 || curC == 0 || curR == R - 1 || curC == C - 1) {
				System.out.println(escape[curR][curC]+1);
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && escape[nr][nc]==-1 && maze[nr][nc] != '#') {
					if ((escape[curR][curC] + 1 < fire[nr][nc]) || fire[nr][nc]==-1) {
						escape[nr][nc] = escape[curR][curC] + 1;
						queue2.offer(new int[] { nr, nc });
					}
				}
			}
		}

		System.out.println("IMPOSSIBLE");

	}

}