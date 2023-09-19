import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int answer = 0;
			int N = Integer.parseInt(br.readLine());
			int[][] cheese = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<=100; i++) {
				answer = Math.max(answer, BFS(i,cheese));
			}
			
			System.out.print(answer);
		
	}
	
	public static int BFS(int day, int[][] cheese) {
		boolean[][] visited = new boolean[cheese.length][cheese.length];
		int block = 0;
		Queue<int[]> queue = new LinkedList<>();
		for(int i=0; i<cheese.length; i++) {
			for(int j=0; j<cheese.length; j++) {
				if(cheese[i][j]>day&&!visited[i][j]) {
					queue.add(new int[] {i,j});
					visited[i][j] = true;
					while(!queue.isEmpty()) {
						int[] now = queue.poll();
						int r = now[0];
						int c = now[1];
						
						for(int d=0; d<4; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							if(nr>=0&&nc>=0&&nr<cheese.length&&nc<cheese.length&&!visited[nr][nc]) {
								if(cheese[nr][nc]>day) {
									visited[nr][nc] = true;
									queue.add(new int[] {nr,nc});
								}
							}
						}
					}
					block++;
				}
			}
		}
		
		
		return block;
	}

}
