
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] maze;
	static int min = Integer.MAX_VALUE;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = s.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
		System.out.println(maze[N-1][M-1]);
	}

	public static void bfs(int r, int c) {
		queue.offer(new int[] {r,c});
		while(!queue.isEmpty()) {
			int[] rc = queue.poll();
			
			// 너비우선 탐색 후 큐에 넣기
			for(int d=0; d<4; d++) {
				int nr = rc[0] + dr[d];
				int nc = rc[1] + dc[d];
				if(nr>=0 && nc>=0 && nr<N && nc<M && maze[nr][nc]==1) {
                    // 너비우선 탐색으로 방문할 때마다 최단거리 업데이트. 이전 노드까지의 거리 +1
					maze[nr][nc] = maze[rc[0]][rc[1]] + 1;
					queue.offer(new int[] {nr,nc});
				}
			}
			
		
		}

	}

}