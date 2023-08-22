
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> queue = new LinkedList<>();

		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int normalCnt = 0;
		int rgweakCnt = 0;
		
		// 적록색약이 아닌 사람 BFS
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					queue.offer(new int[] {i, j});
					while(!queue.isEmpty()) {
						int[] ij = queue.poll();
						for(int d=0; d<4; d++) {
							int nr = ij[0] + dr[d];
							int nc = ij[1] + dc[d];
							if(nr>=0 && nr < N && nc >=0 && nc < N && !visited[nr][nc]) {
								if(arr[i][j] == arr[nr][nc]) {
									visited[nr][nc] = true;
									queue.offer(new int[] {nr, nc});
								}
							}
						}
					}
					normalCnt++;
				}
			}
		}
		// 방문 여부 초기화
		visited = new boolean[N][N];
		// G와 R을 구분할 수 없게 게 배열 업데이트
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]=='G') {
					arr[i][j] = 'R';
				}
			}
		}
		// 적록색약인 사람의 BFS
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					queue.offer(new int[] {i, j});
					while(!queue.isEmpty()) {
						int[] ij = queue.poll();
						for(int d=0; d<4; d++) {
							int nr = ij[0] + dr[d];
							int nc = ij[1] + dc[d];
							if(nr>=0 && nr < N && nc >=0 && nc < N && !visited[nr][nc]) {
								if(arr[i][j] == arr[nr][nc]) {
									visited[nr][nc] = true;
									queue.offer(new int[] {nr, nc});
								}
							}
						}
					}
					rgweakCnt++;
				}
			}
		}
		
		
		System.out.println(normalCnt + " " + rgweakCnt);
	}

}