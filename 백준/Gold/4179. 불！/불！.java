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
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] maze = new char[R][C]; 
		boolean[][] visitedF = new boolean[R][C];
		int[] jStart = {};
		int[][] fire = new int[R][C];
		int[][] escape = new int[R][C];
		Queue<int[]> queue = new LinkedList<>();
		// 미로 입력 받기
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				maze[i][j] = s.charAt(j);
				if(s.charAt(j)=='F') {
					queue.offer(new int[] {i, j});
					visitedF[i][j] = true;
				}
				if(s.charAt(j)=='J') jStart = new int[] {i,j}; 
			}
		}
		// 불이 붙은 위치에서 BFS를 하여 불이 도착하는 분(최단거리)을 새 배열(fire)에 저장
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curR = cur[0];
			int curC = cur[1];
			for(int d=0; d<4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				if(nr>=0 && nr<R && nc>=0 && nc<C && !visitedF[nr][nc] && maze[nr][nc]!='#') {
					visitedF[nr][nc] = true;
					fire[nr][nc] = fire[curR][curC] + 1;
					queue.offer(new int[] {nr,nc});
				}
			}
		}
		
		boolean[][] visitedJ = new boolean[R][C]; // 방문 초기화
		// 지훈이의 위치에서 BFS를 하며, 지훈이가 도착하는 시간(최단거리)에 불이 없다면(fire의 값보다 작다면) 이동
		// 이 이동한 최단거리를 새 배열(escape)에 저장
		queue.offer(jStart);
		visitedJ[jStart[0]][jStart[1]] = true;
		boolean escapable = false;
		int minute = 0;
		Loop1:while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			// 만약 탈출구(모서리의 끝)라면 break; {
			int curR = cur[0];
			int curC = cur[1];
			if(curR==0||curC==0||curR==R-1||curC==C-1) {
				escapable = true;
				minute = escape[curR][curC];
				break Loop1;
			}
			for(int d=0; d<4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				if(nr>=0 && nr<R && nc>=0 && nc<C && !visitedJ[nr][nc] && maze[nr][nc]!='#') {
					if((escape[curR][curC]+1<fire[nr][nc])||!visitedF[nr][nc]) {
						visitedJ[nr][nc] = true;
						escape[nr][nc] = escape[curR][curC] + 1;
						
						queue.offer(new int[] {nr,nc});
					}
				}
			}
		}
		
		if(escapable) {
			System.out.println(minute+1);
		} else {
			System.out.println("IMPOSSIBLE");
		}
	}

}