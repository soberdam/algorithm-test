import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 입력을 받을 때 모두 익어있는 상태인지 boolean변수로 체크하고, 참이라면 0을 출력한다. 
 * BFS로 방문을 시작할 익은 토마토를 큐에 저장한다.
 * BFS를 돌 때마다 날짜를 count한다.
 * BFS를 돈 이후 배열을 확인하여 익지않은 토마토가 있다면 boolean으로 체크, 이후 -1 출력
 * 모두 익었다면 날짜를 출력한다.
 */
class Point {
	int h;
	int r;
	int c;
	Point(int h, int r, int c) {
		this.h = h;
		this.r = r;
		this.c = c;
	}
}
public class Main {
	static int[] dh = {-1,1,0,0, 0, 0 };
	static int[] dr = {0,0, -1, 1, 0, 0 };
	static int[] dc = {0,0, 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int[][][] arr = new int[h][n][m];
		boolean alreadyRipe = true;
		Queue<Point> queue = new LinkedList<>();
		// 토마토 정보를 입력받는다.
		// 익은 토마토에서 BFS를 시작하므로 배열을 돌며 익은 토마토라면 추가.
		for(int k=0; k<h; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					arr[k][i][j] = Integer.parseInt(st.nextToken());
					if (arr[k][i][j] == 0)
						alreadyRipe = false;
					if (arr[k][i][j] == 1) {
						arr[k][i][j] = 2;
						queue.add(new Point(k,i,j));
					}
				}
				
			}
		}
		// 저장할 때 모두 익어있다면 0 출력
		if (alreadyRipe) {
			System.out.println(0);
			return;
		}

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			int curH = cur.h;
			int curR = cur.r;
			int curC = cur.c;
			for (int d = 0; d < 6; d++) {
				int nh = curH + dh[d];
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				if (nh>=0 && nh<h &&nr >= 0 && nr < n && nc >= 0 && nc < m && arr[nh][nr][nc] == 0) {
					arr[nh][nr][nc] = arr[curH][curR][curC]+1;
					queue.offer(new Point(nh, nr, nc));
				}
			}
		}
		
		int day = Integer.MIN_VALUE;
		// BFS를 모두 돈 이후 익지 않은 토마토가 있는 지 확인
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(arr[k][i][j]==0) {
						System.out.println(-1);
						return;
					}
					day = Math.max(day, arr[k][i][j]-2);
				}
			}
		}
		
		// 모두 익었다면 최소 날짜 출력
		System.out.println(day);

	}

}
