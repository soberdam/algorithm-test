import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * BFS로 색칠된 부분을 방문하며 0으로 업데이트한다. 
 * BFS를 돌 때마다 색칠한 개수를 count하고 이를 max와 비교하여 업데이트
 */
public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken()); 
		int[][] arr = new int[n][m];
		// 그림 정보를 입력받는다.
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
				
		}
		int max = 0;
		int count = 0;
		Queue<int[]> queue = new LinkedList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]==1) {
					count++;
					int area = 1;
					arr[i][j]=0;
					queue.offer(new int[] {i, j});
					while(!queue.isEmpty()) {
						int[] cur = queue.poll();
						int curR = cur[0];
						int curC = cur[1];
						for(int d=0; d<4; d++) {
							int nr = curR + dr[d];
							int nc = curC + dc[d];
							if(nr>=0&&nr<n&&nc>=0&&nc<m&&arr[nr][nc]!=0) {
								arr[nr][nc] = 0;
								area++;
								queue.offer(new int[] {nr, nc});
							}
						}
					}
					max = Math.max(max, area);
				}
			}
		}
		
		System.out.println(count);
		System.out.println(max);
		
	}
	
}
